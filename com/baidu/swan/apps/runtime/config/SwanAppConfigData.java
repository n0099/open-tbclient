package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.config.b;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dGF = new HashMap<>();
    public List<com.baidu.swan.pms.model.h> dGA;
    public String dGB;
    public e dGC;
    public b dGD;
    @NonNull
    public Set<RequiredBackgroundModeItem> dGE = new HashSet(1);
    public a dGq;
    public h dGr;
    public i dGs;
    public com.baidu.swan.apps.runtime.config.c dGt;
    public j dGu;
    public f dGv;
    public b.a dGw;
    public c dGx;
    public c dGy;
    @Nullable
    public d dGz;
    public boolean mIsDebug;

    static {
        dGF.put("light", -1);
        dGF.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData o(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dGB = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dGy = c.a(jSONObject, file);
            swanAppConfigData.dGx = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dGA = com.baidu.swan.apps.ac.g.b.aa(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.dGq = a.bC(jSONObject);
            swanAppConfigData.dGr = h.e(jSONObject, file);
            swanAppConfigData.dGs = i.a(jSONObject, swanAppConfigData.dGr);
            swanAppConfigData.dGt = com.baidu.swan.apps.runtime.config.c.bQ(jSONObject);
            swanAppConfigData.dGu = j.bM(jSONObject);
            swanAppConfigData.dGv = f.bK(jSONObject);
            swanAppConfigData.dGw = b.a.bB(jSONObject);
            swanAppConfigData.dGC = e.bI(jSONObject);
            swanAppConfigData.dGz = d.bG(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dGE.add(find);
                    }
                }
            }
            swanAppConfigData.dGD = b.bE(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.axL().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dGt = com.baidu.swan.apps.runtime.config.c.bQ(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dGu = j.bM(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dGB = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int rT(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = rU(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dGF.containsKey(str)) {
                return dGF.get(str).intValue();
            }
            return -1;
        }
    }

    public static String rU(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i2 = 1; i2 < 4; i2++) {
                char charAt = str.charAt(i2);
                sb.append(charAt).append(charAt);
            }
            return sb.toString();
        }
        return str;
    }

    public String azX() {
        return aJA() ? this.dGq.mPages.get(0) : "";
    }

    public String rV(String str) {
        if (this.dGr == null || this.dGr.dGR == null) {
            return null;
        }
        for (g gVar : this.dGr.dGR) {
            if (TextUtils.equals(gVar.dGL, str)) {
                return gVar.azX();
            }
        }
        return null;
    }

    public boolean aJA() {
        return (this.dGq == null || this.dGq.mPages == null || this.dGq.mPages.isEmpty()) ? false : true;
    }

    public boolean aJB() {
        return (this.dGr == null || this.dGr.dGR == null || this.dGr.dGT == null) ? false : true;
    }

    private boolean aJC() {
        return (this.dGr == null || this.dGr.dGR == null || this.dGr.dGU == null) ? false : true;
    }

    public boolean rW(String str) {
        return aJB() && this.dGr.dGT.containsKey(str);
    }

    public boolean rX(String str) {
        return aJC() && this.dGr.dGU.containsKey(str);
    }

    public String rM(String str) {
        String sy = com.baidu.swan.apps.scheme.actions.k.j.sy(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sy)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.qP(sy)) {
            return "dynamicLib";
        }
        if (!rW(sy)) {
            return "main";
        }
        if (!rX(sy)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aJD() {
        return this.dGu != null && this.dGu.aJM();
    }

    public boolean rY(String str) {
        return (aJA() && this.dGq.sb(str)) || (aJB() && this.dGr.dGT.containsKey(str));
    }

    public boolean rZ(String str) {
        return this.dGu != null && this.dGu.sc(str);
    }

    public String sa(String str) {
        if (this.dGC != null && this.dGC.dGJ != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dGC.dGJ.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jo(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dGy, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aEy() && this.dGr != null && (list2 = this.dGr.dGR) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dGP, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dGx, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aEy() && this.dGr != null && (list = this.dGr.dGR) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dGQ, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(c cVar, List<com.baidu.swan.apps.ac.f.a> list) {
        List<com.baidu.swan.apps.ac.f.a> list2;
        if (cVar != null && list != null && (list2 = cVar.dGH) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJE();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aJE();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean sb(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aJE() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class j {
        public int dGW;
        public int dGX;
        public ArrayList<k> dGY;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bM(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aJN();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aJN();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.rT(optJSONObject.optString("color", "#999999"));
            jVar.dGW = SwanAppConfigData.rT(optJSONObject.optString("selectedColor", "black"));
            jVar.dGX = SwanAppConfigData.rT(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.rT(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dGY = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dGY.add(k.bO(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aJM() {
            return this.dGY != null && this.dGY.size() >= 2;
        }

        public boolean sc(String str) {
            if (this.dGY == null) {
                return false;
            }
            for (int i = 0; i < this.dGY.size(); i++) {
                if (TextUtils.equals(this.dGY.get(i).dGZ, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aJN() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dGY = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public boolean dGK;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bK(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aJI();
            }
            com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
            String str = "";
            if (aIN != null) {
                str = aIN.id;
            }
            f fVar = new f();
            fVar.dGK = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.af.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.af.a.c.k(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static boolean aJH() {
            SwanAppConfigData azT = com.baidu.swan.apps.v.f.aAo().azT();
            if (azT == null) {
                return true;
            }
            f fVar = azT.dGv;
            com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
            b.a aVar = null;
            if (aIN != null) {
                aVar = aIN.agc();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean amn = com.baidu.swan.apps.console.debugger.a.e.amn();
            boolean aht = com.baidu.swan.apps.core.e.aht();
            boolean aFp = com.baidu.swan.apps.ad.a.a.aFp();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + amn + " isMobileDebug: " + aht + " urlCheck: " + fVar.dGK);
            }
            return (b || amn || aht || aFp) && !fVar.dGK;
        }

        private static f aJI() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dGK = true;
            return fVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class k {
        public String dGZ;
        public String dHa;
        public String dHb;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJO();
            }
            k kVar = new k();
            kVar.dGZ = jSONObject.optString("pagePath");
            kVar.dHa = jSONObject.optString("iconPath");
            kVar.dHb = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aJO() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public List<g> dGR;
        public HashMap<String, Boolean> dGS;
        public HashMap<String, String> dGT;
        public HashMap<String, String> dGU;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aJK();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aJK();
            }
            h hVar = new h();
            hVar.dGR = new ArrayList();
            hVar.dGT = new HashMap<>();
            hVar.dGS = new HashMap<>();
            hVar.dGU = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dGR.add(g.a(optJSONObject, hVar.dGT, hVar.dGU, file));
                }
            }
            return hVar;
        }

        private static h aJK() {
            h hVar = new h();
            hVar.dGR = new ArrayList();
            hVar.dGT = new HashMap<>();
            hVar.dGS = new HashMap<>();
            hVar.dGU = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        private static final String dGO = File.separator;
        public String dGL;
        public List<String> dGM;
        boolean dGN = false;
        public c dGP;
        public c dGQ;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aJJ();
            }
            g gVar = new g();
            gVar.dGL = jSONObject.optString("root");
            gVar.dGN = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dGM = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dGM.add(optString);
                    if (!TextUtils.isEmpty(gVar.dGL) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dGL.endsWith(dGO) || optString.startsWith(dGO)) {
                            str = gVar.dGL + optString;
                        } else {
                            str = gVar.dGL + dGO + optString;
                        }
                        hashMap.put(str, gVar.dGL);
                        if (gVar.dGN) {
                            hashMap2.put(str, gVar.dGL);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aJJ() {
            g gVar = new g();
            gVar.dGM = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String azX() {
            if (TextUtils.isEmpty(this.dGL) || this.dGM == null || this.dGM.size() <= 0) {
                return null;
            }
            String str = this.dGM.get(0);
            if (this.dGL.endsWith(dGO)) {
                this.dGL = this.dGL.substring(0, this.dGL.length() - 1);
            }
            if (str.startsWith(dGO)) {
                str = str.substring(1);
            }
            return this.dGL + dGO + str;
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public HashMap<String, String> dGV;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dGR == null || hVar.dGR.size() <= 0) {
                return aJL();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aJL();
            }
            i iVar = new i();
            iVar.dGV = new HashMap<>();
            for (g gVar : hVar.dGR) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dGL)) {
                    iVar.dGV.put(gVar.dGL, optJSONObject.optString(gVar.dGL));
                }
            }
            return iVar;
        }

        private static i aJL() {
            i iVar = new i();
            iVar.dGV = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dGH;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, File file) {
            return a(jSONObject, "dynamicLib", 3, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(JSONObject jSONObject, File file) {
            return a(jSONObject, "plugins", 4, file);
        }

        private static c a(JSONObject jSONObject, String str, int i, File file) {
            JSONObject optJSONObject;
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            c cVar = new c();
            cVar.dGH = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dup = next;
                if (file != null && !TextUtils.isEmpty(aVar.dus)) {
                    aVar.dus = new File(file, aVar.dus).getAbsolutePath();
                }
                cVar.dGH.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public HashMap<String, String> dGJ;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bI(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aJG = aJG();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aJG.dGJ.containsKey(optString)) {
                            aJG.dGJ.put(optString, optString2);
                        }
                    }
                }
            }
            return aJG;
        }

        private static e aJG() {
            e eVar = new e();
            eVar.dGJ = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public ArrayList<String> dGI;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bG(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dGI = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dGI.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public Map<String, Map<String, String>> dGG;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            b aJF = aJF();
            if (jSONObject == null) {
                return aJF;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aJF.dGG = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                HashMap hashMap = new HashMap();
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject2.optString(next2));
                    }
                }
                aJF.dGG.put(next, hashMap);
            }
            return aJF;
        }

        private static b aJF() {
            b bVar = new b();
            bVar.dGG = new HashMap();
            return bVar;
        }
    }
}
