package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static ExtDataCallBack sStartupCountExtCallBack = new ExtDataCallBack();
    public static ExtDataCallBack sUseDurationExtCallBack = new ExtDataCallBack();
    public static String sStartupCountUploadId = StartupCountStatsUtils.DEFAULT_STARTUP_UBC_ID;
    public static String sUseDurationUploadId = StartupCountStatsUtils.DEFAULT_USE_DURATION_UBC_ID;
    public static PerfSampleManager sPerfSampleManager = new PerfSampleManager();
    public static UBCManager ubc = null;

    /* loaded from: classes2.dex */
    public static class ExtDataCallBack {
        @Nullable
        public JSONObject addData() {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class StatsRule {
        @Nullable
        public boolean shouldStats(Activity activity) {
            return true;
        }
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
            addData.put(StartupCountStatsUtils.SDK_FLAG_KEY, StartupCountStatsUtils.SDK_FLAG_VALUE);
            if (!TextUtils.isEmpty(sUseDurationStatsType)) {
                addData.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sUseDurationStatsType);
            }
            return addData.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void startTiming() {
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计开始：startTiming");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        sFlow = ubc.beginFlow(sUseDurationUploadId, jSONObject.toString(), 4);
    }

    public static void stopTiming() {
        if (sFlow != null) {
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            ubc.flowEnd(sFlow);
            sFlow = null;
            if (DEBUG) {
                Log.d(TAG, "App使用时长统计结束：stopTiming");
            }
        }
    }

    public static void updateTiming() {
        if (sFlow != null && sUseDurationStatsRule.shouldStats(null) && System.currentTimeMillis() - sFlow.getStartTime() > 300000) {
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            ubc.flowSetValueWithDuration(sFlow, generateValueJson());
            if (DEBUG) {
                Log.d(TAG, "App使用时长统计更新（最小间隔5分钟）：updateTiming");
            }
        }
    }

    @NonNull
    public static String getSampleFlag() {
        return sPerfSampleManager.getSampleFlag();
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
            JSONObject addData = sStartupCountExtCallBack.addData();
            if (addData == null) {
                addData = new JSONObject();
            }
            addData.put("ftime", sForegroundTimeStamp);
            addData.put(StartupCountStatsUtils.BACKGROUND_TIME_STAMP, sBackgroundTimeStamp);
            if (!TextUtils.isEmpty(sStartupCountStatsType)) {
                addData.put(StartupCountStatsUtils.LAUNCH_SAMPLE, sStartupCountStatsType);
            }
            String sampleFlag = sPerfSampleManager.getSampleFlag();
            if (!TextUtils.isEmpty(sampleFlag)) {
                addData.put("pf", sampleFlag);
            }
            addData.put(StartupCountStatsUtils.SDK_FLAG_KEY, StartupCountStatsUtils.SDK_FLAG_VALUE);
            jSONObject.put("ext", addData);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        ubc.onEvent(sStartupCountUploadId, jSONObject);
    }

    @Nullable
    public static void setStartSource(String str) {
        sAppStartSource = str;
    }

    @Nullable
    public static void setStartupCountExtCallBack(ExtDataCallBack extDataCallBack) {
        sStartupCountExtCallBack = extDataCallBack;
    }

    @Nullable
    public static void setStartupCountStatsRule(StatsRule statsRule) {
        sStartupCountStatsRule = statsRule;
    }

    @Nullable
    public static void setStartupCountStatsType(String str) {
        sStartupCountStatsType = str;
    }

    @Nullable
    public static void setStartupCountUploadId(String str) {
        sStartupCountUploadId = str;
    }

    @Nullable
    public static void setUseDurationExtCallBack(ExtDataCallBack extDataCallBack) {
        sUseDurationExtCallBack = extDataCallBack;
    }

    @Nullable
    public static void setUseDurationStatsRule(StatsRule statsRule) {
        sUseDurationStatsRule = statsRule;
    }

    @Nullable
    public static void setUseDurationStatsType(String str) {
        sUseDurationStatsType = str;
    }

    @Nullable
    public static void setUseDurationUploadId(String str) {
        sUseDurationUploadId = str;
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onActivityResumed(Activity activity) {
        updateTiming();
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onBackgroundToForeground(Activity activity) {
        String str;
        if (sStartupCountStatsRule.shouldStats(activity)) {
            sForegroundTimeStamp = System.currentTimeMillis();
            if (sIsWarmBootApp) {
                str = "warm_start";
            } else {
                str = "cold_start";
            }
            appStartupUpload(str);
        }
        if (sUseDurationStatsRule.shouldStats(activity)) {
            startTiming();
        }
        if (!sIsWarmBootApp) {
            sIsWarmBootApp = true;
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onForegroundToBackground(Activity activity) {
        sBackgroundTimeStamp = System.currentTimeMillis();
        if (sUseDurationStatsRule.shouldStats(activity)) {
            stopTiming();
        }
    }
}
