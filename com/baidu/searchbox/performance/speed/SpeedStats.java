package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.d0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_TO_ACTIVITY_DELAY = 300;
    public static final int DATA_TYPE_CACHE = 0;
    public static final int DATA_TYPE_NET = 1;
    public static final int DATA_TYPE_NONE = -1;
    public static boolean DEBUG = false;
    public static final int DEFAULT_DELAY_TIME = 10000;
    public static final int SP_OPT_VERSION_CODE = 100696448;
    public static final String TAG = "SpeedStats";
    public static final int TYPE_INTRODUCTION = 0;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SPLASH = 1;
    public static final String UBC_LAUNCH_SPEED_ID = "127";
    public static SpeedStats mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMainPageStatsEnd;
    public Context mContext;
    public int mCpuCore;
    public int mFeedDataType;
    public Flow mFlow;
    public boolean mHasActivityCreate;
    public boolean mHasBanner;
    public boolean mHasDataFlowDialog;
    public volatile boolean mHasDetectStartAppFromLauncher;
    public boolean mHasForegroundToBackground;
    public boolean mHasMainActivityLaunched;
    public boolean mHasSkin;
    public boolean mHasUserInteraction;
    public int mHotwordDataType;
    public int mIntroductionType;
    public boolean mIsExternalTransfer;
    public boolean mIsStartAppFromLauncher;
    public int mLaunchType;
    public String mLaunchTypeStr;
    public int mOldVersion;
    public SpeedStatsManager mSpeedStatsManager;
    public int mStartMainActivityType;
    public String mTargetActivity;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLaunchType = 0;
        this.mLaunchTypeStr = "";
        this.mStartMainActivityType = -1;
        this.mIsStartAppFromLauncher = false;
        this.mHasDetectStartAppFromLauncher = false;
        this.mHasActivityCreate = false;
        this.mHasMainActivityLaunched = false;
        this.mIntroductionType = -1;
        this.mHasDataFlowDialog = false;
        this.mHasSkin = false;
        this.mHasBanner = false;
        this.mFeedDataType = 0;
        this.mHotwordDataType = 0;
        this.mOldVersion = -1;
        this.mFlow = null;
        this.mCpuCore = 0;
        this.mHasUserInteraction = false;
        this.mUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.mIsExternalTransfer = false;
        this.mHasForegroundToBackground = false;
        this.mSpeedStatsManager = SpeedStatsManager.getInstance();
        this.isMainPageStatsEnd = false;
    }

    private void asyncUploadSpeedInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                                hashMap.put(SpeedStatsUtils.UBC_KEY_USER_PERCEPTION_COST, String.valueOf(this.this$0.mSpeedStatsManager.getAppUserPerceptionLaunchDuration()));
                            }
                            String calculateStage = this.this$0.calculateStage();
                            if (SpeedStats.DEBUG) {
                                String str = "stage:\n" + calculateStage;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", this.this$0.mUbcType);
                                jSONObject.put("value", this.this$0.mUbcValue);
                                jSONObject.put("page", this.this$0.mUbcPage);
                                jSONObject.put("from", this.this$0.mUbcFrom);
                                try {
                                    jSONObject.put("ext", new JSONObject().toString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            String jSONObject2 = jSONObject.toString();
                            if (!TextUtils.isEmpty(jSONObject2)) {
                                hashMap.put(SpeedStatsUtils.UBC_KEY_OPTION, jSONObject2);
                            }
                            if (!TextUtils.isEmpty(calculateStage)) {
                                hashMap.put("stage", calculateStage);
                            }
                            hashMap.put("version", TbadkCoreApplication.getInst().getVersionName());
                            hashMap.put("cpu", String.valueOf(this.this$0.mCpuCore));
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
                        this.this$0.writeDeviceInfoDB();
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
        if (!(interceptable == null || interceptable.invokeL(65563, this, map) == null) || map == null || map.size() <= 0 || !SpeedStatsUtils.hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$map = map;
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0092 -> B:40:0x0095). Please submit an issue!!! */
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
                            } catch (IOException e2) {
                                e = e2;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        bufferedWriter.write("starttime：" + System.currentTimeMillis() + StringUtils.LF);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.val$map.toString());
                        sb.append(StringUtils.LF);
                        bufferedWriter.write(sb.toString());
                        if (SpeedStats.DEBUG) {
                            String str = "write info to cold_start.txt: " + this.val$map.toString();
                        }
                        bufferedWriter.close();
                    } catch (IOException e4) {
                        e = e4;
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
                            } catch (IOException e5) {
                                e5.printStackTrace();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
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
        long mainActivityCreateStartTimeStamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            int i2 = this.mStartMainActivityType;
            if (i2 != 6 && i2 != 5 && i2 != 3 && i2 != 1) {
                mainActivityCreateStartTimeStamp = (i2 == 4 || i2 == 2 || i2 == 0) ? this.mSpeedStatsManager.getAppLaunchStartTimeStamp() : -1L;
            } else {
                mainActivityCreateStartTimeStamp = this.mSpeedStatsManager.getMainActivityCreateStartTimeStamp();
            }
            if (mainActivityCreateStartTimeStamp > 0) {
                long appUserPerceptionLaunchDuration = this.mSpeedStatsManager.getAppUserPerceptionLaunchDuration() - this.mSpeedStatsManager.getSplashActivityDuration();
                if (appUserPerceptionLaunchDuration <= 50 || appUserPerceptionLaunchDuration >= 60000) {
                    return null;
                }
                return String.valueOf(appUserPerceptionLaunchDuration);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateStage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (TextUtils.equals(this.mUbcType, SpeedStatsUtils.UBC_TYPE_COLD_DIRECT) && ((TextUtils.equals(this.mUbcValue, "none") || TextUtils.equals(this.mUbcValue, "skin")) && TextUtils.equals(this.mUbcFrom, SpeedStatsUtils.UBC_FROM_MAINLINE) && TextUtils.equals(this.mUbcPage, SpeedStatsUtils.UBC_PAGE_ALLCACHE))) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            if (this.mFeedDataType == -1 && this.mHotwordDataType == -1) {
                return "error";
            }
            if (this.mFeedDataType == 0 && this.mHotwordDataType == 0) {
                return SpeedStatsUtils.UBC_PAGE_ALLCACHE;
            }
            if (this.mFeedDataType == 0 && this.mHotwordDataType == 1) {
                return SpeedStatsUtils.UBC_PAGE_FEED_CACHE;
            }
            if (this.mFeedDataType == 1 && this.mHotwordDataType == 0) {
                return SpeedStatsUtils.UBC_PAGE_HOTWORD_CACHE;
            }
            if (this.mFeedDataType == 1 && this.mHotwordDataType == 1) {
                return SpeedStatsUtils.UBC_PAGE_ALLNET;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
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
                default:
                    return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String calculateUbcValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            int i2 = this.mIntroductionType;
            if (i2 == -1) {
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
                return "banner";
            } else if (i2 == 0) {
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
            } else if (i2 != 1) {
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
                        return "splash";
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) ? SpeedStatsUtils.UBC_FROM_MAINLINE : (String) invokeV.objValue;
    }

    private boolean checkValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) ? getAppLaunchDuration() >= 0 && getAppStartTime() >= 0 : invokeV.booleanValue;
    }

    private void detectStartAppFrom(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, this, activity) == null) || activity == null || this.mHasActivityCreate) {
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
                if (isLogoActivity(activity)) {
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
        String str = "detectStartAppFrom hasDetect=" + this.mHasDetectStartAppFromLauncher + ",isStartAppFromLauncher=" + this.mIsStartAppFromLauncher;
    }

    public static SpeedStats getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            if (mInstance == null) {
                mInstance = new SpeedStats();
            }
            return mInstance;
        }
        return (SpeedStats) invokeV.objValue;
    }

    private HashMap<String, String> getLaunchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, this, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            this.mUbcPage = calculateUbcPage();
            this.mUbcType = calculateUbcType();
            this.mUbcFrom = calcultateUbcFrom();
            this.mUbcValue = calculateUbcValue();
            hashMap.put("from", this.mUbcFrom);
            hashMap.put("type", this.mUbcType);
            hashMap.put("value", this.mUbcValue);
            hashMap.put("page", this.mUbcPage);
            hashMap.put("appLaunchDuration", str);
            hashMap.put("appStartTime", String.valueOf(getAppStartTime()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    private void getMainActivityStartType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            int i2 = this.mLaunchType;
            if (i2 == 0) {
                this.mStartMainActivityType = this.mIsStartAppFromLauncher ? 4 : 5;
                return;
            }
            if (i2 == 1) {
                this.mStartMainActivityType = this.mIsStartAppFromLauncher ? 2 : 3;
            } else if (i2 != 2) {
            } else {
                this.mStartMainActivityType = !this.mIsStartAppFromLauncher ? 1 : 0;
            }
        }
    }

    private boolean isLogoActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, this, activity)) == null) {
            ComponentName componentName = activity.getComponentName();
            return componentName != null && SpeedRuntime.SPLASH_ACTIVITY_NAME.equals(componentName.getClassName());
        }
        return invokeL.booleanValue;
    }

    private boolean isMaintab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            String topActivityClassName = UtilHelper.getTopActivityClassName();
            return !k.isEmpty(topActivityClassName) && topActivityClassName.equals(SpeedRuntime.MAIN_ACTIVITY_NAME);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printUBCFlow(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, this, map) == null) {
            String str = "************" + map.get(SpeedStatsUtils.UBC_KEY_OPTION) + "*************";
            String str2 = "************duration:" + map.get("duration") + "*************";
            String str3 = "************version:" + map.get("version") + "*************";
            String str4 = "************stage:" + map.get("stage") + "*************";
            String str5 = "************cpu:" + map.get("cpu") + "*************";
            String str6 = "************drawCount:" + map.get(SpeedStatsUtils.UBC_KEY_DRAW_COUNT) + "*************";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMainActivityStatsPeriod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.mSpeedStatsManager.reset();
            this.mHasDataFlowDialog = false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void writeDeviceInfoDB() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65580, this) == null) && TextUtils.equals(this.mUbcType, SpeedStatsUtils.UBC_TYPE_COLD_DIRECT) && TextUtils.equals(this.mUbcValue, "none") && TextUtils.equals(this.mUbcFrom, SpeedStatsUtils.UBC_FROM_MAINLINE) && TextUtils.equals(this.mUbcPage, SpeedStatsUtils.UBC_PAGE_ALLCACHE)) {
            ExecutorUtilsExt.delayPostOnElastic(new Runnable(this) { // from class: com.baidu.searchbox.performance.speed.SpeedStats.3
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        this.this$0.getAppLaunchDuration();
                    }
                }
            }, "write_device_info_db", 3, 10000L);
        }
    }

    public long getAppLaunchDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSpeedStatsManager.getAppLaunchDuration() : invokeV.longValue;
    }

    public long getAppStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSpeedStatsManager.getAppLaunchStartTimeStamp() : invokeV.longValue;
    }

    public long getLaunchEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSpeedStatsManager.getAppLaunchEndTimeStamp() : invokeV.longValue;
    }

    public int getLaunchType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLaunchType : invokeV.intValue;
    }

    public String getLaunchTypeString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.mLaunchTypeStr)) {
                return this.mLaunchTypeStr;
            }
            int i2 = this.mLaunchType;
            if (i2 == 0) {
                this.mLaunchTypeStr = "normal";
            } else if (i2 == 1) {
                this.mLaunchTypeStr = "upgrade";
            } else if (i2 == 2) {
                this.mLaunchTypeStr = LaunchStatsUtils.NEW_INSTALL_LAUNCH;
            }
            return this.mLaunchTypeStr;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIntroductionType == 1 : invokeV.booleanValue;
    }

    public boolean hasForegroundToBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHasForegroundToBackground : invokeV.booleanValue;
    }

    public boolean hasSkin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mHasSkin : invokeV.booleanValue;
    }

    public boolean isExternalTransfer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsExternalTransfer : invokeV.booleanValue;
    }

    public boolean isHotLaunch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.mStartMainActivityType;
            return i2 == 6 || i2 == 7;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedClearFeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mOldVersion == 100696448 : invokeV.booleanValue;
    }

    public boolean isStartAppFromLauncher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIsStartAppFromLauncher : invokeV.booleanValue;
    }

    public void onAppCreateEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SmartLaunchStats.setAppStartTimeStamp(getAppStartTime());
        }
    }

    public void onAppProcessUpgrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mLaunchType = i2;
        }
    }

    public void onBaseActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            detectStartAppFrom(activity);
            if (!this.mHasActivityCreate && System.currentTimeMillis() - this.mSpeedStatsManager.getAppCreateEndTimeStamp() > 300) {
                SmartLaunchStats.setFirstAvailableTimeFlag(false);
            }
            if (activity != null) {
                if (isLogoActivity(activity)) {
                    Intent intent = activity.getIntent();
                    if (intent != null) {
                        if (TextUtils.equals(intent.getAction(), "android.intent.action.MAIN")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onBaseActivityCreate******有效统计一次*******isFirstEnterMainActivity=");
                            sb.append(!this.mHasMainActivityLaunched);
                            sb.toString();
                            this.mSpeedStatsManager.setStatsFlag(true);
                            if (this.mHasMainActivityLaunched) {
                                this.mStartMainActivityType = 6;
                            } else {
                                getMainActivityStartType();
                            }
                        } else {
                            this.mStartMainActivityType = 7;
                        }
                    }
                    this.mHasMainActivityLaunched = true;
                }
                this.mHasActivityCreate = true;
            }
        }
    }

    public void onColdStartRecovery() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.mSpeedStatsManager.getStatsFlag()) {
            this.mStartMainActivityType = 5;
        }
    }

    public void onHasBanner() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.mSpeedStatsManager.getStatsFlag()) {
            this.mHasBanner = true;
        }
    }

    public void onHasDataFlowDialog(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && this.mSpeedStatsManager.getStatsFlag()) {
            if (this.mLaunchType == 2 && z) {
                SmartLaunchStats.onPrivacyDialogShow();
            }
            this.mHasDataFlowDialog = z;
        }
    }

    public void onHasIntroduction(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i2) == null) && this.mSpeedStatsManager.getStatsFlag()) {
            this.mIntroductionType = i2;
        }
    }

    public void onHasSkin() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.mSpeedStatsManager.getStatsFlag()) {
            this.mHasSkin = true;
        }
    }

    @DebugTrace
    @TimeSpendTrace(isEnd = true)
    public void onMainPageStatsEnd(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            this.isMainPageStatsEnd = true;
            if (this.mSpeedStatsManager.getStatsFlag()) {
                this.mSpeedStatsManager.addStatsTimeStamp(6000);
                if (!checkValid()) {
                    resetMainActivityStatsPeriod();
                    return;
                }
                asyncUploadSpeedInfo();
                if (!SmartLaunchStats.hasTriedToFindFirstAvailableTime() && !hasForegroundToBackground()) {
                    SmartLaunchStats.tryToFindFirstIdleTimeStamp();
                }
            } else {
                LaunchStatsUtils.setLaunchTypeDetail(this.mLaunchType, this.mIsStartAppFromLauncher, this.mHasSkin, this.mIntroductionType != -1);
            }
            int k = b.j().k("app_start_time", 0);
            if (k > 0) {
                for (int i2 = 0; i2 < k; i2++) {
                    TiebaStatic.log(new StatisticItem("app_start"));
                }
                b.j().v("app_start_time", 0);
            }
            TiebaStatic.log(new StatisticItem("main_show").param("obj_type", System.currentTimeMillis() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp()));
        }
    }

    public void onReceivePushMsg() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.mHasActivityCreate) {
            return;
        }
        this.mIsStartAppFromLauncher = false;
        this.mHasDetectStartAppFromLauncher = true;
    }

    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mHasUserInteraction = true;
            if (this.mSpeedStatsManager.getAppLaunchStartTimeStamp() <= 0 || this.mSpeedStatsManager.getAppLaunchEndTimeStamp() <= 0 || SmartLaunchStats.getFirstTouchTime() != -1) {
                return;
            }
            SmartLaunchStats.setFirstTouchTime(System.currentTimeMillis());
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            this.mContext = context;
        }
    }

    public void setFeedDataType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mFeedDataType = i2;
        }
    }

    public void setForegroundToBackgroundFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mHasForegroundToBackground = true;
            ExternalTransferSpeedStats.setForegroundToBackgroundFlag(true);
        }
    }

    public void setHotwordDataType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mHotwordDataType = i2;
        }
    }
}
