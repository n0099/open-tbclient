package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.config.b;
import com.baidu.swan.apps.v.b.b;
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
    private static final HashMap<String, Integer> cAG = new HashMap<>();
    public b cAA;
    @Nullable
    public c cAB;
    public List<com.baidu.swan.pms.model.h> cAC;
    public String cAD;
    public d cAE;
    @NonNull
    public Set<RequiredBackgroundModeItem> cAF = new HashSet(1);
    public a cAs;
    public g cAt;
    public h cAu;
    public com.baidu.swan.apps.runtime.config.c cAv;
    public i cAw;
    public e cAx;
    public b.a cAy;
    public b cAz;
    public boolean mIsDebug;

    static {
        cAG.put("light", -1);
        cAG.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData k(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.cAD = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.cAA = b.a(jSONObject, file);
            swanAppConfigData.cAz = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.cAC = com.baidu.swan.apps.ae.g.b.O(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.cAs = a.aP(jSONObject);
            swanAppConfigData.cAt = g.e(jSONObject, file);
            swanAppConfigData.cAu = h.a(jSONObject, swanAppConfigData.cAt);
            swanAppConfigData.cAv = com.baidu.swan.apps.runtime.config.c.bb(jSONObject);
            swanAppConfigData.cAw = i.aX(jSONObject);
            swanAppConfigData.cAx = e.aV(jSONObject);
            swanAppConfigData.cAy = b.a.aO(jSONObject);
            swanAppConfigData.cAE = d.aT(jSONObject);
            swanAppConfigData.cAB = c.aR(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.cAF.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.u.a.afB().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.e.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.cAv = com.baidu.swan.apps.runtime.config.c.bb(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.cAw = i.aX(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.cAD = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int dT(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = nG(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (cAG.containsKey(str)) {
                return cAG.get(str).intValue();
            }
            return -1;
        }
    }

    public static String nG(String str) {
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

    public String ahE() {
        return apv() ? this.cAs.mPages.get(0) : "";
    }

    public String nH(String str) {
        if (this.cAt == null || this.cAt.cAR == null) {
            return null;
        }
        for (f fVar : this.cAt.cAR) {
            if (TextUtils.equals(fVar.cAL, str)) {
                return fVar.ahE();
            }
        }
        return null;
    }

    public boolean apv() {
        return (this.cAs == null || this.cAs.mPages == null || this.cAs.mPages.isEmpty()) ? false : true;
    }

    public boolean apw() {
        return (this.cAt == null || this.cAt.cAR == null || this.cAt.cAT == null) ? false : true;
    }

    private boolean apx() {
        return (this.cAt == null || this.cAt.cAR == null || this.cAt.cAU == null) ? false : true;
    }

    public boolean nI(String str) {
        return apw() && this.cAt.cAT.containsKey(str);
    }

    public boolean nJ(String str) {
        return apx() && this.cAt.cAU.containsKey(str);
    }

    public String nz(String str) {
        String oh = com.baidu.swan.apps.scheme.actions.k.j.oh(ah.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(oh)) {
            return "main";
        }
        if (com.baidu.swan.apps.ae.b.a.mH(oh)) {
            return "dynamicLib";
        }
        if (!nI(oh)) {
            return "main";
        }
        if (!nJ(oh)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean apy() {
        return this.cAw != null && this.cAw.apG();
    }

    public boolean nK(String str) {
        return (apv() && this.cAs.nN(str)) || (apw() && this.cAt.cAT.containsKey(str));
    }

    public boolean nL(String str) {
        return this.cAw != null && this.cAw.nO(str);
    }

    public String nM(String str) {
        if (this.cAE != null && this.cAE.cAJ != null) {
            String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
            String str2 = this.cAE.cAJ.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ae.f.a> gM(int i2) {
        List<f> list;
        List<f> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.cAA, arrayList);
            if (this.cAt != null && (list2 = this.cAt.cAR) != null) {
                for (f fVar : list2) {
                    if (fVar != null) {
                        a(fVar.cAP, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.cAz, arrayList2);
            if (this.cAt != null && (list = this.cAt.cAR) != null) {
                for (f fVar2 : list) {
                    if (fVar2 != null) {
                        a(fVar2.cAQ, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(b bVar, List<com.baidu.swan.apps.ae.f.a> list) {
        List<com.baidu.swan.apps.ae.f.a> list2;
        if (bVar != null && list != null && (list2 = bVar.cAH) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a aP(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apz();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return apz();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean nN(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a apz() {
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
    public static class i {
        public int cAW;
        public int cAX;
        public ArrayList<j> cAY;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static i aX(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return apH();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return apH();
            }
            i iVar = new i();
            iVar.mColor = SwanAppConfigData.dT(optJSONObject.optString("color", "#999999"));
            iVar.cAW = SwanAppConfigData.dT(optJSONObject.optString("selectedColor", "black"));
            iVar.cAX = SwanAppConfigData.dT(optJSONObject.optString("borderStyle", "black"));
            iVar.mBackgroundColor = SwanAppConfigData.dT(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                iVar.cAY = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    iVar.cAY.add(j.aZ(optJSONArray.optJSONObject(i2)));
                }
            }
            return iVar;
        }

        public boolean apG() {
            return this.cAY != null && this.cAY.size() >= 2;
        }

        public boolean nO(String str) {
            if (this.cAY == null) {
                return false;
            }
            for (int i = 0; i < this.cAY.size(); i++) {
                if (TextUtils.equals(this.cAY.get(i).cAZ, str)) {
                    return true;
                }
            }
            return false;
        }

        private static i apH() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            i iVar = new i();
            iVar.cAY = new ArrayList<>();
            return iVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public boolean cAK;

        /* JADX INFO: Access modifiers changed from: private */
        public static e aV(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apC();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return apC();
            }
            com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
            String str = "";
            if (aoF != null) {
                str = aoF.id;
            }
            e eVar = new e();
            eVar.cAK = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.ah.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.ah.a.c.g(str, optJSONObject3);
                }
            }
            return eVar;
        }

        public static boolean apB() {
            SwanAppConfigData ahA = com.baidu.swan.apps.w.f.ahV().ahA();
            if (ahA == null) {
                return true;
            }
            e eVar = ahA.cAx;
            com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
            b.a aVar = null;
            if (aoF != null) {
                aVar = aoF.QJ();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean Wm = com.baidu.swan.apps.console.debugger.a.e.Wm();
            boolean RN = com.baidu.swan.apps.core.a.RN();
            boolean amr = com.baidu.swan.apps.af.a.a.amr();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Wm + " isMobileDebug: " + RN + " urlCheck: " + eVar.cAK);
            }
            return (b || Wm || RN || amr) && !eVar.cAK;
        }

        private static e apC() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            e eVar = new e();
            eVar.cAK = true;
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class j {
        public String cAZ;
        public String cBa;
        public String cBb;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static j aZ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apI();
            }
            j jVar = new j();
            jVar.cAZ = jSONObject.optString("pagePath");
            jVar.cBa = jSONObject.optString("iconPath");
            jVar.cBb = jSONObject.optString("selectedIconPath");
            jVar.mText = jSONObject.optString("text");
            return jVar;
        }

        private static j apI() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new j();
        }
    }

    /* loaded from: classes11.dex */
    public static class g {
        public List<f> cAR;
        public HashMap<String, Boolean> cAS;
        public HashMap<String, String> cAT;
        public HashMap<String, String> cAU;

        /* JADX INFO: Access modifiers changed from: private */
        public static g e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return apE();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return apE();
            }
            g gVar = new g();
            gVar.cAR = new ArrayList();
            gVar.cAT = new HashMap<>();
            gVar.cAS = new HashMap<>();
            gVar.cAU = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    gVar.cAR.add(f.a(optJSONObject, gVar.cAT, gVar.cAU, file));
                }
            }
            return gVar;
        }

        private static g apE() {
            g gVar = new g();
            gVar.cAR = new ArrayList();
            gVar.cAT = new HashMap<>();
            gVar.cAS = new HashMap<>();
            gVar.cAU = new HashMap<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        private static final String cAO = File.separator;
        public String cAL;
        public List<String> cAM;
        boolean cAN = false;
        public b cAP;
        public b cAQ;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return apD();
            }
            f fVar = new f();
            fVar.cAL = jSONObject.optString("root");
            fVar.cAN = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                fVar.cAM = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    fVar.cAM.add(optString);
                    if (!TextUtils.isEmpty(fVar.cAL) && !TextUtils.isEmpty(optString)) {
                        if (fVar.cAL.endsWith(cAO) || optString.startsWith(cAO)) {
                            str = fVar.cAL + optString;
                        } else {
                            str = fVar.cAL + cAO + optString;
                        }
                        hashMap.put(str, fVar.cAL);
                        if (fVar.cAN) {
                            hashMap2.put(str, fVar.cAL);
                        }
                    }
                }
            }
            return fVar;
        }

        private static f apD() {
            f fVar = new f();
            fVar.cAM = new ArrayList();
            return fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String ahE() {
            if (TextUtils.isEmpty(this.cAL) || this.cAM == null || this.cAM.size() <= 0) {
                return null;
            }
            String str = this.cAM.get(0);
            if (this.cAL.endsWith(cAO)) {
                this.cAL = this.cAL.substring(0, this.cAL.length() - 1);
            }
            if (str.startsWith(cAO)) {
                str = str.substring(1);
            }
            return this.cAL + cAO + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public HashMap<String, String> cAV;

        /* JADX INFO: Access modifiers changed from: private */
        public static h a(JSONObject jSONObject, g gVar) {
            if (jSONObject == null || gVar == null || gVar.cAR == null || gVar.cAR.size() <= 0) {
                return apF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return apF();
            }
            h hVar = new h();
            hVar.cAV = new HashMap<>();
            for (f fVar : gVar.cAR) {
                if (fVar != null && !TextUtils.isEmpty(fVar.cAL)) {
                    hVar.cAV.put(fVar.cAL, optJSONObject.optString(fVar.cAL));
                }
            }
            return hVar;
        }

        private static h apF() {
            h hVar = new h();
            hVar.cAV = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ae.f.a> cAH;

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
            bVar.cAH = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ae.f.a aVar = new com.baidu.swan.apps.ae.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cta = next;
                if (file != null && !TextUtils.isEmpty(aVar.ctd)) {
                    aVar.ctd = new File(file, aVar.ctd).getAbsolutePath();
                }
                bVar.cAH.add(aVar);
            }
            return bVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        public HashMap<String, String> cAJ;

        /* JADX INFO: Access modifiers changed from: private */
        public static d aT(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            d apA = apA();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!apA.cAJ.containsKey(optString)) {
                            apA.cAJ.put(optString, optString2);
                        }
                    }
                }
            }
            return apA;
        }

        private static d apA() {
            d dVar = new d();
            dVar.cAJ = new HashMap<>();
            return dVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public ArrayList<String> cAI;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static c aR(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            c cVar = new c();
            cVar.cAI = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                cVar.cAI.add(optJSONArray.optString(i));
            }
            return cVar;
        }
    }
}
