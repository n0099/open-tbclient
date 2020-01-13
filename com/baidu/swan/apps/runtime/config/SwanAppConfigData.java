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
/* loaded from: classes10.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> bLI = new HashMap<>();
    public g bLA;
    public c bLB;
    public b.a bLC;
    public b bLD;
    public b bLE;
    public List<com.baidu.swan.pms.model.h> bLF;
    public String bLG;
    @NonNull
    public Set<RequiredBackgroundModeItem> bLH = new HashSet(1);
    public a bLw;
    public e bLx;
    public f bLy;
    public com.baidu.swan.apps.runtime.config.c bLz;
    public boolean mIsDebug;

    static {
        bLI.put("light", -1);
        bLI.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.bLG = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.bLE = b.a(jSONObject, file);
            swanAppConfigData.bLD = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.bLF = com.baidu.swan.apps.ag.g.b.x(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.bLw = a.az(jSONObject);
            swanAppConfigData.bLx = e.e(jSONObject, file);
            swanAppConfigData.bLy = f.a(jSONObject, swanAppConfigData.bLx);
            swanAppConfigData.bLz = com.baidu.swan.apps.runtime.config.c.aH(jSONObject);
            swanAppConfigData.bLA = g.aD(jSONObject);
            swanAppConfigData.bLB = c.aB(jSONObject);
            swanAppConfigData.bLC = b.a.ay(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.bLH.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.Sr().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.bLz = com.baidu.swan.apps.runtime.config.c.aH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.bLA = g.aD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.bLG = jSONObject.toString();
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
            str = kJ(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (bLI.containsKey(str)) {
                return bLI.get(str).intValue();
            }
            return -1;
        }
    }

    public static String kJ(String str) {
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

    public String Um() {
        return abb() ? this.bLw.mPages.get(0) : "";
    }

    public String kK(String str) {
        if (this.bLx == null || this.bLx.bLR == null) {
            return null;
        }
        for (d dVar : this.bLx.bLR) {
            if (TextUtils.equals(dVar.bLL, str)) {
                return dVar.Um();
            }
        }
        return null;
    }

    public boolean abb() {
        return (this.bLw == null || this.bLw.mPages == null || this.bLw.mPages.isEmpty()) ? false : true;
    }

    public boolean abc() {
        return (this.bLx == null || this.bLx.bLR == null || this.bLx.bLT == null) ? false : true;
    }

    private boolean abd() {
        return (this.bLx == null || this.bLx.bLR == null || this.bLx.bLU == null) ? false : true;
    }

    public boolean kL(String str) {
        return abc() && this.bLx.bLT.containsKey(str);
    }

    public boolean kM(String str) {
        return abd() && this.bLx.bLU.containsKey(str);
    }

    public String kD(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !kL(delAllParamsFromUrl)) {
            return "main";
        }
        if (!kM(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean abe() {
        return this.bLA != null && this.bLA.abl();
    }

    public boolean kN(String str) {
        return (abb() && this.bLw.kP(str)) || (abc() && this.bLx.bLT.containsKey(str));
    }

    public boolean kO(String str) {
        return this.bLA != null && this.bLA.kQ(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> fV(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.bLE, arrayList);
            if (this.bLx != null && (list2 = this.bLx.bLR) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.bLP, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.bLD, arrayList2);
            if (this.bLx != null && (list = this.bLx.bLR) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.bLQ, arrayList2);
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
        if (bVar != null && list != null && (list2 = bVar.bLJ) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a az(JSONObject jSONObject) {
            if (jSONObject == null) {
                return abf();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return abf();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean kP(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a abf() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class g {
        public int bLW;
        public int bLX;
        public ArrayList<h> bLY;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return abm();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return abm();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.cy(optJSONObject.optString("color", "#999999"));
            gVar.bLW = SwanAppConfigData.cy(optJSONObject.optString("selectedColor", "black"));
            gVar.bLX = SwanAppConfigData.cy(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.cy(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.bLY = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.bLY.add(h.aF(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean abl() {
            return this.bLY != null && this.bLY.size() >= 2;
        }

        public boolean kQ(String str) {
            if (this.bLY == null) {
                return false;
            }
            for (int i = 0; i < this.bLY.size(); i++) {
                if (TextUtils.equals(this.bLY.get(i).bLZ, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g abm() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.bLY = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public boolean bLK;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return abh();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return abh();
            }
            com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
            String str = "";
            if (aap != null) {
                str = aap.id;
            }
            c cVar = new c();
            cVar.bLK = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean abg() {
            SwanAppConfigData Ui = com.baidu.swan.apps.y.f.UC().Ui();
            if (Ui == null) {
                return true;
            }
            c cVar = Ui.bLB;
            com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
            b.a aVar = null;
            if (aap != null) {
                aVar = aap.En();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean Jy = com.baidu.swan.apps.console.debugger.a.e.Jy();
            boolean FE = com.baidu.swan.apps.core.a.FE();
            boolean Yn = com.baidu.swan.apps.ah.a.a.Yn();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Jy + " isMobileDebug: " + FE + " urlCheck: " + cVar.bLK);
            }
            return (b || Jy || FE || Yn) && !cVar.bLK;
        }

        private static c abh() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.bLK = true;
            return cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class h {
        public String bLZ;
        public String bMa;
        public String bMb;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return abn();
            }
            h hVar = new h();
            hVar.bLZ = jSONObject.optString("pagePath");
            hVar.bMa = jSONObject.optString("iconPath");
            hVar.bMb = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h abn() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public List<d> bLR;
        public HashMap<String, Boolean> bLS;
        public HashMap<String, String> bLT;
        public HashMap<String, String> bLU;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return abj();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return abj();
            }
            e eVar = new e();
            eVar.bLR = new ArrayList();
            eVar.bLT = new HashMap<>();
            eVar.bLS = new HashMap<>();
            eVar.bLU = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.bLR.add(d.a(optJSONObject, eVar.bLT, eVar.bLU, file));
                }
            }
            return eVar;
        }

        private static e abj() {
            e eVar = new e();
            eVar.bLR = new ArrayList();
            eVar.bLT = new HashMap<>();
            eVar.bLS = new HashMap<>();
            eVar.bLU = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        private static final String bLO = File.separator;
        public String bLL;
        public List<String> bLM;
        boolean bLN = false;
        public b bLP;
        public b bLQ;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return abi();
            }
            d dVar = new d();
            dVar.bLL = jSONObject.optString("root");
            dVar.bLN = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.bLM = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.bLM.add(optString);
                    if (!TextUtils.isEmpty(dVar.bLL) && !TextUtils.isEmpty(optString)) {
                        if (dVar.bLL.endsWith(bLO) || optString.startsWith(bLO)) {
                            str = dVar.bLL + optString;
                        } else {
                            str = dVar.bLL + bLO + optString;
                        }
                        hashMap.put(str, dVar.bLL);
                        if (dVar.bLN) {
                            hashMap2.put(str, dVar.bLL);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d abi() {
            d dVar = new d();
            dVar.bLM = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String Um() {
            if (TextUtils.isEmpty(this.bLL) || this.bLM == null || this.bLM.size() <= 0) {
                return null;
            }
            String str = this.bLM.get(0);
            if (this.bLL.endsWith(bLO)) {
                this.bLL = this.bLL.substring(0, this.bLL.length() - 1);
            }
            if (str.startsWith(bLO)) {
                str = str.substring(1);
            }
            return this.bLL + bLO + str;
        }
    }

    /* loaded from: classes10.dex */
    public static class f {
        public HashMap<String, String> bLV;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.bLR == null || eVar.bLR.size() <= 0) {
                return abk();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return abk();
            }
            f fVar = new f();
            fVar.bLV = new HashMap<>();
            for (d dVar : eVar.bLR) {
                if (dVar != null && !TextUtils.isEmpty(dVar.bLL)) {
                    fVar.bLV.put(dVar.bLL, optJSONObject.optString(dVar.bLL));
                }
            }
            return fVar;
        }

        private static f abk() {
            f fVar = new f();
            fVar.bLV = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> bLJ;

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
            bVar.bLJ = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.bEE = next;
                if (file != null && !TextUtils.isEmpty(aVar.bEH)) {
                    aVar.bEH = new File(file, aVar.bEH).getAbsolutePath();
                }
                bVar.bLJ.add(aVar);
            }
            return bVar;
        }
    }
}
