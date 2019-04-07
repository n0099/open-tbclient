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
    private static final HashMap<String, Integer> aOr = new HashMap<>();
    public a aOj;
    public d aOk;
    public e aOl;
    public com.baidu.swan.apps.ae.a.d aOm;
    public f aOn;
    public b aOo;
    public b.a aOp;
    public String aOq;
    public boolean axV;

    static {
        aOr.put("light", -1);
        aOr.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aOq = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.axV = jSONObject.optBoolean("debug");
            cVar.aOj = a.O(jSONObject);
            cVar.aOk = d.S(jSONObject);
            cVar.aOl = e.a(jSONObject, cVar.aOk);
            cVar.aOm = com.baidu.swan.apps.ae.a.d.Y(jSONObject);
            cVar.aOn = f.U(jSONObject);
            cVar.aOo = b.Q(jSONObject);
            cVar.aOp = b.a.N(jSONObject);
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
            if (aOr.containsKey(str)) {
                return aOr.get(str).intValue();
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
            return this.aOn.aOC.get(0).aOD;
        }
        if (Jo()) {
            return this.aOj.mPages.get(0);
        }
        return "";
    }

    public boolean Jo() {
        return (this.aOj == null || this.aOj.mPages == null || this.aOj.mPages.isEmpty()) ? false : true;
    }

    public boolean Jp() {
        return (this.aOk == null || this.aOk.aOw == null || this.aOk.aOy == null) ? false : true;
    }

    public boolean Jq() {
        return this.aOn != null && this.aOn.Jx();
    }

    public boolean gn(String str) {
        return (Jo() && this.aOj.gp(str)) || (Jp() && this.aOk.aOy.containsKey(str));
    }

    public boolean go(String str) {
        return this.aOn != null && this.aOn.gq(str);
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
        public int aOA;
        public int aOB;
        public ArrayList<g> aOC;
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
            fVar.aOA = c.parseColor(optJSONObject.optString("selectedColor", "black"));
            fVar.aOB = c.parseColor(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.parseColor(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aOC = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aOC.add(g.W(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean Jx() {
            return this.aOC != null && this.aOC.size() >= 2;
        }

        public boolean gq(String str) {
            if (this.aOC == null) {
                return false;
            }
            for (int i = 0; i < this.aOC.size(); i++) {
                if (TextUtils.equals(this.aOC.get(i).aOD, str)) {
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
            fVar.aOC = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aOs;

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
            bVar.aOs = optJSONObject.optBoolean("urlCheck", true);
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
            b bVar = DI.aOo;
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (IV != null) {
                bVar2 = IV.uA();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean wO = com.baidu.swan.apps.console.a.d.wO();
            boolean vw = com.baidu.swan.apps.core.a.vw();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + wO + " isMobileDebug: " + vw + " urlCheck: " + bVar.aOs);
            }
            return (b || wO || vw) && !bVar.aOs;
        }

        private static b Jt() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aOs = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aOD;
        public String aOE;
        public String aOF;
        public String alN;

        /* JADX INFO: Access modifiers changed from: private */
        public static g W(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jz();
            }
            g gVar = new g();
            gVar.aOD = jSONObject.optString("pagePath");
            gVar.aOE = jSONObject.optString("iconPath");
            gVar.aOF = jSONObject.optString("selectedIconPath");
            gVar.alN = jSONObject.optString("text");
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
        public List<C0109c> aOw;
        public HashMap<String, Boolean> aOx;
        public HashMap<String, String> aOy;

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
            dVar.aOw = new ArrayList();
            dVar.aOy = new HashMap<>();
            dVar.aOx = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aOw.add(C0109c.a(optJSONObject, dVar.aOy));
                }
            }
            return dVar;
        }

        private static d Jv() {
            d dVar = new d();
            dVar.aOw = new ArrayList();
            dVar.aOy = new HashMap<>();
            dVar.aOx = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0109c {
        private static final String aOv = File.separator;
        public String aOt;
        public List<String> aOu;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0109c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return Ju();
            }
            C0109c c0109c = new C0109c();
            c0109c.aOt = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0109c.aOu = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0109c.aOu.add(optString);
                    if (!TextUtils.isEmpty(c0109c.aOt) && !TextUtils.isEmpty(optString)) {
                        if (c0109c.aOt.endsWith(aOv) || optString.startsWith(aOv)) {
                            str = c0109c.aOt + optString;
                        } else {
                            str = c0109c.aOt + aOv + optString;
                        }
                        hashMap.put(str, c0109c.aOt);
                    }
                }
            }
            return c0109c;
        }

        private static C0109c Ju() {
            C0109c c0109c = new C0109c();
            c0109c.aOu = new ArrayList();
            return c0109c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aOz;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aOw == null || dVar.aOw.size() <= 0) {
                return Jw();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return Jw();
            }
            e eVar = new e();
            eVar.aOz = new HashMap<>();
            for (C0109c c0109c : dVar.aOw) {
                if (c0109c != null && !TextUtils.isEmpty(c0109c.aOt)) {
                    eVar.aOz.put(c0109c.aOt, optJSONObject.optString(c0109c.aOt));
                }
            }
            return eVar;
        }

        private static e Jw() {
            e eVar = new e();
            eVar.aOz = new HashMap<>();
            return eVar;
        }
    }
}
