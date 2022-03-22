package com.baidu.sapi2.stat;

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
/* loaded from: classes4.dex */
public class OneKeyLoginStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OneKeyLoginStat";
    public static final String UBC_ID_ONEKEY_LOGIN = "4920";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class CheckAbility {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_CONNECTTIMEOUT = "connectTimeout";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_JS_ABLE = "js_able";
        public static final String KEY_EXT_JS_ABLE_REPETITION = "js_able_repetition";
        public static final String KEY_EXT_JS_DUR = "js_dur";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_PHONENUM = "phoneNum";
        public static final String KEY_EXT_SCENE = "scene";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_check_ability";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1144487248, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$CheckAbility;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1144487248, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$CheckAbility;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public CheckAbility() {
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
                    Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_PAGE);
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LoadLogin {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_DUR_JS = "dur_js";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_load_login";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1694530721, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$LoadLogin;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1694530721, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$LoadLogin;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public LoadLogin() {
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
                    Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_PAGE);
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class OauthToken {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_SUBCODE = "subCode";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_oauth_token";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1286710736, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$OauthToken;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1286710736, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$OauthToken;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public OauthToken() {
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
                    Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_PAGE);
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class PreGetPhoneStat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_CONNECTTIMEOUT = "connectTimeout";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_IS_ABLE_SIM = "is_able_sim";
        public static final String KEY_EXT_IS_GRAY = "is_gray";
        public static final String KEY_EXT_IS_LOGIN = "is_login";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_PHONENUM = "phoneNum";
        public static final String KEY_EXT_SCENE = "scene";
        public static final String KEY_EXT_SUBCODE = "subCode";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_pre_get_phone";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1238053141, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$PreGetPhoneStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1238053141, "Lcom/baidu/sapi2/stat/OneKeyLoginStat$PreGetPhoneStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public PreGetPhoneStat() {
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
                    Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_PAGE);
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", sValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1935016608, "Lcom/baidu/sapi2/stat/OneKeyLoginStat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1935016608, "Lcom/baidu/sapi2/stat/OneKeyLoginStat;");
        }
    }

    public OneKeyLoginStat() {
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
