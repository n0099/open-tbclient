package com.baidu.sapi2;

import android.text.TextUtils;
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
    public static final String A = "share_inter_storage_gray";
    public static final String B = "share_livinguname_enabled";
    public static final String C = "di_except_index";
    public static final String D = "share_common_storage_enable";
    public static final String E = "join_qr_login_prompt";
    public static final String F = "extrajson_limit_len";
    public static final String G = "open_bduss_tpls";
    public static final String H = "open_bduss_domains";
    public static final String I = "can_get_bduss";
    public static final String J = "pass_httpclient_async_cookie";
    public static final String K = "reset_file_exec_per";
    public static final String L = "gray";
    public static final int M = 1000000;
    public static final String N = "tid";
    public static final String O = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    public static final String k = "global_share_strategy";
    public static final String l = "specific_share_strategy";
    public static final String m = "default_https_enabled";
    public static final String n = "address_use_web";
    public static final String o = "authorized_domains";
    public static final String p = "cuid_authorized_domains";
    public static final String q = "cache";
    public static final String r = "cache_gray";
    public static final String s = "percent";
    public static final String t = "enabled";
    public static final String u = "version";
    public static final String v = "modules";
    public static final String w = "id";
    public static final String x = "download_url";
    public static final String y = "hash";
    public static final String z = "login_cookie_di_keys";

    /* renamed from: b  reason: collision with root package name */
    public LoginShareStrategy f10790b;
    public boolean httpClientAsyncCookie;
    public int loginStatExtraLimitLen;
    public boolean resetFileExecPer;
    public boolean shareCommonStorageEnable;
    public boolean shareLivingunameEnabled;
    public String tid;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10791c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10792d = false;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, LoginShareStrategy> f10793e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public List<String> f10794f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List<String> f10795g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f10796h = new ArrayList();
    public List<Integer> diExceptIndex = new ArrayList();
    public List<String> i = new ArrayList();
    public List<String> j = new ArrayList();
    public boolean canGetBduss = true;
    public int shareInterGray = 100;
    public String joinQrLoginPrompt = O;

    /* renamed from: a  reason: collision with root package name */
    public a f10789a = new a();
    public Gray gray = new Gray();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final String f10807d = ".BD_SAPI_CACHE";

        /* renamed from: b  reason: collision with root package name */
        public String f10809b;

        /* renamed from: c  reason: collision with root package name */
        public List<C0135a> f10810c = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public boolean f10808a = true;

        public String b() {
            return this.f10809b;
        }

        public boolean c() {
            return this.f10808a;
        }

        public JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SapiOptions.t, this.f10808a);
                jSONObject.put("version", this.f10809b);
                JSONArray jSONArray = new JSONArray();
                for (C0135a c0135a : a()) {
                    jSONArray.put(c0135a.a());
                }
                jSONObject.put(SapiOptions.v, jSONArray);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public List<C0135a> a() {
            return this.f10810c;
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.f10808a = jSONObject.optBoolean(SapiOptions.t, true);
                    aVar.f10809b = jSONObject.optLong("version") + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.v);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.a().add(C0135a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable unused) {
                }
            }
            return aVar;
        }

        /* renamed from: com.baidu.sapi2.SapiOptions$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0135a {

            /* renamed from: a  reason: collision with root package name */
            public String f10811a;

            /* renamed from: b  reason: collision with root package name */
            public String f10812b;

            /* renamed from: c  reason: collision with root package name */
            public String f10813c;

            public static String b(String str) {
                return ShareStorage.f11327d + a(str);
            }

            public static String c(String str) {
                return a(str).replace('/', '-');
            }

            public JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f10811a);
                    jSONObject.put("download_url", this.f10812b);
                    jSONObject.put("hash", this.f10813c);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0135a.class != obj.getClass()) {
                    return false;
                }
                return this.f10811a.equals(((C0135a) obj).f10811a);
            }

            public int hashCode() {
                return this.f10811a.hashCode();
            }

            public static C0135a a(JSONObject jSONObject) {
                C0135a c0135a = new C0135a();
                c0135a.f10811a = jSONObject.optString("id");
                c0135a.f10812b = jSONObject.optString("download_url");
                c0135a.f10813c = jSONObject.optString("hash");
                return c0135a;
            }

            public static String a(String str) {
                return str.replace(':', '/');
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f10814a;

        /* renamed from: b  reason: collision with root package name */
        public List<a.C0135a> f10815b = new ArrayList();

        public String b() {
            return this.f10814a;
        }

        public List<a.C0135a> a() {
            return this.f10815b;
        }

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            if (jSONObject != null) {
                try {
                    bVar.f10814a = jSONObject.optString(SapiOptions.s);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SapiOptions.v);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        bVar.a().add(a.C0135a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
    }

    public static void b(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put(str, jSONObject2);
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    public static List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    public static SapiOptions fromJSON(JSONObject jSONObject) {
        SapiOptions sapiOptions = new SapiOptions();
        sapiOptions.f10789a = a.a(jSONObject.optJSONObject(q));
        if (jSONObject.has(r)) {
            a(jSONObject, sapiOptions);
        }
        sapiOptions.shareLivingunameEnabled = jSONObject.optBoolean(B);
        sapiOptions.shareCommonStorageEnable = jSONObject.optBoolean(D);
        sapiOptions.f10791c = jSONObject.optBoolean(m, true);
        sapiOptions.f10792d = jSONObject.optBoolean(n);
        sapiOptions.shareInterGray = jSONObject.optInt(A, 0);
        String optString = jSONObject.optString(k);
        if (!TextUtils.isEmpty(optString)) {
            sapiOptions.f10790b = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(l);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                sapiOptions.f10793e.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        a(jSONObject.optJSONArray(o), sapiOptions.f10794f);
        a(jSONObject.optJSONArray(p), sapiOptions.f10795g);
        a(jSONObject.optJSONArray(z), sapiOptions.f10796h);
        a(jSONObject.optJSONArray(G), sapiOptions.i);
        a(jSONObject.optJSONArray(H), sapiOptions.j);
        JSONArray optJSONArray = jSONObject.optJSONArray(C);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                sapiOptions.diExceptIndex.add(Integer.valueOf(optJSONArray.optInt(i)));
            }
        }
        sapiOptions.loginStatExtraLimitLen = jSONObject.optInt(F, 100);
        sapiOptions.httpClientAsyncCookie = jSONObject.optBoolean(J, false);
        sapiOptions.resetFileExecPer = jSONObject.optBoolean(K, false);
        sapiOptions.joinQrLoginPrompt = jSONObject.optString(E, O);
        sapiOptions.gray = Gray.a(jSONObject);
        sapiOptions.canGetBduss = jSONObject.optBoolean(I, true);
        sapiOptions.tid = jSONObject.optString("tid");
        return sapiOptions;
    }

    public static List<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.BaiduMap(.*)");
        arrayList.add("cn.opda.a.phonoalbumshoushou(.*)");
        return arrayList;
    }

    public static List<String> getInitialCachePackagesWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.sapi2.f.a.f11224g);
        return arrayList;
    }

    public Map<String, Integer> d() {
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

    public boolean getAddressUseWeb() {
        return this.f10792d;
    }

    public List<String> getAuthorizedDomains() {
        if (!this.f10794f.isEmpty()) {
            return this.f10794f;
        }
        return e();
    }

    public a getCache() {
        return this.f10789a;
    }

    public List<String> getCuidAuthorizedDomains() {
        if (!this.f10795g.isEmpty()) {
            return this.f10795g;
        }
        return f();
    }

    public boolean getDefaultHttpsEnabled() {
        return this.f10791c;
    }

    public LoginShareStrategy getGlobalShareStrategy() {
        return this.f10790b;
    }

    public boolean getHttpAsyncCookie() {
        return this.httpClientAsyncCookie;
    }

    public List<String> getLoginCookieDiKeys() {
        return this.f10796h;
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
        if (!this.j.isEmpty()) {
            arrayList.addAll(this.j);
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
        if (!this.i.isEmpty()) {
            arrayList.addAll(this.i);
        }
        return arrayList;
    }

    public Map<String, LoginShareStrategy> getSpecificShareStrategy() {
        return this.f10793e;
    }

    public void setCache(a aVar) {
        this.f10789a = aVar;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(q, this.f10789a.d());
            jSONObject.put(B, this.shareLivingunameEnabled);
            jSONObject.put(D, this.shareCommonStorageEnable);
            jSONObject.put(A, this.shareInterGray);
            if (this.f10790b != null) {
                jSONObject.put(k, this.f10790b.getStrValue());
            }
            jSONObject.put(m, this.f10791c);
            jSONObject.put(n, this.f10792d);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.f10793e.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(l, jSONObject2);
            a(jSONObject, o, this.f10794f);
            a(jSONObject, p, this.f10795g);
            a(jSONObject, z, this.f10796h);
            a(jSONObject, G, this.i);
            a(jSONObject, H, this.j);
            JSONArray jSONArray = new JSONArray();
            for (Integer num : this.diExceptIndex) {
                jSONArray.put(num);
            }
            jSONObject.put(C, jSONArray);
            jSONObject.put(F, this.loginStatExtraLimitLen);
            jSONObject.put(J, this.httpClientAsyncCookie);
            jSONObject.put(K, this.resetFileExecPer);
            jSONObject.put(E, this.joinQrLoginPrompt);
            jSONObject.put("gray", this.gray.a());
            jSONObject.put(I, this.canGetBduss);
            jSONObject.put("tid", this.tid);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public static final String f10816c = "authorized_packages";

        /* renamed from: d  reason: collision with root package name */
        public static final String f10817d = "sc_authorized_packages";

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f10818a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f10819b = new HashMap();

        public static c a(JSONObject jSONObject) {
            c cVar = new c();
            SapiOptions.b(jSONObject.optJSONObject(f10816c), cVar.f10818a);
            SapiOptions.b(jSONObject.optJSONObject(f10817d), cVar.f10819b);
            return cVar;
        }

        public Map<String, String> b() {
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
            hashMap.put(com.baidu.sapi2.f.a.f11224g, "db97d206640d7aca6d75975b3c1f6e87");
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

        public Map<String, String> c() {
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

        public Map<String, String> d() {
            if (!this.f10819b.isEmpty()) {
                return this.f10819b;
            }
            return c();
        }

        public String e() {
            JSONObject jSONObject = new JSONObject();
            try {
                SapiOptions.b(jSONObject, f10816c, this.f10818a);
                SapiOptions.b(jSONObject, f10817d, this.f10819b);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }

        public Map<String, String> a() {
            if (!this.f10818a.isEmpty()) {
                return this.f10818a;
            }
            return b();
        }
    }

    public static void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : list) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
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

        /* renamed from: b  reason: collision with root package name */
        public static String f10797b = "v";

        /* renamed from: c  reason: collision with root package name */
        public static String f10798c = "p";

        /* renamed from: d  reason: collision with root package name */
        public static String f10799d = "ex";

        /* renamed from: e  reason: collision with root package name */
        public static String f10800e = "meet";

        /* renamed from: f  reason: collision with root package name */
        public static String f10801f = "t";

        /* renamed from: a  reason: collision with root package name */
        public Map<String, GrayModule> f10802a = new HashMap();

        public static Gray a(JSONObject jSONObject) {
            Gray gray = new Gray();
            JSONObject optJSONObject = jSONObject.optJSONObject("gray");
            if (optJSONObject == null) {
                return gray;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (obj != null && !"".equals(obj)) {
                    gray.f10802a.put(obj, GrayModule.a(obj, optJSONObject.optJSONObject(obj)));
                }
            }
            return gray;
        }

        public GrayModule getGrayModuleByFunName(String str) {
            GrayModule grayModule = this.f10802a.get(str);
            if (grayModule == null) {
                GrayModule grayModule2 = new GrayModule();
                grayModule2.f10805c = true;
                return grayModule2;
            }
            return grayModule;
        }

        /* loaded from: classes2.dex */
        public static class GrayModule implements NoProguard {

            /* renamed from: a  reason: collision with root package name */
            public String f10803a;

            /* renamed from: b  reason: collision with root package name */
            public long f10804b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f10805c;

            /* renamed from: d  reason: collision with root package name */
            public String f10806d;

            public JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Gray.f10797b, this.f10803a);
                    jSONObject.put(Gray.f10798c, this.f10804b);
                    jSONObject.put(Gray.f10799d, this.f10806d);
                    jSONObject.put(Gray.f10800e, this.f10805c);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }

            public boolean isMeetGray() {
                return this.f10805c;
            }

            public static GrayModule a(String str, JSONObject jSONObject) {
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                GrayModule grayModule = new GrayModule();
                JSONObject optJSONObject = jSONObject.has(Gray.f10801f) ? jSONObject.optJSONObject(Gray.f10801f).optJSONObject(confignation.tpl) : new JSONObject();
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                grayModule.f10803a = optJSONObject.has(Gray.f10797b) ? optJSONObject.optString(Gray.f10797b) : jSONObject.optString(Gray.f10797b);
                grayModule.f10804b = optJSONObject.has(Gray.f10798c) ? optJSONObject.optLong(Gray.f10798c) : jSONObject.optLong(Gray.f10798c);
                grayModule.f10806d = optJSONObject.has(Gray.f10799d) ? optJSONObject.optString(Gray.f10799d) : jSONObject.optString(Gray.f10799d);
                long j = SapiContext.getInstance().getLong(str, -1L);
                if (j == -1) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    j = random.nextInt(1000000);
                    SapiContext.getInstance().put(str, j);
                }
                grayModule.f10805c = grayModule.f10804b >= j;
                if (!TextUtils.isEmpty(grayModule.f10803a) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), grayModule.f10803a) < 0) {
                    grayModule.f10805c = false;
                }
                return grayModule;
            }
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f10802a.keySet()) {
                try {
                    jSONObject.put(str, this.f10802a.get(str).a());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return jSONObject;
        }
    }

    public static void b(JSONObject jSONObject, Map<String, String> map) {
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

    public static void a(JSONObject jSONObject, SapiOptions sapiOptions) {
        SapiContext sapiContext = SapiContext.getInstance();
        int i = sapiContext.getInt(r, -1);
        if (i == -1) {
            i = new Random().nextInt(100);
            sapiContext.put(r, i);
        }
        b a2 = b.a(jSONObject.optJSONObject(r));
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split = b2.split("_");
        int length = split.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += Integer.valueOf(split[i3]).intValue();
            if (i <= i2) {
                sapiOptions.f10789a.f10810c.clear();
                sapiOptions.f10789a.f10810c.add(a2.f10815b.get(i3));
                return;
            }
        }
    }

    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(com.baidu.sapi2.f.a.f11224g);
        return arrayList;
    }

    public static void a(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                    list.add(jSONArray.optString(i));
                }
            }
        }
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String replaceAll = confignation.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }
}
