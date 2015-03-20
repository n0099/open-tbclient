package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    private static final String a = "reg_mode";
    private static final String b = "fast_reg_sms_num";
    private static final String c = "voluntary_share_plist";
    private static final String d = "global_share_strategy";
    private static final String e = "specific_share_strategy";
    private static final String f = "authorized_packages";
    private static final String g = "authorized_domains";
    private static final String h = "cache";
    private static final String i = "enabled";
    private static final String j = "modules";
    private static final String k = "id";
    private static final String l = "ref_entry";
    private static final String m = "ref";
    private static final String n = "download_url";
    private static final String o = "version";
    private static final String p = "hash";
    private LoginShareStrategy u;
    private Map<String, Integer> t = new HashMap();
    private Map<String, LoginShareStrategy> v = new HashMap();
    private Map<String, String> w = new HashMap();
    private List<String> x = new ArrayList();
    private a q = new a();
    private RegistMode r = RegistMode.getDefault();
    private String s = e.n;

    public String a() {
        return this.s;
    }

    public Map<String, Integer> b() {
        return this.t;
    }

    public RegistMode c() {
        return this.r;
    }

    public LoginShareStrategy d() {
        return this.u;
    }

    public Map<String, LoginShareStrategy> e() {
        return this.v;
    }

    public Map<String, String> f() {
        return !this.w.isEmpty() ? this.w : j();
    }

    public List<String> g() {
        return !this.x.isEmpty() ? this.x : k();
    }

    public a h() {
        return this.q;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(h, this.q.c());
            jSONObject.put(a, this.r.getStrValue());
            jSONObject.put(b, this.s);
            jSONObject.put(c, new JSONObject(this.t));
            if (this.u != null) {
                jSONObject.put(d, this.u.getStrValue());
            }
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.v.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(e, jSONObject2);
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
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.r = RegistMode.mapStrToValue(jSONObject.optString(a));
        bVar.q = a.a(jSONObject.optJSONObject(h));
        bVar.s = jSONObject.optString(b, e.n);
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bVar.t.put(next, Integer.valueOf(optJSONObject.optInt(next, 0)));
            }
        }
        String optString = jSONObject.optString(d);
        if (!TextUtils.isEmpty(optString)) {
            bVar.u = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(e);
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                bVar.v.put(next2, LoginShareStrategy.mapStrToValue(optJSONObject2.optString(next2)));
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(f);
        if (optJSONObject3 != null) {
            Iterator<String> keys3 = optJSONObject3.keys();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                String optString2 = optJSONObject3.optString(next3);
                if (!TextUtils.isEmpty(next3) && !TextUtils.isEmpty(optString2)) {
                    bVar.w.put(next3, optString2);
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(g);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                    bVar.x.add(optJSONArray.optString(i2));
                }
            }
        }
        return bVar;
    }

    /* loaded from: classes.dex */
    public class a {
        private static final String a = ".BD_SAPI_CACHE";
        private List<C0004a> c = new ArrayList();
        private boolean b = true;

        public boolean a() {
            return this.b;
        }

        public List<C0004a> b() {
            return this.c;
        }

        /* renamed from: com.baidu.sapi2.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0004a {
            public String a;
            public String b;
            public C0005a c = new C0005a();

            /* renamed from: com.baidu.sapi2.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0005a {
                public String a;
                public long b = 0;
                public String c;

                JSONObject a() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(b.n, this.a);
                        jSONObject.put(b.o, this.b);
                        jSONObject.put(b.p, this.c);
                        return jSONObject;
                    } catch (Throwable th) {
                        return null;
                    }
                }

                public static C0005a a(JSONObject jSONObject) {
                    C0005a c0005a = new C0005a();
                    if (jSONObject != null) {
                        c0005a.a = jSONObject.optString(b.n);
                        c0005a.b = jSONObject.optLong(b.o);
                        c0005a.c = jSONObject.optString(b.p);
                    }
                    return c0005a;
                }
            }

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    jSONObject.put(b.m, this.b);
                    jSONObject.put(b.l, this.c.a());
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static C0004a a(JSONObject jSONObject) {
                C0004a c0004a = new C0004a();
                c0004a.a = jSONObject.optString("id");
                c0004a.b = jSONObject.optString(b.m);
                c0004a.c = C0005a.a(jSONObject.optJSONObject(b.l));
                return c0004a;
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
                return this.a.equals(((C0004a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b.i, this.b);
                JSONArray jSONArray = new JSONArray();
                for (C0004a c0004a : b()) {
                    jSONArray.put(c0004a.a());
                }
                jSONObject.put(b.j, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.b = jSONObject.optBoolean(b.i, true);
                    JSONArray optJSONArray = jSONObject.optJSONArray(b.j);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.b().add(C0004a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return aVar;
        }
    }

    static Map<String, String> j() {
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
        hashMap.put("com.baidu.navi", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.travel", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.baidulife", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.ting.mp3.android", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.news", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.hao123", "7fd3727852d29eb6f4283988dc0d6150");
        hashMap.put("com.baidu.netdisk", "ae5821440fab5e1a61a025f014bd8972");
        hashMap.put("com.baidu.music.lebo", "b1d67a31136599143c5c38879728dcfd");
        hashMap.put("com.hiapk.marketpho", "d46053ef4381d35cb774eb632d8e8aec");
        hashMap.put("com.baidu.gamecenter(.*)", "bddf74f2473eb1802fe13fe3e1aab81a");
        hashMap.put("com.baidu.notes", "989d3c446cadade24c8c57a10fe6370d");
        hashMap.put("com.baidu.lifenote", "c1a65e392e3892db0935d22f6c20b9cc");
        hashMap.put("com.baidu.passport.securitycenter", "db97d206640d7aca6d75975b3c1f6e87");
        hashMap.put("com.nuomi", "59215ee95c063ff2c56226581a62130a");
        hashMap.put("com.baidu.shucheng91", "2090b2ef3011c12d851ed125c2360954");
        hashMap.put("com.duoku.gamesearch", "153a76549eb514258b5806f95da02bb3");
        hashMap.put("com.baidu.qingpai", "80344917d9e7cf0fd8a8914cc918e0ef");
        hashMap.put("cn.jingling.motu.photowonder", "6930f0bd9fa461c2cd65e216acee0118");
        hashMap.put("com.baidu.account", "fe3c74f0431ea0dc303a10b6af6470fc");
        hashMap.put("com.duoku.game.helper", "6231a79a3f43cdd01797eb5febbc6350");
        hashMap.put("com.dragon.android.pandaspace", "5b120e96b20f5b4ec695d79b20d18753");
        hashMap.put("com.baidu.addressugc", "9e2a7cde67d36c1e6a01bb070fc8ef7b");
        hashMap.put("cn.opda.a.phonoalbumshoushou", "310a4f78e839b86df7731c2f48fcadae");
        hashMap.put("com.baidu.fb", "a4622402640f20dfda894cbe2edf8823");
        hashMap.put("com.baidu.baidutranslate", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.lbs.waimai", "77ad7ac419a031af0252422152c62e67");
        hashMap.put("com.baidu.lottery", "6e45686dd05db2374b0a600c7f28c0c4");
        hashMap.put("com.baidu.doctor", "49c95b74699e358ffe67f5daacab3d48");
        hashMap.put("com.baidu.patient", "49c95b74699e358ffe67f5daacab3d48");
        hashMap.put("com.baidu.baidumovie", "645c143e25f34e076bcee9600b30e4c2");
        hashMap.put("com.baidu.hao123tejia", "7fd3727852d29eb6f4283988dc0d6150");
        return hashMap;
    }

    static List<String> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("baifubao.com");
        arrayList.add("nuomi.com");
        arrayList.add("chuanke.com");
        return arrayList;
    }
}
