package com.baidu.sapi2.stat;

import android.content.Context;
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
/* loaded from: classes10.dex */
public class ShareLoginStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ShareLoginStat";
    public static final String UBC_ID_SHARE_LOGIN = "4833";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class GetShareListStat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_ACCOUNT_APPS = "account_apps";
        public static final String KEY_ACCOUNT_SIZE = "account_size";
        public static final String KEY_ACCOUNT_TPLS = "account_tpls";
        public static final String KEY_API_NAME = "api_name";
        public static final String KEY_CHECK_BDUSS_APP = "check_bduss_app";
        public static final String KEY_EXT = "ext";
        public static final String KEY_FROM = "from";
        public static final String KEY_FROM_NET_ERRCODE = "from_net_errcode";
        public static final String KEY_FROM_NET_GRAY = "from_net_gray";
        public static final String KEY_GRAY = "gray";
        public static final String KEY_IS_ABLE = "is_able";
        public static final String KEY_IS_CHECK_BDUSS = "is_check_bduss";
        public static final String KEY_IS_DEBUG = "is_debug";
        public static final String KEY_IS_TIMEOUT_FROM_NET = "is_timeout_from_net";
        public static final String KEY_IS_V3_DEMOTION = "is_v3_demotion";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SENCE = "sence";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_V2_INITIAL_SIZE = "v2_initial_size";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_API_NAME_NEW = "getShareModels";
        public static final String VALUE_API_NAME_V2 = "getV2ShareModelList";
        public static final String VALUE_FROM_CACHE = "cache";
        public static final String VALUE_FROM_NET = "net";
        public static final String VALUE_FROM_SD = "sd";
        public static final String VALUE_FROM_SP = "sp";
        public static final String VALUE_NAME = "get_share_accounts";
        public static final String VALUE_SENCE_IN = "in";
        public static final String VALUE_SENCE_OUT = "out";
        public static final String VALUE_UNABLE = "0";
        public static String sValueSence;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(388392227, "Lcom/baidu/sapi2/stat/ShareLoginStat$GetShareListStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(388392227, "Lcom/baidu/sapi2/stat/ShareLoginStat$GetShareListStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValueSence = "out";
        }

        public GetShareListStat() {
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

        public static void resetData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                statExtMap.clear();
                sValueSence = "out";
            }
        }

        public static void upload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                statExtMap.put("sence", sValueSence);
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(ShareLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(ShareLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(ShareLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_NAME);
                    jSONObject2.put("ext", jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(ShareLoginStat.UBC_ID_SHARE_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class MakeShareLoginStat {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_ERRMSG = "errorMsg";
        public static final String KEY_ERRNO = "errorNo";
        public static final String KEY_EXT = "ext";
        public static final String KEY_FROM_APP_NAME = "from_app_name";
        public static final String KEY_FROM_PKG = "from_pkg";
        public static final String KEY_FROM_TPL = "from_tpl";
        public static final String KEY_IS_INSTALL = "is_install";
        public static final String KEY_NEED_AUTH = "need_auth";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SENCE = "sence";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_SUCCESS = "is_success";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_NAME = "make_share_login";
        public static final String VALUE_SENCE_IN = "in";
        public static final String VALUE_SENCE_OUT = "out";
        public static final String VALUE_UNABLE = "0";
        public static String sValueSence;
        public static Map<String, Object> statExtMap;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-808586734, "Lcom/baidu/sapi2/stat/ShareLoginStat$MakeShareLoginStat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-808586734, "Lcom/baidu/sapi2/stat/ShareLoginStat$MakeShareLoginStat;");
                    return;
                }
            }
            statExtMap = new HashMap();
            sValueSence = "out";
        }

        public MakeShareLoginStat() {
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

        public static void resetData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                statExtMap.clear();
                sValueSence = "out";
            }
        }

        public static void upload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                statExtMap.put("sence", sValueSence);
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(ShareLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(ShareLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(ShareLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    SapiConfiguration confignation = isAccountManager.getConfignation();
                    if (confignation != null) {
                        jSONObject2.put("source", confignation.getTpl());
                    }
                    jSONObject2.put("page", VALUE_NAME);
                    jSONObject2.put("ext", jSONObject);
                    jSONObject2.put("value", statExtMap.get(KEY_SUCCESS));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ubcUploadImplCallback.onEvent(ShareLoginStat.UBC_ID_SHARE_LOGIN, jSONObject2);
                resetData();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-271702348, "Lcom/baidu/sapi2/stat/ShareLoginStat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-271702348, "Lcom/baidu/sapi2/stat/ShareLoginStat;");
        }
    }

    public ShareLoginStat() {
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

    public void onStat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }
}
