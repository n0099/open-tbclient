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
    private static final HashMap<String, Integer> aQv = new HashMap<>();
    public a aQn;
    public d aQo;
    public e aQp;
    public com.baidu.swan.apps.ae.a.d aQq;
    public f aQr;
    public b aQs;
    public b.a aQt;
    public String aQu;
    public boolean ayM;

    static {
        aQv.put("light", -1);
        aQv.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aQu = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.ayM = jSONObject.optBoolean("debug");
            cVar.aQn = a.N(jSONObject);
            cVar.aQo = d.R(jSONObject);
            cVar.aQp = e.a(jSONObject, cVar.aQo);
            cVar.aQq = com.baidu.swan.apps.ae.a.d.X(jSONObject);
            cVar.aQr = f.T(jSONObject);
            cVar.aQs = b.P(jSONObject);
            cVar.aQt = b.a.M(jSONObject);
            return cVar;
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e("SwanAppConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }

    public static int parseColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = gG(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (aQv.containsKey(str)) {
                return aQv.get(str).intValue();
            }
            return -1;
        }
    }

    public static String gG(String str) {
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

    public String FG() {
        if (LL()) {
            return this.aQr.aQG.get(0).aQH;
        }
        if (LJ()) {
            return this.aQn.mPages.get(0);
        }
        return "";
    }

    public boolean LJ() {
        return (this.aQn == null || this.aQn.mPages == null || this.aQn.mPages.isEmpty()) ? false : true;
    }

    public boolean LK() {
        return (this.aQo == null || this.aQo.aQA == null || this.aQo.aQC == null) ? false : true;
    }

    public boolean LL() {
        return this.aQr != null && this.aQr.LS();
    }

    public boolean gH(String str) {
        return (LJ() && this.aQn.gJ(str)) || (LK() && this.aQo.aQC.containsKey(str));
    }

    public boolean gI(String str) {
        return this.aQr != null && this.aQr.gK(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a N(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LM();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return LM();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean gJ(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a LM() {
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
        public int aQE;
        public int aQF;
        public ArrayList<g> aQG;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f T(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LT();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return LT();
            }
            f fVar = new f();
            fVar.mColor = c.parseColor(optJSONObject.optString("color", "#999999"));
            fVar.aQE = c.parseColor(optJSONObject.optString("selectedColor", "black"));
            fVar.aQF = c.parseColor(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.parseColor(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aQG = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aQG.add(g.V(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean LS() {
            return this.aQG != null && this.aQG.size() >= 2;
        }

        public boolean gK(String str) {
            if (this.aQG == null) {
                return false;
            }
            for (int i = 0; i < this.aQG.size(); i++) {
                if (TextUtils.equals(this.aQG.get(i).aQH, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f LT() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.aQG = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aQw;

        /* JADX INFO: Access modifiers changed from: private */
        public static b P(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LO();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return LO();
            }
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            String str = "";
            if (Lq != null) {
                str = Lq.id;
            }
            b bVar = new b();
            bVar.aQw = optJSONObject.optBoolean("urlCheck", true);
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

        public static boolean LN() {
            c FD = com.baidu.swan.apps.w.e.FV().FD();
            if (FD == null) {
                return true;
            }
            b bVar = FD.aQs;
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (Lq != null) {
                bVar2 = Lq.vk();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean xG = com.baidu.swan.apps.console.a.d.xG();
            boolean wl = com.baidu.swan.apps.core.a.wl();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + xG + " isMobileDebug: " + wl + " urlCheck: " + bVar.aQw);
            }
            return (b || xG || wl) && !bVar.aQw;
        }

        private static b LO() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aQw = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aQH;
        public String aQI;
        public String aQJ;
        public String ama;

        /* JADX INFO: Access modifiers changed from: private */
        public static g V(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LU();
            }
            g gVar = new g();
            gVar.aQH = jSONObject.optString("pagePath");
            gVar.aQI = jSONObject.optString("iconPath");
            gVar.aQJ = jSONObject.optString("selectedIconPath");
            gVar.ama = jSONObject.optString("text");
            return gVar;
        }

        private static g LU() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0110c> aQA;
        public HashMap<String, Boolean> aQB;
        public HashMap<String, String> aQC;

        /* JADX INFO: Access modifiers changed from: private */
        public static d R(JSONObject jSONObject) {
            if (jSONObject == null) {
                return LQ();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return LQ();
            }
            d dVar = new d();
            dVar.aQA = new ArrayList();
            dVar.aQC = new HashMap<>();
            dVar.aQB = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aQA.add(C0110c.a(optJSONObject, dVar.aQC));
                }
            }
            return dVar;
        }

        private static d LQ() {
            d dVar = new d();
            dVar.aQA = new ArrayList();
            dVar.aQC = new HashMap<>();
            dVar.aQB = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0110c {
        private static final String aQz = File.separator;
        public String aQx;
        public List<String> aQy;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0110c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return LP();
            }
            C0110c c0110c = new C0110c();
            c0110c.aQx = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0110c.aQy = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0110c.aQy.add(optString);
                    if (!TextUtils.isEmpty(c0110c.aQx) && !TextUtils.isEmpty(optString)) {
                        if (c0110c.aQx.endsWith(aQz) || optString.startsWith(aQz)) {
                            str = c0110c.aQx + optString;
                        } else {
                            str = c0110c.aQx + aQz + optString;
                        }
                        hashMap.put(str, c0110c.aQx);
                    }
                }
            }
            return c0110c;
        }

        private static C0110c LP() {
            C0110c c0110c = new C0110c();
            c0110c.aQy = new ArrayList();
            return c0110c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aQD;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aQA == null || dVar.aQA.size() <= 0) {
                return LR();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return LR();
            }
            e eVar = new e();
            eVar.aQD = new HashMap<>();
            for (C0110c c0110c : dVar.aQA) {
                if (c0110c != null && !TextUtils.isEmpty(c0110c.aQx)) {
                    eVar.aQD.put(c0110c.aQx, optJSONObject.optString(c0110c.aQx));
                }
            }
            return eVar;
        }

        private static e LR() {
            e eVar = new e();
            eVar.aQD = new HashMap<>();
            return eVar;
        }
    }
}
