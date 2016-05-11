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
    private static final String e = "authorized_packages";
    private static final String f = "authorized_domains";
    private static final String g = "cache";
    private static final String h = "enabled";
    private static final String i = "modules";
    private static final String j = "id";
    private static final String k = "download_url";
    private static final String l = "hash";
    private static final String m = "login_cookie_di_keys";
    private static final String n = "pre_fetch_tpl_list";
    private LoginShareStrategy q;
    private boolean r;
    private Map<String, LoginShareStrategy> s = new HashMap();
    private Map<String, String> t = new HashMap();
    private List<String> u = new ArrayList();
    private List<String> v = new ArrayList();
    private List<String> w = new ArrayList();
    private a o = new a();
    private String p = f.u;

    public String a() {
        return this.p;
    }

    public LoginShareStrategy b() {
        return this.q;
    }

    public boolean c() {
        return this.r;
    }

    public Map<String, LoginShareStrategy> d() {
        return this.s;
    }

    public Map<String, String> e() {
        return !this.t.isEmpty() ? this.t : k();
    }

    public List<String> f() {
        return !this.u.isEmpty() ? this.u : o();
    }

    public List<String> g() {
        return this.v;
    }

    public List<String> h() {
        return this.w;
    }

    public a i() {
        return this.o;
    }

    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g, this.o.c());
            jSONObject.put(a, this.p);
            if (this.q != null) {
                jSONObject.put(b, this.q.getStrValue());
            }
            jSONObject.put(d, this.r);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, LoginShareStrategy> entry : this.s.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().getStrValue());
            }
            jSONObject.put(c, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : this.t.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject.put(e, jSONObject3);
            JSONArray jSONArray = new JSONArray();
            for (String str : this.u) {
                jSONArray.put(str);
            }
            jSONObject.put(f, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : this.v) {
                jSONArray2.put(str2);
            }
            jSONObject.put(m, jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (String str3 : this.w) {
                jSONArray3.put(str3);
            }
            jSONObject.put(n, jSONArray3);
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        dVar.o = a.a(jSONObject.optJSONObject(g));
        dVar.p = jSONObject.optString(a, f.u);
        dVar.r = jSONObject.optBoolean(d);
        String optString = jSONObject.optString(b);
        if (!TextUtils.isEmpty(optString)) {
            dVar.q = LoginShareStrategy.mapStrToValue(optString);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(c);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                dVar.s.put(next, LoginShareStrategy.mapStrToValue(optJSONObject.optString(next)));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(e);
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                String optString2 = optJSONObject2.optString(next2);
                if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(optString2)) {
                    dVar.t.put(next2, optString2);
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(f);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                    dVar.u.add(optJSONArray.optString(i2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(m);
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (!TextUtils.isEmpty(optJSONArray2.optString(i3))) {
                    dVar.v.add(optJSONArray2.optString(i3));
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(n);
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                if (!TextUtils.isEmpty(optJSONArray3.optString(i4))) {
                    dVar.w.add(optJSONArray3.optString(i4));
                }
            }
        }
        return dVar;
    }

    /* loaded from: classes.dex */
    public static class a {
        private static final String a = ".BD_SAPI_CACHE";
        private List<C0026a> c = new ArrayList();
        private boolean b = true;

        public boolean a() {
            return this.b;
        }

        public List<C0026a> b() {
            return this.c;
        }

        /* renamed from: com.baidu.sapi2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0026a {
            public String a;
            public String b;
            public String c;

            JSONObject a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    jSONObject.put(d.k, this.b);
                    jSONObject.put(d.l, this.c);
                    return jSONObject;
                } catch (Throwable th) {
                    return null;
                }
            }

            static C0026a a(JSONObject jSONObject) {
                C0026a c0026a = new C0026a();
                c0026a.a = jSONObject.optString("id");
                c0026a.b = jSONObject.optString(d.k);
                c0026a.c = jSONObject.optString(d.l);
                return c0026a;
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
                return this.a.equals(((C0026a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(d.h, this.b);
                JSONArray jSONArray = new JSONArray();
                for (C0026a c0026a : b()) {
                    jSONArray.put(c0026a.a());
                }
                jSONObject.put(d.i, jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                try {
                    aVar.b = jSONObject.optBoolean(d.h, true);
                    JSONArray optJSONArray = jSONObject.optJSONArray(d.i);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aVar.b().add(C0026a.a(optJSONArray.getJSONObject(i)));
                    }
                } catch (Throwable th) {
                }
            }
            return aVar;
        }
    }

    static Map<String, String> k() {
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
        hashMap.put("com.baidu.news(.*)", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.video", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.hao123(.*)", "7fd3727852d29eb6f4283988dc0d6150");
        hashMap.put("com.baidu.netdisk(.*)", "ae5821440fab5e1a61a025f014bd8972");
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
        hashMap.put("com.baidu.bdg.skyeye", "544f0f4a82864fbf7b9663fbc80437bb");
        hashMap.put("com.zongheng.reader(.*)", "b9c43ba43f1e150d4f1670ae09a89a7f");
        hashMap.put("com.baidu.doctor.doctorask", "13a0a8019be4015ed20e075d824f1696");
        hashMap.put("com.baidu.k12edu", "610d60c69d2adf4b57fc6c2ec83fecbf");
        hashMap.put("com.baidu.zuowen", "fa6b26072965ee3f372da85ca69b7b99");
        hashMap.put("com.baidu.wallet", "de74282b18c0847e64b2b3f0ebbfe0a0");
        hashMap.put("com.baidu.clouda.mobile.crm", "561e009b4a1f97012bf90dfed6c054d5");
        hashMap.put("com.baidu.wear.app", "73a9573a74d219b8cf3066316d0b330c");
        hashMap.put("com.dianxinos.optimizer.channel", "bd3df198d50f0dafa3c5804d342d3698");
        hashMap.put("com.baidu.lbs.bus", "3d96c8b0be8fd5b1db754b8dbb73f23e");
        hashMap.put("com.baidu.hui", "3102ce07daa9cb7c8d62c82fdc61c0ba");
        hashMap.put("com.baidu.image", "ff934173c55f54a81d9c5da216263479");
        hashMap.put("com.baidu.vip", "a00a833bf8afe07172262db3ccb3a5c5");
        hashMap.put("com.baidu.mami", "86743dc804add1dd5f3a81a5818ead58");
        hashMap.put("com.baidu.faceu", "a140a3b0775361c459fc751c50e98d77");
        hashMap.put("com.baidu.movie", "0586742e88a2e6a19e996598ec336b61");
        hashMap.put("com.baidu.panocam", "c6186fde16482ce83196441e7fbed1b3");
        hashMap.put("com.baidu.dsocial", "49c95b74699e358ffe67f5daacab3d48");
        hashMap.put("com.duwear.fb", "a4622402640f20dfda894cbe2edf8823");
        hashMap.put("com.qiyi.video", "846b46b26f2d9572124e4cfd778e8774");
        hashMap.put("tv.pps.mobile", "79a4816c58b11ba96e85524a7d5cf697");
        hashMap.put("com.baidu.cloudenterprise", "ae5821440fab5e1a61a025f014bd8972");
        hashMap.put("com.baidu.haokan", "7fd3727852d29eb6f4283988dc0d6150");
        hashMap.put("com.baidu.fangmi", "08e0e60c3b3a37ac88a2a06e86d0f8fa");
        hashMap.put("com.chuanke.ikk", "b12d5bcf96654b0a8da91256638695ab");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Integer> l() {
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
    public List<String> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.browser.(.+)");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> n() {
        ArrayList arrayList = new ArrayList();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String replaceAll = sapiConfiguration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = sapiConfiguration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        arrayList.add(replaceAll);
        arrayList.add(replaceAll2);
        return arrayList;
    }

    static List<String> o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }
}
