package com.baidu.sapi2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SapiOptions implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_GRAY = 1000000;
    public static final String KEY_ADDRESS_USE_WEB = "address_use_web";
    public static final String KEY_AUTHORIZED_DOMAINS = "authorized_domains";
    public static final String KEY_CACHE = "cache";
    public static final String KEY_CACHE_ENABLED = "enabled";
    public static final String KEY_CACHE_GRAY = "cache_gray";
    public static final String KEY_CACHE_MODULES = "modules";
    public static final String KEY_CACHE_MODULE_DOWNLOAD_URL = "download_url";
    public static final String KEY_CACHE_MODULE_HASH = "hash";
    public static final String KEY_CACHE_MODULE_ID = "id";
    public static final String KEY_CACHE_PERCENT = "percent";
    public static final String KEY_CACHE_VERSION = "version";
    public static final String KEY_CUID_AUTHORIZED_DOMAINS = "cuid_authorized_domains";
    public static final String KEY_DEFAULT_HTTPS_ENABLED = "default_https_enabled";
    public static final String KEY_DI_EXCEPT_INDEX = "di_except_index";
    public static final String KEY_GLOBAL_SHARE_STRATEGY = "global_share_strategy";
    public static final String KEY_GRAY = "gray_android";
    public static final String KEY_JOIN_QR_LOGIN_PROMPT = "join_qr_login_prompt";
    public static final String KEY_LOGIN_COOKIE_DI_KEYS = "login_cookie_di_keys";
    public static final String KEY_LOGIN_STAT_EXTRA_LIMIT_LENGTH = "extrajson_limit_len";
    public static final String KEY_OPEN_BDUSS_CAN_GET_BDUSS = "can_get_bduss";
    public static final String KEY_OPEN_BDUSS_TPLS = "open_bduss_tpls";
    public static final String KEY_OPTN_BDUSS_DOMAINS = "open_bduss_domains";
    public static final String KEY_PASSHTTP_CLIENT_ASYNC_COOKIE = "pass_httpclient_async_cookie";
    public static final String KEY_RESET_FILE_EXEC_PER = "reset_file_exec_per";
    public static final String KEY_SHARE_CHECK_ONLINE_TIME_OUT = "share_check_online_time_out";
    public static final String KEY_SHARE_COMMOM_STORAGE_ENABLE = "share_common_storage_enable";
    public static final String KEY_SHARE_INTERNAL_STORAGE = "share_inter_storage_gray";
    public static final String KEY_SHARE_LIVINGUNAME_ENABLE = "share_livinguname_enabled";
    public static final String KEY_SPECIFIC_SHARE_STRATEGY = "specific_share_strategy";
    public static final String KEY_TID = "tid";
    public static final String defaultJoinQrLoginPrompt = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean addressUseWeb;
    public List<String> authorizedDomains;
    public Cache cache;
    public boolean canGetBduss;
    public List<String> cuidAuthorizedDomains;
    public boolean defaultHttpsEnabled;
    public List<Integer> diExceptIndex;
    public LoginShareStrategy globalShareStrategy;
    public Gray gray;
    public boolean httpClientAsyncCookie;
    public String joinQrLoginPrompt;
    public List<String> loginCookieDiKeys;
    public int loginStatExtraLimitLen;
    public List<String> openBdussDomains;
    public List<String> openBdussTpls;
    public boolean resetFileExecPer;
    public int shareCheckOnlineTimeOut;
    public boolean shareCommonStorageEnable;
    public int shareInterGray;
    public boolean shareLivingunameEnabled;
    public Map<String, LoginShareStrategy> specificShareStrategy;
    public String tid;

    /* loaded from: classes4.dex */
    public static class Cache {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTERNAL_CACHE_DIR = ".BD_SAPI_CACHE";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enabled;
        public List<Module> modules;
        public String version;

        /* loaded from: classes4.dex */
        public static class Module {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String downloadUrl;
            public String hash;
            public String id;

            public Module() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public static Module fromJSON(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    Module module = new Module();
                    module.id = jSONObject.optString("id");
                    module.downloadUrl = jSONObject.optString("download_url");
                    module.hash = jSONObject.optString(SapiOptions.KEY_CACHE_MODULE_HASH);
                    return module;
                }
                return (Module) invokeL.objValue;
            }

            public static String getAssetFile(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.replace(':', WebvttCueParser.CHAR_SLASH) : (String) invokeL.objValue;
            }

            public static String getExternalFile(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                    return ShareStorage.SP_FILE_PATH + getAssetFile(str);
                }
                return (String) invokeL.objValue;
            }

            public static String getInternalFile(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? getAssetFile(str).replace(WebvttCueParser.CHAR_SLASH, SignatureImpl.SEP) : (String) invokeL.objValue;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || Module.class != obj.getClass()) {
                        return false;
                    }
                    return this.id.equals(((Module) obj).id);
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.id.hashCode() : invokeV.intValue;
            }

            public JSONObject toJSON() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.id);
                        jSONObject.put("download_url", this.downloadUrl);
                        jSONObject.put(SapiOptions.KEY_CACHE_MODULE_HASH, this.hash);
                        return jSONObject;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        public Cache() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.modules = new ArrayList();
            this.enabled = true;
        }

        public static Cache fromJSON(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                Cache cache = new Cache();
                if (jSONObject != null) {
                    try {
                        cache.enabled = jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true);
                        cache.version = jSONObject.optLong("version") + "";
                        JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.KEY_CACHE_MODULES);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            cache.getModules().add(Module.fromJSON(optJSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                    }
                }
                return cache;
            }
            return (Cache) invokeL.objValue;
        }

        public List<Module> getModules() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.modules : (List) invokeV.objValue;
        }

        public String getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.version : (String) invokeV.objValue;
        }

        public boolean isEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enabled : invokeV.booleanValue;
        }

        public JSONObject toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SapiOptions.KEY_CACHE_ENABLED, this.enabled);
                    jSONObject.put("version", this.version);
                    JSONArray jSONArray = new JSONArray();
                    for (Module module : getModules()) {
                        jSONArray.put(module.toJSON());
                    }
                    jSONObject.put(SapiOptions.KEY_CACHE_MODULES, jSONArray);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class CacheGray {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Cache.Module> modules;
        public String percent;

        public CacheGray() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.modules = new ArrayList();
        }

        public static CacheGray fromJSON(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                CacheGray cacheGray = new CacheGray();
                if (jSONObject != null) {
                    try {
                        cacheGray.percent = jSONObject.optString("percent");
                        JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.KEY_CACHE_MODULES);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            cacheGray.getModules().add(Cache.Module.fromJSON(optJSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                    }
                }
                return cacheGray;
            }
            return (CacheGray) invokeL.objValue;
        }

        public List<Cache.Module> getModules() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.modules : (List) invokeV.objValue;
        }

        public String getPercent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.percent : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class Gray implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FUN_NAME_ADDRESS_NA_MAP = "addrmap";
        public static final String FUN_NAME_CHINA_MOBILE_OAUTH = "cm_oauth";
        public static final String FUN_NAME_CHINA_TELECOM_OAUTH = "ct_oauth";
        public static final String FUN_NAME_CHINA_UNICOM_OAUTH = "cu_oauth";
        public static final String FUN_NAME_CLIPBOARD_ADDR = "clipboard_addr";
        public static final String FUN_NAME_GINGER = "finger";
        public static final String FUN_NAME_MAPPING = "mapping";
        public static final String FUN_NAME_NUOMI_ADDR = "nuomi_addr";
        public static final String FUN_NAME_SHARE_V3 = "share_v3";
        public static final String FUN_NAME_SHARE_V4 = "share_v4";
        public static final String FUN_NAME_VALIDATE_SP_COMMIT = "validate_sp_commit";
        public static final String FUN_SHARE_CACHE_ABILITY = "fun_share_cache_ability";
        public static final String FUN_SHARE_MODEL_FROM_SERVER = "share_model_from_server";
        public static final String FUN_SHARE_V3_EXTERNAL_RECOVERY = "share_v3_external_recovery";
        public static String KEY_GRAY_EX = "ex";
        public static String KEY_GRAY_MEET = "meet";
        public static String KEY_GRAY_MIN_VERSION = "v";
        public static String KEY_GRAY_PERCENT = "p";
        public static String KEY_GRAY_TPLS = "t";
        public static final String KEY_NEW_INIT_SOFIRE = "new_init_sofire";
        public static final String KEY_SHARE_CHECK_ONLINE_SWITCH = "share_check_online_switch";
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, GrayModule> grayModuleMap;

        /* loaded from: classes4.dex */
        public static class GrayModule implements NoProguard {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String extraParams;
            public boolean meetGray;
            public String minVersion;
            public long percent;

            public GrayModule() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public static GrayModule fromJSON(String str, JSONObject jSONObject) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
                    SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                    GrayModule grayModule = new GrayModule();
                    JSONObject optJSONObject = jSONObject.has(Gray.KEY_GRAY_TPLS) ? jSONObject.optJSONObject(Gray.KEY_GRAY_TPLS).optJSONObject(confignation.tpl) : new JSONObject();
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    grayModule.minVersion = optJSONObject.has(Gray.KEY_GRAY_MIN_VERSION) ? optJSONObject.optString(Gray.KEY_GRAY_MIN_VERSION) : jSONObject.optString(Gray.KEY_GRAY_MIN_VERSION);
                    grayModule.percent = optJSONObject.has(Gray.KEY_GRAY_PERCENT) ? optJSONObject.optLong(Gray.KEY_GRAY_PERCENT) : jSONObject.optLong(Gray.KEY_GRAY_PERCENT);
                    grayModule.extraParams = optJSONObject.has(Gray.KEY_GRAY_EX) ? optJSONObject.optString(Gray.KEY_GRAY_EX) : jSONObject.optString(Gray.KEY_GRAY_EX);
                    long j = SapiContext.getInstance().getLong(str, -1L);
                    if (j == -1) {
                        Random random = new Random();
                        random.setSeed(System.currentTimeMillis());
                        j = random.nextInt(1000000);
                        SapiContext.getInstance().put(str, j);
                    }
                    grayModule.meetGray = grayModule.percent >= j;
                    if (!TextUtils.isEmpty(grayModule.minVersion) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), grayModule.minVersion) < 0) {
                        grayModule.meetGray = false;
                    }
                    return grayModule;
                }
                return (GrayModule) invokeLL.objValue;
            }

            public String getExtraParams() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.extraParams : (String) invokeV.objValue;
            }

            public String getMinVersion() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.minVersion : (String) invokeV.objValue;
            }

            public long getPercent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.percent : invokeV.longValue;
            }

            public boolean isMeetGray() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.meetGray : invokeV.booleanValue;
            }

            public JSONObject toJSON() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(Gray.KEY_GRAY_MIN_VERSION, this.minVersion);
                        jSONObject.put(Gray.KEY_GRAY_PERCENT, this.percent);
                        jSONObject.put(Gray.KEY_GRAY_EX, this.extraParams);
                        jSONObject.put(Gray.KEY_GRAY_MEET, this.meetGray);
                        return jSONObject;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(382613337, "Lcom/baidu/sapi2/SapiOptions$Gray;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(382613337, "Lcom/baidu/sapi2/SapiOptions$Gray;");
            }
        }

        public Gray() {
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
            this.grayModuleMap = new HashMap();
        }

        public static Gray fromJSON(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                Gray gray = new Gray();
                JSONObject optJSONObject = jSONObject.optJSONObject(SapiOptions.KEY_GRAY);
                if (optJSONObject == null) {
                    return gray;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        gray.grayModuleMap.put(obj, GrayModule.fromJSON(obj, optJSONObject.optJSONObject(obj)));
                    }
                }
                return gray;
            }
            return (Gray) invokeL.objValue;
        }

        public GrayModule getGrayModuleByFunName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                GrayModule grayModule = this.grayModuleMap.get(str);
                if (grayModule == null) {
                    GrayModule grayModule2 = new GrayModule();
                    grayModule2.meetGray = true;
                    return grayModule2;
                }
                return grayModule;
            }
            return (GrayModule) invokeL.objValue;
        }

        public JSONObject toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : this.grayModuleMap.keySet()) {
                    try {
                        jSONObject.put(str, this.grayModuleMap.get(str).toJSON());
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class PkgSigns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_AUTHORIZED_PACKAGES = "authorized_packages";
        public static final String KEY_SC_AUTHORIZED_PACKAGES = "sc_authorized_packages";
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> authorizedPackages;
        public Map<String, String> scAuthorizedPackages;

        public PkgSigns() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.authorizedPackages = new HashMap();
            this.scAuthorizedPackages = new HashMap();
        }

        public static PkgSigns fromJSON(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                PkgSigns pkgSigns = new PkgSigns();
                SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_AUTHORIZED_PACKAGES), pkgSigns.authorizedPackages);
                SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_SC_AUTHORIZED_PACKAGES), pkgSigns.scAuthorizedPackages);
                return pkgSigns;
            }
            return (PkgSigns) invokeL.objValue;
        }

        public Map<String, String> getAuthorizedPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.authorizedPackages.isEmpty()) {
                    return this.authorizedPackages;
                }
                return getInitialAuthorizedPackages();
            }
            return (Map) invokeV.objValue;
        }

        public Map<String, String> getInitialAuthorizedPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
                hashMap.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
                hashMap.put("com.baidu.searchbox(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.appsearch", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.BaiduMap(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.browser.(.+)", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.iknow", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.yuedu", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.homework", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.mbaby", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.travel", "0586742e88a2e6a19e996598ec336b61");
                hashMap.put("com.ting.mp3.android", "0586742e88a2e6a19e996598ec336b61");
                hashMap.put("com.baidu.news(.*)", "0586742e88a2e6a19e996598ec336b61");
                hashMap.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
                hashMap.put("com.baidu.hao123(.*)", "7fd3727852d29eb6f4283988dc0d6150");
                hashMap.put("com.baidu.netdisk(.*)", "ae5821440fab5e1a61a025f014bd8972");
                hashMap.put("com.hiapk.marketpho", "d46053ef4381d35cb774eb632d8e8aec");
                hashMap.put(SapiScheme.SC_APP_PACKAGENAME, "db97d206640d7aca6d75975b3c1f6e87");
                hashMap.put("com.nuomi", "59215ee95c063ff2c56226581a62130a");
                hashMap.put("cn.jingling.motu.photowonder", "6930f0bd9fa461c2cd65e216acee0118");
                hashMap.put("cn.opda.a.phonoalbumshoushou", "310a4f78e839b86df7731c2f48fcadae");
                hashMap.put("com.baidu.fb", "a4622402640f20dfda894cbe2edf8823");
                hashMap.put("com.baidu.baidutranslate", "0586742e88a2e6a19e996598ec336b61");
                hashMap.put("com.baidu.lbs.waimai", "77ad7ac419a031af0252422152c62e67");
                hashMap.put("com.baidu.lottery", "6e45686dd05db2374b0a600c7f28c0c4");
                hashMap.put("com.baidu.doctor", "49c95b74699e358ffe67f5daacab3d48");
                hashMap.put("com.baidu.patient", "49c95b74699e358ffe67f5daacab3d48");
                hashMap.put("com.zongheng.reader(.*)", "b9c43ba43f1e150d4f1670ae09a89a7f");
                hashMap.put("com.baidu.doctor.doctorask", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.k12edu", "610d60c69d2adf4b57fc6c2ec83fecbf");
                hashMap.put("com.baidu.wallet", "de74282b18c0847e64b2b3f0ebbfe0a0");
                hashMap.put("com.baidu.clouda.mobile.crm", "561e009b4a1f97012bf90dfed6c054d5");
                hashMap.put("com.dianxinos.optimizer.channel", "bd3df198d50f0dafa3c5804d342d3698");
                hashMap.put("com.baidu.lbs.bus", "3d96c8b0be8fd5b1db754b8dbb73f23e");
                hashMap.put("com.baidu.hui", "3102ce07daa9cb7c8d62c82fdc61c0ba");
                hashMap.put("com.baidu.image", "ff934173c55f54a81d9c5da216263479");
                hashMap.put("com.baidu.vip", "a00a833bf8afe07172262db3ccb3a5c5");
                hashMap.put("com.baidu.mami", "86743dc804add1dd5f3a81a5818ead58");
                hashMap.put("com.baidu.panocam", "c6186fde16482ce83196441e7fbed1b3");
                hashMap.put("com.baidu.dsocial", "49c95b74699e358ffe67f5daacab3d48");
                hashMap.put("com.qiyi.video", "846b46b26f2d9572124e4cfd778e8774");
                hashMap.put("tv.pps.mobile", "79a4816c58b11ba96e85524a7d5cf697");
                hashMap.put("com.baidu.cloudenterprise", "ae5821440fab5e1a61a025f014bd8972");
                hashMap.put("com.baidu.haokan", "7fd3727852d29eb6f4283988dc0d6150");
                hashMap.put("com.baidu.fangmi", "08e0e60c3b3a37ac88a2a06e86d0f8fa");
                hashMap.put("com.chuanke.ikk", "b12d5bcf96654b0a8da91256638695ab");
                hashMap.put("com.baidu.golf", "57ed129c4f9c2340b91d9f224d1478e7");
                hashMap.put("com.baidu.wefan", "7cc37b8563f320aee19809b1ee56cba7");
                hashMap.put("com.baidu.inote", "c266cc0c884249ce197bcf0cdacbe772");
                hashMap.put("com.baidu.album", "4ffb648ae77dbfc7f8d57593d9a6b50c");
                hashMap.put("com.baidu.eduai", "5a9c869602eb27e97af3eaec4d88160b");
                hashMap.put("com.baidu.eureka", "934e69310f5eb3234ba2067d67694ec9");
                hashMap.put("com.baidu.aiting", "0fb46b5e8f8d50dd5a8cda441c8af10d");
                hashMap.put("com.baidu.car.faceos", "9b284760b6eed6ad6ff793c5ad32736a");
                hashMap.put("com.baidu.nani", "dd473ebed169a590680a89351a596f60");
                hashMap.put("com.baidu.car.radio", "246ed007729a5f84a1886adfebce0d63");
                hashMap.put("com.baidu.che.codriver", "5a7c4b062a2292a56f5b7ff283bf3da5");
                hashMap.put("com.baidu.searchcraft", "88f73a1aa8439d646e7ee31c92684f9a");
                hashMap.put("com.baidu.minivideo", "7fd3727852d29eb6f4283988dc0d6150");
                hashMap.put("com.baidu.duer.superapp", "bd8af7603d638668269bff68aeffd05a");
                hashMap.put("com.zaijia.xiaodu", "ea36f50eb0a843f6f5063b897b5e9497");
                hashMap.put("com.baidu.aihome", "047b5448218d47f64f2d40009c20e306");
                hashMap.put("com.baidu.tingshu", "0fb46b5e8f8d50dd5a8cda441c8af10d");
                hashMap.put("com.baidu.auto.accountmanager", "e4cebec6e83e2817aaae40de3a2275cb");
                hashMap.put("car.baidu.carlink", "e4cebec6e83e2817aaae40de3a2275cb");
                hashMap.put("com.baidu.yuedupro", "5663095053b6d5e3cfb34b1286af472c");
                hashMap.put("com.baidu.xiaoduos.launcher", "8ddb342f2da5408402d7568af21e29f9");
                hashMap.put("com.baidu.iov.faceos", "9b284760b6eed6ad6ff793c5ad32736a");
                hashMap.put("com.baidu.searchbox.mission", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.intelligence.wm", "187cbd79d77a11cfdefdf63d6fd49272");
                hashMap.put("com.ivi.map", "9693645ee43055f27cee881ca6567f2c");
                hashMap.put("com.ivi.accountcenter", "9693645ee43055f27cee881ca6567f2c");
                hashMap.put("com.baidu.carlife", "e4cebec6e83e2817aaae40de3a2275cb");
                hashMap.put("com.xiaodu.smartspeaker", "09d3c630491bea65d747bc0e433c89f0");
                hashMap.put("com.baidu.live.assistant", "05ffabc16f5415dcfd5c52104041a3d3");
                hashMap.put("com.baidu.zhaopin", "2da0b26ff041f5bc3225ff00d8d6d38b");
                hashMap.put("com.baidu.xifan", "7e0543973c0a725830bf6d8f192e6774");
                hashMap.put("com.ford.oa.ap", "6815c19a21647794bdb19140c005b050");
                hashMap.put("com.baidu.iotsecurity", "35abb58862c10c50a5d746ec9db24de5");
                hashMap.put("com.baidu.tbflutterlite", "673004cf2f6efdec2385c8116c1e8c14");
                hashMap.put("com.baidu.baijia", "121c6e789e83fd28e8103ba0c7610955");
                hashMap.put("com.baidu.lemon", "db7265b0d6b46addf86ac746afa005c3");
                hashMap.put("com.baidu.mv.drama", "7fd3727852d29eb6f4283988dc0d6150");
                hashMap.put("com.baidu.youavideo", "ae5821440fab5e1a61a025f014bd8972");
                hashMap.put("com.baidu.gamenow", "26085162dd9d02784b4705f2b89f9e79");
                hashMap.put("com.baidu.autocar", "b0406d30b7fe65b186e969b1ee3b38ee");
                hashMap.put("com.baidu.voice.assistant", "77e0bd9fbce28dd13545826d352fd15f");
                hashMap.put("com.baidu.yinbo", "7fd3727852d29eb6f4283988dc0d6150");
                hashMap.put("com.baidu.apollo.go", "3335596e86b479021d8ef2a2a560ceb2");
                hashMap.put("com.baidu.aipurchase.buyer", "84c884d8daa7a674e81bcae0f6fdbc82");
                hashMap.put("com.baidu.xin.aiqicha", "9fd27d8a245e04de41f6d0756c1b31f7");
                hashMap.put("com.baidu.yiju", "3b7df5eb5b1592c160f37b22ff53350d");
                hashMap.put("com.baidu.duershow.swan", "ff3cc4b3dfcb2419ea8cf8abfcba6684");
                hashMap.put("com.baidu.launcher", "2171946eb93787d73348c42064b5c8b7");
                hashMap.put("com.baidu.rap", "44488ccee79ea8da05b4654a4d689016");
                hashMap.put(CommonMethods.PKGNAME_SKIP_CHECK_INPUT, "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.xiuxiu", "efa43c8bebf232432fd7c3559b34fe04");
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        public Map<String, String> getInitialSCAuthorizedPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("com.baidu.(.*)input(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.nuomi.merchant", "59215ee95c063ff2c56226581a62130a");
                hashMap.put("com.baidu.hi", "c2b0b497d0389e6de1505e7fd8f4d539");
                hashMap.put("com.baidu.finance", "3029dbf5932d8d9cd70d3f6e61a1bfaf");
                hashMap.put("com.baidu.searchcraft", "88f73a1aa8439d646e7ee31c92684f9a");
                hashMap.put("com.baidu.robot", "251b30bf338a35325dbcce7182009571");
                hashMap.put("com.baidu.carlife", "e4cebec6e83e2817aaae40de3a2275cb");
                hashMap.put("com.baidu.duer.smartmate", "b650a93303a12982d36ea9bbc1bba8");
                hashMap.put("com.baidu.wifikey", "a442374d6d1e3191490e9b1bf5bdf28f");
                hashMap.put("com.baidu.baijia", "121c6e789e83fd28e8103ba0c7610955");
                hashMap.put("com.baidu.mtjapp", "656365c98ade631c914b5aeac8737449");
                hashMap.put("com.baidu.umoney", "c2fad038465e40f47640e77c529165fb");
                hashMap.put("com.baidu.lbs.crowdapp", "dcbf2b2dc4c43c60cd09c09165de1b1f");
                hashMap.put("com.baidu.video.pad", "194981736af29076ef2e66238b70ba0d");
                hashMap.put("com.dianxinos.superuser", "bd3df198d50f0dafa3c5804d342d3698");
                hashMap.put("com.baidu.baiducamera", "ac979bc4100a1e17d145ca8a4d09bcde");
                hashMap.put("com.baidu.vrvision", "f250054dfbefd747928103b3c7146c95");
                hashMap.put("com.baidu.baike", "b729d38e6bca7cf35683f438159c000d");
                hashMap.put("com.baidu.bshop", "f099e273c67592854c51edccbb91005c");
                hashMap.put("com.baidu.motu.finder", "f555bc53b39fc3d5ceb16e1a9f5cf68b");
                hashMap.put("com.kezhuo", "525c84e2fa04915f12eb0a7bacdf7e8f");
                hashMap.put("com.baidu.roocontroller", "35abb58862c10c50a5d746ec9db24de5");
                hashMap.put("com.baidu.imesceneinput", "35abb58862c10c50a5d746ec9db24de5");
                hashMap.put("com.baidu.doctor.doctoranswer", "13a0a8019be4015ed20e075d824f1696");
                hashMap.put("com.baidu.dict", "b154fb69ae7b033725dabaaf1e3b70d0");
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        public Map<String, String> getSCAuthorizedPackages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!this.scAuthorizedPackages.isEmpty()) {
                    return this.scAuthorizedPackages;
                }
                return getInitialSCAuthorizedPackages();
            }
            return (Map) invokeV.objValue;
        }

        public String toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    SapiOptions.setMapToJson(jSONObject, KEY_AUTHORIZED_PACKAGES, this.authorizedPackages);
                    SapiOptions.setMapToJson(jSONObject, KEY_SC_AUTHORIZED_PACKAGES, this.scAuthorizedPackages);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public SapiOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.defaultHttpsEnabled = true;
        this.addressUseWeb = false;
        this.specificShareStrategy = new HashMap();
        this.authorizedDomains = new ArrayList();
        this.cuidAuthorizedDomains = new ArrayList();
        this.loginCookieDiKeys = new ArrayList();
        this.diExceptIndex = new ArrayList();
        this.openBdussTpls = new ArrayList();
        this.openBdussDomains = new ArrayList();
        this.canGetBduss = true;
        this.shareInterGray = 100;
        this.shareCheckOnlineTimeOut = 1000;
        this.joinQrLoginPrompt = defaultJoinQrLoginPrompt;
        this.cache = new Cache();
        this.gray = new Gray();
    }

    public static void cacheGrayTest(JSONObject jSONObject, SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONObject, sapiOptions) == null) {
            SapiContext sapiContext = SapiContext.getInstance();
            int i = sapiContext.getInt(KEY_CACHE_GRAY, -1);
            if (i == -1) {
                i = new Random().nextInt(100);
                sapiContext.put(KEY_CACHE_GRAY, i);
            }
            CacheGray fromJSON = CacheGray.fromJSON(jSONObject.optJSONObject(KEY_CACHE_GRAY));
            String percent = fromJSON.getPercent();
            if (TextUtils.isEmpty(percent)) {
                return;
            }
            String[] split = percent.split("_");
            int length = split.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += Integer.valueOf(split[i3]).intValue();
                if (i <= i2) {
                    sapiOptions.cache.modules.clear();
                    sapiOptions.cache.modules.add(fromJSON.modules.get(i3));
                    return;
                }
            }
        }
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            SapiOptions sapiOptions = new SapiOptions();
            sapiOptions.cache = Cache.fromJSON(jSONObject.optJSONObject("cache"));
            if (jSONObject.has(KEY_CACHE_GRAY)) {
                cacheGrayTest(jSONObject, sapiOptions);
            }
            sapiOptions.shareLivingunameEnabled = jSONObject.optBoolean(KEY_SHARE_LIVINGUNAME_ENABLE);
            sapiOptions.shareCommonStorageEnable = jSONObject.optBoolean(KEY_SHARE_COMMOM_STORAGE_ENABLE);
            sapiOptions.defaultHttpsEnabled = jSONObject.optBoolean(KEY_DEFAULT_HTTPS_ENABLED, true);
            sapiOptions.addressUseWeb = jSONObject.optBoolean(KEY_ADDRESS_USE_WEB);
            sapiOptions.shareInterGray = jSONObject.optInt(KEY_SHARE_INTERNAL_STORAGE, 0);
            sapiOptions.shareCheckOnlineTimeOut = jSONObject.optInt(KEY_SHARE_CHECK_ONLINE_TIME_OUT, 2000);
            String optString = jSONObject.optString(KEY_GLOBAL_SHARE_STRATEGY);
            if (!TextUtils.isEmpty(optString)) {
                sapiOptions.globalShareStrategy = LoginShareStrategy.mapStrToValue(optString);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(KEY_SPECIFIC_SHARE_STRATEGY);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    sapiOptions.specificShareStrategy.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
                }
            }
            setJsonArrayToList(jSONObject.optJSONArray(KEY_AUTHORIZED_DOMAINS), sapiOptions.authorizedDomains);
            setJsonArrayToList(jSONObject.optJSONArray(KEY_CUID_AUTHORIZED_DOMAINS), sapiOptions.cuidAuthorizedDomains);
            setJsonArrayToList(jSONObject.optJSONArray(KEY_LOGIN_COOKIE_DI_KEYS), sapiOptions.loginCookieDiKeys);
            setJsonArrayToList(jSONObject.optJSONArray(KEY_OPEN_BDUSS_TPLS), sapiOptions.openBdussTpls);
            setJsonArrayToList(jSONObject.optJSONArray(KEY_OPTN_BDUSS_DOMAINS), sapiOptions.openBdussDomains);
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_DI_EXCEPT_INDEX);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    sapiOptions.diExceptIndex.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            sapiOptions.loginStatExtraLimitLen = jSONObject.optInt(KEY_LOGIN_STAT_EXTRA_LIMIT_LENGTH, 100);
            sapiOptions.httpClientAsyncCookie = jSONObject.optBoolean(KEY_PASSHTTP_CLIENT_ASYNC_COOKIE, false);
            sapiOptions.resetFileExecPer = jSONObject.optBoolean(KEY_RESET_FILE_EXEC_PER, false);
            sapiOptions.joinQrLoginPrompt = jSONObject.optString(KEY_JOIN_QR_LOGIN_PROMPT, defaultJoinQrLoginPrompt);
            sapiOptions.gray = Gray.fromJSON(jSONObject);
            sapiOptions.canGetBduss = jSONObject.optBoolean(KEY_OPEN_BDUSS_CAN_GET_BDUSS, true);
            sapiOptions.tid = jSONObject.optString("tid");
            return sapiOptions;
        }
        return (SapiOptions) invokeL.objValue;
    }

    public static List<String> getInitialAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("baidu.com");
            arrayList.add("hao123.com");
            arrayList.add("nuomi.com");
            arrayList.add("baifubao.com");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static List<String> getInitialCachePackagesWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.baidu.browser.(.+)");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static List<String> getInitialCuidAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("nsclick.baidu.com");
            arrayList.add("passport.baidu.com");
            arrayList.add("wappass.baidu.com");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static List<String> getInitialProcessNameWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.baidu.BaiduMap(.*)");
            arrayList.add("cn.opda.a.phonoalbumshoushou(.*)");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void setJsonArrayToList(JSONArray jSONArray, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, jSONArray, list) == null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                list.add(jSONArray.optString(i));
            }
        }
    }

    public static void setJsonToMap(JSONObject jSONObject, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, jSONObject, map) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                map.put(next, optString);
            }
        }
    }

    public static void setListToJsonArray(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, jSONObject, str, list) == null) {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : list) {
                jSONArray.put(str2);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    public static void setMapToJson(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, jSONObject, str, map) == null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    public boolean getAddressUseWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.addressUseWeb : invokeV.booleanValue;
    }

    public List<String> getAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.authorizedDomains.isEmpty()) {
                return this.authorizedDomains;
            }
            return getInitialAuthorizedDomains();
        }
        return (List) invokeV.objValue;
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
            String replaceAll = confignation.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            arrayList.add(replaceAll);
            arrayList.add(replaceAll2);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getAuthorizedPackagesForPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.baidu.searchbox(.*)");
            arrayList.add("com.baidu.browser.(.+)");
            arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getAuthorizedPackagesForUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public Cache getCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cache : (Cache) invokeV.objValue;
    }

    public List<String> getCuidAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.cuidAuthorizedDomains.isEmpty()) {
                return this.cuidAuthorizedDomains;
            }
            return getInitialCuidAuthorizedDomains();
        }
        return (List) invokeV.objValue;
    }

    public boolean getDefaultHttpsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.defaultHttpsEnabled : invokeV.booleanValue;
    }

    public LoginShareStrategy getGlobalShareStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.globalShareStrategy : (LoginShareStrategy) invokeV.objValue;
    }

    public boolean getHttpAsyncCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.httpClientAsyncCookie : invokeV.booleanValue;
    }

    public List<String> getLoginCookieDiKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.loginCookieDiKeys : (List) invokeV.objValue;
    }

    public List<String> getOpenBdussDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("baifubao.com");
            arrayList.add("duxiaoman.com");
            arrayList.add("dxmpay.com");
            arrayList.add("baiyingfund.com");
            arrayList.add("dxmbaoxian.com");
            arrayList.add("duxiaomanfund.com");
            arrayList.add("baidu.com");
            if (!this.openBdussDomains.isEmpty()) {
                arrayList.addAll(this.openBdussDomains);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getOpenBdussTpls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("licai");
            arrayList.add("baidugushitong");
            arrayList.add("walletloan");
            arrayList.add("baiduwalletapp");
            arrayList.add("umoney_ios");
            arrayList.add("walletloan_lite");
            arrayList.add("bdwalletsdk");
            if (!this.openBdussTpls.isEmpty()) {
                arrayList.addAll(this.openBdussTpls);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.searchbox(.*)", 4);
            hashMap.put("com.baidu.BaiduMap(.*)", 5);
            hashMap.put("com.baidu.tieba(.*)", 6);
            hashMap.put("com.baidu.netdisk(.*)", 7);
            hashMap.put("com.baidu.appsearch", 8);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.specificShareStrategy : (Map) invokeV.objValue;
    }

    public void setCache(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cache) == null) {
            this.cache = cache;
        }
    }

    public String toJSON() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cache", this.cache.toJSON());
                jSONObject.put(KEY_SHARE_LIVINGUNAME_ENABLE, this.shareLivingunameEnabled);
                jSONObject.put(KEY_SHARE_COMMOM_STORAGE_ENABLE, this.shareCommonStorageEnable);
                jSONObject.put(KEY_SHARE_INTERNAL_STORAGE, this.shareInterGray);
                jSONObject.put(KEY_SHARE_CHECK_ONLINE_TIME_OUT, this.shareCheckOnlineTimeOut);
                if (this.globalShareStrategy != null) {
                    jSONObject.put(KEY_GLOBAL_SHARE_STRATEGY, this.globalShareStrategy.getStrValue());
                }
                jSONObject.put(KEY_DEFAULT_HTTPS_ENABLED, this.defaultHttpsEnabled);
                jSONObject.put(KEY_ADDRESS_USE_WEB, this.addressUseWeb);
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, LoginShareStrategy> entry : this.specificShareStrategy.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
                }
                jSONObject.put(KEY_SPECIFIC_SHARE_STRATEGY, jSONObject2);
                setListToJsonArray(jSONObject, KEY_AUTHORIZED_DOMAINS, this.authorizedDomains);
                setListToJsonArray(jSONObject, KEY_CUID_AUTHORIZED_DOMAINS, this.cuidAuthorizedDomains);
                setListToJsonArray(jSONObject, KEY_LOGIN_COOKIE_DI_KEYS, this.loginCookieDiKeys);
                setListToJsonArray(jSONObject, KEY_OPEN_BDUSS_TPLS, this.openBdussTpls);
                setListToJsonArray(jSONObject, KEY_OPTN_BDUSS_DOMAINS, this.openBdussDomains);
                JSONArray jSONArray = new JSONArray();
                for (Integer num : this.diExceptIndex) {
                    jSONArray.put(num);
                }
                jSONObject.put(KEY_DI_EXCEPT_INDEX, jSONArray);
                jSONObject.put(KEY_LOGIN_STAT_EXTRA_LIMIT_LENGTH, this.loginStatExtraLimitLen);
                jSONObject.put(KEY_PASSHTTP_CLIENT_ASYNC_COOKIE, this.httpClientAsyncCookie);
                jSONObject.put(KEY_RESET_FILE_EXEC_PER, this.resetFileExecPer);
                jSONObject.put(KEY_JOIN_QR_LOGIN_PROMPT, this.joinQrLoginPrompt);
                jSONObject.put(KEY_GRAY, this.gray.toJSON());
                jSONObject.put(KEY_OPEN_BDUSS_CAN_GET_BDUSS, this.canGetBduss);
                jSONObject.put("tid", this.tid);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
