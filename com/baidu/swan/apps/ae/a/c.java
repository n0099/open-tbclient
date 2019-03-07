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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final HashMap<String, Integer> aOn = new HashMap<>();
    public a aOf;
    public d aOg;
    public e aOh;
    public com.baidu.swan.apps.ae.a.d aOi;
    public f aOj;
    public b aOk;
    public b.a aOl;
    public String aOm;
    public boolean axR;

    static {
        aOn.put("light", -1);
        aOn.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aOm = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.axR = jSONObject.optBoolean("debug");
            cVar.aOf = a.O(jSONObject);
            cVar.aOg = d.S(jSONObject);
            cVar.aOh = e.a(jSONObject, cVar.aOg);
            cVar.aOi = com.baidu.swan.apps.ae.a.d.Y(jSONObject);
            cVar.aOj = f.U(jSONObject);
            cVar.aOk = b.Q(jSONObject);
            cVar.aOl = b.a.N(jSONObject);
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
            str = gl(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (aOn.containsKey(str)) {
                return aOn.get(str).intValue();
            }
            return -1;
        }
    }

    public static String gl(String str) {
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

    public String DN() {
        if (Js()) {
            return this.aOj.aOy.get(0).aOz;
        }
        if (Jq()) {
            return this.aOf.mPages.get(0);
        }
        return "";
    }

    public boolean Jq() {
        return (this.aOf == null || this.aOf.mPages == null || this.aOf.mPages.isEmpty()) ? false : true;
    }

    public boolean Jr() {
        return (this.aOg == null || this.aOg.aOs == null || this.aOg.aOu == null) ? false : true;
    }

    public boolean Js() {
        return this.aOj != null && this.aOj.Jz();
    }

    public boolean gm(String str) {
        return (Jq() && this.aOf.go(str)) || (Jr() && this.aOg.aOu.containsKey(str));
    }

    public boolean gn(String str) {
        return this.aOj != null && this.aOj.gp(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a O(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jt();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return Jt();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean go(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a Jt() {
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
        public int aOw;
        public int aOx;
        public ArrayList<g> aOy;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f U(JSONObject jSONObject) {
            if (jSONObject == null) {
                return JA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return JA();
            }
            f fVar = new f();
            fVar.mColor = c.parseColor(optJSONObject.optString("color", "#999999"));
            fVar.aOw = c.parseColor(optJSONObject.optString("selectedColor", "black"));
            fVar.aOx = c.parseColor(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.parseColor(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aOy = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aOy.add(g.W(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean Jz() {
            return this.aOy != null && this.aOy.size() >= 2;
        }

        public boolean gp(String str) {
            if (this.aOy == null) {
                return false;
            }
            for (int i = 0; i < this.aOy.size(); i++) {
                if (TextUtils.equals(this.aOy.get(i).aOz, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f JA() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.aOy = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aOo;

        /* JADX INFO: Access modifiers changed from: private */
        public static b Q(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jv();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return Jv();
            }
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            String str = "";
            if (IX != null) {
                str = IX.id;
            }
            b bVar = new b();
            bVar.aOo = optJSONObject.optBoolean("urlCheck", true);
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

        public static boolean Ju() {
            c DK = com.baidu.swan.apps.w.e.Ec().DK();
            if (DK == null) {
                return true;
            }
            b bVar = DK.aOk;
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (IX != null) {
                bVar2 = IX.uB();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean wP = com.baidu.swan.apps.console.a.d.wP();
            boolean vx = com.baidu.swan.apps.core.a.vx();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + wP + " isMobileDebug: " + vx + " urlCheck: " + bVar.aOo);
            }
            return (b || wP || vx) && !bVar.aOo;
        }

        private static b Jv() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aOo = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aOA;
        public String aOB;
        public String aOz;
        public String alI;

        /* JADX INFO: Access modifiers changed from: private */
        public static g W(JSONObject jSONObject) {
            if (jSONObject == null) {
                return JB();
            }
            g gVar = new g();
            gVar.aOz = jSONObject.optString("pagePath");
            gVar.aOA = jSONObject.optString("iconPath");
            gVar.aOB = jSONObject.optString("selectedIconPath");
            gVar.alI = jSONObject.optString("text");
            return gVar;
        }

        private static g JB() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0079c> aOs;
        public HashMap<String, Boolean> aOt;
        public HashMap<String, String> aOu;

        /* JADX INFO: Access modifiers changed from: private */
        public static d S(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jx();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return Jx();
            }
            d dVar = new d();
            dVar.aOs = new ArrayList();
            dVar.aOu = new HashMap<>();
            dVar.aOt = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aOs.add(C0079c.a(optJSONObject, dVar.aOu));
                }
            }
            return dVar;
        }

        private static d Jx() {
            d dVar = new d();
            dVar.aOs = new ArrayList();
            dVar.aOu = new HashMap<>();
            dVar.aOt = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0079c {
        private static final String aOr = File.separator;
        public String aOp;
        public List<String> aOq;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0079c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return Jw();
            }
            C0079c c0079c = new C0079c();
            c0079c.aOp = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0079c.aOq = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0079c.aOq.add(optString);
                    if (!TextUtils.isEmpty(c0079c.aOp) && !TextUtils.isEmpty(optString)) {
                        if (c0079c.aOp.endsWith(aOr) || optString.startsWith(aOr)) {
                            str = c0079c.aOp + optString;
                        } else {
                            str = c0079c.aOp + aOr + optString;
                        }
                        hashMap.put(str, c0079c.aOp);
                    }
                }
            }
            return c0079c;
        }

        private static C0079c Jw() {
            C0079c c0079c = new C0079c();
            c0079c.aOq = new ArrayList();
            return c0079c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aOv;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aOs == null || dVar.aOs.size() <= 0) {
                return Jy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return Jy();
            }
            e eVar = new e();
            eVar.aOv = new HashMap<>();
            for (C0079c c0079c : dVar.aOs) {
                if (c0079c != null && !TextUtils.isEmpty(c0079c.aOp)) {
                    eVar.aOv.put(c0079c.aOp, optJSONObject.optString(c0079c.aOp));
                }
            }
            return eVar;
        }

        private static e Jy() {
            e eVar = new e();
            eVar.aOv = new HashMap<>();
            return eVar;
        }
    }
}
