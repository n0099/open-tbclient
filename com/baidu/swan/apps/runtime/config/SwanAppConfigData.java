package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.runtime.config.b;
import com.baidu.swan.apps.x.b.b;
import com.baidu.webkit.internal.CfgFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> bKY = new HashMap<>();
    public a bKM;
    public e bKN;
    public f bKO;
    public com.baidu.swan.apps.runtime.config.c bKP;
    public g bKQ;
    public c bKR;
    public b.a bKS;
    public b bKT;
    public b bKU;
    public List<com.baidu.swan.pms.model.h> bKV;
    public String bKW;
    @NonNull
    public Set<RequiredBackgroundModeItem> bKX = new HashSet(1);
    public boolean mIsDebug;

    static {
        bKY.put("light", -1);
        bKY.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.bKW = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.bKU = b.a(jSONObject, file);
            swanAppConfigData.bKT = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.bKV = com.baidu.swan.apps.ag.g.b.x(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.bKM = a.az(jSONObject);
            swanAppConfigData.bKN = e.e(jSONObject, file);
            swanAppConfigData.bKO = f.a(jSONObject, swanAppConfigData.bKN);
            swanAppConfigData.bKP = com.baidu.swan.apps.runtime.config.c.aH(jSONObject);
            swanAppConfigData.bKQ = g.aD(jSONObject);
            swanAppConfigData.bKR = c.aB(jSONObject);
            swanAppConfigData.bKS = b.a.ay(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.bKX.add(find);
                    }
                }
            }
            a(swanAppConfigData, jSONObject, file);
            return swanAppConfigData;
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e("SwanAppConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }

    private static void a(@NonNull SwanAppConfigData swanAppConfigData, @NonNull JSONObject jSONObject, @NonNull File file) {
        File file2 = new File(file, com.baidu.swan.apps.w.a.RV().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.bKP = com.baidu.swan.apps.runtime.config.c.aH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.bKQ = g.aD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.bKW = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int cy(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = kG(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (bKY.containsKey(str)) {
                return bKY.get(str).intValue();
            }
            return -1;
        }
    }

    public static String kG(String str) {
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

    public String TP() {
        return aaE() ? this.bKM.mPages.get(0) : "";
    }

    public String kH(String str) {
        if (this.bKN == null || this.bKN.bLh == null) {
            return null;
        }
        for (d dVar : this.bKN.bLh) {
            if (TextUtils.equals(dVar.bLb, str)) {
                return dVar.TP();
            }
        }
        return null;
    }

    public boolean aaE() {
        return (this.bKM == null || this.bKM.mPages == null || this.bKM.mPages.isEmpty()) ? false : true;
    }

    public boolean aaF() {
        return (this.bKN == null || this.bKN.bLh == null || this.bKN.bLj == null) ? false : true;
    }

    private boolean aaG() {
        return (this.bKN == null || this.bKN.bLh == null || this.bKN.bLk == null) ? false : true;
    }

    public boolean kI(String str) {
        return aaF() && this.bKN.bLj.containsKey(str);
    }

    public boolean kJ(String str) {
        return aaG() && this.bKN.bLk.containsKey(str);
    }

    public String kA(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !kI(delAllParamsFromUrl)) {
            return "main";
        }
        if (!kJ(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aaH() {
        return this.bKQ != null && this.bKQ.aaO();
    }

    public boolean kK(String str) {
        return (aaE() && this.bKM.kM(str)) || (aaF() && this.bKN.bLj.containsKey(str));
    }

    public boolean kL(String str) {
        return this.bKQ != null && this.bKQ.kN(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> fU(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.bKU, arrayList);
            if (this.bKN != null && (list2 = this.bKN.bLh) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.bLf, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.bKT, arrayList2);
            if (this.bKN != null && (list = this.bKN.bLh) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.bLg, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(b bVar, List<com.baidu.swan.apps.ag.f.a> list) {
        List<com.baidu.swan.apps.ag.f.a> list2;
        if (bVar != null && list != null && (list2 = bVar.bKZ) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a az(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aaI();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aaI();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean kM(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aaI() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes9.dex */
    public enum RequiredBackgroundModeItem {
        AUDIO("audio");
        
        private String mMode;

        RequiredBackgroundModeItem(String str) {
            this.mMode = str;
        }

        @Nullable
        public static RequiredBackgroundModeItem find(String str) {
            RequiredBackgroundModeItem[] values;
            if (str != null) {
                for (RequiredBackgroundModeItem requiredBackgroundModeItem : values()) {
                    if (str.equals(requiredBackgroundModeItem.mMode)) {
                        return requiredBackgroundModeItem;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public int bLm;
        public int bLn;
        public ArrayList<h> bLo;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aaP();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aaP();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.cy(optJSONObject.optString("color", "#999999"));
            gVar.bLm = SwanAppConfigData.cy(optJSONObject.optString("selectedColor", "black"));
            gVar.bLn = SwanAppConfigData.cy(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.cy(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.bLo = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.bLo.add(h.aF(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean aaO() {
            return this.bLo != null && this.bLo.size() >= 2;
        }

        public boolean kN(String str) {
            if (this.bLo == null) {
                return false;
            }
            for (int i = 0; i < this.bLo.size(); i++) {
                if (TextUtils.equals(this.bLo.get(i).bLp, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g aaP() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.bLo = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public boolean bLa;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aaK();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aaK();
            }
            com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
            String str = "";
            if (ZS != null) {
                str = ZS.id;
            }
            c cVar = new c();
            cVar.bLa = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.aj.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.aj.a.c.f(str, optJSONObject3);
                }
            }
            return cVar;
        }

        public static boolean aaJ() {
            SwanAppConfigData TL = com.baidu.swan.apps.y.f.Uf().TL();
            if (TL == null) {
                return true;
            }
            c cVar = TL.bKR;
            com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
            b.a aVar = null;
            if (ZS != null) {
                aVar = ZS.DR();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean Jc = com.baidu.swan.apps.console.debugger.a.e.Jc();
            boolean Fi = com.baidu.swan.apps.core.a.Fi();
            boolean XQ = com.baidu.swan.apps.ah.a.a.XQ();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Jc + " isMobileDebug: " + Fi + " urlCheck: " + cVar.bLa);
            }
            return (b || Jc || Fi || XQ) && !cVar.bLa;
        }

        private static c aaK() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.bLa = true;
            return cVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public String bLp;
        public String bLq;
        public String bLr;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aaQ();
            }
            h hVar = new h();
            hVar.bLp = jSONObject.optString("pagePath");
            hVar.bLq = jSONObject.optString("iconPath");
            hVar.bLr = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h aaQ() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public List<d> bLh;
        public HashMap<String, Boolean> bLi;
        public HashMap<String, String> bLj;
        public HashMap<String, String> bLk;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aaM();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aaM();
            }
            e eVar = new e();
            eVar.bLh = new ArrayList();
            eVar.bLj = new HashMap<>();
            eVar.bLi = new HashMap<>();
            eVar.bLk = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.bLh.add(d.a(optJSONObject, eVar.bLj, eVar.bLk, file));
                }
            }
            return eVar;
        }

        private static e aaM() {
            e eVar = new e();
            eVar.bLh = new ArrayList();
            eVar.bLj = new HashMap<>();
            eVar.bLi = new HashMap<>();
            eVar.bLk = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        private static final String bLe = File.separator;
        public String bLb;
        public List<String> bLc;
        boolean bLd = false;
        public b bLf;
        public b bLg;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aaL();
            }
            d dVar = new d();
            dVar.bLb = jSONObject.optString("root");
            dVar.bLd = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.bLc = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.bLc.add(optString);
                    if (!TextUtils.isEmpty(dVar.bLb) && !TextUtils.isEmpty(optString)) {
                        if (dVar.bLb.endsWith(bLe) || optString.startsWith(bLe)) {
                            str = dVar.bLb + optString;
                        } else {
                            str = dVar.bLb + bLe + optString;
                        }
                        hashMap.put(str, dVar.bLb);
                        if (dVar.bLd) {
                            hashMap2.put(str, dVar.bLb);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d aaL() {
            d dVar = new d();
            dVar.bLc = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String TP() {
            if (TextUtils.isEmpty(this.bLb) || this.bLc == null || this.bLc.size() <= 0) {
                return null;
            }
            String str = this.bLc.get(0);
            if (this.bLb.endsWith(bLe)) {
                this.bLb = this.bLb.substring(0, this.bLb.length() - 1);
            }
            if (str.startsWith(bLe)) {
                str = str.substring(1);
            }
            return this.bLb + bLe + str;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public HashMap<String, String> bLl;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.bLh == null || eVar.bLh.size() <= 0) {
                return aaN();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aaN();
            }
            f fVar = new f();
            fVar.bLl = new HashMap<>();
            for (d dVar : eVar.bLh) {
                if (dVar != null && !TextUtils.isEmpty(dVar.bLb)) {
                    fVar.bLl.put(dVar.bLb, optJSONObject.optString(dVar.bLb));
                }
            }
            return fVar;
        }

        private static f aaN() {
            f fVar = new f();
            fVar.bLl = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> bKZ;

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(JSONObject jSONObject, File file) {
            return a(jSONObject, "dynamicLib", 3, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(JSONObject jSONObject, File file) {
            return a(jSONObject, "plugins", 4, file);
        }

        private static b a(JSONObject jSONObject, String str, int i, File file) {
            JSONObject optJSONObject;
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            b bVar = new b();
            bVar.bKZ = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.bDT = next;
                if (file != null && !TextUtils.isEmpty(aVar.bDW)) {
                    aVar.bDW = new File(file, aVar.bDW).getAbsolutePath();
                }
                bVar.bKZ.add(aVar);
            }
            return bVar;
        }
    }
}
