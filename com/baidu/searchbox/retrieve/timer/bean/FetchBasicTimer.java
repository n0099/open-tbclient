package com.baidu.searchbox.retrieve.timer.bean;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchBasicTimer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String EXPIRED = "expiredTime";
    public static final String INFO = "info";
    public static final String JOB_ID = "jobId";
    public static final String TAG = "FetchTimerData";
    public static final String TYPE = "type";
    public static final String VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1178975302, "Lcom/baidu/searchbox/retrieve/timer/bean/FetchBasicTimer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1178975302, "Lcom/baidu/searchbox/retrieve/timer/bean/FetchBasicTimer;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchBasicTimer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static FetchTimerBasicBean parseJsonContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("jobId");
            String optString3 = jSONObject.optString("version");
            try {
                long parseLong = Long.parseLong(jSONObject.optString("expiredTime")) * 1000;
                if (parseLong < System.currentTimeMillis()) {
                    reportTaskCheckFail(optString, optString2, optString2, jSONObject);
                    return null;
                }
                return new FetchTimerBasicBean(optString2, optString, optString3, parseLong);
            } catch (Exception e) {
                reportTaskCheckFail(optString, optString2, optString3, jSONObject);
                if (DEBUG) {
                    Log.d(TAG, e.getMessage());
                }
                reportTaskCheckFail(optString, optString2, optString3, jSONObject);
                return null;
            }
        }
        return (FetchTimerBasicBean) invokeL.objValue;
    }

    public static void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, str2, str3, jSONObject) == null) {
            ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(str, str2, str3, jSONObject);
        }
    }
}
