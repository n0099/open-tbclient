package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StartupCountStats extends SimpleActivityLifeCycle implements NoProGuard {
    public static final String TAG = "StartupCountStats";
    public static Flow sFlow;
    public static String sStartupCountStatsType;
    public static String sUseDurationStatsType;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static boolean sIsWarmBootApp = false;
    public static volatile String sAppStartSource = "";
    public static long sForegroundTimeStamp = -1;
    public static long sBackgroundTimeStamp = -1;
    public static StatsRule sStartupCountStatsRule = new StatsRule();
    public static StatsRule sUseDurationStatsRule = new StatsRule();
    public static ExtDataCallBack sUseDurationExtCallBack = new ExtDataCallBack();
    public static String sStartupCountUploadId = StartupCountStatsUtils.DEFAULT_STARTUP_UBC_ID;
    public static String sUseDurationUploadId = StartupCountStatsUtils.DEFAULT_USE_DURATION_UBC_ID;
    public static PerfSampleManager sPerfSampleManager = new PerfSampleManager();
    public static UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    /* loaded from: classes2.dex */
    public static class ExtDataCallBack {
        public JSONObject addData() {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class StatsRule {
        public boolean shouldStats(Activity activity) {
            return true;
        }
    }

    public static void appStartupUpload(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "research");
            jSONObject.put("type", str);
            if (!TextUtils.isEmpty(sAppStartSource)) {
                jSONObject.put("source", sAppStartSource);
                sAppStartSource = "";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ftime", sForegroundTimeStamp);
            jSONObject2.put(StartupCountStatsUtils.BACKGROUND_TIME_STAMP, sBackgroundTimeStamp);
            if (!TextUtils.isEmpty(sStartupCountStatsType)) {
                jSONObject2.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sStartupCountStatsType);
            }
            String sampleFlag = sPerfSampleManager.getSampleFlag();
            if (!TextUtils.isEmpty(sampleFlag)) {
                jSONObject2.put("pf", sampleFlag);
            }
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        ubc.onEvent(sStartupCountUploadId, jSONObject);
    }

    public static String generateValueJson() {
        try {
            JSONObject addData = sUseDurationExtCallBack.addData();
            if (addData == null) {
                addData = new JSONObject();
            }
            String sampleFlag = sPerfSampleManager.getSampleFlag();
            if (!TextUtils.isEmpty(sampleFlag)) {
                addData.put("pf", sampleFlag);
            }
            if (!TextUtils.isEmpty(sUseDurationStatsType)) {
                addData.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sUseDurationStatsType);
            }
            return addData.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getSampleFlag() {
        return sPerfSampleManager.getSampleFlag();
    }

    public static void setStartSource(String str) {
        sAppStartSource = str;
    }

    public static void setStartupCountStatsRule(StatsRule statsRule) {
        sStartupCountStatsRule = statsRule;
    }

    public static void setStartupCountStatsType(String str) {
        sStartupCountStatsType = str;
    }

    public static void setStartupCountUploadId(String str) {
        sStartupCountUploadId = str;
    }

    public static void setUseDurationExtCallBack(ExtDataCallBack extDataCallBack) {
        sUseDurationExtCallBack = extDataCallBack;
    }

    public static void setUseDurationStatsRule(StatsRule statsRule) {
        sUseDurationStatsRule = statsRule;
    }

    public static void setUseDurationStatsType(String str) {
        sUseDurationStatsType = str;
    }

    public static void setUseDurationUploadId(String str) {
        sUseDurationUploadId = str;
    }

    public static void startTiming() {
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计开始：startTiming");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sFlow = ubc.beginFlow(sUseDurationUploadId, jSONObject.toString(), 4);
    }

    public static void stopTiming() {
        Flow flow = sFlow;
        if (flow != null) {
            ubc.flowSetValueWithDuration(flow, generateValueJson());
            ubc.flowEnd(sFlow);
            sFlow = null;
            if (DEBUG) {
                Log.d(TAG, "App使用时长统计结束：stopTiming");
            }
        }
    }

    public static void updateTiming() {
        if (sFlow == null || !sUseDurationStatsRule.shouldStats(null) || System.currentTimeMillis() - sFlow.getStartTime() <= 300000) {
            return;
        }
        ubc.flowSetValueWithDuration(sFlow, generateValueJson());
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计更新（最小间隔5分钟）：updateTiming");
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityResumed(Activity activity) {
        updateTiming();
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        if (sStartupCountStatsRule.shouldStats(activity)) {
            sForegroundTimeStamp = System.currentTimeMillis();
            appStartupUpload(sIsWarmBootApp ? StartupCountStatsUtils.START_WARM_START : StartupCountStatsUtils.STARTUP_COLD_START);
        }
        if (sUseDurationStatsRule.shouldStats(activity)) {
            startTiming();
        }
        if (sIsWarmBootApp) {
            return;
        }
        sIsWarmBootApp = true;
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onForegroundToBackground(Activity activity) {
        sBackgroundTimeStamp = System.currentTimeMillis();
        if (sUseDurationStatsRule.shouldStats(activity)) {
            stopTiming();
        }
    }
}
