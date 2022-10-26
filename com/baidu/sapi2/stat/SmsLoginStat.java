package com.baidu.sapi2.stat;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SmsLoginStat implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SmsLoginStat";
    public static final String UBC_ID = "4922";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(600757614, "Lcom/baidu/sapi2/stat/SmsLoginStat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(600757614, "Lcom/baidu/sapi2/stat/SmsLoginStat;");
        }
    }

    /* loaded from: classes2.dex */
    public class GetdpassStat implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "getdpass";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(545611441, "Lcom/baidu/sapi2/stat/SmsLoginStat$GetdpassStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(545611441, "Lcom/baidu/sapi2/stat/SmsLoginStat$GetdpassStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public GetdpassStat() {
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

        public static void resetData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                statExtMap.clear();
                sValue = "";
            }
        }

        public static void upload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(SmsLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(SmsLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(SmsLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", "getdpass");
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(SmsLoginStat.UBC_ID, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SmsClickLoginStat implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "smslogin";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(28605764, "Lcom/baidu/sapi2/stat/SmsLoginStat$SmsClickLoginStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(28605764, "Lcom/baidu/sapi2/stat/SmsLoginStat$SmsClickLoginStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public SmsClickLoginStat() {
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

        public static void resetData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                statExtMap.clear();
                sValue = "";
            }
        }

        public static void upload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(SmsLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(SmsLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(SmsLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", "smslogin");
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(SmsLoginStat.UBC_ID, jSONObject2);
                resetData();
            }
        }
    }

    public SmsLoginStat() {
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
}
