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
public class HistoryLoginStat implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HistoryLoginStat";
    public static final String UBC_ID = "4921";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1513372521, "Lcom/baidu/sapi2/stat/HistoryLoginStat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1513372521, "Lcom/baidu/sapi2/stat/HistoryLoginStat;");
        }
    }

    /* loaded from: classes2.dex */
    public static class HistoryClickLoginStat implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_SENCE = "sence";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "smslogin";
        public static final String VALUE_SENCE_IN = "in";
        public static final String VALUE_SENCE_OUT = "out";
        public static final String VALUE_UNABLE = "0";
        public static String sValue;
        public static String sValueSence;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(377801956, "Lcom/baidu/sapi2/stat/HistoryLoginStat$HistoryClickLoginStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(377801956, "Lcom/baidu/sapi2/stat/HistoryLoginStat$HistoryClickLoginStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
            sValueSence = "out";
        }

        public HistoryClickLoginStat() {
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
                statExtMap.put("sence", sValueSence);
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(HistoryLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(HistoryLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(HistoryLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
                ubcUploadImplCallback.onEvent(HistoryLoginStat.UBC_ID, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class HistoryShowStat implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_AVAILABLE_COUNT = "available_count";
        public static final String KEY_EXT_HISTORY_COUNT = "history_count";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_PAGE = "getdpass";
        public static String sValue;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1689783464, "Lcom/baidu/sapi2/stat/HistoryLoginStat$HistoryShowStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1689783464, "Lcom/baidu/sapi2/stat/HistoryLoginStat$HistoryShowStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValue = "";
        }

        public HistoryShowStat() {
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
                    Log.e(HistoryLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(HistoryLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(HistoryLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
                ubcUploadImplCallback.onEvent(HistoryLoginStat.UBC_ID, jSONObject2);
                resetData();
            }
        }
    }

    public HistoryLoginStat() {
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
