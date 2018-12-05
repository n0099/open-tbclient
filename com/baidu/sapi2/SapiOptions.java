package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SapiOptions {
    private static final String A = "di_except_index";
    private static final String B = "share_account_gray";
    private static final String C = "share_common_storage_enable";
    private static final String D = "face_login_check_freq_v2";
    private static final String E = "extrajson_limit_len";
    private static final String F = "vehicle_system_pkgs";
    private static final String G = "share_direction";
    private static final String H = "reset_file_exec_per";
    private static final String a = "fast_reg_sms_num";
    private static final String b = "global_share_strategy";
    private static final String c = "specific_share_strategy";
    private static final String d = "default_https_enabled";
    private static final String e = "sofire_sdk_enabled";
    private static final String f = "plugins_enabled";
    private static final String g = "plugins_suffix";
    private static final String h = "authorized_packages";
    private static final String i = "sc_authorized_packages";
    private static final String j = "authorized_domains";
    private static final String k = "cuid_authorized_domains";
    private static final String l = "cache";
    private static final String m = "enabled";
    private static final String n = "version";
    private static final String o = "modules";
    private static final String p = "id";
    private static final String q = "download_url";
    private static final String r = "hash";
    private static final String s = "login_cookie_di_keys";
    private static final String t = "pre_fetch_tpl_list";
    private static final String u = "config_type";
    private static final String v = "config_step";
    private static final String w = "share_inter_storage_gray";
    private static final String x = "sms_face_login_enabled";
    private static final String y = "share_livinguname_enabled";
    private static final String z = "face_login_check_enabled";
    private LoginShareStrategy K;
    private boolean M;
    private boolean N;
    public boolean faceLoginCheckEnabled;
    public int faceLoginCheckFreq;
    public int loginStatExtraLimitLen;
    public boolean resetFileExecPer;
    public int shareAccountGray;
    public boolean shareCommonStorageEnable;
    public boolean shareFaceLoginEnable;
    public int shareInterGray;
    public boolean shareLivingunameEnabled;
    public boolean smsFaceLoginEnable;
    private boolean L = true;
    private Map<String, LoginShareStrategy> O = new HashMap();
    private Map<String, String> P = new HashMap();
    private Map<String, String> Q = new HashMap();
    private Map<String, String> R = new HashMap();
    private Map<String, String> S = new HashMap();
    private List<String> T = new ArrayList();
    private List<String> U = new ArrayList();
    private List<String> V = new ArrayList();
    private List<String> W = new ArrayList();
    public List<Integer> diExceptIndex = new ArrayList();
    public Map<String, String> shareDirection = new HashMap();
    public int configType = 0;
    public int configStep = 300;
    private Cache I = new Cache();
    private String J = SapiEnv.FAST_REG_SMS_NUMBER;

    public String getFastRegSmsNum() {
        return this.J;
    }

    public LoginShareStrategy getGlobalShareStrategy() {
        return this.K;
    }

    public boolean getDefaultHttpsEnabled() {
        return this.L;
    }

    public boolean getSofireSdkEnabled() {
        return this.M;
    }

    public boolean getPluginsEnabled() {
        return this.N;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        return this.O;
    }

    public Map<String, String> getPluginsSuffix() {
        return this.S;
    }

    public int getLoginStatExtraLimitLen() {
        return this.loginStatExtraLimitLen;
    }

    public Map<String, String> getAuthorizedPackages() {
        return !this.P.isEmpty() ? this.P : b();
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return !this.Q.isEmpty() ? this.Q : a();
    }

    public Map<String, String> getVehicleSystemPackages() {
        return this.R.isEmpty() ? c() : this.R;
    }

    public List<String> getAuthorizedDomains() {
        return !this.T.isEmpty() ? this.T : h();
    }

    public List<String> getCuidAuthorizedDomains() {
        return !this.U.isEmpty() ? this.U : i();
    }

    public List<String> getLoginCookieDiKeys() {
        return this.V;
    }

    public List<String> getPreFetchTplList() {
        return this.W;
    }

    public Cache getCache() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCache(Cache cache) {
        this.I = cache;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(l, this.I.a());
            jSONObject.put(a, this.J);
            jSONObject.put(v, this.configStep);
            jSONObject.put(u, this.configType);
            jSONObject.put(x, this.smsFaceLoginEnable);
            jSONObject.put(y, this.shareLivingunameEnabled);
            jSONObject.put(z, this.faceLoginCheckEnabled);
            jSONObject.put(C, this.shareCommonStorageEnable);
            jSONObject.put(D, this.faceLoginCheckFreq);
            jSONObject.put(B, this.shareAccountGray);
            jSONObject.put(w, this.shareInterGray);
            if (this.K != null) {
                jSONObject.put(b, this.K.getStrValue());
            }
            jSONObject.put(d, this.L);
            jSONObject.put(e, this.M);
            jSONObject.put(f, this.N);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.O.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(c, jSONObject2);
            a(jSONObject, h, this.P);
            a(jSONObject, F, this.R);
            a(jSONObject, i, this.Q);
            a(jSONObject, g, this.S);
            a(jSONObject, G, this.shareDirection);
            a(jSONObject, j, this.T);
            a(jSONObject, k, this.U);
            a(jSONObject, s, this.V);
            a(jSONObject, t, this.W);
            JSONArray jSONArray = new JSONArray();
            for (Integer num : this.diExceptIndex) {
                jSONArray.put(num);
            }
            jSONObject.put(A, jSONArray);
            jSONObject.put(E, this.loginStatExtraLimitLen);
            jSONObject.put(H, this.resetFileExecPer);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : list) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
        SapiOptions sapiOptions = new SapiOptions();
        sapiOptions.I = Cache.a(jSONObject.optJSONObject(l));
        sapiOptions.J = jSONObject.optString(a, SapiEnv.FAST_REG_SMS_NUMBER);
        sapiOptions.configType = jSONObject.optInt(u, 0);
        sapiOptions.configStep = jSONObject.optInt(v, 300);
        sapiOptions.smsFaceLoginEnable = jSONObject.optBoolean(x);
        sapiOptions.faceLoginCheckEnabled = jSONObject.optBoolean(z, true);
        sapiOptions.shareLivingunameEnabled = jSONObject.optBoolean(y);
        sapiOptions.shareCommonStorageEnable = jSONObject.optBoolean(C);
        sapiOptions.faceLoginCheckFreq = jSONObject.optInt(D, 24);
        sapiOptions.L = jSONObject.optBoolean(d, true);
        sapiOptions.M = jSONObject.optBoolean(e);
        sapiOptions.N = jSONObject.optBoolean(f);
        sapiOptions.shareAccountGray = jSONObject.optInt(B, 0);
        sapiOptions.shareInterGray = jSONObject.optInt(w, 0);
        String optString = jSONObject.optString(b);
        if (!TextUtils.isEmpty(optString)) {
            sapiOptions.K = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                sapiOptions.O.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        a(jSONObject.optJSONObject(h), sapiOptions.P);
        a(jSONObject.optJSONObject(F), sapiOptions.R);
        a(jSONObject.optJSONObject(i), sapiOptions.Q);
        a(jSONObject.optJSONObject(g), sapiOptions.S);
        a(jSONObject.optJSONObject(G), sapiOptions.shareDirection);
        a(jSONObject.optJSONArray(j), sapiOptions.T);
        a(jSONObject.optJSONArray(k), sapiOptions.U);
        a(jSONObject.optJSONArray(s), sapiOptions.V);
        a(jSONObject.optJSONArray(t), sapiOptions.W);
        JSONArray optJSONArray = jSONObject.optJSONArray(A);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                sapiOptions.diExceptIndex.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
        }
        sapiOptions.loginStatExtraLimitLen = jSONObject.optInt(E, 100);
        sapiOptions.resetFileExecPer = jSONObject.optBoolean(H, false);
        return sapiOptions;
    }

    private static void a(JSONObject jSONObject, Map<String, String> map) {
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

    private static void a(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                    list.add(jSONArray.optString(i2));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Cache {
        private static final String a = ".BD_SAPI_CACHE";
        private String c;
        private List<Module> d = new ArrayList();
        private boolean b = true;

        public boolean isEnabled() {
            return this.b;
        }

        public List<Module> getModules() {
            return this.d;
        }

        public String getVersion() {
            return this.c;
        }

        /* loaded from: classes.dex */
        public static class Module {
            public String downloadUrl;
            public String hash;
            public String id;

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.id);
                    jSONObject.put("download_url", this.downloadUrl);
                    jSONObject.put(SapiOptions.r, this.hash);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static Module a(JSONObject jSONObject) {
                Module module = new Module();
                module.id = jSONObject.optString("id");
                module.downloadUrl = jSONObject.optString("download_url");
                module.hash = jSONObject.optString(SapiOptions.r);
                return module;
            }

            public static String getInternalFile(String str) {
                return getAssetFile(str).replace('/', '-');
            }

            public static String getAssetFile(String str) {
                return str.replace(':', '/');
            }

            public static String getExternalFile(String str) {
                return ".BD_SAPI_CACHE/" + getAssetFile(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.id.equals(((Module) obj).id);
            }

            public int hashCode() {
                return this.id.hashCode();
            }
        }

        JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SapiOptions.m, this.b);
                jSONObject.put("version", this.c);
                JSONArray jSONArray = new JSONArray();
                for (Module module : getModules()) {
                    jSONArray.put(module.a());
                }
                jSONObject.put(SapiOptions.o, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        static Cache a(JSONObject jSONObject) {
            Cache cache = new Cache();
            if (jSONObject != null) {
                try {
                    cache.b = jSONObject.optBoolean(SapiOptions.m, true);
                    cache.c = jSONObject.optLong("version") + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.o);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        cache.getModules().add(Module.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return cache;
        }
    }

    Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.BaiduMap(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        hashMap.put("com.baidu.minivideo", "7fd3727852d29eb6f4283988dc0d6150");
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

    Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
        hashMap.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
        hashMap.put("com.baidu.searchbox(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        hashMap.put(OpenAppAction.APPSEARCH_PACKAGE_NAME, "c2b0b497d0389e6de1505e7fd8f4d539");
        hashMap.put("com.baidu.(.*)input(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
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
        hashMap.put("com.dragon.android.pandaspace", "5b120e96b20f5b4ec695d79b20d18753");
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
        return hashMap;
    }

    Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.sapi2.demo.standard", "de308d7973b5171883333a97253327e4");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.wallet", 1);
        hashMap.put("com.nuomi", 2);
        hashMap.put("com.baidu.lbs.waimai", 3);
        hashMap.put("com.baidu.searchbox(.*)", 4);
        hashMap.put("com.baidu.BaiduMap(.*)", 5);
        hashMap.put("com.baidu.tieba(.*)", 6);
        hashMap.put("com.baidu.netdisk(.*)", 7);
        hashMap.put(OpenAppAction.APPSEARCH_PACKAGE_NAME, 8);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> g() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String replaceAll = confignation.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = confignation.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    static List<String> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    static List<String> i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> getInitialCachePackagesWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> j() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("com.baidu.BaiduMap(.*)");
        return arrayList;
    }
}
