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
/* loaded from: classes11.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> bPP = new HashMap<>();
    public a bPD;
    public e bPE;
    public f bPF;
    public com.baidu.swan.apps.runtime.config.c bPG;
    public g bPH;
    public c bPI;
    public b.a bPJ;
    public b bPK;
    public b bPL;
    public List<com.baidu.swan.pms.model.h> bPM;
    public String bPN;
    @NonNull
    public Set<RequiredBackgroundModeItem> bPO = new HashSet(1);
    public boolean mIsDebug;

    static {
        bPP.put("light", -1);
        bPP.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.bPN = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.bPL = b.a(jSONObject, file);
            swanAppConfigData.bPK = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.bPM = com.baidu.swan.apps.ag.g.b.x(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.bPD = a.az(jSONObject);
            swanAppConfigData.bPE = e.e(jSONObject, file);
            swanAppConfigData.bPF = f.a(jSONObject, swanAppConfigData.bPE);
            swanAppConfigData.bPG = com.baidu.swan.apps.runtime.config.c.aH(jSONObject);
            swanAppConfigData.bPH = g.aD(jSONObject);
            swanAppConfigData.bPI = c.aB(jSONObject);
            swanAppConfigData.bPJ = b.a.ay(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.bPO.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.UH().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.bPG = com.baidu.swan.apps.runtime.config.c.aH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.bPH = g.aD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.bPN = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = kY(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (bPP.containsKey(str)) {
                return bPP.get(str).intValue();
            }
            return -1;
        }
    }

    public static String kY(String str) {
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

    public String WC() {
        return adr() ? this.bPD.mPages.get(0) : "";
    }

    public String kZ(String str) {
        if (this.bPE == null || this.bPE.bPY == null) {
            return null;
        }
        for (d dVar : this.bPE.bPY) {
            if (TextUtils.equals(dVar.bPS, str)) {
                return dVar.WC();
            }
        }
        return null;
    }

    public boolean adr() {
        return (this.bPD == null || this.bPD.mPages == null || this.bPD.mPages.isEmpty()) ? false : true;
    }

    public boolean ads() {
        return (this.bPE == null || this.bPE.bPY == null || this.bPE.bQa == null) ? false : true;
    }

    private boolean adt() {
        return (this.bPE == null || this.bPE.bPY == null || this.bPE.bQb == null) ? false : true;
    }

    public boolean la(String str) {
        return ads() && this.bPE.bQa.containsKey(str);
    }

    public boolean lb(String str) {
        return adt() && this.bPE.bQb.containsKey(str);
    }

    public String kS(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !la(delAllParamsFromUrl)) {
            return "main";
        }
        if (!lb(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean adu() {
        return this.bPH != null && this.bPH.adB();
    }

    public boolean lc(String str) {
        return (adr() && this.bPD.le(str)) || (ads() && this.bPE.bQa.containsKey(str));
    }

    public boolean ld(String str) {
        return this.bPH != null && this.bPH.lf(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> gl(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.bPL, arrayList);
            if (this.bPE != null && (list2 = this.bPE.bPY) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.bPW, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.bPK, arrayList2);
            if (this.bPE != null && (list = this.bPE.bPY) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.bPX, arrayList2);
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
        if (bVar != null && list != null && (list2 = bVar.bPQ) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a az(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adv();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return adv();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean le(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a adv() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static class g {
        public int bQd;
        public int bQe;
        public ArrayList<h> bQf;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return adC();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return adC();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.cG(optJSONObject.optString("color", "#999999"));
            gVar.bQd = SwanAppConfigData.cG(optJSONObject.optString("selectedColor", "black"));
            gVar.bQe = SwanAppConfigData.cG(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.cG(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.bQf = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.bQf.add(h.aF(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean adB() {
            return this.bQf != null && this.bQf.size() >= 2;
        }

        public boolean lf(String str) {
            if (this.bQf == null) {
                return false;
            }
            for (int i = 0; i < this.bQf.size(); i++) {
                if (TextUtils.equals(this.bQf.get(i).bQg, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g adC() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.bQf = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public boolean bPR;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adx();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return adx();
            }
            com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
            String str = "";
            if (acF != null) {
                str = acF.id;
            }
            c cVar = new c();
            cVar.bPR = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean adw() {
            SwanAppConfigData Wy = com.baidu.swan.apps.y.f.WS().Wy();
            if (Wy == null) {
                return true;
            }
            c cVar = Wy.bPI;
            com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
            b.a aVar = null;
            if (acF != null) {
                aVar = acF.GE();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean LP = com.baidu.swan.apps.console.debugger.a.e.LP();
            boolean HV = com.baidu.swan.apps.core.a.HV();
            boolean aaD = com.baidu.swan.apps.ah.a.a.aaD();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + LP + " isMobileDebug: " + HV + " urlCheck: " + cVar.bPR);
            }
            return (b || LP || HV || aaD) && !cVar.bPR;
        }

        private static c adx() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.bPR = true;
            return cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public String bQg;
        public String bQh;
        public String bQi;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adD();
            }
            h hVar = new h();
            hVar.bQg = jSONObject.optString("pagePath");
            hVar.bQh = jSONObject.optString("iconPath");
            hVar.bQi = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h adD() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public List<d> bPY;
        public HashMap<String, Boolean> bPZ;
        public HashMap<String, String> bQa;
        public HashMap<String, String> bQb;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return adz();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return adz();
            }
            e eVar = new e();
            eVar.bPY = new ArrayList();
            eVar.bQa = new HashMap<>();
            eVar.bPZ = new HashMap<>();
            eVar.bQb = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.bPY.add(d.a(optJSONObject, eVar.bQa, eVar.bQb, file));
                }
            }
            return eVar;
        }

        private static e adz() {
            e eVar = new e();
            eVar.bPY = new ArrayList();
            eVar.bQa = new HashMap<>();
            eVar.bPZ = new HashMap<>();
            eVar.bQb = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        private static final String bPV = File.separator;
        public String bPS;
        public List<String> bPT;
        boolean bPU = false;
        public b bPW;
        public b bPX;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return ady();
            }
            d dVar = new d();
            dVar.bPS = jSONObject.optString("root");
            dVar.bPU = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.bPT = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.bPT.add(optString);
                    if (!TextUtils.isEmpty(dVar.bPS) && !TextUtils.isEmpty(optString)) {
                        if (dVar.bPS.endsWith(bPV) || optString.startsWith(bPV)) {
                            str = dVar.bPS + optString;
                        } else {
                            str = dVar.bPS + bPV + optString;
                        }
                        hashMap.put(str, dVar.bPS);
                        if (dVar.bPU) {
                            hashMap2.put(str, dVar.bPS);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d ady() {
            d dVar = new d();
            dVar.bPT = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String WC() {
            if (TextUtils.isEmpty(this.bPS) || this.bPT == null || this.bPT.size() <= 0) {
                return null;
            }
            String str = this.bPT.get(0);
            if (this.bPS.endsWith(bPV)) {
                this.bPS = this.bPS.substring(0, this.bPS.length() - 1);
            }
            if (str.startsWith(bPV)) {
                str = str.substring(1);
            }
            return this.bPS + bPV + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public HashMap<String, String> bQc;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.bPY == null || eVar.bPY.size() <= 0) {
                return adA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return adA();
            }
            f fVar = new f();
            fVar.bQc = new HashMap<>();
            for (d dVar : eVar.bPY) {
                if (dVar != null && !TextUtils.isEmpty(dVar.bPS)) {
                    fVar.bQc.put(dVar.bPS, optJSONObject.optString(dVar.bPS));
                }
            }
            return fVar;
        }

        private static f adA() {
            f fVar = new f();
            fVar.bQc = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> bPQ;

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
            bVar.bPQ = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.bIL = next;
                if (file != null && !TextUtils.isEmpty(aVar.bIO)) {
                    aVar.bIO = new File(file, aVar.bIO).getAbsolutePath();
                }
                bVar.bPQ.add(aVar);
            }
            return bVar;
        }
    }
}
