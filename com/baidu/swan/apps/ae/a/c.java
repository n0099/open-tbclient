package com.baidu.swan.apps.ae.a;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private static final HashMap<String, Integer> aRf = new HashMap<>();
    public a aQX;
    public d aQY;
    public e aQZ;
    public com.baidu.swan.apps.ae.a.d aRa;
    public f aRb;
    public b aRc;
    public b.a aRd;
    public String aRe;
    public boolean azt;

    static {
        aRf.put("light", -1);
        aRf.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aRe = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.azt = jSONObject.optBoolean("debug");
            cVar.aQX = a.N(jSONObject);
            cVar.aQY = d.R(jSONObject);
            cVar.aQZ = e.a(jSONObject, cVar.aQY);
            cVar.aRa = com.baidu.swan.apps.ae.a.d.X(jSONObject);
            cVar.aRb = f.T(jSONObject);
            cVar.aRc = b.P(jSONObject);
            cVar.aRd = b.a.M(jSONObject);
            return cVar;
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e("SwanAppConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }

    public static int cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = gN(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (aRf.containsKey(str)) {
                return aRf.get(str).intValue();
            }
            return -1;
        }
    }

    public static String gN(String str) {
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

    public String Gq() {
        if (Mz()) {
            return this.aRb.aRq.get(0).aRr;
        }
        if (Mx()) {
            return this.aQX.mPages.get(0);
        }
        return "";
    }

    public boolean Mx() {
        return (this.aQX == null || this.aQX.mPages == null || this.aQX.mPages.isEmpty()) ? false : true;
    }

    public boolean My() {
        return (this.aQY == null || this.aQY.aRk == null || this.aQY.aRm == null) ? false : true;
    }

    public boolean Mz() {
        return this.aRb != null && this.aRb.MG();
    }

    public boolean gO(String str) {
        return (Mx() && this.aQX.gQ(str)) || (My() && this.aQY.aRm.containsKey(str));
    }

    public boolean gP(String str) {
        return this.aRb != null && this.aRb.gR(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a N(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MA();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return MA();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean gQ(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a MA() {
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
        public int aRo;
        public int aRp;
        public ArrayList<g> aRq;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f T(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MH();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return MH();
            }
            f fVar = new f();
            fVar.mColor = c.cE(optJSONObject.optString("color", "#999999"));
            fVar.aRo = c.cE(optJSONObject.optString("selectedColor", "black"));
            fVar.aRp = c.cE(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.cE(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aRq = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aRq.add(g.V(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean MG() {
            return this.aRq != null && this.aRq.size() >= 2;
        }

        public boolean gR(String str) {
            if (this.aRq == null) {
                return false;
            }
            for (int i = 0; i < this.aRq.size(); i++) {
                if (TextUtils.equals(this.aRq.get(i).aRr, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f MH() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.aRq = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aRg;

        /* JADX INFO: Access modifiers changed from: private */
        public static b P(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MC();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return MC();
            }
            com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
            String str = "";
            if (Md != null) {
                str = Md.id;
            }
            b bVar = new b();
            bVar.aRg = optJSONObject.optBoolean("urlCheck", true);
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

        public static boolean MB() {
            c Gn = com.baidu.swan.apps.w.e.GF().Gn();
            if (Gn == null) {
                return true;
            }
            b bVar = Gn.aRc;
            com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (Md != null) {
                bVar2 = Md.vL();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean yl = com.baidu.swan.apps.console.a.d.yl();
            boolean wM = com.baidu.swan.apps.core.a.wM();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + yl + " isMobileDebug: " + wM + " urlCheck: " + bVar.aRg);
            }
            return (b || yl || wM) && !bVar.aRg;
        }

        private static b MC() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aRg = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aRr;
        public String aRs;
        public String aRt;
        public String amD;

        /* JADX INFO: Access modifiers changed from: private */
        public static g V(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MI();
            }
            g gVar = new g();
            gVar.aRr = jSONObject.optString("pagePath");
            gVar.aRs = jSONObject.optString("iconPath");
            gVar.aRt = jSONObject.optString("selectedIconPath");
            gVar.amD = jSONObject.optString("text");
            return gVar;
        }

        private static g MI() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0112c> aRk;
        public HashMap<String, Boolean> aRl;
        public HashMap<String, String> aRm;

        /* JADX INFO: Access modifiers changed from: private */
        public static d R(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ME();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return ME();
            }
            d dVar = new d();
            dVar.aRk = new ArrayList();
            dVar.aRm = new HashMap<>();
            dVar.aRl = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aRk.add(C0112c.a(optJSONObject, dVar.aRm));
                }
            }
            return dVar;
        }

        private static d ME() {
            d dVar = new d();
            dVar.aRk = new ArrayList();
            dVar.aRm = new HashMap<>();
            dVar.aRl = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0112c {
        private static final String aRj = File.separator;
        public String aRh;
        public List<String> aRi;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0112c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return MD();
            }
            C0112c c0112c = new C0112c();
            c0112c.aRh = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0112c.aRi = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0112c.aRi.add(optString);
                    if (!TextUtils.isEmpty(c0112c.aRh) && !TextUtils.isEmpty(optString)) {
                        if (c0112c.aRh.endsWith(aRj) || optString.startsWith(aRj)) {
                            str = c0112c.aRh + optString;
                        } else {
                            str = c0112c.aRh + aRj + optString;
                        }
                        hashMap.put(str, c0112c.aRh);
                    }
                }
            }
            return c0112c;
        }

        private static C0112c MD() {
            C0112c c0112c = new C0112c();
            c0112c.aRi = new ArrayList();
            return c0112c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aRn;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aRk == null || dVar.aRk.size() <= 0) {
                return MF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return MF();
            }
            e eVar = new e();
            eVar.aRn = new HashMap<>();
            for (C0112c c0112c : dVar.aRk) {
                if (c0112c != null && !TextUtils.isEmpty(c0112c.aRh)) {
                    eVar.aRn.put(c0112c.aRh, optJSONObject.optString(c0112c.aRh));
                }
            }
            return eVar;
        }

        private static e MF() {
            e eVar = new e();
            eVar.aRn = new HashMap<>();
            return eVar;
        }
    }
}
