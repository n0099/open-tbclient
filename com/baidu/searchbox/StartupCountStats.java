package com.baidu.searchbox;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes3.dex */
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
    public static StatsRule sStartupCountStatsRule;
    public static String sStartupCountStatsType;
    public static String sStartupCountUploadId;
    public static ExtDataCallBack sUseDurationExtCallBack;
    public static StatsRule sUseDurationStatsRule;
    public static String sUseDurationStatsType;
    public static String sUseDurationUploadId;
    public static UBCManager ubc;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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

        public JSONObject addData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
        sUseDurationExtCallBack = new ExtDataCallBack();
        sStartupCountUploadId = StartupCountStatsUtils.DEFAULT_STARTUP_UBC_ID;
        sUseDurationUploadId = StartupCountStatsUtils.DEFAULT_USE_DURATION_UBC_ID;
        sPerfSampleManager = new PerfSampleManager();
        ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
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

    public static String getSampleFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? sPerfSampleManager.getSampleFlag() : (String) invokeV.objValue;
    }

    public static void setStartSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            sAppStartSource = str;
        }
    }

    public static void setStartupCountStatsRule(StatsRule statsRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, statsRule) == null) {
            sStartupCountStatsRule = statsRule;
        }
    }

    public static void setStartupCountStatsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            sStartupCountStatsType = str;
        }
    }

    public static void setStartupCountUploadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            sStartupCountUploadId = str;
        }
    }

    public static void setUseDurationExtCallBack(ExtDataCallBack extDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, extDataCallBack) == null) {
            sUseDurationExtCallBack = extDataCallBack;
        }
    }

    public static void setUseDurationStatsRule(StatsRule statsRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, statsRule) == null) {
            sUseDurationStatsRule = statsRule;
        }
    }

    public static void setUseDurationStatsType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            sUseDurationStatsType = str;
        }
    }

    public static void setUseDurationUploadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            sUseDurationUploadId = str;
        }
    }

    public static void startTiming() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
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
    }

    public static void stopTiming() {
        Flow flow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (flow = sFlow) == null) {
            return;
        }
        ubc.flowSetValueWithDuration(flow, generateValueJson());
        ubc.flowEnd(sFlow);
        sFlow = null;
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计结束：stopTiming");
        }
    }

    public static void updateTiming() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || sFlow == null || !sUseDurationStatsRule.shouldStats(null) || System.currentTimeMillis() - sFlow.getStartTime() <= 300000) {
            return;
        }
        ubc.flowSetValueWithDuration(sFlow, generateValueJson());
        if (DEBUG) {
            Log.d(TAG, "App使用时长统计更新（最小间隔5分钟）：updateTiming");
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            updateTiming();
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
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
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
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
