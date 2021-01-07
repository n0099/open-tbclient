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
/* loaded from: classes9.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dHM = new HashMap<>();
    public boolean dFO;
    public com.baidu.swan.apps.runtime.config.c dHA;
    public j dHB;
    public f dHC;
    public b.a dHD;
    public c dHE;
    public c dHF;
    @Nullable
    public d dHG;
    public List<com.baidu.swan.pms.model.h> dHH;
    public String dHI;
    public e dHJ;
    public b dHK;
    @NonNull
    public Set<RequiredBackgroundModeItem> dHL = new HashSet(1);
    public a dHx;
    public h dHy;
    public i dHz;

    static {
        dHM.put("light", -1);
        dHM.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData o(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dHI = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dHF = c.a(jSONObject, file);
            swanAppConfigData.dHE = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dHH = com.baidu.swan.apps.ac.g.b.ab(optJSONArray.toString(), false);
            }
            swanAppConfigData.dFO = jSONObject.optBoolean("debug");
            swanAppConfigData.dHx = a.bD(jSONObject);
            swanAppConfigData.dHy = h.e(jSONObject, file);
            swanAppConfigData.dHz = i.a(jSONObject, swanAppConfigData.dHy);
            swanAppConfigData.dHA = com.baidu.swan.apps.runtime.config.c.bR(jSONObject);
            swanAppConfigData.dHB = j.bN(jSONObject);
            swanAppConfigData.dHC = f.bL(jSONObject);
            swanAppConfigData.dHD = b.a.bC(jSONObject);
            swanAppConfigData.dHJ = e.bJ(jSONObject);
            swanAppConfigData.dHG = d.bH(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dHL.add(find);
                    }
                }
            }
            swanAppConfigData.dHK = b.bF(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.aBe().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dHA = com.baidu.swan.apps.runtime.config.c.bR(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dHB = j.bN(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dHI = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int sF(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = sG(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dHM.containsKey(str)) {
                return dHM.get(str).intValue();
            }
            return -1;
        }
    }

    public static String sG(String str) {
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

    public String aDq() {
        return aMY() ? this.dHx.mPages.get(0) : "";
    }

    public String sH(String str) {
        if (this.dHy == null || this.dHy.dHY == null) {
            return null;
        }
        for (g gVar : this.dHy.dHY) {
            if (TextUtils.equals(gVar.dHS, str)) {
                return gVar.aDq();
            }
        }
        return null;
    }

    public boolean aMY() {
        return (this.dHx == null || this.dHx.mPages == null || this.dHx.mPages.isEmpty()) ? false : true;
    }

    public boolean aMZ() {
        return (this.dHy == null || this.dHy.dHY == null || this.dHy.dIa == null) ? false : true;
    }

    private boolean aNa() {
        return (this.dHy == null || this.dHy.dHY == null || this.dHy.dIb == null) ? false : true;
    }

    public boolean sI(String str) {
        return aMZ() && this.dHy.dIa.containsKey(str);
    }

    public boolean sJ(String str) {
        return aNa() && this.dHy.dIb.containsKey(str);
    }

    public String sy(String str) {
        String tj = com.baidu.swan.apps.scheme.actions.k.j.tj(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(tj)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.rB(tj)) {
            return "dynamicLib";
        }
        if (!sI(tj)) {
            return "main";
        }
        if (!sJ(tj)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aNb() {
        return this.dHB != null && this.dHB.aNk();
    }

    public boolean sK(String str) {
        return (aMY() && this.dHx.sN(str)) || (aMZ() && this.dHy.dIa.containsKey(str));
    }

    public boolean sL(String str) {
        return this.dHB != null && this.dHB.sO(str);
    }

    public String sM(String str) {
        if (this.dHJ != null && this.dHJ.dHQ != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dHJ.dHQ.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> kQ(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dHF, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aHU() && this.dHy != null && (list2 = this.dHy.dHY) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dHW, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dHE, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aHU() && this.dHy != null && (list = this.dHy.dHY) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dHX, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dHO) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bD(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aNc();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aNc();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean sN(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aNc() {
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
    public static class j {
        public int dId;
        public int dIe;
        public ArrayList<k> dIf;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bN(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aNl();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aNl();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.sF(optJSONObject.optString("color", "#999999"));
            jVar.dId = SwanAppConfigData.sF(optJSONObject.optString("selectedColor", "black"));
            jVar.dIe = SwanAppConfigData.sF(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.sF(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dIf = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dIf.add(k.bP(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aNk() {
            return this.dIf != null && this.dIf.size() >= 2;
        }

        public boolean sO(String str) {
            if (this.dIf == null) {
                return false;
            }
            for (int i = 0; i < this.dIf.size(); i++) {
                if (TextUtils.equals(this.dIf.get(i).dIg, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aNl() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dIf = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public boolean dHR;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bL(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aNg();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aNg();
            }
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            String str = "";
            if (aMl != null) {
                str = aMl.id;
            }
            f fVar = new f();
            fVar.dHR = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.af.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.af.a.c.j(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static boolean aNf() {
            SwanAppConfigData aDm = com.baidu.swan.apps.v.f.aDH().aDm();
            if (aDm == null) {
                return true;
            }
            f fVar = aDm.dHC;
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            b.a aVar = null;
            if (aMl != null) {
                aVar = aMl.ajv();
            }
            boolean b2 = com.baidu.swan.apps.f.a.b(aVar);
            boolean apH = com.baidu.swan.apps.console.debugger.a.e.apH();
            boolean akM = com.baidu.swan.apps.core.e.akM();
            boolean aIL = com.baidu.swan.apps.ad.a.a.aIL();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b2 + " isRemoteDebug: " + apH + " isMobileDebug: " + akM + " urlCheck: " + fVar.dHR);
            }
            return (b2 || apH || akM || aIL) && !fVar.dHR;
        }

        private static f aNg() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dHR = true;
            return fVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class k {
        public String dIg;
        public String dIh;
        public String dIi;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bP(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aNm();
            }
            k kVar = new k();
            kVar.dIg = jSONObject.optString("pagePath");
            kVar.dIh = jSONObject.optString("iconPath");
            kVar.dIi = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aNm() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public List<g> dHY;
        public HashMap<String, Boolean> dHZ;
        public HashMap<String, String> dIa;
        public HashMap<String, String> dIb;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aNi();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aNi();
            }
            h hVar = new h();
            hVar.dHY = new ArrayList();
            hVar.dIa = new HashMap<>();
            hVar.dHZ = new HashMap<>();
            hVar.dIb = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dHY.add(g.a(optJSONObject, hVar.dIa, hVar.dIb, file));
                }
            }
            return hVar;
        }

        private static h aNi() {
            h hVar = new h();
            hVar.dHY = new ArrayList();
            hVar.dIa = new HashMap<>();
            hVar.dHZ = new HashMap<>();
            hVar.dIb = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        private static final String dHV = File.separator;
        public String dHS;
        public List<String> dHT;
        boolean dHU = false;
        public c dHW;
        public c dHX;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aNh();
            }
            g gVar = new g();
            gVar.dHS = jSONObject.optString("root");
            gVar.dHU = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dHT = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dHT.add(optString);
                    if (!TextUtils.isEmpty(gVar.dHS) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dHS.endsWith(dHV) || optString.startsWith(dHV)) {
                            str = gVar.dHS + optString;
                        } else {
                            str = gVar.dHS + dHV + optString;
                        }
                        hashMap.put(str, gVar.dHS);
                        if (gVar.dHU) {
                            hashMap2.put(str, gVar.dHS);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aNh() {
            g gVar = new g();
            gVar.dHT = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aDq() {
            if (TextUtils.isEmpty(this.dHS) || this.dHT == null || this.dHT.size() <= 0) {
                return null;
            }
            String str = this.dHT.get(0);
            if (this.dHS.endsWith(dHV)) {
                this.dHS = this.dHS.substring(0, this.dHS.length() - 1);
            }
            if (str.startsWith(dHV)) {
                str = str.substring(1);
            }
            return this.dHS + dHV + str;
        }
    }

    /* loaded from: classes9.dex */
    public static class i {
        public HashMap<String, String> dIc;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dHY == null || hVar.dHY.size() <= 0) {
                return aNj();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aNj();
            }
            i iVar = new i();
            iVar.dIc = new HashMap<>();
            for (g gVar : hVar.dHY) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dHS)) {
                    iVar.dIc.put(gVar.dHS, optJSONObject.optString(gVar.dHS));
                }
            }
            return iVar;
        }

        private static i aNj() {
            i iVar = new i();
            iVar.dIc = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dHO;

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
            cVar.dHO = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dvq = next;
                if (file != null && !TextUtils.isEmpty(aVar.dvt)) {
                    aVar.dvt = new File(file, aVar.dvt).getAbsolutePath();
                }
                cVar.dHO.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public HashMap<String, String> dHQ;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bJ(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aNe = aNe();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aNe.dHQ.containsKey(optString)) {
                            aNe.dHQ.put(optString, optString2);
                        }
                    }
                }
            }
            return aNe;
        }

        private static e aNe() {
            e eVar = new e();
            eVar.dHQ = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public ArrayList<String> dHP;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bH(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dHP = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dHP.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public Map<String, Map<String, String>> dHN;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bF(JSONObject jSONObject) {
            b aNd = aNd();
            if (jSONObject == null) {
                return aNd;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aNd.dHN = new HashMap();
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
                aNd.dHN.put(next, hashMap);
            }
            return aNd;
        }

        private static b aNd() {
            b bVar = new b();
            bVar.dHN = new HashMap();
            return bVar;
        }
    }
}
