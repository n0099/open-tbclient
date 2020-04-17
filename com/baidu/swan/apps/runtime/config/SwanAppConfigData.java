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
    private static final HashMap<String, Integer> coM = new HashMap<>();
    public a coA;
    public e coB;
    public f coC;
    public com.baidu.swan.apps.runtime.config.c coD;
    public g coE;
    public c coF;
    public b.a coG;
    public b coH;
    public b coI;
    public List<com.baidu.swan.pms.model.h> coJ;
    public String coK;
    @NonNull
    public Set<RequiredBackgroundModeItem> coL = new HashSet(1);
    public boolean mIsDebug;

    static {
        coM.put("light", -1);
        coM.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData k(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.coK = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.coI = b.a(jSONObject, file);
            swanAppConfigData.coH = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.coJ = com.baidu.swan.apps.ag.g.b.C(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.coA = a.aK(jSONObject);
            swanAppConfigData.coB = e.e(jSONObject, file);
            swanAppConfigData.coC = f.a(jSONObject, swanAppConfigData.coB);
            swanAppConfigData.coD = com.baidu.swan.apps.runtime.config.c.aS(jSONObject);
            swanAppConfigData.coE = g.aO(jSONObject);
            swanAppConfigData.coF = c.aM(jSONObject);
            swanAppConfigData.coG = b.a.aJ(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.coL.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.acz().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.coD = com.baidu.swan.apps.runtime.config.c.aS(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.coE = g.aO(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.coK = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = mk(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (coM.containsKey(str)) {
                return coM.get(str).intValue();
            }
            return -1;
        }
    }

    public static String mk(String str) {
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

    public String aeu() {
        return alz() ? this.coA.mPages.get(0) : "";
    }

    public String ml(String str) {
        if (this.coB == null || this.coB.coV == null) {
            return null;
        }
        for (d dVar : this.coB.coV) {
            if (TextUtils.equals(dVar.coP, str)) {
                return dVar.aeu();
            }
        }
        return null;
    }

    public boolean alz() {
        return (this.coA == null || this.coA.mPages == null || this.coA.mPages.isEmpty()) ? false : true;
    }

    public boolean alA() {
        return (this.coB == null || this.coB.coV == null || this.coB.coX == null) ? false : true;
    }

    private boolean alB() {
        return (this.coB == null || this.coB.coV == null || this.coB.coY == null) ? false : true;
    }

    public boolean mm(String str) {
        return alA() && this.coB.coX.containsKey(str);
    }

    public boolean mn(String str) {
        return alB() && this.coB.coY.containsKey(str);
    }

    public String me(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !mm(delAllParamsFromUrl)) {
            return "main";
        }
        if (!mn(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean alC() {
        return this.coE != null && this.coE.alJ();
    }

    public boolean mo(String str) {
        return (alz() && this.coA.mq(str)) || (alA() && this.coB.coX.containsKey(str));
    }

    public boolean mp(String str) {
        return this.coE != null && this.coE.mr(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> gt(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.coI, arrayList);
            if (this.coB != null && (list2 = this.coB.coV) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.coT, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.coH, arrayList2);
            if (this.coB != null && (list = this.coB.coV) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.coU, arrayList2);
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
        if (bVar != null && list != null && (list2 = bVar.coN) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a aK(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alD();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return alD();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean mq(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a alD() {
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
        public int cpa;
        public int cpb;
        public ArrayList<h> cpc;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aO(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return alK();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return alK();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.dA(optJSONObject.optString("color", "#999999"));
            gVar.cpa = SwanAppConfigData.dA(optJSONObject.optString("selectedColor", "black"));
            gVar.cpb = SwanAppConfigData.dA(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.dA(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.cpc = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.cpc.add(h.aQ(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean alJ() {
            return this.cpc != null && this.cpc.size() >= 2;
        }

        public boolean mr(String str) {
            if (this.cpc == null) {
                return false;
            }
            for (int i = 0; i < this.cpc.size(); i++) {
                if (TextUtils.equals(this.cpc.get(i).cpd, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g alK() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.cpc = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public boolean coO;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aM(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return alF();
            }
            com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
            String str = "";
            if (akN != null) {
                str = akN.id;
            }
            c cVar = new c();
            cVar.coO = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.aj.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.aj.a.c.g(str, optJSONObject3);
                }
            }
            return cVar;
        }

        public static boolean alE() {
            SwanAppConfigData aeq = com.baidu.swan.apps.y.f.aeK().aeq();
            if (aeq == null) {
                return true;
            }
            c cVar = aeq.coF;
            com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
            b.a aVar = null;
            if (akN != null) {
                aVar = akN.Ow();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean TG = com.baidu.swan.apps.console.debugger.a.e.TG();
            boolean PK = com.baidu.swan.apps.core.a.PK();
            boolean aiL = com.baidu.swan.apps.ah.a.a.aiL();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + TG + " isMobileDebug: " + PK + " urlCheck: " + cVar.coO);
            }
            return (b || TG || PK || aiL) && !cVar.coO;
        }

        private static c alF() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.coO = true;
            return cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public String cpd;
        public String cpe;
        public String cpf;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aQ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alL();
            }
            h hVar = new h();
            hVar.cpd = jSONObject.optString("pagePath");
            hVar.cpe = jSONObject.optString("iconPath");
            hVar.cpf = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h alL() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public List<d> coV;
        public HashMap<String, Boolean> coW;
        public HashMap<String, String> coX;
        public HashMap<String, String> coY;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return alH();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return alH();
            }
            e eVar = new e();
            eVar.coV = new ArrayList();
            eVar.coX = new HashMap<>();
            eVar.coW = new HashMap<>();
            eVar.coY = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.coV.add(d.a(optJSONObject, eVar.coX, eVar.coY, file));
                }
            }
            return eVar;
        }

        private static e alH() {
            e eVar = new e();
            eVar.coV = new ArrayList();
            eVar.coX = new HashMap<>();
            eVar.coW = new HashMap<>();
            eVar.coY = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        private static final String coS = File.separator;
        public String coP;
        public List<String> coQ;
        boolean coR = false;
        public b coT;
        public b coU;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return alG();
            }
            d dVar = new d();
            dVar.coP = jSONObject.optString("root");
            dVar.coR = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.coQ = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.coQ.add(optString);
                    if (!TextUtils.isEmpty(dVar.coP) && !TextUtils.isEmpty(optString)) {
                        if (dVar.coP.endsWith(coS) || optString.startsWith(coS)) {
                            str = dVar.coP + optString;
                        } else {
                            str = dVar.coP + coS + optString;
                        }
                        hashMap.put(str, dVar.coP);
                        if (dVar.coR) {
                            hashMap2.put(str, dVar.coP);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d alG() {
            d dVar = new d();
            dVar.coQ = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aeu() {
            if (TextUtils.isEmpty(this.coP) || this.coQ == null || this.coQ.size() <= 0) {
                return null;
            }
            String str = this.coQ.get(0);
            if (this.coP.endsWith(coS)) {
                this.coP = this.coP.substring(0, this.coP.length() - 1);
            }
            if (str.startsWith(coS)) {
                str = str.substring(1);
            }
            return this.coP + coS + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public HashMap<String, String> coZ;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.coV == null || eVar.coV.size() <= 0) {
                return alI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return alI();
            }
            f fVar = new f();
            fVar.coZ = new HashMap<>();
            for (d dVar : eVar.coV) {
                if (dVar != null && !TextUtils.isEmpty(dVar.coP)) {
                    fVar.coZ.put(dVar.coP, optJSONObject.optString(dVar.coP));
                }
            }
            return fVar;
        }

        private static f alI() {
            f fVar = new f();
            fVar.coZ = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> coN;

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
            bVar.coN = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.chF = next;
                if (file != null && !TextUtils.isEmpty(aVar.chI)) {
                    aVar.chI = new File(file, aVar.chI).getAbsolutePath();
                }
                bVar.coN.add(aVar);
            }
            return bVar;
        }
    }
}
