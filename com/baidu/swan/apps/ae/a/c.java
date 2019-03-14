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
    private static final HashMap<String, Integer> aOo = new HashMap<>();
    public a aOg;
    public d aOh;
    public e aOi;
    public com.baidu.swan.apps.ae.a.d aOj;
    public f aOk;
    public b aOl;
    public b.a aOm;
    public String aOn;
    public boolean axS;

    static {
        aOo.put("light", -1);
        aOo.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c gk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.aOn = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.axS = jSONObject.optBoolean("debug");
            cVar.aOg = a.O(jSONObject);
            cVar.aOh = d.S(jSONObject);
            cVar.aOi = e.a(jSONObject, cVar.aOh);
            cVar.aOj = com.baidu.swan.apps.ae.a.d.Y(jSONObject);
            cVar.aOk = f.U(jSONObject);
            cVar.aOl = b.Q(jSONObject);
            cVar.aOm = b.a.N(jSONObject);
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
            if (aOo.containsKey(str)) {
                return aOo.get(str).intValue();
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
            return this.aOk.aOz.get(0).aOA;
        }
        if (Jq()) {
            return this.aOg.mPages.get(0);
        }
        return "";
    }

    public boolean Jq() {
        return (this.aOg == null || this.aOg.mPages == null || this.aOg.mPages.isEmpty()) ? false : true;
    }

    public boolean Jr() {
        return (this.aOh == null || this.aOh.aOt == null || this.aOh.aOv == null) ? false : true;
    }

    public boolean Js() {
        return this.aOk != null && this.aOk.Jz();
    }

    public boolean gm(String str) {
        return (Jq() && this.aOg.go(str)) || (Jr() && this.aOh.aOv.containsKey(str));
    }

    public boolean gn(String str) {
        return this.aOk != null && this.aOk.gp(str);
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
        public int aOx;
        public int aOy;
        public ArrayList<g> aOz;
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
            fVar.aOx = c.parseColor(optJSONObject.optString("selectedColor", "black"));
            fVar.aOy = c.parseColor(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.parseColor(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray(IntentConfig.LIST);
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.aOz = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.aOz.add(g.W(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean Jz() {
            return this.aOz != null && this.aOz.size() >= 2;
        }

        public boolean gp(String str) {
            if (this.aOz == null) {
                return false;
            }
            for (int i = 0; i < this.aOz.size(); i++) {
                if (TextUtils.equals(this.aOz.get(i).aOA, str)) {
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
            fVar.aOz = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean aOp;

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
            bVar.aOp = optJSONObject.optBoolean("urlCheck", true);
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
            b bVar = DK.aOl;
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (IX != null) {
                bVar2 = IX.uB();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean wP = com.baidu.swan.apps.console.a.d.wP();
            boolean vx = com.baidu.swan.apps.core.a.vx();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + wP + " isMobileDebug: " + vx + " urlCheck: " + bVar.aOp);
            }
            return (b || wP || vx) && !bVar.aOp;
        }

        private static b Jv() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.aOp = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String aOA;
        public String aOB;
        public String aOC;
        public String alJ;

        /* JADX INFO: Access modifiers changed from: private */
        public static g W(JSONObject jSONObject) {
            if (jSONObject == null) {
                return JB();
            }
            g gVar = new g();
            gVar.aOA = jSONObject.optString("pagePath");
            gVar.aOB = jSONObject.optString("iconPath");
            gVar.aOC = jSONObject.optString("selectedIconPath");
            gVar.alJ = jSONObject.optString("text");
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
        public List<C0109c> aOt;
        public HashMap<String, Boolean> aOu;
        public HashMap<String, String> aOv;

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
            dVar.aOt = new ArrayList();
            dVar.aOv = new HashMap<>();
            dVar.aOu = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.aOt.add(C0109c.a(optJSONObject, dVar.aOv));
                }
            }
            return dVar;
        }

        private static d Jx() {
            d dVar = new d();
            dVar.aOt = new ArrayList();
            dVar.aOv = new HashMap<>();
            dVar.aOu = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0109c {
        private static final String aOs = File.separator;
        public String aOq;
        public List<String> aOr;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0109c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return Jw();
            }
            C0109c c0109c = new C0109c();
            c0109c.aOq = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0109c.aOr = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0109c.aOr.add(optString);
                    if (!TextUtils.isEmpty(c0109c.aOq) && !TextUtils.isEmpty(optString)) {
                        if (c0109c.aOq.endsWith(aOs) || optString.startsWith(aOs)) {
                            str = c0109c.aOq + optString;
                        } else {
                            str = c0109c.aOq + aOs + optString;
                        }
                        hashMap.put(str, c0109c.aOq);
                    }
                }
            }
            return c0109c;
        }

        private static C0109c Jw() {
            C0109c c0109c = new C0109c();
            c0109c.aOr = new ArrayList();
            return c0109c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> aOw;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.aOt == null || dVar.aOt.size() <= 0) {
                return Jy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return Jy();
            }
            e eVar = new e();
            eVar.aOw = new HashMap<>();
            for (C0109c c0109c : dVar.aOt) {
                if (c0109c != null && !TextUtils.isEmpty(c0109c.aOq)) {
                    eVar.aOw.put(c0109c.aOq, optJSONObject.optString(c0109c.aOq));
                }
            }
            return eVar;
        }

        private static e Jy() {
            e eVar = new e();
            eVar.aOw = new HashMap<>();
            return eVar;
        }
    }
}
