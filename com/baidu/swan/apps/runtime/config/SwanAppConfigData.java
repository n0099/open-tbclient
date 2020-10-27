package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dnS = new HashMap<>();
    public a dnD;
    public h dnE;
    public i dnF;
    public com.baidu.swan.apps.runtime.config.c dnG;
    public j dnH;
    public f dnI;
    public b.a dnJ;
    public c dnK;
    public c dnL;
    @Nullable
    public d dnM;
    public List<com.baidu.swan.pms.model.h> dnN;
    public String dnO;
    public e dnP;
    public b dnQ;
    @NonNull
    public Set<RequiredBackgroundModeItem> dnR = new HashSet(1);
    public boolean mIsDebug;

    static {
        dnS.put("light", -1);
        dnS.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dnO = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dnL = c.a(jSONObject, file);
            swanAppConfigData.dnK = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dnN = com.baidu.swan.apps.ac.g.b.aa(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.dnD = a.bt(jSONObject);
            swanAppConfigData.dnE = h.e(jSONObject, file);
            swanAppConfigData.dnF = i.a(jSONObject, swanAppConfigData.dnE);
            swanAppConfigData.dnG = com.baidu.swan.apps.runtime.config.c.bH(jSONObject);
            swanAppConfigData.dnH = j.bD(jSONObject);
            swanAppConfigData.dnI = f.bB(jSONObject);
            swanAppConfigData.dnJ = b.a.bs(jSONObject);
            swanAppConfigData.dnP = e.bz(jSONObject);
            swanAppConfigData.dnM = d.bx(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dnR.add(find);
                    }
                }
            }
            swanAppConfigData.dnQ = b.bv(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.auM().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dnG = com.baidu.swan.apps.runtime.config.c.bH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dnH = j.bD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dnO = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int fv(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = rS(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dnS.containsKey(str)) {
                return dnS.get(str).intValue();
            }
            return -1;
        }
    }

    public static String rS(String str) {
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

    public String awX() {
        return aFH() ? this.dnD.mPages.get(0) : "";
    }

    public String rT(String str) {
        if (this.dnE == null || this.dnE.dof == null) {
            return null;
        }
        for (g gVar : this.dnE.dof) {
            if (TextUtils.equals(gVar.dnY, str)) {
                return gVar.awX();
            }
        }
        return null;
    }

    public boolean aFH() {
        return (this.dnD == null || this.dnD.mPages == null || this.dnD.mPages.isEmpty()) ? false : true;
    }

    public boolean aFI() {
        return (this.dnE == null || this.dnE.dof == null || this.dnE.doh == null) ? false : true;
    }

    private boolean aFJ() {
        return (this.dnE == null || this.dnE.dof == null || this.dnE.doi == null) ? false : true;
    }

    public boolean rU(String str) {
        return aFI() && this.dnE.doh.containsKey(str);
    }

    public boolean rV(String str) {
        return aFJ() && this.dnE.doi.containsKey(str);
    }

    public String rL(String str) {
        String sw = com.baidu.swan.apps.scheme.actions.k.j.sw(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sw)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.qT(sw)) {
            return "dynamicLib";
        }
        if (!rU(sw)) {
            return "main";
        }
        if (!rV(sw)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aFK() {
        return this.dnH != null && this.dnH.aFT();
    }

    public boolean rW(String str) {
        return (aFH() && this.dnD.rZ(str)) || (aFI() && this.dnE.doh.containsKey(str));
    }

    public boolean rX(String str) {
        return this.dnH != null && this.dnH.sa(str);
    }

    public String rY(String str) {
        if (this.dnP != null && this.dnP.dnW != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dnP.dnW.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> kg(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dnL, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aBA() && this.dnE != null && (list2 = this.dnE.dof) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dod, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dnK, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aBA() && this.dnE != null && (list = this.dnE.dof) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.doe, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dnU) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bt(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aFL();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aFL();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean rZ(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aFL() {
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
        AUDIO(MediaStreamTrack.AUDIO_TRACK_KIND);
        
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
    public static class j {
        public int dok;
        public int dol;
        public ArrayList<k> dom;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aFU();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aFU();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.fv(optJSONObject.optString("color", "#999999"));
            jVar.dok = SwanAppConfigData.fv(optJSONObject.optString("selectedColor", "black"));
            jVar.dol = SwanAppConfigData.fv(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.fv(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dom = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dom.add(k.bF(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aFT() {
            return this.dom != null && this.dom.size() >= 2;
        }

        public boolean sa(String str) {
            if (this.dom == null) {
                return false;
            }
            for (int i = 0; i < this.dom.size(); i++) {
                if (TextUtils.equals(this.dom.get(i).don, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aFU() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dom = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class f {
        public boolean dnX;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aFP();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aFP();
            }
            com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
            String str = "";
            if (aEU != null) {
                str = aEU.id;
            }
            f fVar = new f();
            fVar.dnX = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.ag.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.ag.a.c.g(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static boolean aFO() {
            SwanAppConfigData awT = com.baidu.swan.apps.v.f.axo().awT();
            if (awT == null) {
                return true;
            }
            f fVar = awT.dnI;
            com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
            b.a aVar = null;
            if (aEU != null) {
                aVar = aEU.ado();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean ajt = com.baidu.swan.apps.console.debugger.a.e.ajt();
            boolean aeD = com.baidu.swan.apps.core.e.aeD();
            boolean aCr = com.baidu.swan.apps.ad.a.a.aCr();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + ajt + " isMobileDebug: " + aeD + " urlCheck: " + fVar.dnX);
            }
            return (b || ajt || aeD || aCr) && !fVar.dnX;
        }

        private static f aFP() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dnX = true;
            return fVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class k {
        public String don;
        public String doo;
        public String dop;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aFV();
            }
            k kVar = new k();
            kVar.don = jSONObject.optString("pagePath");
            kVar.doo = jSONObject.optString("iconPath");
            kVar.dop = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aFV() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes10.dex */
    public static class h {
        public List<g> dof;
        public HashMap<String, Boolean> dog;
        public HashMap<String, String> doh;
        public HashMap<String, String> doi;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aFR();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aFR();
            }
            h hVar = new h();
            hVar.dof = new ArrayList();
            hVar.doh = new HashMap<>();
            hVar.dog = new HashMap<>();
            hVar.doi = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dof.add(g.a(optJSONObject, hVar.doh, hVar.doi, file));
                }
            }
            return hVar;
        }

        private static h aFR() {
            h hVar = new h();
            hVar.dof = new ArrayList();
            hVar.doh = new HashMap<>();
            hVar.dog = new HashMap<>();
            hVar.doi = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class g {
        private static final String dob = File.separator;
        public String dnY;
        public List<String> dnZ;
        boolean doa = false;
        public c dod;
        public c doe;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aFQ();
            }
            g gVar = new g();
            gVar.dnY = jSONObject.optString("root");
            gVar.doa = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dnZ = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dnZ.add(optString);
                    if (!TextUtils.isEmpty(gVar.dnY) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dnY.endsWith(dob) || optString.startsWith(dob)) {
                            str = gVar.dnY + optString;
                        } else {
                            str = gVar.dnY + dob + optString;
                        }
                        hashMap.put(str, gVar.dnY);
                        if (gVar.doa) {
                            hashMap2.put(str, gVar.dnY);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aFQ() {
            g gVar = new g();
            gVar.dnZ = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String awX() {
            if (TextUtils.isEmpty(this.dnY) || this.dnZ == null || this.dnZ.size() <= 0) {
                return null;
            }
            String str = this.dnZ.get(0);
            if (this.dnY.endsWith(dob)) {
                this.dnY = this.dnY.substring(0, this.dnY.length() - 1);
            }
            if (str.startsWith(dob)) {
                str = str.substring(1);
            }
            return this.dnY + dob + str;
        }
    }

    /* loaded from: classes10.dex */
    public static class i {
        public HashMap<String, String> doj;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dof == null || hVar.dof.size() <= 0) {
                return aFS();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aFS();
            }
            i iVar = new i();
            iVar.doj = new HashMap<>();
            for (g gVar : hVar.dof) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dnY)) {
                    iVar.doj.put(gVar.dnY, optJSONObject.optString(gVar.dnY));
                }
            }
            return iVar;
        }

        private static i aFS() {
            i iVar = new i();
            iVar.doj = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dnU;

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
            cVar.dnU = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dfe = next;
                if (file != null && !TextUtils.isEmpty(aVar.dfh)) {
                    aVar.dfh = new File(file, aVar.dfh).getAbsolutePath();
                }
                cVar.dnU.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public HashMap<String, String> dnW;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bz(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aFN = aFN();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aFN.dnW.containsKey(optString)) {
                            aFN.dnW.put(optString, optString2);
                        }
                    }
                }
            }
            return aFN;
        }

        private static e aFN() {
            e eVar = new e();
            eVar.dnW = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public ArrayList<String> dnV;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bx(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dnV = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dnV.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public Map<String, Map<String, String>> dnT;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bv(JSONObject jSONObject) {
            b aFM = aFM();
            if (jSONObject == null) {
                return aFM;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aFM.dnT = new HashMap();
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
                aFM.dnT.put(next, hashMap);
            }
            return aFM;
        }

        private static b aFM() {
            b bVar = new b();
            bVar.dnT = new HashMap();
            return bVar;
        }
    }
}
