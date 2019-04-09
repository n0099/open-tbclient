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
    private static final HashMap<String, Integer> aOs = new HashMap<>();
    public a aOk;
    public d aOl;
    public e aOm;
    public com.baidu.swan.apps.ae.a.d aOn;
    public f aOo;
    public b aOp;
    public b.a aOq;
    public String aOr;
    public boolean axW;

    static {
        aOs.put("light", -1);
        aOs.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aOr = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.axW = jSONObject.optBoolean("debug");
            cVar.aOk = a.O(jSONObject);
            cVar.aOl = d.S(jSONObject);
            cVar.aOm = e.a(jSONObject, cVar.aOl);
            cVar.aOn = com.baidu.swan.apps.ae.a.d.Y(jSONObject);
            cVar.aOo = f.U(jSONObject);
            cVar.aOp = b.Q(jSONObject);
            cVar.aOq = b.a.N(jSONObject);
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
            str = gm(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (aOs.containsKey(str)) {
                return aOs.get(str).intValue();
            }
            return -1;
        }
    }

    public static String gm(String str) {
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

    public String DL() {
        if (Jq()) {
            return this.aOo.aOD.get(0).aOE;
        }
        if (Jo()) {
            return this.aOk.mPages.get(0);
        }
        return "";
    }

    public boolean Jo() {
        return (this.aOk == null || this.aOk.mPages == null || this.aOk.mPages.isEmpty()) ? false : true;
    }

    public boolean Jp() {
        return (this.aOl == null || this.aOl.aOx == null || this.aOl.aOz == null) ? false : true;
    }

    public boolean Jq() {
        return this.aOo != null && this.aOo.Jx();
    }

    public boolean gn(String str) {
        return (Jo() && this.aOk.gp(str)) || (Jp() && this.aOl.aOz.containsKey(str));
    }

    public boolean go(String str) {
        return this.aOo != null && this.aOo.gq(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a O(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jr();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return Jr();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean gp(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a Jr() {
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
        public int aOB;
        public int aOC;
        public ArrayList<g> aOD;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f U(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return Jy();
            }
            f fVar = new f();
            fVar.mColor = c.parseColor(optJSONObject.optString("color", "#999999"));
            fVar.aOB = c.parseColor(optJSONObject.optString("selectedColor", "black"));
            fVar.aOC = c.parseColor(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.parseColor(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aOD = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aOD.add(g.W(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean Jx() {
            return this.aOD != null && this.aOD.size() >= 2;
        }

        public boolean gq(String str) {
            if (this.aOD == null) {
                return false;
            }
            for (int i = 0; i < this.aOD.size(); i++) {
                if (TextUtils.equals(this.aOD.get(i).aOE, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f Jy() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.aOD = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aOt;

        /* JADX INFO: Access modifiers changed from: private */
        public static b Q(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jt();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return Jt();
            }
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            String str = "";
            if (IV != null) {
                str = IV.id;
            }
            b bVar = new b();
            bVar.aOt = optJSONObject.optBoolean("urlCheck", true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.af.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.af.a.c.g(str, optJSONObject3);
                }
            }
            return bVar;
        }

        public static boolean Js() {
            c DI = com.baidu.swan.apps.w.e.Ea().DI();
            if (DI == null) {
                return true;
            }
            b bVar = DI.aOp;
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (IV != null) {
                bVar2 = IV.uA();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean wO = com.baidu.swan.apps.console.a.d.wO();
            boolean vw = com.baidu.swan.apps.core.a.vw();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + wO + " isMobileDebug: " + vw + " urlCheck: " + bVar.aOt);
            }
            return (b || wO || vw) && !bVar.aOt;
        }

        private static b Jt() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aOt = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aOE;
        public String aOF;
        public String aOG;
        public String alO;

        /* JADX INFO: Access modifiers changed from: private */
        public static g W(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jz();
            }
            g gVar = new g();
            gVar.aOE = jSONObject.optString("pagePath");
            gVar.aOF = jSONObject.optString("iconPath");
            gVar.aOG = jSONObject.optString("selectedIconPath");
            gVar.alO = jSONObject.optString("text");
            return gVar;
        }

        private static g Jz() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0109c> aOx;
        public HashMap<String, Boolean> aOy;
        public HashMap<String, String> aOz;

        /* JADX INFO: Access modifiers changed from: private */
        public static d S(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jv();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return Jv();
            }
            d dVar = new d();
            dVar.aOx = new ArrayList();
            dVar.aOz = new HashMap<>();
            dVar.aOy = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aOx.add(C0109c.a(optJSONObject, dVar.aOz));
                }
            }
            return dVar;
        }

        private static d Jv() {
            d dVar = new d();
            dVar.aOx = new ArrayList();
            dVar.aOz = new HashMap<>();
            dVar.aOy = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0109c {
        private static final String aOw = File.separator;
        public String aOu;
        public List<String> aOv;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0109c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return Ju();
            }
            C0109c c0109c = new C0109c();
            c0109c.aOu = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0109c.aOv = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0109c.aOv.add(optString);
                    if (!TextUtils.isEmpty(c0109c.aOu) && !TextUtils.isEmpty(optString)) {
                        if (c0109c.aOu.endsWith(aOw) || optString.startsWith(aOw)) {
                            str = c0109c.aOu + optString;
                        } else {
                            str = c0109c.aOu + aOw + optString;
                        }
                        hashMap.put(str, c0109c.aOu);
                    }
                }
            }
            return c0109c;
        }

        private static C0109c Ju() {
            C0109c c0109c = new C0109c();
            c0109c.aOv = new ArrayList();
            return c0109c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aOA;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aOx == null || dVar.aOx.size() <= 0) {
                return Jw();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return Jw();
            }
            e eVar = new e();
            eVar.aOA = new HashMap<>();
            for (C0109c c0109c : dVar.aOx) {
                if (c0109c != null && !TextUtils.isEmpty(c0109c.aOu)) {
                    eVar.aOA.put(c0109c.aOu, optJSONObject.optString(c0109c.aOu));
                }
            }
            return eVar;
        }

        private static e Jw() {
            e eVar = new e();
            eVar.aOA = new HashMap<>();
            return eVar;
        }
    }
}
