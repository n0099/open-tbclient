package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
    public static final String KEY_DI_EXCEPT_INDEX = "di_except_index";
    public static final String KEY_GLOBAL_SHARE_STRATEGY = "global_share_strategy";
    public static final String KEY_GRAY = "gray";
    public static final String KEY_JOIN_QR_LOGIN_PROMPT = "join_qr_login_prompt";
    public static final String KEY_LOGIN_COOKIE_DI_KEYS = "login_cookie_di_keys";
    public static final String KEY_LOGIN_STAT_EXTRA_LIMIT_LENGTH = "extrajson_limit_len";
    public static final String KEY_OPEN_BDUSS_CAN_GET_BDUSS = "can_get_bduss";
    public static final String KEY_OPEN_BDUSS_TPLS = "open_bduss_tpls";
    public static final String KEY_OPTN_BDUSS_DOMAINS = "open_bduss_domains";
    public static final String KEY_PASSHTTP_CLIENT_ASYNC_COOKIE = "pass_httpclient_async_cookie";
    public static final String KEY_RESET_FILE_EXEC_PER = "reset_file_exec_per";
    public static final String KEY_SHARE_COMMOM_STORAGE_ENABLE = "share_common_storage_enable";
    public static final String KEY_SHARE_INTERNAL_STORAGE = "share_inter_storage_gray";
    public static final String KEY_SHARE_LIVINGUNAME_ENABLE = "share_livinguname_enabled";
    public static final String KEY_SPECIFIC_SHARE_STRATEGY = "specific_share_strategy";
    public static final String KEY_TID = "tid";
    public static final String defaultJoinQrLoginPrompt = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    public LoginShareStrategy globalShareStrategy;
    public boolean httpClientAsyncCookie;
    public int loginStatExtraLimitLen;
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
    public String joinQrLoginPrompt = defaultJoinQrLoginPrompt;
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

            public static Module fromJSON(JSONObject jSONObject) {
                Module module = new Module();
                module.id = jSONObject.optString("id");
                module.downloadUrl = jSONObject.optString("download_url");
                module.hash = jSONObject.optString("hash");
                return module;
            }

            public static String getAssetFile(String str) {
                return str.replace(':', '/');
            }

            public static String getExternalFile(String str) {
                return ShareStorage.SP_FILE_PATH + getAssetFile(str);
            }

            public static String getInternalFile(String str) {
                return getAssetFile(str).replace('/', '-');
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Module.class != obj.getClass()) {
                    return false;
                }
                return this.id.equals(((Module) obj).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.id);
                    jSONObject.put("download_url", this.downloadUrl);
                    jSONObject.put("hash", this.hash);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }

        public static Cache fromJSON(JSONObject jSONObject) {
            Cache cache = new Cache();
            if (jSONObject != null) {
                try {
                    cache.enabled = jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED, true);
                    cache.version = jSONObject.optLong("version") + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.KEY_CACHE_MODULES);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        cache.getModules().add(Module.fromJSON(optJSONArray.getJSONObject(i2)));
                    }
                } catch (Throwable unused) {
                }
            }
            return cache;
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
    public static class CacheGray {
        public List<Cache.Module> modules = new ArrayList();
        public String percent;

        public static CacheGray fromJSON(JSONObject jSONObject) {
            CacheGray cacheGray = new CacheGray();
            if (jSONObject != null) {
                try {
                    cacheGray.percent = jSONObject.optString(SapiOptions.KEY_CACHE_PERCENT);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.KEY_CACHE_MODULES);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        cacheGray.getModules().add(Cache.Module.fromJSON(optJSONArray.getJSONObject(i2)));
                    }
                } catch (Throwable unused) {
                }
            }
            return cacheGray;
        }

        public List<Cache.Module> getModules() {
            return this.modules;
        }

        public String getPercent() {
            return this.percent;
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
        public static final String FUN_NAME_NUOMI_ADDR = "nuomi_addr";
        public static final String FUN_NAME_SHARE_V3 = "share_v3";
        public static final String FUN_NAME_VALIDATE_SP_COMMIT = "validate_sp_commit";
        public static final String FUN_SHARE_MODEL_FROM_SERVER = "share_model_from_server";
        public static final String FUN_SHARE_V3_EXTERNAL_RECOVERY = "share_v3_external_recovery";
        public static String KEY_GRAY_EX = "ex";
        public static String KEY_GRAY_MEET = "meet";
        public static String KEY_GRAY_MIN_VERSION = "v";
        public static String KEY_GRAY_PERCENT = "p";
        public static String KEY_GRAY_TPLS = "t";
        public Map<String, GrayModule> grayModuleMap = new HashMap();

        /* loaded from: classes2.dex */
        public static class GrayModule implements NoProguard {
            public String extraParams;
            public boolean meetGray;
            public String minVersion;
            public long percent;

            public static GrayModule fromJSON(String str, JSONObject jSONObject) {
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
        }

        public static Gray fromJSON(JSONObject jSONObject) {
            Gray gray = new Gray();
            JSONObject optJSONObject = jSONObject.optJSONObject("gray");
            if (optJSONObject == null) {
                return gray;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (obj != null && !"".equals(obj)) {
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

        public JSONObject toJSON() {
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
    }

    /* loaded from: classes2.dex */
    public static class PkgSigns {
        public static final String KEY_AUTHORIZED_PACKAGES = "authorized_packages";
        public static final String KEY_SC_AUTHORIZED_PACKAGES = "sc_authorized_packages";
        public Map<String, String> authorizedPackages = new HashMap();
        public Map<String, String> scAuthorizedPackages = new HashMap();

        public static PkgSigns fromJSON(JSONObject jSONObject) {
            PkgSigns pkgSigns = new PkgSigns();
            SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_AUTHORIZED_PACKAGES), pkgSigns.authorizedPackages);
            SapiOptions.setJsonToMap(jSONObject.optJSONObject(KEY_SC_AUTHORIZED_PACKAGES), pkgSigns.scAuthorizedPackages);
            return pkgSigns;
        }

        public Map<String, String> getAuthorizedPackages() {
            if (!this.authorizedPackages.isEmpty()) {
                return this.authorizedPackages;
            }
            return getInitialAuthorizedPackages();
        }

        public Map<String, String> getInitialAuthorizedPackages() {
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
            hashMap.put("com.baidu.wenku", "13a0a8019be4015ed20e075d824f1696");
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
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }
    }

    public static void cacheGrayTest(JSONObject jSONObject, SapiOptions sapiOptions) {
        SapiContext sapiContext = SapiContext.getInstance();
        int i2 = sapiContext.getInt(KEY_CACHE_GRAY, -1);
        if (i2 == -1) {
            i2 = new Random().nextInt(100);
            sapiContext.put(KEY_CACHE_GRAY, i2);
        }
        CacheGray fromJSON = CacheGray.fromJSON(jSONObject.optJSONObject(KEY_CACHE_GRAY));
        String percent = fromJSON.getPercent();
        if (TextUtils.isEmpty(percent)) {
            return;
        }
        String[] split = percent.split("_");
        int length = split.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3 += Integer.valueOf(split[i4]).intValue();
            if (i2 <= i3) {
                sapiOptions.cache.modules.clear();
                sapiOptions.cache.modules.add(fromJSON.modules.get(i4));
                return;
            }
        }
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
        SapiOptions sapiOptions = new SapiOptions();
        sapiOptions.cache = Cache.fromJSON(jSONObject.optJSONObject(KEY_CACHE));
        if (jSONObject.has(KEY_CACHE_GRAY)) {
            cacheGrayTest(jSONObject, sapiOptions);
        }
        sapiOptions.shareLivingunameEnabled = jSONObject.optBoolean(KEY_SHARE_LIVINGUNAME_ENABLE);
        sapiOptions.shareCommonStorageEnable = jSONObject.optBoolean(KEY_SHARE_COMMOM_STORAGE_ENABLE);
        sapiOptions.defaultHttpsEnabled = jSONObject.optBoolean(KEY_DEFAULT_HTTPS_ENABLED, true);
        sapiOptions.addressUseWeb = jSONObject.optBoolean(KEY_ADDRESS_USE_WEB);
        sapiOptions.shareInterGray = jSONObject.optInt(KEY_SHARE_INTERNAL_STORAGE, 0);
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
            for (int i2 = 0; i2 < length; i2++) {
                sapiOptions.diExceptIndex.add(Integer.valueOf(optJSONArray.optInt(i2)));
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

    public static List<String> getInitialAuthorizedDomains() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    public static List<String> getInitialCachePackagesWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
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

    public static void setJsonArrayToList(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                    list.add(jSONArray.optString(i2));
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

    public boolean getAddressUseWeb() {
        return this.addressUseWeb;
    }

    public List<String> getAuthorizedDomains() {
        if (!this.authorizedDomains.isEmpty()) {
            return this.authorizedDomains;
        }
        return getInitialAuthorizedDomains();
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

    public List<String> getLoginCookieDiKeys() {
        return this.loginCookieDiKeys;
    }

    public List<String> getOpenBdussDomains() {
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
        hashMap.put("com.baidu.wallet", 1);
        hashMap.put("com.nuomi", 2);
        hashMap.put("com.baidu.lbs.waimai", 3);
        hashMap.put("com.baidu.searchbox(.*)", 4);
        hashMap.put("com.baidu.BaiduMap(.*)", 5);
        hashMap.put("com.baidu.tieba(.*)", 6);
        hashMap.put("com.baidu.netdisk(.*)", 7);
        hashMap.put("com.baidu.appsearch", 8);
        return hashMap;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        return this.specificShareStrategy;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CACHE, this.cache.toJSON());
            jSONObject.put(KEY_SHARE_LIVINGUNAME_ENABLE, this.shareLivingunameEnabled);
            jSONObject.put(KEY_SHARE_COMMOM_STORAGE_ENABLE, this.shareCommonStorageEnable);
            jSONObject.put(KEY_SHARE_INTERNAL_STORAGE, this.shareInterGray);
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
            jSONObject.put("gray", this.gray.toJSON());
            jSONObject.put(KEY_OPEN_BDUSS_CAN_GET_BDUSS, this.canGetBduss);
            jSONObject.put("tid", this.tid);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
