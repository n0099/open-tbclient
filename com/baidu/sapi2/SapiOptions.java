package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SapiOptions {
    private static final String A = "share_account_gray";
    private static final String B = "share_face_login";
    private static final String C = "share_common_storage_enable";
    private static final String D = "face_login_check_freq";
    private static final String E = "extrajson_limit_len";
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
    private static final String w = "sms_face_login_enabled";
    private static final String x = "share_livinguname_enabled";
    private static final String y = "face_login_check_enabled";
    private static final String z = "di_except_index";
    private LoginShareStrategy H;
    private boolean J;
    private boolean K;
    public boolean faceLoginCheckEnabled;
    public int faceLoginCheckFreq;
    public int loginStatExtraLimitLen;
    public int shareAccountGray;
    public boolean shareCommonStorageEnable;
    public boolean shareFaceLoginEnable;
    public boolean shareLivingunameEnabled;
    public boolean smsFaceLoginEnable;
    private boolean I = true;
    private Map<String, LoginShareStrategy> L = new HashMap();
    private Map<String, String> M = new HashMap();
    private Map<String, String> N = new HashMap();
    private Map<String, String> O = new HashMap();
    private List<String> P = new ArrayList();
    private List<String> Q = new ArrayList();
    private List<String> R = new ArrayList();
    private List<String> S = new ArrayList();
    public List<Integer> diExceptIndex = new ArrayList();
    public int configType = 0;
    public int configStep = 300;
    private Cache F = new Cache();
    private String G = SapiEnv.FAST_REG_SMS_NUMBER;

    public String getFastRegSmsNum() {
        return this.G;
    }

    public LoginShareStrategy getGlobalShareStrategy() {
        return this.H;
    }

    public boolean getDefaultHttpsEnabled() {
        return this.I;
    }

    public boolean getSofireSdkEnabled() {
        return this.J;
    }

    public boolean getPluginsEnabled() {
        return this.K;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        return this.L;
    }

    public Map<String, String> getPluginsSuffix() {
        return this.O;
    }

    public int getLoginStatExtraLimitLen() {
        return this.loginStatExtraLimitLen;
    }

    public Map<String, String> getAuthorizedPackages() {
        return !this.M.isEmpty() ? this.M : b();
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return !this.N.isEmpty() ? this.N : a();
    }

    public List<String> getAuthorizedDomains() {
        return !this.P.isEmpty() ? this.P : g();
    }

    public List<String> getCuidAuthorizedDomains() {
        return !this.Q.isEmpty() ? this.Q : h();
    }

    public List<String> getLoginCookieDiKeys() {
        return this.R;
    }

    public List<String> getPreFetchTplList() {
        return this.S;
    }

    public Cache getCache() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCache(Cache cache) {
        this.F = cache;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(l, this.F.a());
            jSONObject.put(a, this.G);
            jSONObject.put(v, this.configStep);
            jSONObject.put(u, this.configType);
            jSONObject.put(w, this.smsFaceLoginEnable);
            jSONObject.put(x, this.shareLivingunameEnabled);
            jSONObject.put(y, this.faceLoginCheckEnabled);
            jSONObject.put(B, this.shareFaceLoginEnable);
            jSONObject.put(C, this.shareCommonStorageEnable);
            jSONObject.put(D, this.faceLoginCheckFreq);
            jSONObject.put(A, this.shareAccountGray);
            if (this.H != null) {
                jSONObject.put(b, this.H.getStrValue());
            }
            jSONObject.put(d, this.I);
            jSONObject.put(e, this.J);
            jSONObject.put(f, this.K);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.L.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(c, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : this.M.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject.put(h, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry<String, String> entry3 : this.N.entrySet()) {
                jSONObject4.put(entry3.getKey(), entry3.getValue());
            }
            jSONObject.put(i, jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            for (Map.Entry<String, String> entry4 : this.O.entrySet()) {
                jSONObject5.put(entry4.getKey(), entry4.getValue());
            }
            jSONObject.put(g, jSONObject5);
            JSONArray jSONArray = new JSONArray();
            for (String str : this.P) {
                jSONArray.put(str);
            }
            jSONObject.put(j, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : this.Q) {
                jSONArray2.put(str2);
            }
            jSONObject.put(k, jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (String str3 : this.R) {
                jSONArray3.put(str3);
            }
            jSONObject.put(s, jSONArray3);
            JSONArray jSONArray4 = new JSONArray();
            for (String str4 : this.S) {
                jSONArray4.put(str4);
            }
            jSONObject.put(t, jSONArray4);
            JSONArray jSONArray5 = new JSONArray();
            for (Integer num : this.diExceptIndex) {
                jSONArray5.put(num);
            }
            jSONObject.put(z, jSONArray5);
            jSONObject.put(E, this.loginStatExtraLimitLen);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
        SapiOptions sapiOptions = new SapiOptions();
        sapiOptions.F = Cache.a(jSONObject.optJSONObject(l));
        sapiOptions.G = jSONObject.optString(a, SapiEnv.FAST_REG_SMS_NUMBER);
        sapiOptions.configType = jSONObject.optInt(u, 0);
        sapiOptions.configStep = jSONObject.optInt(v, 300);
        sapiOptions.smsFaceLoginEnable = jSONObject.optBoolean(w);
        sapiOptions.faceLoginCheckEnabled = jSONObject.optBoolean(y, true);
        sapiOptions.shareLivingunameEnabled = jSONObject.optBoolean(x);
        sapiOptions.shareFaceLoginEnable = jSONObject.optBoolean(B);
        sapiOptions.shareCommonStorageEnable = jSONObject.optBoolean(C);
        sapiOptions.faceLoginCheckFreq = jSONObject.optInt(D, 24);
        sapiOptions.I = jSONObject.optBoolean(d, true);
        sapiOptions.J = jSONObject.optBoolean(e);
        sapiOptions.K = jSONObject.optBoolean(f);
        sapiOptions.shareAccountGray = jSONObject.optInt(A, 0);
        String optString = jSONObject.optString(b);
        if (!TextUtils.isEmpty(optString)) {
            sapiOptions.H = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                sapiOptions.L.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(h);
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                String optString2 = optJSONObject2.optString(next2);
                if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(optString2)) {
                    sapiOptions.M.put(next2, optString2);
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(i);
        if (optJSONObject3 != null) {
            Iterator<String> keys3 = optJSONObject3.keys();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                String optString3 = optJSONObject3.optString(next3);
                if (!TextUtils.isEmpty(next3) && !TextUtils.isEmpty(optString3)) {
                    sapiOptions.N.put(next3, optString3);
                }
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject(g);
        if (optJSONObject4 != null) {
            Iterator<String> keys4 = optJSONObject4.keys();
            while (keys4.hasNext()) {
                String next4 = keys4.next();
                String optString4 = optJSONObject4.optString(next4);
                if (!TextUtils.isEmpty(next4) && !TextUtils.isEmpty(next4)) {
                    sapiOptions.O.put(next4, optString4);
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(j);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                    sapiOptions.P.add(optJSONArray.optString(i2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(k);
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (!TextUtils.isEmpty(optJSONArray2.optString(i3))) {
                    sapiOptions.Q.add(optJSONArray2.optString(i3));
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(s);
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                if (!TextUtils.isEmpty(optJSONArray3.optString(i4))) {
                    sapiOptions.R.add(optJSONArray3.optString(i4));
                }
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray(t);
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                if (!TextUtils.isEmpty(optJSONArray4.optString(i5))) {
                    sapiOptions.S.add(optJSONArray4.optString(i5));
                }
            }
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray(z);
        if (optJSONArray5 != null) {
            int length = optJSONArray5.length();
            for (int i6 = 0; i6 < length; i6++) {
                sapiOptions.diExceptIndex.add(Integer.valueOf(optJSONArray5.optInt(i6)));
            }
        }
        sapiOptions.loginStatExtraLimitLen = jSONObject.optInt(E, 100);
        return sapiOptions;
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

    static Map<String, String> a() {
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

    static Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.sapi2.(.*)", "de308d7973b5171883333a97253327e4");
        hashMap.put("com.baidu.tieba(.*)", "673004cf2f6efdec2385c8116c1e8c14");
        hashMap.put("com.baidu.searchbox(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
        hashMap.put("com.baidu.appsearch", "c2b0b497d0389e6de1505e7fd8f4d539");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> c() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(SapiScheme.SC_APP_PACKAGENAME);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String replaceAll = confignation.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = confignation.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    static List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    static List<String> h() {
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
    public static List<String> i() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("com.baidu.BaiduMap(.*)");
        return arrayList;
    }
}
