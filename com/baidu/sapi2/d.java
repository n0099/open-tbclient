package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    private static final String a = "fast_reg_sms_num";
    private static final String b = "global_share_strategy";
    private static final String c = "specific_share_strategy";
    private static final String d = "default_https_enabled";
    private static final String e = "sofire_sdk_enabled";
    private static final String f = "authorized_packages";
    private static final String g = "authorized_domains";
    private static final String h = "cache";
    private static final String i = "enabled";
    private static final String j = "version";
    private static final String k = "modules";
    private static final String l = "id";
    private static final String m = "download_url";
    private static final String n = "hash";
    private static final String o = "login_cookie_di_keys";
    private static final String p = "pre_fetch_tpl_list";
    private LoginShareStrategy s;
    private boolean u;
    private boolean t = true;
    private Map<String, LoginShareStrategy> v = new HashMap();
    private Map<String, String> w = new HashMap();
    private List<String> x = new ArrayList();
    private List<String> y = new ArrayList();
    private List<String> z = new ArrayList();
    private a q = new a();
    private String r = f.u;

    public String a() {
        return this.r;
    }

    public LoginShareStrategy b() {
        return this.s;
    }

    public boolean c() {
        return this.t;
    }

    public boolean d() {
        return this.u;
    }

    public Map<String, LoginShareStrategy> e() {
        return this.v;
    }

    public Map<String, String> f() {
        return !this.w.isEmpty() ? this.w : l();
    }

    public List<String> g() {
        return !this.x.isEmpty() ? this.x : p();
    }

    public List<String> h() {
        return this.y;
    }

    public List<String> i() {
        return this.z;
    }

    public a j() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.q = aVar;
    }

    public String k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(h, this.q.d());
            jSONObject.put(a, this.r);
            if (this.s != null) {
                jSONObject.put(b, this.s.getStrValue());
            }
            jSONObject.put(d, this.t);
            jSONObject.put(e, this.u);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.v.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(c, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : this.w.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject.put(f, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (String str : this.x) {
                jSONArray.put(str);
            }
            jSONObject.put(g, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : this.y) {
                jSONArray2.put(str2);
            }
            jSONObject.put(o, jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (String str3 : this.z) {
                jSONArray3.put(str3);
            }
            jSONObject.put(p, jSONArray3);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        dVar.q = a.a(jSONObject.optJSONObject(h));
        dVar.r = jSONObject.optString(a, f.u);
        dVar.t = jSONObject.optBoolean(d, true);
        dVar.u = jSONObject.optBoolean(e);
        String optString = jSONObject.optString(b);
        if (!TextUtils.isEmpty(optString)) {
            dVar.s = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                dVar.v.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(f);
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                String optString2 = optJSONObject2.optString(next2);
                if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(optString2)) {
                    dVar.w.put(next2, optString2);
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(g);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                    dVar.x.add(optJSONArray.optString(i2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(o);
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (!TextUtils.isEmpty(optJSONArray2.optString(i3))) {
                    dVar.y.add(optJSONArray2.optString(i3));
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(p);
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                if (!TextUtils.isEmpty(optJSONArray3.optString(i4))) {
                    dVar.z.add(optJSONArray3.optString(i4));
                }
            }
        }
        return dVar;
    }

    /* loaded from: classes.dex */
    public static class a {
        private static final String a = ".BD_SAPI_CACHE";
        private String c;
        private List<C0032a> d = new ArrayList();
        private boolean b = true;

        public boolean a() {
            return this.b;
        }

        public List<C0032a> b() {
            return this.d;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: com.baidu.sapi2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0032a {
            public String a;
            public String b;
            public String c;

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    jSONObject.put(d.m, this.b);
                    jSONObject.put(d.n, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static C0032a a(JSONObject jSONObject) {
                C0032a c0032a = new C0032a();
                c0032a.a = jSONObject.optString("id");
                c0032a.b = jSONObject.optString(d.m);
                c0032a.c = jSONObject.optString(d.n);
                return c0032a;
            }

            public static String a(String str) {
                return b(str).replace('/', '-');
            }

            public static String b(String str) {
                return str.replace(':', '/');
            }

            public static String c(String str) {
                return ".BD_SAPI_CACHE/" + b(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0032a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(d.i, this.b);
                jSONObject.put(d.j, this.c);
                JSONArray jSONArray = new JSONArray();
                for (C0032a c0032a : b()) {
                    jSONArray.put(c0032a.a());
                }
                jSONObject.put(d.k, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.b = jSONObject.optBoolean(d.i, true);
                    aVar.c = jSONObject.optLong(d.j) + "";
                    JSONArray optJSONArray = jSONObject.optJSONArray(d.k);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.b().add(C0032a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return aVar;
        }
    }

    static Map<String, String> l() {
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
        hashMap.put("com.baidu.passport.securitycenter", "db97d206640d7aca6d75975b3c1f6e87");
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
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> m() {
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
    public List<String> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> o() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String replaceAll = sapiConfiguration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = sapiConfiguration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    static List<String> p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }
}
