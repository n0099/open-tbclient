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
public final class S {
    private static final String A = "can_get_bduss";
    private static final String B = "share_direction";
    private static final String C = "pass_httpclient_async_cookie";
    private static final String D = "reset_file_exec_per";
    private static final String E = "sid_key";
    private static final String F = "gray";
    private static final int G = 1000000;
    private static final String H = "登录后%s将获得百度帐号的公开信息（用户名、头像）";
    private static final String a = "fast_reg_sms_num";
    private static final String b = "global_share_strategy";
    private static final String c = "specific_share_strategy";
    private static final String d = "default_https_enabled";
    private static final String e = "authorized_domains";
    private static final String f = "cuid_authorized_domains";
    private static final String g = "cache";
    private static final String h = "cache_gray";
    private static final String i = "percent";
    private static final String j = "enabled";
    private static final String k = "version";
    private static final String l = "modules";
    private static final String m = "id";
    private static final String n = "download_url";
    private static final String o = "hash";
    private static final String p = "login_cookie_di_keys";
    private static final String q = "pre_fetch_tpl_list";
    private static final String r = "phone_risks_tpls";
    private static final String s = "share_inter_storage_gray";
    private static final String t = "share_livinguname_enabled";
    private static final String u = "di_except_index";
    private static final String v = "share_common_storage_enable";
    private static final String w = "join_qr_login_prompt";
    private static final String x = "extrajson_limit_len";
    private static final String y = "open_bduss_tpls";
    private static final String z = "open_bduss_domains";
    private LoginShareStrategy K;
    public boolean X;
    public boolean Y;
    public int Z;
    public boolean aa;
    public boolean ca;
    public String da;
    private boolean L = true;
    private Map<String, LoginShareStrategy> M = new HashMap();
    private List<String> N = new ArrayList();
    private List<String> O = new ArrayList();
    private List<String> P = new ArrayList();
    private List<String> Q = new ArrayList();
    public List<Integer> R = new ArrayList();
    public List<String> S = new ArrayList();
    public Map<String, String> T = new HashMap();
    private List<String> U = new ArrayList();
    private List<String> V = new ArrayList();
    public boolean W = true;
    public int ba = 100;
    public String ea = H;
    private a I = new a();
    public c fa = new c();
    private String J = com.baidu.sapi2.utils.f.o;

    /* loaded from: classes5.dex */
    public static class a {
        private static final String a = ".BD_SAPI_CACHE";
        private String c;
        private List<C0163a> d = new ArrayList();
        private boolean b = true;

        public String b() {
            return this.c;
        }

        public boolean c() {
            return this.b;
        }

        JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(S.j, this.b);
                jSONObject.put("version", this.c);
                JSONArray jSONArray = new JSONArray();
                for (C0163a c0163a : a()) {
                    jSONArray.put(c0163a.a());
                }
                jSONObject.put(S.l, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        /* renamed from: com.baidu.sapi2.S$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0163a {
            public String a;
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
                    jSONObject.put("id", this.a);
                    jSONObject.put(S.n, this.b);
                    jSONObject.put(S.o, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && C0163a.class == obj.getClass()) {
                    return this.a.equals(((C0163a) obj).a);
                }
                return false;
            }

            static C0163a a(JSONObject jSONObject) {
                C0163a c0163a = new C0163a();
                c0163a.a = jSONObject.optString("id");
                c0163a.b = jSONObject.optString(S.n);
                c0163a.c = jSONObject.optString(S.o);
                return c0163a;
            }

            public static String a(String str) {
                return str.replace(':', '/');
            }
        }

        public List<C0163a> a() {
            return this.d;
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.b = jSONObject.optBoolean(S.j, true);
                    aVar.c = jSONObject.optLong("version") + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(S.l);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.a().add(C0163a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return aVar;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        String a;
        private List<a.C0163a> b = new ArrayList();

        public String b() {
            return this.a;
        }

        public List<a.C0163a> a() {
            return this.b;
        }

        static b a(JSONObject jSONObject) {
            b bVar = new b();
            if (jSONObject != null) {
                try {
                    bVar.a = jSONObject.optString(S.i);
                    JSONArray optJSONArray = jSONObject.optJSONArray(S.l);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        bVar.a().add(a.C0163a.a(optJSONArray.getJSONObject(i)));
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

    static List<String> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.(.*)input(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    static List<String> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("nsclick.baidu.com");
        arrayList.add("passport.baidu.com");
        arrayList.add("wappass.baidu.com");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> n() {
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
        arrayList.add(com.baidu.sapi2.b.a.e);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.baidu.sapi2.b.a.e);
        return arrayList;
    }

    public a e() {
        return this.I;
    }

    public List<String> f() {
        return !this.O.isEmpty() ? this.O : m();
    }

    public boolean g() {
        return this.L;
    }

    public String h() {
        return this.J;
    }

    public LoginShareStrategy i() {
        return this.K;
    }

    public boolean j() {
        return this.aa;
    }

    public List<String> o() {
        return this.P;
    }

    public int p() {
        return this.Z;
    }

    public List<String> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baifubao.com");
        arrayList.add("duxiaoman.com");
        arrayList.add("dxmpay.com");
        arrayList.add("baiyingfund.com");
        arrayList.add("dxmbaoxian.com");
        arrayList.add("duxiaomanfund.com");
        arrayList.add("baidu.com");
        if (!this.V.isEmpty()) {
            arrayList.addAll(this.V);
        }
        return arrayList;
    }

    public List<String> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("licai");
        arrayList.add("baidugushitong");
        arrayList.add("walletloan");
        arrayList.add("baiduwalletapp");
        arrayList.add("umoney_ios");
        arrayList.add("walletloan_lite");
        arrayList.add("bdwalletsdk");
        if (!this.U.isEmpty()) {
            arrayList.addAll(this.U);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> s() {
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

    public List<String> t() {
        return this.Q;
    }

    public Map<String, LoginShareStrategy> u() {
        return this.M;
    }

    public String v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g, this.I.d());
            jSONObject.put(a, this.J);
            jSONObject.put(t, this.X);
            jSONObject.put(v, this.Y);
            jSONObject.put(s, this.ba);
            if (this.K != null) {
                jSONObject.put(b, this.K.getStrValue());
            }
            jSONObject.put(d, this.L);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.M.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(c, jSONObject2);
            b(jSONObject, B, this.T);
            a(jSONObject, e, this.N);
            a(jSONObject, f, this.O);
            a(jSONObject, p, this.P);
            a(jSONObject, q, this.Q);
            a(jSONObject, r, this.S);
            a(jSONObject, y, this.U);
            a(jSONObject, z, this.V);
            JSONArray jSONArray = new JSONArray();
            for (Integer num : this.R) {
                jSONArray.put(num);
            }
            jSONObject.put(u, jSONArray);
            jSONObject.put(x, this.Z);
            jSONObject.put(C, this.aa);
            jSONObject.put(D, this.ca);
            jSONObject.put(E, this.da);
            jSONObject.put(w, this.ea);
            jSONObject.put("gray", this.fa.a());
            jSONObject.put(A, this.W);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public List<String> a() {
        return !this.N.isEmpty() ? this.N : k();
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static final String a = "finger";
        public static final String b = "cm_oauth";
        public static final String c = "cu_oauth";
        public static final String d = "ct_oauth";
        static String e = "v";
        static String f = "p";
        static String g = "ex";
        static String h = "meet";
        static String i = "t";
        private Map<String, a> j = new HashMap();

        static c a(JSONObject jSONObject) {
            c cVar = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("gray");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    if (obj != null && !"".equals(obj)) {
                        cVar.j.put(obj, a.a(obj, optJSONObject.optJSONObject(obj)));
                    }
                }
            }
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static class a {
            String a;
            long b;
            boolean c;
            String d;

            a() {
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.e, this.a);
                    jSONObject.put(c.f, this.b);
                    jSONObject.put(c.g, this.d);
                    jSONObject.put(c.h, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static a a(String str, JSONObject jSONObject) {
                SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.has(c.i) ? jSONObject.optJSONObject(c.i).optJSONObject(confignation.tpl) : new JSONObject();
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                aVar.a = optJSONObject.has(c.e) ? optJSONObject.optString(c.e) : jSONObject.optString(c.e);
                aVar.b = optJSONObject.has(c.f) ? optJSONObject.optLong(c.f) : jSONObject.optLong(c.f);
                aVar.d = optJSONObject.has(c.g) ? optJSONObject.optString(c.g) : jSONObject.optString(c.g);
                long j = SapiContext.getInstance().getLong(str, -1L);
                if (j == -1) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    j = random.nextInt(1000000);
                    SapiContext.getInstance().put(str, j);
                }
                aVar.c = aVar.b >= j;
                if (!TextUtils.isEmpty(aVar.a) && SapiUtils.versionCompareTo(ServiceManager.getInstance().getIsAccountManager().getVersionName(), aVar.a) < 0) {
                    aVar.c = false;
                }
                return aVar;
            }
        }

        JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.j.keySet()) {
                try {
                    jSONObject.put(str, this.j.get(str).a());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return jSONObject;
        }

        public a a(String str) {
            a aVar = this.j.get(str);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.c = true;
                return aVar2;
            }
            return aVar;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        private static final String a = "authorized_packages";
        private static final String b = "sc_authorized_packages";
        private static final String c = "vehicle_system_pkgs";
        private Map<String, String> d = new HashMap();
        private Map<String, String> e = new HashMap();
        private Map<String, String> f = new HashMap();

        public static d a(JSONObject jSONObject) {
            d dVar = new d();
            S.b(jSONObject.optJSONObject(a), dVar.d);
            S.b(jSONObject.optJSONObject(c), dVar.f);
            S.b(jSONObject.optJSONObject(b), dVar.e);
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
            hashMap.put(com.baidu.sapi2.b.a.e, "db97d206640d7aca6d75975b3c1f6e87");
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
            return !this.e.isEmpty() ? this.e : c();
        }

        public Map<String, String> f() {
            return this.f.isEmpty() ? d() : this.f;
        }

        public String g() {
            JSONObject jSONObject = new JSONObject();
            try {
                S.b(jSONObject, a, this.d);
                S.b(jSONObject, c, this.f);
                S.b(jSONObject, b, this.e);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }

        public Map<String, String> a() {
            return !this.d.isEmpty() ? this.d : b();
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
        this.I = aVar;
    }

    private static void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : list) {
            jSONArray.put(str2);
        }
        jSONObject.put(str, jSONArray);
    }

    private static void a(JSONObject jSONObject, S s2) {
        SapiContext sapiContext = SapiContext.getInstance();
        int i2 = sapiContext.getInt(h, -1);
        if (i2 == -1) {
            i2 = new Random().nextInt(100);
            sapiContext.put(h, i2);
        }
        b a2 = b.a(jSONObject.optJSONObject(h));
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split = b2.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        int length = split.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3 += Integer.valueOf(split[i4]).intValue();
            if (i2 <= i3) {
                s2.I.d.clear();
                s2.I.d.add(a2.b.get(i4));
                return;
            }
        }
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

    public static S a(JSONObject jSONObject) {
        S s2 = new S();
        s2.I = a.a(jSONObject.optJSONObject(g));
        if (jSONObject.has(h)) {
            a(jSONObject, s2);
        }
        s2.J = jSONObject.optString(a, com.baidu.sapi2.utils.f.o);
        s2.X = jSONObject.optBoolean(t);
        s2.Y = jSONObject.optBoolean(v);
        s2.L = jSONObject.optBoolean(d, true);
        s2.ba = jSONObject.optInt(s, 0);
        String optString = jSONObject.optString(b);
        if (!TextUtils.isEmpty(optString)) {
            s2.K = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                s2.M.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        b(jSONObject.optJSONObject(B), s2.T);
        a(jSONObject.optJSONArray(e), s2.N);
        a(jSONObject.optJSONArray(f), s2.O);
        a(jSONObject.optJSONArray(p), s2.P);
        a(jSONObject.optJSONArray(q), s2.Q);
        a(jSONObject.optJSONArray(r), s2.S);
        a(jSONObject.optJSONArray(y), s2.U);
        a(jSONObject.optJSONArray(z), s2.V);
        JSONArray optJSONArray = jSONObject.optJSONArray(u);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                s2.R.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
        }
        s2.Z = jSONObject.optInt(x, 100);
        s2.aa = jSONObject.optBoolean(C, false);
        s2.ca = jSONObject.optBoolean(D, false);
        s2.da = jSONObject.optString(E, "");
        s2.ea = jSONObject.optString(w, H);
        s2.fa = c.a(jSONObject);
        s2.W = jSONObject.optBoolean(A, true);
        return s2;
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
}
