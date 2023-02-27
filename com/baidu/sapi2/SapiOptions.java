package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.webkit.sdk.WebViewFactory;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiOptions implements NoProguard {
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
    public static final String KEY_DEFAULT_SELECT_AGREEMENT_TPLS = "default_select_agreement_tpls";
    public static final String KEY_DIALOG_LOGIN_CONFIG = "dialog_login_config";
    public static final String KEY_DI_EXCEPT_INDEX = "di_except_index";
    public static final String KEY_GLOBAL_SHARE_STRATEGY = "global_share_strategy";
    public static final String KEY_GRAY = "gray_android";
    public static final String KEY_JOIN_QR_LOGIN_PROMPT = "join_qr_login_prompt";
    public static final String KEY_LOGIN_COOKIE_DI_KEYS = "login_cookie_di_keys";
    public static final String KEY_LOGIN_STAT_EXTRA_LIMIT_LENGTH = "extrajson_limit_len";
    public static final String KEY_LOGIN_TPLS_PRIORITY = "login_tpls_priority";
    public static final String KEY_OPEN_BDUSS_CAN_GET_BDUSS = "can_get_bduss";
    public static final String KEY_OPEN_BDUSS_TPLS = "open_bduss_tpls";
    public static final String KEY_OPTN_BDUSS_DOMAINS = "open_bduss_domains";
    public static final String KEY_PASSHTTP_CLIENT_ASYNC_COOKIE = "pass_httpclient_async_cookie";
    public static final String KEY_RESET_FILE_EXEC_PER = "reset_file_exec_per";
    public static final String KEY_SHARE_CHECK_ONLINE_TIME_OUT = "share_check_online_time_out";
    public static final String KEY_SHARE_COMMOM_STORAGE_ENABLE = "share_common_storage_enable";
    public static final String KEY_SHARE_INTERNAL_STORAGE = "share_inter_storage_gray";
    public static final String KEY_SHARE_LIVINGUNAME_ENABLE = "share_livinguname_enabled";
    public static final String KEY_SHOW_CHILREN_AGREEMENT = "show_chilren_agreement";
    public static final String KEY_SPECIFIC_SHARE_STRATEGY = "specific_share_strategy";
    public static final String KEY_TID = "tid";
    public static final String defaultJoinQrLoginPrompt = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    public List<String> dialogSelectAgreementTpls;
    public LoginShareStrategy globalShareStrategy;
    public boolean httpClientAsyncCookie;
    public int loginStatExtraLimitLen;
    public Map<String, JSONArray> loginTplsPriority;
    public boolean resetFileExecPer;
    public boolean shareCommonStorageEnable;
    public boolean shareLivingunameEnabled;
    public String tid;
    public boolean defaultHttpsEnabled = true;
    public boolean addressUseWeb = false;
    public Map<String, LoginShareStrategy> specificShareStrategy = new HashMap();
    public List<String> authorizedDomains = new ArrayList();
    public List<String> cuidAuthorizedDomains = new ArrayList();
    public List<String> loginCookieDiKeys = new ArrayList();
    public List<Integer> diExceptIndex = new ArrayList();
    public List<String> openBdussTpls = new ArrayList();
    public List<String> openBdussDomains = new ArrayList();
    public boolean canGetBduss = true;
    public int shareInterGray = 100;
    public int shareCheckOnlineTimeOut = 1000;
    public String joinQrLoginPrompt = defaultJoinQrLoginPrompt;
    public boolean dialogShowChilrenAgreement = true;
    public Cache cache = new Cache();
    public Gray gray = new Gray();

    /* loaded from: classes2.dex */
    public static class Cache {
        public static final String EXTERNAL_CACHE_DIR = ".BD_SAPI_CACHE";
        public String version;
        public List<Module> modules = new ArrayList();
        public boolean enabled = true;

        /* loaded from: classes2.dex */
        public static class Module {
            public String downloadUrl;
            public String hash;
            public String id;

            public int hashCode() {
                return this.id.hashCode();
            }

            public JSONObject toJSON() {
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

            public static Module fromJSON(JSONObject jSONObject) {
                Module module = new Module();
                module.id = jSONObject.optString("id");
                module.downloadUrl = jSONObject.optString("download_url");
                module.hash = jSONObject.optString(SapiOptions.KEY_CACHE_MODULE_HASH);
                return module;
            }

            public static String getAssetFile(String str) {
                return str.replace(':', WebvttCueParser.CHAR_SLASH);
            }

            public static String getExternalFile(String str) {
                return ShareStorage.SP_FILE_PATH + getAssetFile(str);
            }

            public static String getInternalFile(String str) {
                return getAssetFile(str).replace(WebvttCueParser.CHAR_SLASH, SignatureImpl.SEP);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && Module.class == obj.getClass()) {
                    return this.id.equals(((Module) obj).id);
                }
                return false;
            }
        }

        public List<Module> getModules() {
            return this.modules;
        }

        public String getVersion() {
            return this.version;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public static Cache fromJSON(JSONObject jSONObject) {
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

        public JSONObject toJSON() {
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
    }

    /* loaded from: classes2.dex */
    public static class Gray implements NoProguard {
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
        public static final String KEY_FUSION = "fusion";
        public static String KEY_GRAY_EX = "ex";
        public static String KEY_GRAY_MEET = "meet";
        public static String KEY_GRAY_MIN_VERSION = "v";
        public static String KEY_GRAY_PERCENT = "p";
        public static String KEY_GRAY_TPLS = "t";
        public static final String KEY_NEW_INIT_SOFIRE = "new_init_sofire";
        public static final String KEY_OB_TITLE = "ob_title";
        public static final String KEY_SHARE_CHECK_ONLINE_SWITCH = "share_check_online_switch";
        public Map<String, GrayModule> grayModuleMap = new HashMap();

        /* loaded from: classes2.dex */
        public static class GrayModule implements NoProguard {
            public String extraParams;
            public boolean meetGray;
            public String minVersion;
            public long percent;

            public String getExtraParams() {
                return this.extraParams;
            }

            public String getMinVersion() {
                return this.minVersion;
            }

            public long getPercent() {
                return this.percent;
            }

            public boolean isMeetGray() {
                return this.meetGray;
            }

            public JSONObject toJSON() {
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

            public static GrayModule fromJSON(String str, JSONObject jSONObject) {
                JSONObject jSONObject2;
                String optString;
                long optLong;
                String optString2;
                boolean z;
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                GrayModule grayModule = new GrayModule();
                if (jSONObject.has(Gray.KEY_GRAY_TPLS)) {
                    jSONObject2 = jSONObject.optJSONObject(Gray.KEY_GRAY_TPLS).optJSONObject(confignation.tpl);
                } else {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2.has(Gray.KEY_GRAY_MIN_VERSION)) {
                    optString = jSONObject2.optString(Gray.KEY_GRAY_MIN_VERSION);
                } else {
                    optString = jSONObject.optString(Gray.KEY_GRAY_MIN_VERSION);
                }
                grayModule.minVersion = optString;
                if (jSONObject2.has(Gray.KEY_GRAY_PERCENT)) {
                    optLong = jSONObject2.optLong(Gray.KEY_GRAY_PERCENT);
                } else {
                    optLong = jSONObject.optLong(Gray.KEY_GRAY_PERCENT);
                }
                grayModule.percent = optLong;
                if (jSONObject2.has(Gray.KEY_GRAY_EX)) {
                    optString2 = jSONObject2.optString(Gray.KEY_GRAY_EX);
                } else {
                    optString2 = jSONObject.optString(Gray.KEY_GRAY_EX);
                }
                grayModule.extraParams = optString2;
                long j = SapiContext.getInstance().getLong(str, -1L);
                if (j == -1) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    j = random.nextInt(1000000);
                    SapiContext.getInstance().put(str, j);
                }
                if (grayModule.percent >= j) {
                    z = true;
                } else {
                    z = false;
                }
                grayModule.meetGray = z;
                if (!TextUtils.isEmpty(grayModule.minVersion) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), grayModule.minVersion) < 0) {
                    grayModule.meetGray = false;
                }
                return grayModule;
            }
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.grayModuleMap.keySet()) {
                try {
                    jSONObject.put(str, this.grayModuleMap.get(str).toJSON());
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return jSONObject;
        }

        public static Gray fromJSON(JSONObject jSONObject) {
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

        public GrayModule getGrayModuleByFunName(String str) {
            GrayModule grayModule = this.grayModuleMap.get(str);
            if (grayModule == null) {
                GrayModule grayModule2 = new GrayModule();
                grayModule2.meetGray = true;
                return grayModule2;
            }
            return grayModule;
        }
    }

    /* loaded from: classes2.dex */
    public static class CacheGray {
        public List<Cache.Module> modules = new ArrayList();
        public String percent;

        public List<Cache.Module> getModules() {
            return this.modules;
        }

        public String getPercent() {
            return this.percent;
        }

        public static CacheGray fromJSON(JSONObject jSONObject) {
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
    }

    /* loaded from: classes2.dex */
    public static class PkgSigns {
        public static final String KEY_AUTHORIZED_PACKAGES = "authorized_packages";
        public static final String KEY_SC_AUTHORIZED_PACKAGES = "sc_authorized_packages";
        public Map<String, String> authorizedPackages = new HashMap();
        public Map<String, String> scAuthorizedPackages = new HashMap();

        public Map<String, String> getAuthorizedPackages() {
            if (!this.authorizedPackages.isEmpty()) {
                return this.authorizedPackages;
            }
            return getInitialAuthorizedPackages();
        }

        public Map<String, String> getSCAuthorizedPackages() {
            if (!this.scAuthorizedPackages.isEmpty()) {
                return this.scAuthorizedPackages;
            }
            return getInitialSCAuthorizedPackages();
        }

        public String toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                SapiOptions.setMapToJson(jSONObject, KEY_AUTHORIZED_PACKAGES, this.authorizedPackages);
                SapiOptions.setMapToJson(jSONObject, KEY_SC_AUTHORIZED_PACKAGES, this.scAuthorizedPackages);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }

        public static PkgSigns fromJSON(JSONObject jSONObject) {
            PkgSigns pkgSigns = new PkgSigns();
            SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_AUTHORIZED_PACKAGES), pkgSigns.authorizedPackages);
            SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_SC_AUTHORIZED_PACKAGES), pkgSigns.scAuthorizedPackages);
            return pkgSigns;
        }

        public Map<String, String> getInitialAuthorizedPackages() {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.sapi2.demo.standard", "de308d7973b5171883333a97253327e4");
            hashMap.put("com.baidu.searchbox", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put(BdSailorPlatform.LITE_PACKAGE_NAME, "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.searchbox.tomas", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.searchbox.senior", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.searchbox.vision", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.searchbox.mission", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.tieba", "673004cf2f6efdec2385c8116c1e8c14");
            hashMap.put("com.baidu.BaiduMap", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.netdisk", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put("com.baidu.netdisk.xiaomi", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put("com.baidu.netdisk.meizu", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put("com.baidu.netdisk.samsung", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put("com.baidu.netdisk.yonth", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put("com.baidu.netdisk.tv", "ae5821440fab5e1a61a025f014bd8972");
            hashMap.put(WebViewFactory.CHROMIUM_HOST_APP, "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.news", "0586742e88a2e6a19e996598ec336b61");
            hashMap.put("com.baidu.hao123", "7fd3727852d29eb6f4283988dc0d6150");
            hashMap.put("com.baidu.appsearch", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.iknow", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.yuedu", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.homework", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.wenku", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.mbaby", "13a0a8019be4015ed20e075d824f1696");
            hashMap.put("com.baidu.travel", "0586742e88a2e6a19e996598ec336b61");
            hashMap.put("com.ting.mp3.android", "0586742e88a2e6a19e996598ec336b61");
            hashMap.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
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
            hashMap.put("com.baidu.carlife", "e4cebec6e83e2817aaae40de3a2275cb");
            hashMap.put("com.baidu.yuedupro", "5663095053b6d5e3cfb34b1286af472c");
            hashMap.put("com.baidu.xiaoduos.launcher", "8ddb342f2da5408402d7568af21e29f9");
            hashMap.put("com.baidu.iov.faceos", "9b284760b6eed6ad6ff793c5ad32736a");
            hashMap.put("com.intelligence.wm", "187cbd79d77a11cfdefdf63d6fd49272");
            hashMap.put("com.ivi.map", "9693645ee43055f27cee881ca6567f2c");
            hashMap.put("com.ivi.accountcenter", "9693645ee43055f27cee881ca6567f2c");
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
            hashMap.put("com.baidu.input", "c2b0b497d0389e6de1505e7fd8f4d539");
            hashMap.put("com.baidu.xiuxiu", "efa43c8bebf232432fd7c3559b34fe04");
            return hashMap;
        }

        public Map<String, String> getInitialSCAuthorizedPackages() {
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
    }

    public static void setJsonArrayToList(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                    list.add(jSONArray.optString(i));
                }
            }
        }
    }

    public static void setJsonToMap(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    map.put(next, optString);
                }
            }
        }
    }

    public static void setListToJsonArray(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : list) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }

    public static void setMapToJson(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put(str, jSONObject2);
    }

    public static void cacheGrayTest(JSONObject jSONObject, SapiOptions sapiOptions) {
        SapiContext sapiContext = SapiContext.getInstance();
        int i = sapiContext.getInt(KEY_CACHE_GRAY, -1);
        if (i == -1) {
            i = new Random().nextInt(100);
            sapiContext.put(KEY_CACHE_GRAY, i);
        }
        CacheGray fromJSON = CacheGray.fromJSON(jSONObject.optJSONObject(KEY_CACHE_GRAY));
        String percent = fromJSON.getPercent();
        if (!TextUtils.isEmpty(percent)) {
            String[] split = percent.split("_");
            int length = split.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += Integer.valueOf(split[i3]).intValue();
                if (i <= i2) {
                    sapiOptions.cache.modules.clear();
                    sapiOptions.cache.modules.add((Cache.Module) fromJSON.modules.get(i3));
                    return;
                }
            }
        }
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
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
        JSONObject optJSONObject2 = jSONObject.optJSONObject(KEY_DIALOG_LOGIN_CONFIG);
        if (optJSONObject2 != null) {
            sapiOptions.dialogShowChilrenAgreement = optJSONObject2.optBoolean(KEY_SHOW_CHILREN_AGREEMENT, true);
            sapiOptions.dialogSelectAgreementTpls = new ArrayList();
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray(KEY_DEFAULT_SELECT_AGREEMENT_TPLS);
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    sapiOptions.dialogSelectAgreementTpls.add((String) optJSONArray2.opt(i2));
                }
            }
            sapiOptions.loginTplsPriority = new HashMap();
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(KEY_LOGIN_TPLS_PRIORITY);
            if (optJSONObject3 != null) {
                Iterator<String> keys2 = optJSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray(next2);
                    if (optJSONArray3 != null) {
                        sapiOptions.loginTplsPriority.put(next2, optJSONArray3);
                    }
                }
            }
        }
        return sapiOptions;
    }

    public static List<String> getInitialAuthorizedDomains() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    public static List<String> getInitialCachePackagesWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    public static List<String> getInitialCuidAuthorizedDomains() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    public static List<String> getInitialProcessNameWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.BaiduMap(.*)");
        arrayList.add("cn.opda.a.phonoalbumshoushou(.*)");
        return arrayList;
    }

    public boolean getAddressUseWeb() {
        return this.addressUseWeb;
    }

    public List<String> getAuthorizedDomains() {
        if (!this.authorizedDomains.isEmpty()) {
            return this.authorizedDomains;
        }
        return getInitialAuthorizedDomains();
    }

    public List<String> getAuthorizedPackagesForPtoken() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    public List<String> getAuthorizedPackagesForUA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    public Cache getCache() {
        return this.cache;
    }

    public List<String> getCuidAuthorizedDomains() {
        if (!this.cuidAuthorizedDomains.isEmpty()) {
            return this.cuidAuthorizedDomains;
        }
        return getInitialCuidAuthorizedDomains();
    }

    public boolean getDefaultHttpsEnabled() {
        return this.defaultHttpsEnabled;
    }

    public LoginShareStrategy getGlobalShareStrategy() {
        return this.globalShareStrategy;
    }

    public boolean getHttpAsyncCookie() {
        return this.httpClientAsyncCookie;
    }

    public boolean getIsShowChildrenAgreement() {
        return this.dialogShowChilrenAgreement;
    }

    public List<String> getLoginCookieDiKeys() {
        return this.loginCookieDiKeys;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        return this.specificShareStrategy;
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String replaceAll = confignation.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    public List<String> getOpenBdussDomains() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baifubao.com");
        arrayList.add("duxiaoman.com");
        arrayList.add("dxmpay.com");
        arrayList.add("baiyingfund.com");
        arrayList.add("dxmbaoxian.com");
        arrayList.add("duxiaomanfund.com");
        arrayList.add(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        if (!this.openBdussDomains.isEmpty()) {
            arrayList.addAll(this.openBdussDomains);
        }
        return arrayList;
    }

    public List<String> getOpenBdussTpls() {
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

    public Map<String, Integer> getOrderAuthorizedPackages() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.searchbox(.*)", 4);
        hashMap.put("com.baidu.BaiduMap(.*)", 5);
        hashMap.put("com.baidu.tieba(.*)", 6);
        hashMap.put("com.baidu.netdisk(.*)", 7);
        hashMap.put("com.baidu.appsearch", 8);
        return hashMap;
    }

    public JSONArray getDialogLoginPriority(String str) {
        Map<String, JSONArray> map = this.loginTplsPriority;
        if (map != null && map.containsKey(str)) {
            return this.loginTplsPriority.get(str);
        }
        return null;
    }

    public Boolean getIsProtocolCheck(String str) {
        List<String> list = this.dialogSelectAgreementTpls;
        if (list != null && list.contains(str)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public String toJSON() {
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
            JSONObject jSONObject3 = new JSONObject();
            if (this.dialogSelectAgreementTpls != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : this.dialogSelectAgreementTpls) {
                    jSONArray2.put(str);
                }
                jSONObject3.put(KEY_DEFAULT_SELECT_AGREEMENT_TPLS, jSONArray2);
            }
            jSONObject3.put(KEY_SHOW_CHILREN_AGREEMENT, this.dialogShowChilrenAgreement);
            if (this.loginTplsPriority != null) {
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, JSONArray> entry2 : this.loginTplsPriority.entrySet()) {
                    String key = entry2.getKey();
                    JSONArray value = entry2.getValue();
                    if (key != null && value != null) {
                        jSONObject4.put(key, value);
                    }
                }
                jSONObject3.put(KEY_LOGIN_TPLS_PRIORITY, jSONObject4);
            }
            jSONObject.put(KEY_DIALOG_LOGIN_CONFIG, jSONObject3);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
