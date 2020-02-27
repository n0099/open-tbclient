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
    private static final HashMap<String, Integer> bPN = new HashMap<>();
    public a bPB;
    public e bPC;
    public f bPD;
    public com.baidu.swan.apps.runtime.config.c bPE;
    public g bPF;
    public c bPG;
    public b.a bPH;
    public b bPI;
    public b bPJ;
    public List<com.baidu.swan.pms.model.h> bPK;
    public String bPL;
    @NonNull
    public Set<RequiredBackgroundModeItem> bPM = new HashSet(1);
    public boolean mIsDebug;

    static {
        bPN.put("light", -1);
        bPN.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.bPL = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.bPJ = b.a(jSONObject, file);
            swanAppConfigData.bPI = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.bPK = com.baidu.swan.apps.ag.g.b.x(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.bPB = a.az(jSONObject);
            swanAppConfigData.bPC = e.e(jSONObject, file);
            swanAppConfigData.bPD = f.a(jSONObject, swanAppConfigData.bPC);
            swanAppConfigData.bPE = com.baidu.swan.apps.runtime.config.c.aH(jSONObject);
            swanAppConfigData.bPF = g.aD(jSONObject);
            swanAppConfigData.bPG = c.aB(jSONObject);
            swanAppConfigData.bPH = b.a.ay(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.bPM.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.UF().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.bPE = com.baidu.swan.apps.runtime.config.c.aH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.bPF = g.aD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.bPL = jSONObject.toString();
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
            if (bPN.containsKey(str)) {
                return bPN.get(str).intValue();
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

    public String WA() {
        return adp() ? this.bPB.mPages.get(0) : "";
    }

    public String kZ(String str) {
        if (this.bPC == null || this.bPC.bPW == null) {
            return null;
        }
        for (d dVar : this.bPC.bPW) {
            if (TextUtils.equals(dVar.bPQ, str)) {
                return dVar.WA();
            }
        }
        return null;
    }

    public boolean adp() {
        return (this.bPB == null || this.bPB.mPages == null || this.bPB.mPages.isEmpty()) ? false : true;
    }

    public boolean adq() {
        return (this.bPC == null || this.bPC.bPW == null || this.bPC.bPY == null) ? false : true;
    }

    private boolean adr() {
        return (this.bPC == null || this.bPC.bPW == null || this.bPC.bPZ == null) ? false : true;
    }

    public boolean la(String str) {
        return adq() && this.bPC.bPY.containsKey(str);
    }

    public boolean lb(String str) {
        return adr() && this.bPC.bPZ.containsKey(str);
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

    public boolean ads() {
        return this.bPF != null && this.bPF.adz();
    }

    public boolean lc(String str) {
        return (adp() && this.bPB.le(str)) || (adq() && this.bPC.bPY.containsKey(str));
    }

    public boolean ld(String str) {
        return this.bPF != null && this.bPF.lf(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> gl(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.bPJ, arrayList);
            if (this.bPC != null && (list2 = this.bPC.bPW) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.bPU, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.bPI, arrayList2);
            if (this.bPC != null && (list = this.bPC.bPW) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.bPV, arrayList2);
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
        if (bVar != null && list != null && (list2 = bVar.bPO) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a az(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adt();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return adt();
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

        private static a adt() {
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
        public int bQb;
        public int bQc;
        public ArrayList<h> bQd;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return adA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return adA();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.cG(optJSONObject.optString("color", "#999999"));
            gVar.bQb = SwanAppConfigData.cG(optJSONObject.optString("selectedColor", "black"));
            gVar.bQc = SwanAppConfigData.cG(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.cG(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.bQd = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.bQd.add(h.aF(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean adz() {
            return this.bQd != null && this.bQd.size() >= 2;
        }

        public boolean lf(String str) {
            if (this.bQd == null) {
                return false;
            }
            for (int i = 0; i < this.bQd.size(); i++) {
                if (TextUtils.equals(this.bQd.get(i).bQe, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g adA() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.bQd = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public boolean bPP;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adv();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return adv();
            }
            com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
            String str = "";
            if (acD != null) {
                str = acD.id;
            }
            c cVar = new c();
            cVar.bPP = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean adu() {
            SwanAppConfigData Ww = com.baidu.swan.apps.y.f.WQ().Ww();
            if (Ww == null) {
                return true;
            }
            c cVar = Ww.bPG;
            com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
            b.a aVar = null;
            if (acD != null) {
                aVar = acD.GC();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean LN = com.baidu.swan.apps.console.debugger.a.e.LN();
            boolean HT = com.baidu.swan.apps.core.a.HT();
            boolean aaB = com.baidu.swan.apps.ah.a.a.aaB();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + LN + " isMobileDebug: " + HT + " urlCheck: " + cVar.bPP);
            }
            return (b || LN || HT || aaB) && !cVar.bPP;
        }

        private static c adv() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.bPP = true;
            return cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public String bQe;
        public String bQf;
        public String bQg;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adB();
            }
            h hVar = new h();
            hVar.bQe = jSONObject.optString("pagePath");
            hVar.bQf = jSONObject.optString("iconPath");
            hVar.bQg = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h adB() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public List<d> bPW;
        public HashMap<String, Boolean> bPX;
        public HashMap<String, String> bPY;
        public HashMap<String, String> bPZ;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return adx();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return adx();
            }
            e eVar = new e();
            eVar.bPW = new ArrayList();
            eVar.bPY = new HashMap<>();
            eVar.bPX = new HashMap<>();
            eVar.bPZ = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.bPW.add(d.a(optJSONObject, eVar.bPY, eVar.bPZ, file));
                }
            }
            return eVar;
        }

        private static e adx() {
            e eVar = new e();
            eVar.bPW = new ArrayList();
            eVar.bPY = new HashMap<>();
            eVar.bPX = new HashMap<>();
            eVar.bPZ = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        private static final String bPT = File.separator;
        public String bPQ;
        public List<String> bPR;
        boolean bPS = false;
        public b bPU;
        public b bPV;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return adw();
            }
            d dVar = new d();
            dVar.bPQ = jSONObject.optString("root");
            dVar.bPS = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.bPR = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.bPR.add(optString);
                    if (!TextUtils.isEmpty(dVar.bPQ) && !TextUtils.isEmpty(optString)) {
                        if (dVar.bPQ.endsWith(bPT) || optString.startsWith(bPT)) {
                            str = dVar.bPQ + optString;
                        } else {
                            str = dVar.bPQ + bPT + optString;
                        }
                        hashMap.put(str, dVar.bPQ);
                        if (dVar.bPS) {
                            hashMap2.put(str, dVar.bPQ);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d adw() {
            d dVar = new d();
            dVar.bPR = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String WA() {
            if (TextUtils.isEmpty(this.bPQ) || this.bPR == null || this.bPR.size() <= 0) {
                return null;
            }
            String str = this.bPR.get(0);
            if (this.bPQ.endsWith(bPT)) {
                this.bPQ = this.bPQ.substring(0, this.bPQ.length() - 1);
            }
            if (str.startsWith(bPT)) {
                str = str.substring(1);
            }
            return this.bPQ + bPT + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public HashMap<String, String> bQa;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.bPW == null || eVar.bPW.size() <= 0) {
                return ady();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return ady();
            }
            f fVar = new f();
            fVar.bQa = new HashMap<>();
            for (d dVar : eVar.bPW) {
                if (dVar != null && !TextUtils.isEmpty(dVar.bPQ)) {
                    fVar.bQa.put(dVar.bPQ, optJSONObject.optString(dVar.bPQ));
                }
            }
            return fVar;
        }

        private static f ady() {
            f fVar = new f();
            fVar.bQa = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> bPO;

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
            bVar.bPO = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.bIJ = next;
                if (file != null && !TextUtils.isEmpty(aVar.bIM)) {
                    aVar.bIM = new File(file, aVar.bIM).getAbsolutePath();
                }
                bVar.bPO.add(aVar);
            }
            return bVar;
        }
    }
}
