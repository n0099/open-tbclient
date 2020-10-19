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
    private static final HashMap<String, Integer> dfs = new HashMap<>();
    public a dfd;
    public h dfe;
    public i dff;
    public com.baidu.swan.apps.runtime.config.c dfg;
    public j dfh;
    public f dfi;
    public b.a dfj;
    public c dfk;
    public c dfl;
    @Nullable
    public d dfm;
    public List<com.baidu.swan.pms.model.h> dfn;
    public String dfo;
    public e dfp;
    public b dfq;
    @NonNull
    public Set<RequiredBackgroundModeItem> dfr = new HashSet(1);
    public boolean mIsDebug;

    static {
        dfs.put("light", -1);
        dfs.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dfo = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dfl = c.a(jSONObject, file);
            swanAppConfigData.dfk = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dfn = com.baidu.swan.apps.ac.g.b.Y(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.dfd = a.bq(jSONObject);
            swanAppConfigData.dfe = h.e(jSONObject, file);
            swanAppConfigData.dff = i.a(jSONObject, swanAppConfigData.dfe);
            swanAppConfigData.dfg = com.baidu.swan.apps.runtime.config.c.bE(jSONObject);
            swanAppConfigData.dfh = j.bA(jSONObject);
            swanAppConfigData.dfi = f.by(jSONObject);
            swanAppConfigData.dfj = b.a.bp(jSONObject);
            swanAppConfigData.dfp = e.bw(jSONObject);
            swanAppConfigData.dfm = d.bu(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dfr.add(find);
                    }
                }
            }
            swanAppConfigData.dfq = b.bs(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.asS().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dfg = com.baidu.swan.apps.runtime.config.c.bE(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dfh = j.bA(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dfo = jSONObject.toString();
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
            str = rz(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dfs.containsKey(str)) {
                return dfs.get(str).intValue();
            }
            return -1;
        }
    }

    public static String rz(String str) {
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

    public String avd() {
        return aDN() ? this.dfd.mPages.get(0) : "";
    }

    public String rA(String str) {
        if (this.dfe == null || this.dfe.dfE == null) {
            return null;
        }
        for (g gVar : this.dfe.dfE) {
            if (TextUtils.equals(gVar.dfy, str)) {
                return gVar.avd();
            }
        }
        return null;
    }

    public boolean aDN() {
        return (this.dfd == null || this.dfd.mPages == null || this.dfd.mPages.isEmpty()) ? false : true;
    }

    public boolean aDO() {
        return (this.dfe == null || this.dfe.dfE == null || this.dfe.dfG == null) ? false : true;
    }

    private boolean aDP() {
        return (this.dfe == null || this.dfe.dfE == null || this.dfe.dfH == null) ? false : true;
    }

    public boolean rB(String str) {
        return aDO() && this.dfe.dfG.containsKey(str);
    }

    public boolean rC(String str) {
        return aDP() && this.dfe.dfH.containsKey(str);
    }

    public String rs(String str) {
        String sc = com.baidu.swan.apps.scheme.actions.k.j.sc(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sc)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.qA(sc)) {
            return "dynamicLib";
        }
        if (!rB(sc)) {
            return "main";
        }
        if (!rC(sc)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aDQ() {
        return this.dfh != null && this.dfh.aDZ();
    }

    public boolean rD(String str) {
        return (aDN() && this.dfd.rG(str)) || (aDO() && this.dfe.dfG.containsKey(str));
    }

    public boolean rE(String str) {
        return this.dfh != null && this.dfh.rH(str);
    }

    public String rF(String str) {
        if (this.dfp != null && this.dfp.dfw != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dfp.dfw.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jV(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dfl, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.azG() && this.dfe != null && (list2 = this.dfe.dfE) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dfC, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dfk, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.azG() && this.dfe != null && (list = this.dfe.dfE) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dfD, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dfu) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aDR();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aDR();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean rG(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aDR() {
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
        public int dfJ;
        public int dfK;
        public ArrayList<k> dfL;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bA(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aEa();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aEa();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.fv(optJSONObject.optString("color", "#999999"));
            jVar.dfJ = SwanAppConfigData.fv(optJSONObject.optString("selectedColor", "black"));
            jVar.dfK = SwanAppConfigData.fv(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.fv(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dfL = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dfL.add(k.bC(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aDZ() {
            return this.dfL != null && this.dfL.size() >= 2;
        }

        public boolean rH(String str) {
            if (this.dfL == null) {
                return false;
            }
            for (int i = 0; i < this.dfL.size(); i++) {
                if (TextUtils.equals(this.dfL.get(i).dfM, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aEa() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dfL = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class f {
        public boolean dfx;

        /* JADX INFO: Access modifiers changed from: private */
        public static f by(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aDV();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aDV();
            }
            com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
            String str = "";
            if (aDa != null) {
                str = aDa.id;
            }
            f fVar = new f();
            fVar.dfx = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aDU() {
            SwanAppConfigData auZ = com.baidu.swan.apps.v.f.avu().auZ();
            if (auZ == null) {
                return true;
            }
            f fVar = auZ.dfi;
            com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
            b.a aVar = null;
            if (aDa != null) {
                aVar = aDa.abu();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean ahz = com.baidu.swan.apps.console.debugger.a.e.ahz();
            boolean acJ = com.baidu.swan.apps.core.e.acJ();
            boolean aAx = com.baidu.swan.apps.ad.a.a.aAx();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + ahz + " isMobileDebug: " + acJ + " urlCheck: " + fVar.dfx);
            }
            return (b || ahz || acJ || aAx) && !fVar.dfx;
        }

        private static f aDV() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dfx = true;
            return fVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class k {
        public String dfM;
        public String dfN;
        public String dfO;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aEb();
            }
            k kVar = new k();
            kVar.dfM = jSONObject.optString("pagePath");
            kVar.dfN = jSONObject.optString("iconPath");
            kVar.dfO = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aEb() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes10.dex */
    public static class h {
        public List<g> dfE;
        public HashMap<String, Boolean> dfF;
        public HashMap<String, String> dfG;
        public HashMap<String, String> dfH;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aDX();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aDX();
            }
            h hVar = new h();
            hVar.dfE = new ArrayList();
            hVar.dfG = new HashMap<>();
            hVar.dfF = new HashMap<>();
            hVar.dfH = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dfE.add(g.a(optJSONObject, hVar.dfG, hVar.dfH, file));
                }
            }
            return hVar;
        }

        private static h aDX() {
            h hVar = new h();
            hVar.dfE = new ArrayList();
            hVar.dfG = new HashMap<>();
            hVar.dfF = new HashMap<>();
            hVar.dfH = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class g {
        private static final String dfB = File.separator;
        boolean dfA = false;
        public c dfC;
        public c dfD;
        public String dfy;
        public List<String> dfz;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aDW();
            }
            g gVar = new g();
            gVar.dfy = jSONObject.optString("root");
            gVar.dfA = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dfz = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dfz.add(optString);
                    if (!TextUtils.isEmpty(gVar.dfy) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dfy.endsWith(dfB) || optString.startsWith(dfB)) {
                            str = gVar.dfy + optString;
                        } else {
                            str = gVar.dfy + dfB + optString;
                        }
                        hashMap.put(str, gVar.dfy);
                        if (gVar.dfA) {
                            hashMap2.put(str, gVar.dfy);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aDW() {
            g gVar = new g();
            gVar.dfz = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String avd() {
            if (TextUtils.isEmpty(this.dfy) || this.dfz == null || this.dfz.size() <= 0) {
                return null;
            }
            String str = this.dfz.get(0);
            if (this.dfy.endsWith(dfB)) {
                this.dfy = this.dfy.substring(0, this.dfy.length() - 1);
            }
            if (str.startsWith(dfB)) {
                str = str.substring(1);
            }
            return this.dfy + dfB + str;
        }
    }

    /* loaded from: classes10.dex */
    public static class i {
        public HashMap<String, String> dfI;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dfE == null || hVar.dfE.size() <= 0) {
                return aDY();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aDY();
            }
            i iVar = new i();
            iVar.dfI = new HashMap<>();
            for (g gVar : hVar.dfE) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dfy)) {
                    iVar.dfI.put(gVar.dfy, optJSONObject.optString(gVar.dfy));
                }
            }
            return iVar;
        }

        private static i aDY() {
            i iVar = new i();
            iVar.dfI = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dfu;

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
            cVar.dfu = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cWD = next;
                if (file != null && !TextUtils.isEmpty(aVar.cWG)) {
                    aVar.cWG = new File(file, aVar.cWG).getAbsolutePath();
                }
                cVar.dfu.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public HashMap<String, String> dfw;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bw(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aDT = aDT();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aDT.dfw.containsKey(optString)) {
                            aDT.dfw.put(optString, optString2);
                        }
                    }
                }
            }
            return aDT;
        }

        private static e aDT() {
            e eVar = new e();
            eVar.dfw = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public ArrayList<String> dfv;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bu(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dfv = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dfv.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public Map<String, Map<String, String>> dft;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bs(JSONObject jSONObject) {
            b aDS = aDS();
            if (jSONObject == null) {
                return aDS;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aDS.dft = new HashMap();
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
                aDS.dft.put(next, hashMap);
            }
            return aDS;
        }

        private static b aDS() {
            b bVar = new b();
            bVar.dft = new HashMap();
            return bVar;
        }
    }
}
