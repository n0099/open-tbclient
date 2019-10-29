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
    private static final HashMap<String, Integer> bkH = new HashMap<>();
    public boolean aTf;
    public d bkA;
    public e bkB;
    public com.baidu.swan.apps.ae.a.d bkC;
    public f bkD;
    public b bkE;
    public b.a bkF;
    public String bkG;
    public a bkz;

    static {
        bkH.put("light", -1);
        bkH.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    public static c hs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        cVar.bkG = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.aTf = jSONObject.optBoolean("debug");
            cVar.bkz = a.al(jSONObject);
            cVar.bkA = d.ap(jSONObject);
            cVar.bkB = e.a(jSONObject, cVar.bkA);
            cVar.bkC = com.baidu.swan.apps.ae.a.d.av(jSONObject);
            cVar.bkD = f.ar(jSONObject);
            cVar.bkE = b.an(jSONObject);
            cVar.bkF = b.a.ak(jSONObject);
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
            if (bkH.containsKey(str)) {
                return bkH.get(str).intValue();
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

    public String Lo() {
        if (Rv()) {
            return this.bkD.bkS.get(0).bkT;
        }
        if (Rt()) {
            return this.bkz.mPages.get(0);
        }
        return "";
    }

    public boolean Rt() {
        return (this.bkz == null || this.bkz.mPages == null || this.bkz.mPages.isEmpty()) ? false : true;
    }

    public boolean Ru() {
        return (this.bkA == null || this.bkA.bkM == null || this.bkA.bkO == null) ? false : true;
    }

    public boolean Rv() {
        return this.bkD != null && this.bkD.RC();
    }

    public boolean hu(String str) {
        return (Rt() && this.bkz.hw(str)) || (Ru() && this.bkA.bkO.containsKey(str));
    }

    public boolean hv(String str) {
        return this.bkD != null && this.bkD.hx(str);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a al(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Rw();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return Rw();
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

        private static a Rw() {
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
        public int bkQ;
        public int bkR;
        public ArrayList<g> bkS;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static f ar(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RD();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return RD();
            }
            f fVar = new f();
            fVar.mColor = c.bR(optJSONObject.optString("color", "#999999"));
            fVar.bkQ = c.bR(optJSONObject.optString("selectedColor", "black"));
            fVar.bkR = c.bR(optJSONObject.optString("borderStyle", "black"));
            fVar.mBackgroundColor = c.bR(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            int length = optJSONArray.length();
            if (length > 5) {
                length = 5;
            }
            if (optJSONArray != null && length > 0) {
                fVar.bkS = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    fVar.bkS.add(g.at(optJSONArray.optJSONObject(i)));
                }
                return fVar;
            }
            return fVar;
        }

        public boolean RC() {
            return this.bkS != null && this.bkS.size() >= 2;
        }

        public boolean hx(String str) {
            if (this.bkS == null) {
                return false;
            }
            for (int i = 0; i < this.bkS.size(); i++) {
                if (TextUtils.equals(this.bkS.get(i).bkT, str)) {
                    return true;
                }
            }
            return false;
        }

        private static f RD() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.bkS = new ArrayList<>();
            return fVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public boolean bkI;

        /* JADX INFO: Access modifiers changed from: private */
        public static b an(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Ry();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return Ry();
            }
            com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
            String str = "";
            if (QZ != null) {
                str = QZ.id;
            }
            b bVar = new b();
            bVar.bkI = optJSONObject.optBoolean("urlCheck", true);
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

        public static boolean Rx() {
            c Ll = com.baidu.swan.apps.w.e.LD().Ll();
            if (Ll == null) {
                return true;
            }
            b bVar = Ll.bkE;
            com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
            com.baidu.swan.apps.v.b.b bVar2 = null;
            if (QZ != null) {
                bVar2 = QZ.AJ();
            }
            boolean b = com.baidu.swan.apps.f.a.b(bVar2);
            boolean Dk = com.baidu.swan.apps.console.a.d.Dk();
            boolean BK = com.baidu.swan.apps.core.a.BK();
            if (c.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Dk + " isMobileDebug: " + BK + " urlCheck: " + bVar.bkI);
            }
            return (b || Dk || BK) && !bVar.bkI;
        }

        private static b Ry() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            b bVar = new b();
            bVar.bkI = true;
            return bVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public String bkT;
        public String bkU;
        public String bkV;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static g at(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RE();
            }
            g gVar = new g();
            gVar.bkT = jSONObject.optString("pagePath");
            gVar.bkU = jSONObject.optString("iconPath");
            gVar.bkV = jSONObject.optString("selectedIconPath");
            gVar.mText = jSONObject.optString("text");
            return gVar;
        }

        private static g RE() {
            if (c.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public List<C0153c> bkM;
        public HashMap<String, Boolean> bkN;
        public HashMap<String, String> bkO;

        /* JADX INFO: Access modifiers changed from: private */
        public static d ap(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RA();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return RA();
            }
            d dVar = new d();
            dVar.bkM = new ArrayList();
            dVar.bkO = new HashMap<>();
            dVar.bkN = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    dVar.bkM.add(C0153c.a(optJSONObject, dVar.bkO));
                }
            }
            return dVar;
        }

        private static d RA() {
            d dVar = new d();
            dVar.bkM = new ArrayList();
            dVar.bkO = new HashMap<>();
            dVar.bkN = new HashMap<>();
            return dVar;
        }
    }

    /* renamed from: com.baidu.swan.apps.ae.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0153c {
        private static final String bkL = File.separator;
        public String bkJ;
        public List<String> bkK;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0153c a(JSONObject jSONObject, HashMap<String, String> hashMap) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return Rz();
            }
            C0153c c0153c = new C0153c();
            c0153c.bkJ = jSONObject.optString("root");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                c0153c.bkK = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    c0153c.bkK.add(optString);
                    if (!TextUtils.isEmpty(c0153c.bkJ) && !TextUtils.isEmpty(optString)) {
                        if (c0153c.bkJ.endsWith(bkL) || optString.startsWith(bkL)) {
                            str = c0153c.bkJ + optString;
                        } else {
                            str = c0153c.bkJ + bkL + optString;
                        }
                        hashMap.put(str, c0153c.bkJ);
                    }
                }
            }
            return c0153c;
        }

        private static C0153c Rz() {
            C0153c c0153c = new C0153c();
            c0153c.bkK = new ArrayList();
            return c0153c;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public HashMap<String, String> bkP;

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(JSONObject jSONObject, d dVar) {
            if (jSONObject == null || dVar == null || dVar.bkM == null || dVar.bkM.size() <= 0) {
                return RB();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return RB();
            }
            e eVar = new e();
            eVar.bkP = new HashMap<>();
            for (C0153c c0153c : dVar.bkM) {
                if (c0153c != null && !TextUtils.isEmpty(c0153c.bkJ)) {
                    eVar.bkP.put(c0153c.bkJ, optJSONObject.optString(c0153c.bkJ));
                }
            }
            return eVar;
        }

        private static e RB() {
            e eVar = new e();
            eVar.bkP = new HashMap<>();
            return eVar;
        }
    }
}
