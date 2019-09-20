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
    private static final HashMap<String, Integer> aRD = new HashMap<>();
    public b aRA;
    public b.a aRB;
    public String aRC;
    public a aRv;
    public d aRw;
    public e aRx;
    public com.baidu.swan.apps.ae.a.d aRy;
    public f aRz;
    public boolean azR;

    static {
        aRD.put("light", -1);
        aRD.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aRC = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.azR = jSONObject.optBoolean("debug");
            cVar.aRv = a.N(jSONObject);
            cVar.aRw = d.R(jSONObject);
            cVar.aRx = e.a(jSONObject, cVar.aRw);
            cVar.aRy = com.baidu.swan.apps.ae.a.d.X(jSONObject);
            cVar.aRz = f.T(jSONObject);
            cVar.aRA = b.P(jSONObject);
            cVar.aRB = b.a.M(jSONObject);
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
            str = gP(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (aRD.containsKey(str)) {
                return aRD.get(str).intValue();
            }
            return -1;
        }
    }

    public static String gP(String str) {
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

    public String Gu() {
        if (MD()) {
            return this.aRz.aRO.get(0).aRP;
        }
        if (MB()) {
            return this.aRv.mPages.get(0);
        }
        return "";
    }

    public boolean MB() {
        return (this.aRv == null || this.aRv.mPages == null || this.aRv.mPages.isEmpty()) ? false : true;
    }

    public boolean MC() {
        return (this.aRw == null || this.aRw.aRI == null || this.aRw.aRK == null) ? false : true;
    }

    public boolean MD() {
        return this.aRz != null && this.aRz.MK();
    }

    public boolean gQ(String str) {
        return (MB() && this.aRv.gS(str)) || (MC() && this.aRw.aRK.containsKey(str));
    }

    public boolean gR(String str) {
        return this.aRz != null && this.aRz.gT(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a N(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ME();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return ME();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean gS(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a ME() {
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
        public int aRM;
        public int aRN;
        public ArrayList<g> aRO;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f T(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ML();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return ML();
            }
            f fVar = new f();
            fVar.mColor = c.cE(optJSONObject.optString("color", "#999999"));
            fVar.aRM = c.cE(optJSONObject.optString("selectedColor", "black"));
            fVar.aRN = c.cE(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.cE(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aRO = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aRO.add(g.V(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean MK() {
            return this.aRO != null && this.aRO.size() >= 2;
        }

        public boolean gT(String str) {
            if (this.aRO == null) {
                return false;
            }
            for (int i = 0; i < this.aRO.size(); i++) {
                if (TextUtils.equals(this.aRO.get(i).aRP, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f ML() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.aRO = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aRE;

        /* JADX INFO: Access modifiers changed from: private */
        public static b P(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MG();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return MG();
            }
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            String str = "";
            if (Mh != null) {
                str = Mh.id;
            }
            b bVar = new b();
            bVar.aRE = optJSONObject.optBoolean("urlCheck", true);
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

        public static boolean MF() {
            c Gr = com.baidu.swan.apps.w.e.GJ().Gr();
            if (Gr == null) {
                return true;
            }
            b bVar = Gr.aRA;
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (Mh != null) {
                bVar2 = Mh.vP();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean yp = com.baidu.swan.apps.console.a.d.yp();
            boolean wQ = com.baidu.swan.apps.core.a.wQ();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + yp + " isMobileDebug: " + wQ + " urlCheck: " + bVar.aRE);
            }
            return (b || yp || wQ) && !bVar.aRE;
        }

        private static b MG() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aRE = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aRP;
        public String aRQ;
        public String aRR;
        public String anb;

        /* JADX INFO: Access modifiers changed from: private */
        public static g V(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MM();
            }
            g gVar = new g();
            gVar.aRP = jSONObject.optString("pagePath");
            gVar.aRQ = jSONObject.optString("iconPath");
            gVar.aRR = jSONObject.optString("selectedIconPath");
            gVar.anb = jSONObject.optString("text");
            return gVar;
        }

        private static g MM() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0121c> aRI;
        public HashMap<String, Boolean> aRJ;
        public HashMap<String, String> aRK;

        /* JADX INFO: Access modifiers changed from: private */
        public static d R(JSONObject jSONObject) {
            if (jSONObject == null) {
                return MI();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return MI();
            }
            d dVar = new d();
            dVar.aRI = new ArrayList();
            dVar.aRK = new HashMap<>();
            dVar.aRJ = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aRI.add(C0121c.a(optJSONObject, dVar.aRK));
                }
            }
            return dVar;
        }

        private static d MI() {
            d dVar = new d();
            dVar.aRI = new ArrayList();
            dVar.aRK = new HashMap<>();
            dVar.aRJ = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0121c {
        private static final String aRH = File.separator;
        public String aRF;
        public List<String> aRG;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0121c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return MH();
            }
            C0121c c0121c = new C0121c();
            c0121c.aRF = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0121c.aRG = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0121c.aRG.add(optString);
                    if (!TextUtils.isEmpty(c0121c.aRF) && !TextUtils.isEmpty(optString)) {
                        if (c0121c.aRF.endsWith(aRH) || optString.startsWith(aRH)) {
                            str = c0121c.aRF + optString;
                        } else {
                            str = c0121c.aRF + aRH + optString;
                        }
                        hashMap.put(str, c0121c.aRF);
                    }
                }
            }
            return c0121c;
        }

        private static C0121c MH() {
            C0121c c0121c = new C0121c();
            c0121c.aRG = new ArrayList();
            return c0121c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aRL;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aRI == null || dVar.aRI.size() <= 0) {
                return MJ();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return MJ();
            }
            e eVar = new e();
            eVar.aRL = new HashMap<>();
            for (C0121c c0121c : dVar.aRI) {
                if (c0121c != null && !TextUtils.isEmpty(c0121c.aRF)) {
                    eVar.aRL.put(c0121c.aRF, optJSONObject.optString(c0121c.aRF));
                }
            }
            return eVar;
        }

        private static e MJ() {
            e eVar = new e();
            eVar.aRL = new HashMap<>();
            return eVar;
        }
    }
}
