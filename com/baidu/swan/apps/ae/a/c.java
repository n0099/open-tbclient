package com.baidu.swan.apps.ae.a;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> bkp = new HashMap<>();
    public boolean aSN;
    public a bkh;
    public d bki;
    public e bkj;
    public com.baidu.swan.apps.ae.a.d bkk;
    public f bkl;
    public b bkm;
    public b.a bkn;
    public String bko;

    static {
        bkp.put("light", -1);
        bkp.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c hs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.bko = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.aSN = jSONObject.optBoolean("debug");
            cVar.bkh = a.am(jSONObject);
            cVar.bki = d.aq(jSONObject);
            cVar.bkj = e.a(jSONObject, cVar.bki);
            cVar.bkk = com.baidu.swan.apps.ae.a.d.aw(jSONObject);
            cVar.bkl = f.as(jSONObject);
            cVar.bkm = b.ao(jSONObject);
            cVar.bkn = b.a.al(jSONObject);
            return cVar;
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e("SwanAppConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }

    public static int bR(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = ht(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (bkp.containsKey(str)) {
                return bkp.get(str).intValue();
            }
            return -1;
        }
    }

    public static String ht(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i = 1; i < 4; i++) {
                char charAt = str.charAt(i);
                sb.append(charAt).append(charAt);
            }
            return sb.toString();
        }
        return str;
    }

    public String Lp() {
        if (Rx()) {
            return this.bkl.bkA.get(0).bkB;
        }
        if (Rv()) {
            return this.bkh.mPages.get(0);
        }
        return "";
    }

    public boolean Rv() {
        return (this.bkh == null || this.bkh.mPages == null || this.bkh.mPages.isEmpty()) ? false : true;
    }

    public boolean Rw() {
        return (this.bki == null || this.bki.bku == null || this.bki.bkw == null) ? false : true;
    }

    public boolean Rx() {
        return this.bkl != null && this.bkl.RE();
    }

    public boolean hu(String str) {
        return (Rv() && this.bkh.hw(str)) || (Rw() && this.bki.bkw.containsKey(str));
    }

    public boolean hv(String str) {
        return this.bkl != null && this.bkl.hx(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a am(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Ry();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return Ry();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean hw(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a Ry() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public ArrayList<g> bkA;
        public int bky;
        public int bkz;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f as(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return RF();
            }
            f fVar = new f();
            fVar.mColor = c.bR(optJSONObject.optString("color", "#999999"));
            fVar.bky = c.bR(optJSONObject.optString("selectedColor", "black"));
            fVar.bkz = c.bR(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.bR(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.bkA = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.bkA.add(g.au(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean RE() {
            return this.bkA != null && this.bkA.size() >= 2;
        }

        public boolean hx(String str) {
            if (this.bkA == null) {
                return false;
            }
            for (int i = 0; i < this.bkA.size(); i++) {
                if (TextUtils.equals(this.bkA.get(i).bkB, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f RF() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.bkA = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean bkq;

        /* JADX INFO: Access modifiers changed from: private */
        public static b ao(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return RA();
            }
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            String str = "";
            if (Ra != null) {
                str = Ra.id;
            }
            b bVar = new b();
            bVar.bkq = optJSONObject.optBoolean("urlCheck", true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.af.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.af.a.c.h(str, optJSONObject3);
                }
            }
            return bVar;
        }

        public static boolean Rz() {
            c Lm = com.baidu.swan.apps.w.e.LE().Lm();
            if (Lm == null) {
                return true;
            }
            b bVar = Lm.bkm;
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (Ra != null) {
                bVar2 = Ra.AK();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean Dl = com.baidu.swan.apps.console.a.d.Dl();
            boolean BL = com.baidu.swan.apps.core.a.BL();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Dl + " isMobileDebug: " + BL + " urlCheck: " + bVar.bkq);
            }
            return (b || Dl || BL) && !bVar.bkq;
        }

        private static b RA() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.bkq = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String bkB;
        public String bkC;
        public String bkD;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static g au(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RG();
            }
            g gVar = new g();
            gVar.bkB = jSONObject.optString("pagePath");
            gVar.bkC = jSONObject.optString("iconPath");
            gVar.bkD = jSONObject.optString("selectedIconPath");
            gVar.mText = jSONObject.optString("text");
            return gVar;
        }

        private static g RG() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0148c> bku;
        public HashMap<String, Boolean> bkv;
        public HashMap<String, String> bkw;

        /* JADX INFO: Access modifiers changed from: private */
        public static d aq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RC();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return RC();
            }
            d dVar = new d();
            dVar.bku = new ArrayList();
            dVar.bkw = new HashMap<>();
            dVar.bkv = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.bku.add(C0148c.a(optJSONObject, dVar.bkw));
                }
            }
            return dVar;
        }

        private static d RC() {
            d dVar = new d();
            dVar.bku = new ArrayList();
            dVar.bkw = new HashMap<>();
            dVar.bkv = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0148c {
        private static final String bkt = File.separator;
        public String bkr;
        public List<String> bks;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0148c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return RB();
            }
            C0148c c0148c = new C0148c();
            c0148c.bkr = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0148c.bks = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0148c.bks.add(optString);
                    if (!TextUtils.isEmpty(c0148c.bkr) && !TextUtils.isEmpty(optString)) {
                        if (c0148c.bkr.endsWith(bkt) || optString.startsWith(bkt)) {
                            str = c0148c.bkr + optString;
                        } else {
                            str = c0148c.bkr + bkt + optString;
                        }
                        hashMap.put(str, c0148c.bkr);
                    }
                }
            }
            return c0148c;
        }

        private static C0148c RB() {
            C0148c c0148c = new C0148c();
            c0148c.bks = new ArrayList();
            return c0148c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> bkx;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.bku == null || dVar.bku.size() <= 0) {
                return RD();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return RD();
            }
            e eVar = new e();
            eVar.bkx = new HashMap<>();
            for (C0148c c0148c : dVar.bku) {
                if (c0148c != null && !TextUtils.isEmpty(c0148c.bkr)) {
                    eVar.bkx.put(c0148c.bkr, optJSONObject.optString(c0148c.bkr));
                }
            }
            return eVar;
        }

        private static e RD() {
            e eVar = new e();
            eVar.bkx = new HashMap<>();
            return eVar;
        }
    }
}
