package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.tieba.ac;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpeedStats {
    public static final int APP_TO_ACTIVITY_DELAY = 300;
    public static final int DATA_TYPE_CACHE = 0;
    public static final int DATA_TYPE_NET = 1;
    public static final int DATA_TYPE_NONE = -1;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_DELAY_TIME = 10000;
    public static final String PUSH_ACTIVITY = "com.baidu.tieba.yunpush.YunPushProxyActivity";
    public static final String SCHEME_ACTIVITY = "com.baidu.tieba.tblauncher.SchemaRouteActivity";
    public static final String TAG = "SpeedStats";
    public static final int TYPE_INTRODUCTION = 0;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SPLASH = 1;
    public static final String UBC_LAUNCH_SPEED_ID = "127";
    public static SpeedStats mInstance;
    public Context mContext;
    public String mSid;
    public String mUbcFrom;
    public String mUbcPage;
    public String mUbcType;
    public String mUbcValue;
    public int mLaunchType = 0;
    public int mStartMainActivityType = -1;
    public boolean mIsStartAppFromLauncher = false;
    public volatile boolean mHasDetectStartAppFromLauncher = false;
    public boolean mHasActivityCreate = false;
    public boolean mHasMainActivityLaunched = false;
    public int mIntroductionType = -1;
    public boolean mHasSkin = false;
    public boolean mHasBanner = false;
    public int mFeedDataType = 0;
    public int mHotwordDataType = 0;
    public Flow mFlow = null;
    public int mCpuCore = 0;
    public UBCManager mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public boolean mHasForegroundToBackground = false;
    public SpeedStatsManager mSpeedStatsManager = SpeedStatsManager.getInstance();
    public long backgroudTimeStamp = 0;
    public long backgroudDuration = 0;
    public boolean isMainPageStatsEnd = false;
    public boolean isSchemePushStatsEnd = false;

    /* JADX INFO: Access modifiers changed from: private */
    public String calcultateUbcFrom() {
        return SpeedStatsUtils.UBC_FROM_MAINLINE;
    }

    private void asyncUploadSpeedInfo() {
        boolean z;
        Runnable runnable = new Runnable() { // from class: com.baidu.searchbox.performance.speed.SpeedStats.1
            @Override // java.lang.Runnable
            public void run() {
                SpeedStats speedStats = SpeedStats.this;
                speedStats.mUbcType = speedStats.calculateUbcType();
                SpeedStats speedStats2 = SpeedStats.this;
                speedStats2.mUbcValue = speedStats2.calculateUbcValue();
                SpeedStats speedStats3 = SpeedStats.this;
                speedStats3.mUbcPage = speedStats3.calculateUbcPage();
                SpeedStats speedStats4 = SpeedStats.this;
                speedStats4.mUbcFrom = speedStats4.calcultateUbcFrom();
                String calculateDuration = SpeedStats.this.calculateDuration();
                SpeedStats speedStats5 = SpeedStats.this;
                speedStats5.mCpuCore = speedStats5.calculateCpuCore();
                if (SpeedStats.this.mFlow != null) {
                    SpeedStats.this.mFlow.cancel();
                }
                if (SpeedStats.this.mUbcManager != null) {
                    SpeedStats speedStats6 = SpeedStats.this;
                    speedStats6.mFlow = speedStats6.mUbcManager.beginFlow(SpeedStats.UBC_LAUNCH_SPEED_ID);
                }
                if (SpeedStats.this.mFlow != null && !TextUtils.isEmpty(SpeedStats.this.mUbcType) && !TextUtils.isEmpty(SpeedStats.this.mUbcValue) && !TextUtils.isEmpty(SpeedStats.this.mUbcPage) && !TextUtils.isEmpty(SpeedStats.this.mUbcFrom) && !TextUtils.isEmpty(calculateDuration)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("duration", calculateDuration);
                    if (!TextUtils.equals(SpeedStats.this.mUbcType, SpeedStatsUtils.UBC_TYPE_HOT_LAUNCH)) {
                        long appUserPerceptionLaunchDuration = SpeedStats.this.mSpeedStatsManager.getAppUserPerceptionLaunchDuration() - SpeedStatsManager.getInstance().getAdShowDuration();
                        if (appUserPerceptionLaunchDuration > 50 && appUserPerceptionLaunchDuration < 60000) {
                            hashMap.put(SpeedStatsUtils.UBC_KEY_USER_PERCEPTION_COST, String.valueOf(appUserPerceptionLaunchDuration));
                        }
                    }
                    String calculateStage = SpeedStats.this.calculateStage();
                    if (SpeedStats.DEBUG) {
                        Log.d(SpeedStats.TAG, "stage:\n" + calculateStage);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", SpeedStats.this.mUbcType);
                        jSONObject.put("value", SpeedStats.this.mUbcValue);
                        jSONObject.put("page", SpeedStats.this.mUbcPage);
                        jSONObject.put("from", SpeedStats.this.mUbcFrom);
                        try {
                            jSONObject.put("ext", new JSONObject().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        hashMap.put(SpeedStatsUtils.UBC_KEY_OPTION, jSONObject2);
                    }
                    if (!TextUtils.isEmpty(calculateStage)) {
                        hashMap.put("stage", calculateStage);
                    }
                    hashMap.put("version", SpeedRuntime.getSpeedContext().getVersionName());
                    hashMap.put("cpu", String.valueOf(SpeedStats.this.mCpuCore));
                    hashMap.put("device_score", String.valueOf(ScheduleStrategy.getDeviceScore()));
                    hashMap.put(SpeedStatsUtils.UBC_KEY_DRAW_COUNT, String.valueOf(SpeedStats.this.mSpeedStatsManager.getDrawCount()));
                    if (!TextUtils.isEmpty(SpeedStats.this.mSid)) {
                        hashMap.put("sid", SpeedStats.this.mSid);
                    }
                    SpeedStats.this.mFlow.setValue(hashMap);
                    SpeedStats.this.mFlow.end();
                    SpeedStats.this.mFlow = null;
                    SpeedStats.this.printUBCFlow(hashMap);
                    if (SpeedStats.DEBUG) {
                        SpeedStats.this.asyncWriteSpeedInfoToSdcard(hashMap);
                    }
                    LaunchedTaskSpeedStats launchedTaskSpeedStats = LaunchedTaskSpeedStats.getInstance();
                    if (SpeedStats.this.mUbcType != SpeedStatsUtils.UBC_TYPE_HOT_LAUNCH) {
                        launchedTaskSpeedStats.startStatistics();
                        launchedTaskSpeedStats.setUbcType(SpeedStats.this.mUbcType);
                        launchedTaskSpeedStats.setUbcFrom(SpeedStats.this.mUbcFrom);
                        launchedTaskSpeedStats.setUbcPage(SpeedStats.this.mUbcPage);
                        launchedTaskSpeedStats.setUbcValue(SpeedStats.this.mUbcValue);
                    } else {
                        launchedTaskSpeedStats.setStatsSwitch(false);
                    }
                }
                SmartLaunchStats.setAppUserPerceptionStartTime(SpeedStats.this.mSpeedStatsManager.getAppUserPerceptionLaunchDuration());
                SpeedStats.this.resetMainActivityStatsPeriod();
            }
        };
        SmartLaunchStats.setAppStartEndTimeStamp(getLaunchEndTime());
        int i = this.mLaunchType;
        boolean z2 = this.mIsStartAppFromLauncher;
        boolean z3 = this.mHasSkin;
        if (this.mIntroductionType != -1) {
            z = true;
        } else {
            z = false;
        }
        LaunchStatsUtils.setLaunchTypeDetail(i, z2, z3, z);
        ExecutorUtilsExt.postOnElastic(runnable, "asyncUploadSpeedInfo", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateCpuCore() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime != null) {
            return runtime.availableProcessors();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcPage() {
        if (!TextUtils.isEmpty(this.mUbcPage)) {
            return this.mUbcPage;
        }
        return "unknown";
    }

    private boolean checkValid() {
        if (getAppLaunchDuration() >= 0 && getAppStartTime() >= 0) {
            return true;
        }
        return false;
    }

    public static SpeedStats getInstance() {
        if (mInstance == null) {
            mInstance = new SpeedStats();
        }
        return mInstance;
    }

    private void getMainActivityStartType() {
        int i;
        int i2 = this.mLaunchType;
        if (i2 != 0) {
            int i3 = 2;
            if (i2 != 1) {
                if (i2 == 2) {
                    this.mStartMainActivityType = !this.mIsStartAppFromLauncher ? 1 : 0;
                    return;
                }
                return;
            }
            if (!this.mIsStartAppFromLauncher) {
                i3 = 3;
            }
            this.mStartMainActivityType = i3;
            return;
        }
        if (this.mIsStartAppFromLauncher) {
            i = 4;
        } else {
            i = 5;
        }
        this.mStartMainActivityType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMainActivityStatsPeriod() {
        this.mSpeedStatsManager.reset();
        this.mHasBanner = false;
        this.mFeedDataType = 0;
        this.mHotwordDataType = 0;
        this.mUbcType = null;
        this.mUbcValue = null;
        this.mUbcPage = null;
        this.mUbcFrom = null;
        this.mFlow = null;
    }

    public long getAppInBackgroundDuration() {
        return this.backgroudDuration;
    }

    public long getAppLaunchDuration() {
        return this.mSpeedStatsManager.getAppLaunchDuration();
    }

    public long getAppStartTime() {
        return this.mSpeedStatsManager.getAppLaunchStartTimeStamp();
    }

    public long getLaunchEndTime() {
        return this.mSpeedStatsManager.getAppLaunchEndTimeStamp();
    }

    public int getLaunchType() {
        return this.mLaunchType;
    }

    public boolean hasForegroundToBackground() {
        return this.mHasForegroundToBackground;
    }

    public boolean isHotLaunch() {
        int i = this.mStartMainActivityType;
        if (i != 6 && i != 7) {
            return false;
        }
        return true;
    }

    public boolean isStartAppFromLauncher() {
        return this.mIsStartAppFromLauncher;
    }

    public void onAppBackground() {
        this.backgroudTimeStamp = System.currentTimeMillis();
    }

    public void onAppCreateEnd() {
        SmartLaunchStats.setAppStartTimeStamp(getAppStartTime());
    }

    public void onAppForeground() {
        if (!this.isMainPageStatsEnd && this.backgroudTimeStamp != 0) {
            this.backgroudDuration += System.currentTimeMillis() - this.backgroudTimeStamp;
            this.backgroudTimeStamp = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateDuration() {
        long appLaunchDuration;
        int i = this.mStartMainActivityType;
        if (i != 8 && i != 9) {
            if (i == 4) {
                appLaunchDuration = this.mSpeedStatsManager.getAppUserPerceptionLaunchDuration() - this.mSpeedStatsManager.getAdShowDuration();
            } else {
                appLaunchDuration = 0;
            }
        } else {
            appLaunchDuration = this.mSpeedStatsManager.getAppLaunchDuration();
        }
        if (appLaunchDuration > 50 && appLaunchDuration < 60000) {
            return String.valueOf(appLaunchDuration);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcType() {
        switch (this.mStartMainActivityType) {
            case 0:
                return SpeedStatsUtils.UBC_TYPE_NEW_INSTALL_DIRECT;
            case 1:
                return SpeedStatsUtils.UBC_TYPE_NEW_INSTALL_INDIRECT;
            case 2:
                return SpeedStatsUtils.UBC_TYPE_UPGRADE_DIRECT;
            case 3:
                return SpeedStatsUtils.UBC_TYPE_UPGRADE_INDIRECT;
            case 4:
                return SpeedStatsUtils.UBC_TYPE_COLD_DIRECT;
            case 5:
                return SpeedStatsUtils.UBC_TYPE_COLD_INDIRECT;
            case 6:
                return SpeedStatsUtils.UBC_TYPE_HOT_LAUNCH;
            case 7:
            default:
                return null;
            case 8:
                return "scheme";
            case 9:
                return "push";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncWriteSpeedInfoToSdcard(final Map map) {
        if (map != null && map.size() > 0 && SpeedStatsUtils.hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.performance.speed.SpeedStats.2
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0095 -> B:34:0x0098). Please submit an issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    BufferedWriter bufferedWriter;
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            try {
                                File file = new File(Environment.getExternalStorageDirectory(), "cold_start.txt");
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                            } catch (IOException e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedWriter.write("starttime：" + System.currentTimeMillis() + "\n");
                        StringBuilder sb = new StringBuilder();
                        sb.append(map.toString());
                        sb.append("\n");
                        bufferedWriter.write(sb.toString());
                        if (SpeedStats.DEBUG) {
                            Log.d(SpeedStats.TAG, "write info to cold_start.txt: " + map.toString());
                        }
                        bufferedWriter.close();
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter2 = bufferedWriter;
                        e.printStackTrace();
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }, "asyncWriteSpeedInfoToSdcard", 3, 10000L);
        }
    }

    private boolean isMainTabActivity(Activity activity) {
        ComponentName componentName = activity.getComponentName();
        if (componentName == null || !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(componentName.getClassName())) {
            return false;
        }
        return true;
    }

    public void onAppProcessUpgrade(int i) {
        this.mLaunchType = i;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setSid(String str) {
        this.mSid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateStage() {
        if ((TextUtils.equals(this.mUbcType, SpeedStatsUtils.UBC_TYPE_COLD_DIRECT) || TextUtils.equals(this.mUbcType, "push") || TextUtils.equals(this.mUbcType, "scheme")) && ((TextUtils.equals(this.mUbcValue, "none") || TextUtils.equals(this.mUbcValue, "skin")) && TextUtils.equals(this.mUbcFrom, SpeedStatsUtils.UBC_FROM_MAINLINE))) {
            JSONObject jSONObject = new JSONObject();
            if (this.mSpeedStatsManager.packData(jSONObject)) {
                return jSONObject.toString();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcValue() {
        int i = this.mIntroductionType;
        if (i != -1) {
            if (i != 0) {
                if (i == 1) {
                    if (this.mHasBanner && this.mHasSkin) {
                        return SpeedStatsUtils.UBC_VALUE_SPLASH_BANNER_SKIN;
                    }
                    if (this.mHasBanner && !this.mHasSkin) {
                        return SpeedStatsUtils.UBC_VALUE_SPLASH_BANNER;
                    }
                    if (!this.mHasBanner && this.mHasSkin) {
                        return SpeedStatsUtils.UBC_VALUE_SPLASH_SKIN;
                    }
                    if (!this.mHasBanner && !this.mHasSkin) {
                        return SpeedStatsUtils.UBC_VALUE_SPLASH;
                    }
                    return null;
                }
                return null;
            } else if (this.mHasBanner && this.mHasSkin) {
                return SpeedStatsUtils.UBC_VALUE_INTRO_BANNER_SKIN;
            } else {
                if (this.mHasBanner && !this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_INTRO_BANNER;
                }
                if (!this.mHasBanner && this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_INTRO_SKIN;
                }
                if (!this.mHasBanner && !this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_INTRODUCTION;
                }
                return null;
            }
        } else if (this.mHasBanner && this.mHasSkin) {
            return SpeedStatsUtils.UBC_VALUE_BANNER_SKIN;
        } else {
            if (this.mHasBanner && !this.mHasSkin) {
                return SpeedStatsUtils.UBC_VALUE_BANNER;
            }
            if (!this.mHasBanner && this.mHasSkin) {
                return "skin";
            }
            if (!this.mHasBanner && !this.mHasSkin) {
                return "none";
            }
            return null;
        }
    }

    private void detectStartAppFrom(Activity activity) {
        if (activity == null || this.mHasActivityCreate) {
            return;
        }
        if (!this.mHasDetectStartAppFromLauncher) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            if (action != null && categories != null) {
                if (isMainTabActivity(activity)) {
                    if (TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER")) {
                        this.mIsStartAppFromLauncher = true;
                    } else {
                        this.mIsStartAppFromLauncher = false;
                    }
                } else {
                    this.mIsStartAppFromLauncher = false;
                }
                this.mHasDetectStartAppFromLauncher = true;
            }
        }
        Log.d(TAG, "detectStartAppFrom hasDetect=" + this.mHasDetectStartAppFromLauncher + ",isStartAppFromLauncher=" + this.mIsStartAppFromLauncher);
    }

    @DebugTrace
    @TimeSpendTrace(isEnd = true)
    public void onMainPageStatsEnd(Context context) {
        if (this.isMainPageStatsEnd) {
            return;
        }
        boolean z = true;
        this.isMainPageStatsEnd = true;
        ac.b().d();
        this.mSpeedStatsManager.addStatsTimeStamp(6000);
        if (!SmartLaunchStats.hasTriedToFindFirstAvailableTime() && !hasForegroundToBackground()) {
            SmartLaunchStats.tryToFindFirstIdleTimeStamp();
        }
        if (this.mSpeedStatsManager.getStatsFlag() == 0) {
            this.mUbcPage = SpeedStatsUtils.UBC_PAGE_ALLCACHE;
            Log.d(TAG, "*****************统计终点*****************");
            if (!checkValid()) {
                resetMainActivityStatsPeriod();
                return;
            } else {
                asyncUploadSpeedInfo();
                return;
            }
        }
        int i = this.mLaunchType;
        boolean z2 = this.mIsStartAppFromLauncher;
        boolean z3 = this.mHasSkin;
        if (this.mIntroductionType == -1) {
            z = false;
        }
        LaunchStatsUtils.setLaunchTypeDetail(i, z2, z3, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printUBCFlow(Map<String, String> map) {
        Log.d(TAG, "*****************UBC start*****************");
        Log.d(TAG, "************" + map.get(SpeedStatsUtils.UBC_KEY_OPTION) + "*************");
        Log.d(TAG, "************duration:" + map.get("duration") + "*************");
        Log.d(TAG, "************version:" + map.get("version") + "*************");
        Log.d(TAG, "************stage:" + map.get("stage") + "*************");
        Log.d(TAG, "************cpu:" + map.get("cpu") + "*************");
        Log.d(TAG, "************device_score:" + map.get("device_score") + "*************");
        Log.d(TAG, "************drawCount:" + map.get(SpeedStatsUtils.UBC_KEY_DRAW_COUNT) + "*************");
        Log.d(TAG, "*****************UBC end*****************");
    }

    public void onBaseActivityCreate(Activity activity) {
        detectStartAppFrom(activity);
        if (this.mHasActivityCreate) {
            return;
        }
        if (System.currentTimeMillis() - this.mSpeedStatsManager.getAppCreateEndTimeStamp() > 300) {
            SmartLaunchStats.setFirstAvailableTimeFlag(false);
        }
        this.mHasActivityCreate = true;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (isMainTabActivity(activity)) {
                if (intent != null) {
                    if (TextUtils.equals(intent.getAction(), "android.intent.action.MAIN")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onBaseActivityCreate******有效统计一次*******isFirstEnterMainActivity=");
                        sb.append(!this.mHasMainActivityLaunched);
                        Log.d(TAG, sb.toString());
                        if (SpeedRuntime.getSpeedContext().isAgreePrivacyPolicy()) {
                            SpeedStatsManager.getInstance().setStatsFlag(0);
                        }
                        if (this.mStartMainActivityType == -1) {
                            if (this.mHasMainActivityLaunched) {
                                this.mStartMainActivityType = 6;
                            } else {
                                getMainActivityStartType();
                            }
                        }
                    } else if (this.mStartMainActivityType == -1) {
                        this.mStartMainActivityType = 7;
                    }
                }
                this.mHasMainActivityLaunched = true;
            } else if (intent != null && intent.getComponent() != null) {
                String dataString = intent.getDataString();
                String className = intent.getComponent().getClassName();
                if (SpeedRuntime.getSpeedContext().isAgreePrivacyPolicy()) {
                    if (!TextUtils.isEmpty(dataString) && !TextUtils.isEmpty(className) && className.equals("com.baidu.tieba.tblauncher.SchemaRouteActivity")) {
                        SpeedStatsManager.getInstance().setStatsFlag(2);
                    }
                    if (!TextUtils.isEmpty(dataString) && !TextUtils.isEmpty(className) && className.equals(PUSH_ACTIVITY)) {
                        SpeedStatsManager.getInstance().setStatsFlag(1);
                    }
                }
            }
        }
    }

    @DebugTrace
    @TimeSpendTrace(isEnd = true)
    public void onSchemeOrPushStatsEnd(Context context, int i, String str) {
        if (this.isSchemePushStatsEnd) {
            return;
        }
        this.isSchemePushStatsEnd = true;
        ac.b().d();
        if (this.mSpeedStatsManager.getStatsFlag() == 2 || this.mSpeedStatsManager.getStatsFlag() == 1) {
            this.mStartMainActivityType = i;
            this.mUbcPage = str;
            this.mSpeedStatsManager.addStatsTimeStamp(6000);
            asyncUploadSpeedInfo();
        }
        if (!SmartLaunchStats.hasTriedToFindFirstAvailableTime() && !hasForegroundToBackground()) {
            SmartLaunchStats.tryToFindFirstIdleTimeStamp();
        }
    }
}
