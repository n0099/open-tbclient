package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.sb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class SpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_TO_ACTIVITY_DELAY = 300;
    public static final int DATA_TYPE_CACHE = 0;
    public static final int DATA_TYPE_NET = 1;
    public static final int DATA_TYPE_NONE = -1;
    public static final boolean DEBUG;
    public static final int DEFAULT_DELAY_TIME = 10000;
    public static final String PUSH_ACTIVITY = "com.baidu.tieba.yunpush.YunPushProxyActivity";
    public static final String SCHEME_ACTIVITY = "com.baidu.tieba.tblauncher.SchemaRouteActivity";
    public static final String TAG = "SpeedStats";
    public static final int TYPE_INTRODUCTION = 0;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SPLASH = 1;
    public static final String UBC_LAUNCH_SPEED_ID = "127";
    public static SpeedStats mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public long backgroudDuration;
    public long backgroudTimeStamp;
    public boolean isMainPageStatsEnd;
    public boolean isSchemePushStatsEnd;
    public Context mContext;
    public int mCpuCore;
    public int mFeedDataType;
    public Flow mFlow;
    public boolean mHasActivityCreate;
    public boolean mHasBanner;
    public volatile boolean mHasDetectStartAppFromLauncher;
    public boolean mHasForegroundToBackground;
    public boolean mHasMainActivityLaunched;
    public boolean mHasSkin;
    public int mHotwordDataType;
    public int mIntroductionType;
    public boolean mIsStartAppFromLauncher;
    public int mLaunchType;
    public SpeedStatsManager mSpeedStatsManager;
    public int mStartMainActivityType;
    public String mUbcFrom;
    public UBCManager mUbcManager;
    public String mUbcPage;
    public String mUbcType;
    public String mUbcValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(813606882, "Lcom/baidu/searchbox/performance/speed/SpeedStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(813606882, "Lcom/baidu/searchbox/performance/speed/SpeedStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public SpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLaunchType = 0;
        this.mStartMainActivityType = -1;
        this.mIsStartAppFromLauncher = false;
        this.mHasDetectStartAppFromLauncher = false;
        this.mHasActivityCreate = false;
        this.mHasMainActivityLaunched = false;
        this.mIntroductionType = -1;
        this.mHasSkin = false;
        this.mHasBanner = false;
        this.mFeedDataType = 0;
        this.mHotwordDataType = 0;
        this.mFlow = null;
        this.mCpuCore = 0;
        this.mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.mHasForegroundToBackground = false;
        this.mSpeedStatsManager = SpeedStatsManager.getInstance();
        this.backgroudTimeStamp = 0L;
        this.backgroudDuration = 0L;
        this.isMainPageStatsEnd = false;
        this.isSchemePushStatsEnd = false;
    }

    private void asyncUploadSpeedInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            Runnable runnable = new Runnable(this) { // from class: com.baidu.searchbox.performance.speed.SpeedStats.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SpeedStats this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpeedStats speedStats = this.this$0;
                        speedStats.mUbcType = speedStats.calculateUbcType();
                        SpeedStats speedStats2 = this.this$0;
                        speedStats2.mUbcValue = speedStats2.calculateUbcValue();
                        SpeedStats speedStats3 = this.this$0;
                        speedStats3.mUbcPage = speedStats3.calculateUbcPage();
                        SpeedStats speedStats4 = this.this$0;
                        speedStats4.mUbcFrom = speedStats4.calcultateUbcFrom();
                        String calculateDuration = this.this$0.calculateDuration();
                        SpeedStats speedStats5 = this.this$0;
                        speedStats5.mCpuCore = speedStats5.calculateCpuCore();
                        if (this.this$0.mFlow != null) {
                            this.this$0.mFlow.cancel();
                        }
                        if (this.this$0.mUbcManager != null) {
                            SpeedStats speedStats6 = this.this$0;
                            speedStats6.mFlow = speedStats6.mUbcManager.beginFlow(SpeedStats.UBC_LAUNCH_SPEED_ID);
                        }
                        if (this.this$0.mFlow != null && !TextUtils.isEmpty(this.this$0.mUbcType) && !TextUtils.isEmpty(this.this$0.mUbcValue) && !TextUtils.isEmpty(this.this$0.mUbcPage) && !TextUtils.isEmpty(this.this$0.mUbcFrom) && !TextUtils.isEmpty(calculateDuration)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("duration", calculateDuration);
                            if (!TextUtils.equals(this.this$0.mUbcType, SpeedStatsUtils.UBC_TYPE_HOT_LAUNCH)) {
                                long appUserPerceptionLaunchDuration = this.this$0.mSpeedStatsManager.getAppUserPerceptionLaunchDuration() - SpeedStatsManager.getInstance().getAdShowDuration();
                                if (appUserPerceptionLaunchDuration > 50 && appUserPerceptionLaunchDuration < 60000) {
                                    hashMap.put(SpeedStatsUtils.UBC_KEY_USER_PERCEPTION_COST, String.valueOf(appUserPerceptionLaunchDuration));
                                }
                            }
                            String calculateStage = this.this$0.calculateStage();
                            if (SpeedStats.DEBUG) {
                                Log.d(SpeedStats.TAG, "stage:\n" + calculateStage);
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", this.this$0.mUbcType);
                                jSONObject.put("value", this.this$0.mUbcValue);
                                jSONObject.put("page", this.this$0.mUbcPage);
                                jSONObject.put("from", this.this$0.mUbcFrom);
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
                            hashMap.put("cpu", String.valueOf(this.this$0.mCpuCore));
                            hashMap.put("device_score", String.valueOf(ScheduleStrategy.getDeviceScore()));
                            hashMap.put(SpeedStatsUtils.UBC_KEY_DRAW_COUNT, String.valueOf(this.this$0.mSpeedStatsManager.getDrawCount()));
                            this.this$0.mFlow.setValue(hashMap);
                            this.this$0.mFlow.end();
                            this.this$0.mFlow = null;
                            this.this$0.printUBCFlow(hashMap);
                            if (SpeedStats.DEBUG) {
                                this.this$0.asyncWriteSpeedInfoToSdcard(hashMap);
                            }
                            LaunchedTaskSpeedStats launchedTaskSpeedStats = LaunchedTaskSpeedStats.getInstance();
                            if (this.this$0.mUbcType != SpeedStatsUtils.UBC_TYPE_HOT_LAUNCH) {
                                launchedTaskSpeedStats.startStatistics();
                                launchedTaskSpeedStats.setUbcType(this.this$0.mUbcType);
                                launchedTaskSpeedStats.setUbcFrom(this.this$0.mUbcFrom);
                                launchedTaskSpeedStats.setUbcPage(this.this$0.mUbcPage);
                                launchedTaskSpeedStats.setUbcValue(this.this$0.mUbcValue);
                            } else {
                                launchedTaskSpeedStats.setStatsSwitch(false);
                            }
                        }
                        SmartLaunchStats.setAppUserPerceptionStartTime(this.this$0.mSpeedStatsManager.getAppUserPerceptionLaunchDuration());
                        this.this$0.resetMainActivityStatsPeriod();
                    }
                }
            };
            SmartLaunchStats.setAppStartEndTimeStamp(getLaunchEndTime());
            LaunchStatsUtils.setLaunchTypeDetail(this.mLaunchType, this.mIsStartAppFromLauncher, this.mHasSkin, this.mIntroductionType != -1);
            ExecutorUtilsExt.postOnElastic(runnable, "asyncUploadSpeedInfo", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncWriteSpeedInfoToSdcard(Map map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, map) == null) || map == null || map.size() <= 0 || !SpeedStatsUtils.hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, map) { // from class: com.baidu.searchbox.performance.speed.SpeedStats.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpeedStats this$0;
            public final /* synthetic */ Map val$map;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, map};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$map = map;
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:37:0x009a). Please submit an issue!!! */
            @Override // java.lang.Runnable
            public void run() {
                BufferedWriter bufferedWriter;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
                                e.printStackTrace();
                            }
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bufferedWriter.write("starttime：" + System.currentTimeMillis() + "\n");
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.val$map.toString());
                        sb.append("\n");
                        bufferedWriter.write(sb.toString());
                        if (SpeedStats.DEBUG) {
                            Log.d(SpeedStats.TAG, "write info to cold_start.txt: " + this.val$map.toString());
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
            }
        }, "asyncWriteSpeedInfoToSdcard", 3, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateCpuCore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            Runtime runtime = Runtime.getRuntime();
            if (runtime != null) {
                return runtime.availableProcessors();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateDuration() {
        InterceptResult invokeV;
        long appLaunchDuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            int i = this.mStartMainActivityType;
            if (i != 8 && i != 9) {
                appLaunchDuration = i == 4 ? this.mSpeedStatsManager.getAppUserPerceptionLaunchDuration() - this.mSpeedStatsManager.getAdShowDuration() : 0L;
            } else {
                appLaunchDuration = this.mSpeedStatsManager.getAppLaunchDuration();
            }
            if (appLaunchDuration <= 50 || appLaunchDuration >= 60000) {
                return null;
            }
            return String.valueOf(appLaunchDuration);
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateStage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if ((TextUtils.equals(this.mUbcType, SpeedStatsUtils.UBC_TYPE_COLD_DIRECT) || TextUtils.equals(this.mUbcType, "push") || TextUtils.equals(this.mUbcType, "scheme")) && ((TextUtils.equals(this.mUbcValue, "none") || TextUtils.equals(this.mUbcValue, "skin")) && TextUtils.equals(this.mUbcFrom, SpeedStatsUtils.UBC_FROM_MAINLINE))) {
                JSONObject jSONObject = new JSONObject();
                if (this.mSpeedStatsManager.packData(jSONObject)) {
                    return jSONObject.toString();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) ? !TextUtils.isEmpty(this.mUbcPage) ? this.mUbcPage : "unknown" : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            int i = this.mIntroductionType;
            if (i == -1) {
                if (this.mHasBanner && this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_BANNER_SKIN;
                }
                if (!this.mHasBanner || this.mHasSkin) {
                    if (this.mHasBanner || !this.mHasSkin) {
                        if (this.mHasBanner || this.mHasSkin) {
                            return null;
                        }
                        return "none";
                    }
                    return "skin";
                }
                return SpeedStatsUtils.UBC_VALUE_BANNER;
            } else if (i == 0) {
                if (this.mHasBanner && this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_INTRO_BANNER_SKIN;
                }
                if (!this.mHasBanner || this.mHasSkin) {
                    if (this.mHasBanner || !this.mHasSkin) {
                        if (this.mHasBanner || this.mHasSkin) {
                            return null;
                        }
                        return SpeedStatsUtils.UBC_VALUE_INTRODUCTION;
                    }
                    return SpeedStatsUtils.UBC_VALUE_INTRO_SKIN;
                }
                return SpeedStatsUtils.UBC_VALUE_INTRO_BANNER;
            } else if (i != 1) {
                return null;
            } else {
                if (this.mHasBanner && this.mHasSkin) {
                    return SpeedStatsUtils.UBC_VALUE_SPLASH_BANNER_SKIN;
                }
                if (!this.mHasBanner || this.mHasSkin) {
                    if (this.mHasBanner || !this.mHasSkin) {
                        if (this.mHasBanner || this.mHasSkin) {
                            return null;
                        }
                        return SpeedStatsUtils.UBC_VALUE_SPLASH;
                    }
                    return SpeedStatsUtils.UBC_VALUE_SPLASH_SKIN;
                }
                return SpeedStatsUtils.UBC_VALUE_SPLASH_BANNER;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calcultateUbcFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) ? SpeedStatsUtils.UBC_FROM_MAINLINE : (String) invokeV.objValue;
    }

    private boolean checkValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) ? getAppLaunchDuration() >= 0 && getAppStartTime() >= 0 : invokeV.booleanValue;
    }

    private void detectStartAppFrom(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, activity) == null) || activity == null || this.mHasActivityCreate) {
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

    public static SpeedStats getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            if (mInstance == null) {
                mInstance = new SpeedStats();
            }
            return mInstance;
        }
        return (SpeedStats) invokeV.objValue;
    }

    private void getMainActivityStartType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            int i = this.mLaunchType;
            if (i == 0) {
                this.mStartMainActivityType = this.mIsStartAppFromLauncher ? 4 : 5;
                return;
            }
            if (i == 1) {
                this.mStartMainActivityType = this.mIsStartAppFromLauncher ? 2 : 3;
            } else if (i != 2) {
            } else {
                this.mStartMainActivityType = !this.mIsStartAppFromLauncher ? 1 : 0;
            }
        }
    }

    private boolean isMainTabActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, activity)) == null) {
            ComponentName componentName = activity.getComponentName();
            return componentName != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(componentName.getClassName());
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printUBCFlow(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, map) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMainActivityStatsPeriod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
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
    }

    public long getAppInBackgroundDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.backgroudDuration : invokeV.longValue;
    }

    public long getAppLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSpeedStatsManager.getAppLaunchDuration() : invokeV.longValue;
    }

    public long getAppStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSpeedStatsManager.getAppLaunchStartTimeStamp() : invokeV.longValue;
    }

    public long getLaunchEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSpeedStatsManager.getAppLaunchEndTimeStamp() : invokeV.longValue;
    }

    public int getLaunchType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLaunchType : invokeV.intValue;
    }

    public boolean hasForegroundToBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mHasForegroundToBackground : invokeV.booleanValue;
    }

    public boolean isHotLaunch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.mStartMainActivityType;
            return i == 6 || i == 7;
        }
        return invokeV.booleanValue;
    }

    public boolean isStartAppFromLauncher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsStartAppFromLauncher : invokeV.booleanValue;
    }

    public void onAppBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.backgroudTimeStamp = System.currentTimeMillis();
        }
    }

    public void onAppCreateEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SmartLaunchStats.setAppStartTimeStamp(getAppStartTime());
        }
    }

    public void onAppForeground() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.isMainPageStatsEnd || this.backgroudTimeStamp == 0) {
            return;
        }
        this.backgroudDuration += System.currentTimeMillis() - this.backgroudTimeStamp;
        this.backgroudTimeStamp = 0L;
    }

    public void onAppProcessUpgrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mLaunchType = i;
        }
    }

    public void onBaseActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
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
                } else if (intent == null || intent.getComponent() == null) {
                } else {
                    String dataString = intent.getDataString();
                    String className = intent.getComponent().getClassName();
                    if (SpeedRuntime.getSpeedContext().isAgreePrivacyPolicy()) {
                        if (!TextUtils.isEmpty(dataString) && !TextUtils.isEmpty(className) && className.equals("com.baidu.tieba.tblauncher.SchemaRouteActivity")) {
                            SpeedStatsManager.getInstance().setStatsFlag(2);
                        }
                        if (TextUtils.isEmpty(dataString) || TextUtils.isEmpty(className) || !className.equals(PUSH_ACTIVITY)) {
                            return;
                        }
                        SpeedStatsManager.getInstance().setStatsFlag(1);
                    }
                }
            }
        }
    }

    @DebugTrace
    @TimeSpendTrace(isEnd = true)
    public void onMainPageStatsEnd(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, context) == null) || this.isMainPageStatsEnd) {
            return;
        }
        this.isMainPageStatsEnd = true;
        sb.b().d();
        this.mSpeedStatsManager.addStatsTimeStamp(6000);
        if (this.mSpeedStatsManager.getStatsFlag() == 0) {
            this.mUbcPage = SpeedStatsUtils.UBC_PAGE_ALLCACHE;
            Log.d(TAG, "*****************统计终点*****************");
            if (!checkValid()) {
                resetMainActivityStatsPeriod();
                return;
            }
            asyncUploadSpeedInfo();
        } else {
            LaunchStatsUtils.setLaunchTypeDetail(this.mLaunchType, this.mIsStartAppFromLauncher, this.mHasSkin, this.mIntroductionType != -1);
        }
        if (SmartLaunchStats.hasTriedToFindFirstAvailableTime() || hasForegroundToBackground()) {
            return;
        }
        SmartLaunchStats.tryToFindFirstIdleTimeStamp();
    }

    @DebugTrace
    @TimeSpendTrace(isEnd = true)
    public void onSchemeOrPushStatsEnd(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048590, this, context, i, str) == null) || this.isSchemePushStatsEnd) {
            return;
        }
        this.isSchemePushStatsEnd = true;
        sb.b().d();
        if (this.mSpeedStatsManager.getStatsFlag() == 2 || this.mSpeedStatsManager.getStatsFlag() == 1) {
            this.mStartMainActivityType = i;
            this.mUbcPage = str;
            this.mSpeedStatsManager.addStatsTimeStamp(6000);
            asyncUploadSpeedInfo();
        }
        if (SmartLaunchStats.hasTriedToFindFirstAvailableTime() || hasForegroundToBackground()) {
            return;
        }
        SmartLaunchStats.tryToFindFirstIdleTimeStamp();
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.mContext = context;
        }
    }
}
