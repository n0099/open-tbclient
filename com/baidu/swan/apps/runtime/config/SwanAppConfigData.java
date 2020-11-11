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
    private static final HashMap<String, Integer> dtP = new HashMap<>();
    public a dtA;
    public h dtB;
    public i dtC;
    public com.baidu.swan.apps.runtime.config.c dtD;
    public j dtE;
    public f dtF;
    public b.a dtG;
    public c dtH;
    public c dtI;
    @Nullable
    public d dtJ;
    public List<com.baidu.swan.pms.model.h> dtK;
    public String dtL;
    public e dtM;
    public b dtN;
    @NonNull
    public Set<RequiredBackgroundModeItem> dtO = new HashSet(1);
    public boolean mIsDebug;

    static {
        dtP.put("light", -1);
        dtP.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dtL = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dtI = c.a(jSONObject, file);
            swanAppConfigData.dtH = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dtK = com.baidu.swan.apps.ac.g.b.aa(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.dtA = a.bz(jSONObject);
            swanAppConfigData.dtB = h.e(jSONObject, file);
            swanAppConfigData.dtC = i.a(jSONObject, swanAppConfigData.dtB);
            swanAppConfigData.dtD = com.baidu.swan.apps.runtime.config.c.bN(jSONObject);
            swanAppConfigData.dtE = j.bJ(jSONObject);
            swanAppConfigData.dtF = f.bH(jSONObject);
            swanAppConfigData.dtG = b.a.by(jSONObject);
            swanAppConfigData.dtM = e.bF(jSONObject);
            swanAppConfigData.dtJ = d.bD(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dtO.add(find);
                    }
                }
            }
            swanAppConfigData.dtN = b.bB(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.axm().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dtD = com.baidu.swan.apps.runtime.config.c.bN(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dtE = j.bJ(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dtL = jSONObject.toString();
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
            str = sg(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dtP.containsKey(str)) {
                return dtP.get(str).intValue();
            }
            return -1;
        }
    }

    public static String sg(String str) {
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

    public String azx() {
        return aIh() ? this.dtA.mPages.get(0) : "";
    }

    public String sh(String str) {
        if (this.dtB == null || this.dtB.dub == null) {
            return null;
        }
        for (g gVar : this.dtB.dub) {
            if (TextUtils.equals(gVar.dtV, str)) {
                return gVar.azx();
            }
        }
        return null;
    }

    public boolean aIh() {
        return (this.dtA == null || this.dtA.mPages == null || this.dtA.mPages.isEmpty()) ? false : true;
    }

    public boolean aIi() {
        return (this.dtB == null || this.dtB.dub == null || this.dtB.dud == null) ? false : true;
    }

    private boolean aIj() {
        return (this.dtB == null || this.dtB.dub == null || this.dtB.due == null) ? false : true;
    }

    public boolean si(String str) {
        return aIi() && this.dtB.dud.containsKey(str);
    }

    public boolean sj(String str) {
        return aIj() && this.dtB.due.containsKey(str);
    }

    public String rZ(String str) {
        String sK = com.baidu.swan.apps.scheme.actions.k.j.sK(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sK)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.rh(sK)) {
            return "dynamicLib";
        }
        if (!si(sK)) {
            return "main";
        }
        if (!sj(sK)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aIk() {
        return this.dtE != null && this.dtE.aIt();
    }

    public boolean sk(String str) {
        return (aIh() && this.dtA.sn(str)) || (aIi() && this.dtB.dud.containsKey(str));
    }

    public boolean sl(String str) {
        return this.dtE != null && this.dtE.so(str);
    }

    public String sm(String str) {
        if (this.dtM != null && this.dtM.dtT != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dtM.dtT.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> kq(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dtI, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aEa() && this.dtB != null && (list2 = this.dtB.dub) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dtZ, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dtH, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aEa() && this.dtB != null && (list = this.dtB.dub) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dua, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dtR) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bz(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aIl();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aIl();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean sn(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aIl() {
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
        public int dug;
        public int duh;
        public ArrayList<k> dui;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bJ(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aIu();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aIu();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.fv(optJSONObject.optString("color", "#999999"));
            jVar.dug = SwanAppConfigData.fv(optJSONObject.optString("selectedColor", "black"));
            jVar.duh = SwanAppConfigData.fv(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.fv(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dui = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dui.add(k.bL(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aIt() {
            return this.dui != null && this.dui.size() >= 2;
        }

        public boolean so(String str) {
            if (this.dui == null) {
                return false;
            }
            for (int i = 0; i < this.dui.size(); i++) {
                if (TextUtils.equals(this.dui.get(i).duj, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aIu() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dui = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class f {
        public boolean dtU;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bH(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aIp();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aIp();
            }
            com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
            String str = "";
            if (aHu != null) {
                str = aHu.id;
            }
            f fVar = new f();
            fVar.dtU = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.ag.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.ag.a.c.i(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static boolean aIo() {
            SwanAppConfigData azt = com.baidu.swan.apps.v.f.azO().azt();
            if (azt == null) {
                return true;
            }
            f fVar = azt.dtF;
            com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
            b.a aVar = null;
            if (aHu != null) {
                aVar = aHu.afO();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean alT = com.baidu.swan.apps.console.debugger.a.e.alT();
            boolean ahd = com.baidu.swan.apps.core.e.ahd();
            boolean aER = com.baidu.swan.apps.ad.a.a.aER();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + alT + " isMobileDebug: " + ahd + " urlCheck: " + fVar.dtU);
            }
            return (b || alT || ahd || aER) && !fVar.dtU;
        }

        private static f aIp() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dtU = true;
            return fVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class k {
        public String duj;
        public String duk;
        public String dul;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bL(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aIv();
            }
            k kVar = new k();
            kVar.duj = jSONObject.optString("pagePath");
            kVar.duk = jSONObject.optString("iconPath");
            kVar.dul = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aIv() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes10.dex */
    public static class h {
        public List<g> dub;
        public HashMap<String, Boolean> duc;
        public HashMap<String, String> dud;
        public HashMap<String, String> due;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aIr();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aIr();
            }
            h hVar = new h();
            hVar.dub = new ArrayList();
            hVar.dud = new HashMap<>();
            hVar.duc = new HashMap<>();
            hVar.due = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dub.add(g.a(optJSONObject, hVar.dud, hVar.due, file));
                }
            }
            return hVar;
        }

        private static h aIr() {
            h hVar = new h();
            hVar.dub = new ArrayList();
            hVar.dud = new HashMap<>();
            hVar.duc = new HashMap<>();
            hVar.due = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class g {
        private static final String dtY = File.separator;
        public String dtV;
        public List<String> dtW;
        boolean dtX = false;
        public c dtZ;
        public c dua;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aIq();
            }
            g gVar = new g();
            gVar.dtV = jSONObject.optString("root");
            gVar.dtX = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dtW = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dtW.add(optString);
                    if (!TextUtils.isEmpty(gVar.dtV) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dtV.endsWith(dtY) || optString.startsWith(dtY)) {
                            str = gVar.dtV + optString;
                        } else {
                            str = gVar.dtV + dtY + optString;
                        }
                        hashMap.put(str, gVar.dtV);
                        if (gVar.dtX) {
                            hashMap2.put(str, gVar.dtV);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aIq() {
            g gVar = new g();
            gVar.dtW = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String azx() {
            if (TextUtils.isEmpty(this.dtV) || this.dtW == null || this.dtW.size() <= 0) {
                return null;
            }
            String str = this.dtW.get(0);
            if (this.dtV.endsWith(dtY)) {
                this.dtV = this.dtV.substring(0, this.dtV.length() - 1);
            }
            if (str.startsWith(dtY)) {
                str = str.substring(1);
            }
            return this.dtV + dtY + str;
        }
    }

    /* loaded from: classes10.dex */
    public static class i {
        public HashMap<String, String> duf;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dub == null || hVar.dub.size() <= 0) {
                return aIs();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aIs();
            }
            i iVar = new i();
            iVar.duf = new HashMap<>();
            for (g gVar : hVar.dub) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dtV)) {
                    iVar.duf.put(gVar.dtV, optJSONObject.optString(gVar.dtV));
                }
            }
            return iVar;
        }

        private static i aIs() {
            i iVar = new i();
            iVar.duf = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dtR;

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
            cVar.dtR = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dkZ = next;
                if (file != null && !TextUtils.isEmpty(aVar.dlc)) {
                    aVar.dlc = new File(file, aVar.dlc).getAbsolutePath();
                }
                cVar.dtR.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public HashMap<String, String> dtT;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bF(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aIn = aIn();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aIn.dtT.containsKey(optString)) {
                            aIn.dtT.put(optString, optString2);
                        }
                    }
                }
            }
            return aIn;
        }

        private static e aIn() {
            e eVar = new e();
            eVar.dtT = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public ArrayList<String> dtS;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bD(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dtS = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dtS.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public Map<String, Map<String, String>> dtQ;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bB(JSONObject jSONObject) {
            b aIm = aIm();
            if (jSONObject == null) {
                return aIm;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aIm.dtQ = new HashMap();
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
                aIm.dtQ.put(next, hashMap);
            }
            return aIm;
        }

        private static b aIm() {
            b bVar = new b();
            bVar.dtQ = new HashMap();
            return bVar;
        }
    }
}
