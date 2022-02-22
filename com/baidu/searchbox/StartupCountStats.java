package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class StartupCountStats extends SimpleActivityLifeCycle implements NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "StartupCountStats";
    public static volatile String sAppStartSource;
    public static long sBackgroundTimeStamp;
    public static Flow sFlow;
    public static long sForegroundTimeStamp;
    public static boolean sIsWarmBootApp;
    public static PerfSampleManager sPerfSampleManager;
    public static ExtDataCallBack sStartupCountExtCallBack;
    public static StatsRule sStartupCountStatsRule;
    public static String sStartupCountStatsType;
    public static String sStartupCountUploadId;
    public static ExtDataCallBack sUseDurationExtCallBack;
    public static StatsRule sUseDurationStatsRule;
    public static String sUseDurationStatsType;
    public static String sUseDurationUploadId;
    public static UBCManager ubc;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class ExtDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ExtDataCallBack() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        public JSONObject addData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class StatsRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public StatsRule() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        public boolean shouldStats(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-928320696, "Lcom/baidu/searchbox/StartupCountStats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-928320696, "Lcom/baidu/searchbox/StartupCountStats;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sIsWarmBootApp = false;
        sAppStartSource = "";
        sForegroundTimeStamp = -1L;
        sBackgroundTimeStamp = -1L;
        sStartupCountStatsRule = new StatsRule();
        sUseDurationStatsRule = new StatsRule();
        sStartupCountExtCallBack = new ExtDataCallBack();
        sUseDurationExtCallBack = new ExtDataCallBack();
        sStartupCountUploadId = StartupCountStatsUtils.DEFAULT_STARTUP_UBC_ID;
        sUseDurationUploadId = StartupCountStatsUtils.DEFAULT_USE_DURATION_UBC_ID;
        sPerfSampleManager = new PerfSampleManager();
        ubc = null;
    }

    public StartupCountStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void appStartupUpload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
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
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            ubc.onEvent(sStartupCountUploadId, jSONObject);
        }
    }

    public static String generateValueJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getSampleFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sPerfSampleManager.getSampleFlag() : (String) invokeV.objValue;
    }

    @Nullable
    public static void setStartSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            sAppStartSource = str;
        }
    }

    @Nullable
    public static void setStartupCountExtCallBack(ExtDataCallBack extDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, extDataCallBack) == null) {
            sStartupCountExtCallBack = extDataCallBack;
        }
    }

    @Nullable
    public static void setStartupCountStatsRule(StatsRule statsRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, statsRule) == null) {
            sStartupCountStatsRule = statsRule;
        }
    }

    @Nullable
    public static void setStartupCountStatsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            sStartupCountStatsType = str;
        }
    }

    @Nullable
    public static void setStartupCountUploadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            sStartupCountUploadId = str;
        }
    }

    @Nullable
    public static void setUseDurationExtCallBack(ExtDataCallBack extDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, extDataCallBack) == null) {
            sUseDurationExtCallBack = extDataCallBack;
        }
    }

    @Nullable
    public static void setUseDurationStatsRule(StatsRule statsRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, statsRule) == null) {
            sUseDurationStatsRule = statsRule;
        }
    }

    @Nullable
    public static void setUseDurationStatsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            sUseDurationStatsType = str;
        }
    }

    @Nullable
    public static void setUseDurationUploadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            sUseDurationUploadId = str;
        }
    }

    public static void startTiming() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            boolean z = DEBUG;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", "0");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (ubc == null) {
                ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            }
            sFlow = ubc.beginFlow(sUseDurationUploadId, jSONObject.toString(), 4);
        }
    }

    public static void stopTiming() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || sFlow == null) {
            return;
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        ubc.flowSetValueWithDuration(sFlow, generateValueJson());
        ubc.flowEnd(sFlow);
        sFlow = null;
        boolean z = DEBUG;
    }

    public static void updateTiming() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, null) == null) || sFlow == null || !sUseDurationStatsRule.shouldStats(null) || System.currentTimeMillis() - sFlow.getStartTime() <= 300000) {
            return;
        }
        if (ubc == null) {
            ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        ubc.flowSetValueWithDuration(sFlow, generateValueJson());
        boolean z = DEBUG;
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            updateTiming();
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            if (sStartupCountStatsRule.shouldStats(activity)) {
                sForegroundTimeStamp = System.currentTimeMillis();
                appStartupUpload(sIsWarmBootApp ? "warm_start" : "cold_start");
            }
            if (sUseDurationStatsRule.shouldStats(activity)) {
                startTiming();
            }
            if (sIsWarmBootApp) {
                return;
            }
            sIsWarmBootApp = true;
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    @Nullable
    public void onForegroundToBackground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            sBackgroundTimeStamp = System.currentTimeMillis();
            if (sUseDurationStatsRule.shouldStats(activity)) {
                stopTiming();
            }
        }
    }
}
