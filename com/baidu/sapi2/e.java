package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
/* loaded from: classes5.dex */
public final class e {
    private static final String A = "cuid_authorized_domains";
    private static final String B = "cache";
    private static final String C = "cache_gray";
    private static final String D = "percent";
    private static final String E = "enabled";
    private static final String F = "version";
    private static final String G = "modules";
    private static final String H = "id";
    private static final String I = "download_url";
    private static final String J = "hash";
    private static final String K = "login_cookie_di_keys";
    private static final String L = "pre_fetch_tpl_list";
    private static final String M = "share_inter_storage_gray";
    private static final String N = "share_livinguname_enabled";
    private static final String O = "di_except_index";
    private static final String P = "share_common_storage_enable";
    private static final String Q = "join_qr_login_prompt";
    private static final String R = "extrajson_limit_len";
    private static final String S = "open_bduss_tpls";
    private static final String T = "open_bduss_domains";
    private static final String U = "can_get_bduss";
    private static final String V = "share_direction";
    private static final String W = "pass_httpclient_async_cookie";
    private static final String X = "reset_file_exec_per";
    private static final String Y = "gray";
    private static final int Z = 1000000;
    private static final String a0 = "tid";
    private static final String b0 = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    private static final String w = "global_share_strategy";
    private static final String x = "specific_share_strategy";
    private static final String y = "default_https_enabled";
    private static final String z = "authorized_domains";
    private LoginShareStrategy b;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean s;
    protected String v;
    private boolean c = true;
    private Map<String, LoginShareStrategy> d = new HashMap();
    private List<String> e = new ArrayList();
    private List<String> f = new ArrayList();
    private List<String> g = new ArrayList();
    private List<String> h = new ArrayList();
    public List<Integer> i = new ArrayList();
    public Map<String, String> j = new HashMap();
    private List<String> k = new ArrayList();
    private List<String> l = new ArrayList();
    public boolean m = true;
    public int r = 100;
    public String t = b0;

    /* renamed from: a  reason: collision with root package name */
    private a f3447a = new a();
    public c u = new c();

    /* loaded from: classes5.dex */
    public static class a {
        private static final String d = ".BD_SAPI_CACHE";
        private String b;
        private List<C0323a> c = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        private boolean f3448a = true;

        public String b() {
            return this.b;
        }

        public boolean c() {
            return this.f3448a;
        }

        JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(e.E, this.f3448a);
                jSONObject.put("version", this.b);
                JSONArray jSONArray = new JSONArray();
                for (C0323a c0323a : a()) {
                    jSONArray.put(c0323a.a());
                }
                jSONObject.put(e.G, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        public List<C0323a> a() {
            return this.c;
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.f3448a = jSONObject.optBoolean(e.E, true);
                    aVar.b = jSONObject.optLong("version") + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(e.G);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.a().add(C0323a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return aVar;
        }

        /* renamed from: com.baidu.sapi2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0323a {

            /* renamed from: a  reason: collision with root package name */
            public String f3449a;
            public String b;
            public String c;

            public static String b(String str) {
                return ".BD_SAPI_CACHE/" + a(str);
            }

            public static String c(String str) {
                return a(str).replace('/', '-');
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f3449a);
                    jSONObject.put(e.I, this.b);
                    jSONObject.put(e.J, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            public int hashCode() {
                return this.f3449a.hashCode();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && C0323a.class == obj.getClass()) {
                    return this.f3449a.equals(((C0323a) obj).f3449a);
                }
                return false;
            }

            static C0323a a(JSONObject jSONObject) {
                C0323a c0323a = new C0323a();
                c0323a.f3449a = jSONObject.optString("id");
                c0323a.b = jSONObject.optString(e.I);
                c0323a.c = jSONObject.optString(e.J);
                return c0323a;
            }

            public static String a(String str) {
                return str.replace(':', '/');
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f3450a;
        private List<a.C0323a> b = new ArrayList();

        public String b() {
            return this.f3450a;
        }

        public List<a.C0323a> a() {
            return this.b;
        }

        static b a(JSONObject jSONObject) {
            b bVar = new b();
            if (jSONObject != null) {
                try {
                    bVar.f3450a = jSONObject.optString(e.D);
                    JSONArray optJSONArray = jSONObject.optJSONArray(e.G);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        bVar.a().add(a.C0323a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put(str, jSONObject2);
    }

    static List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> s() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    static List<String> t() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.BaiduMap(.*)");
        arrayList.add("cn.opda.a.phonoalbumshoushou(.*)");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        arrayList.add(com.baidu.sapi2.f.a.g);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.sapi2.f.a.g);
        return arrayList;
    }

    public a e() {
        return this.f3447a;
    }

    public List<String> f() {
        return !this.f.isEmpty() ? this.f : t();
    }

    public boolean g() {
        return this.c;
    }

    public LoginShareStrategy h() {
        return this.b;
    }

    public boolean i() {
        return this.q;
    }

    public List<String> j() {
        return this.g;
    }

    public int k() {
        return this.p;
    }

    public List<String> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baifubao.com");
        arrayList.add("duxiaoman.com");
        arrayList.add("dxmpay.com");
        arrayList.add("baiyingfund.com");
        arrayList.add("dxmbaoxian.com");
        arrayList.add("duxiaomanfund.com");
        arrayList.add("baidu.com");
        if (!this.l.isEmpty()) {
            arrayList.addAll(this.l);
        }
        return arrayList;
    }

    public List<String> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("licai");
        arrayList.add("baidugushitong");
        arrayList.add("walletloan");
        arrayList.add("baiduwalletapp");
        arrayList.add("umoney_ios");
        arrayList.add("walletloan_lite");
        arrayList.add("bdwalletsdk");
        if (!this.k.isEmpty()) {
            arrayList.addAll(this.k);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> n() {
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

    public List<String> o() {
        return this.h;
    }

    public Map<String, LoginShareStrategy> p() {
        return this.d;
    }

    public String q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(B, this.f3447a.d());
            jSONObject.put(N, this.n);
            jSONObject.put(P, this.o);
            jSONObject.put(M, this.r);
            if (this.b != null) {
                jSONObject.put(w, this.b.getStrValue());
            }
            jSONObject.put(y, this.c);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.d.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(x, jSONObject2);
            b(jSONObject, V, this.j);
            a(jSONObject, z, this.e);
            a(jSONObject, A, this.f);
            a(jSONObject, K, this.g);
            a(jSONObject, L, this.h);
            a(jSONObject, S, this.k);
            a(jSONObject, T, this.l);
            JSONArray jSONArray = new JSONArray();
            for (Integer num : this.i) {
                jSONArray.put(num);
            }
            jSONObject.put(O, jSONArray);
            jSONObject.put(R, this.p);
            jSONObject.put(W, this.q);
            jSONObject.put(X, this.s);
            jSONObject.put(Q, this.t);
            jSONObject.put("gray", this.u.a());
            jSONObject.put(U, this.m);
            jSONObject.put("tid", this.v);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public List<String> a() {
        return !this.e.isEmpty() ? this.e : r();
    }

    /* loaded from: classes5.dex */
    public static class d {
        private static final String d = "authorized_packages";
        private static final String e = "sc_authorized_packages";
        private static final String f = "vehicle_system_pkgs";

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f3453a = new HashMap();
        private Map<String, String> b = new HashMap();
        private Map<String, String> c = new HashMap();

        public static d a(JSONObject jSONObject) {
            d dVar = new d();
            e.b(jSONObject.optJSONObject(d), dVar.f3453a);
            e.b(jSONObject.optJSONObject(f), dVar.c);
            e.b(jSONObject.optJSONObject(e), dVar.b);
            return dVar;
        }

        Map<String, String> b() {
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
            hashMap.put(com.baidu.sapi2.f.a.g, "db97d206640d7aca6d75975b3c1f6e87");
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
            hashMap.put("com.baidu.minivideo", "7fd3727852d29eb6f4283988dc0d6150");
            hashMap.put("com.baidu.duer.superapp", "bd8af7603d638668269bff68aeffd05a");
            hashMap.put("com.zaijia.xiaodu", "ea36f50eb0a843f6f5063b897b5e9497");
            return hashMap;
        }

        Map<String, String> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.BaiduMap(.*)", "c2b0b497d0389e6de1505e7fd8f4d539");
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

        Map<String, String> d() {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.sapi2.demo.standard", "de308d7973b5171883333a97253327e4");
            return hashMap;
        }

        public Map<String, String> e() {
            return !this.b.isEmpty() ? this.b : c();
        }

        public Map<String, String> f() {
            return this.c.isEmpty() ? d() : this.c;
        }

        public String g() {
            JSONObject jSONObject = new JSONObject();
            try {
                e.b(jSONObject, d, this.f3453a);
                e.b(jSONObject, f, this.c);
                e.b(jSONObject, e, this.b);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.toString();
        }

        public Map<String, String> a() {
            return !this.f3453a.isEmpty() ? this.f3453a : b();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static final String b = "share_v3";
        public static final String c = "finger";
        public static final String d = "cm_oauth";
        public static final String e = "cu_oauth";
        public static final String f = "ct_oauth";
        static String g = "v";
        static String h = "p";
        static String i = "ex";
        static String j = "meet";
        static String k = "t";

        /* renamed from: a  reason: collision with root package name */
        private Map<String, a> f3451a = new HashMap();

        static c a(JSONObject jSONObject) {
            c cVar = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("gray");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    if (obj != null && !"".equals(obj)) {
                        cVar.f3451a.put(obj, a.a(obj, optJSONObject.optJSONObject(obj)));
                    }
                }
            }
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            String f3452a;
            long b;
            boolean c;
            String d;

            a() {
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.g, this.f3452a);
                    jSONObject.put(c.h, this.b);
                    jSONObject.put(c.i, this.d);
                    jSONObject.put(c.j, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static a a(String str, JSONObject jSONObject) {
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.has(c.k) ? jSONObject.optJSONObject(c.k).optJSONObject(confignation.tpl) : new JSONObject();
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                aVar.f3452a = optJSONObject.has(c.g) ? optJSONObject.optString(c.g) : jSONObject.optString(c.g);
                aVar.b = optJSONObject.has(c.h) ? optJSONObject.optLong(c.h) : jSONObject.optLong(c.h);
                aVar.d = optJSONObject.has(c.i) ? optJSONObject.optString(c.i) : jSONObject.optString(c.i);
                long j = SapiContext.getInstance().getLong(str, -1L);
                if (j == -1) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    j = random.nextInt(1000000);
                    SapiContext.getInstance().put(str, j);
                }
                aVar.c = aVar.b >= j;
                if (!TextUtils.isEmpty(aVar.f3452a) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), aVar.f3452a) < 0) {
                    aVar.c = false;
                }
                return aVar;
            }
        }

        JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.f3451a.keySet()) {
                try {
                    jSONObject.put(str, this.f3451a.get(str).a());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return jSONObject;
        }

        public a a(String str) {
            a aVar = this.f3451a.get(str);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.c = true;
                return aVar2;
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.f3447a = aVar;
    }

    private static void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : list) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> b() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String replaceAll = confignation.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    private static void a(JSONObject jSONObject, e eVar) {
        SapiContext sapiContext = SapiContext.getInstance();
        int i = sapiContext.getInt(C, -1);
        if (i == -1) {
            i = new Random().nextInt(100);
            sapiContext.put(C, i);
        }
        b a2 = b.a(jSONObject.optJSONObject(C));
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split = b2.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        int length = split.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += Integer.valueOf(split[i3]).intValue();
            if (i <= i2) {
                eVar.f3447a.c.clear();
                eVar.f3447a.c.add(a2.b.get(i3));
                return;
            }
        }
    }

    public static e a(JSONObject jSONObject) {
        e eVar = new e();
        eVar.f3447a = a.a(jSONObject.optJSONObject(B));
        if (jSONObject.has(C)) {
            a(jSONObject, eVar);
        }
        eVar.n = jSONObject.optBoolean(N);
        eVar.o = jSONObject.optBoolean(P);
        eVar.c = jSONObject.optBoolean(y, true);
        eVar.r = jSONObject.optInt(M, 0);
        String optString = jSONObject.optString(w);
        if (!TextUtils.isEmpty(optString)) {
            eVar.b = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(x);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                eVar.d.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        b(jSONObject.optJSONObject(V), eVar.j);
        a(jSONObject.optJSONArray(z), eVar.e);
        a(jSONObject.optJSONArray(A), eVar.f);
        a(jSONObject.optJSONArray(K), eVar.g);
        a(jSONObject.optJSONArray(L), eVar.h);
        a(jSONObject.optJSONArray(S), eVar.k);
        a(jSONObject.optJSONArray(T), eVar.l);
        JSONArray optJSONArray = jSONObject.optJSONArray(O);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.i.add(Integer.valueOf(optJSONArray.optInt(i)));
            }
        }
        eVar.p = jSONObject.optInt(R, 100);
        eVar.q = jSONObject.optBoolean(W, false);
        eVar.s = jSONObject.optBoolean(X, false);
        eVar.t = jSONObject.optString(Q, b0);
        eVar.u = c.a(jSONObject);
        eVar.m = jSONObject.optBoolean(U, true);
        eVar.v = jSONObject.optString("tid");
        return eVar;
    }

    private static void a(JSONArray jSONArray, List<String> list) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                    list.add(jSONArray.optString(i));
                }
            }
        }
    }
}
