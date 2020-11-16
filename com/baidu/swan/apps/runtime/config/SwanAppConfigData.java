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
/* loaded from: classes7.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dsg = new HashMap<>();
    public a drR;
    public h drS;
    public i drT;
    public com.baidu.swan.apps.runtime.config.c drU;
    public j drV;
    public f drW;
    public b.a drX;
    public c drY;
    public c drZ;
    @Nullable
    public d dsa;
    public List<com.baidu.swan.pms.model.h> dsb;
    public String dsc;
    public e dsd;
    public b dse;
    @NonNull
    public Set<RequiredBackgroundModeItem> dsf = new HashSet(1);
    public boolean mIsDebug;

    static {
        dsg.put("light", -1);
        dsg.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dsc = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.drZ = c.a(jSONObject, file);
            swanAppConfigData.drY = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dsb = com.baidu.swan.apps.ac.g.b.aa(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.drR = a.bt(jSONObject);
            swanAppConfigData.drS = h.e(jSONObject, file);
            swanAppConfigData.drT = i.a(jSONObject, swanAppConfigData.drS);
            swanAppConfigData.drU = com.baidu.swan.apps.runtime.config.c.bH(jSONObject);
            swanAppConfigData.drV = j.bD(jSONObject);
            swanAppConfigData.drW = f.bB(jSONObject);
            swanAppConfigData.drX = b.a.bs(jSONObject);
            swanAppConfigData.dsd = e.bz(jSONObject);
            swanAppConfigData.dsa = d.bx(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dsf.add(find);
                    }
                }
            }
            swanAppConfigData.dse = b.bv(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.awE().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.drU = com.baidu.swan.apps.runtime.config.c.bH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.drV = j.bD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dsc = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int sa(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = sb(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dsg.containsKey(str)) {
                return dsg.get(str).intValue();
            }
            return -1;
        }
    }

    public static String sb(String str) {
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

    public String ayP() {
        return aHz() ? this.drR.mPages.get(0) : "";
    }

    public String sc(String str) {
        if (this.drS == null || this.drS.dss == null) {
            return null;
        }
        for (g gVar : this.drS.dss) {
            if (TextUtils.equals(gVar.dsm, str)) {
                return gVar.ayP();
            }
        }
        return null;
    }

    public boolean aHz() {
        return (this.drR == null || this.drR.mPages == null || this.drR.mPages.isEmpty()) ? false : true;
    }

    public boolean aHA() {
        return (this.drS == null || this.drS.dss == null || this.drS.dsv == null) ? false : true;
    }

    private boolean aHB() {
        return (this.drS == null || this.drS.dss == null || this.drS.dsw == null) ? false : true;
    }

    public boolean sd(String str) {
        return aHA() && this.drS.dsv.containsKey(str);
    }

    public boolean se(String str) {
        return aHB() && this.drS.dsw.containsKey(str);
    }

    public String rT(String str) {
        String sF = com.baidu.swan.apps.scheme.actions.k.j.sF(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sF)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.rb(sF)) {
            return "dynamicLib";
        }
        if (!sd(sF)) {
            return "main";
        }
        if (!se(sF)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aHC() {
        return this.drV != null && this.drV.aHL();
    }

    public boolean sf(String str) {
        return (aHz() && this.drR.si(str)) || (aHA() && this.drS.dsv.containsKey(str));
    }

    public boolean sg(String str) {
        return this.drV != null && this.drV.sj(str);
    }

    public String sh(String str) {
        if (this.dsd != null && this.dsd.dsk != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dsd.dsk.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> km(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.drZ, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aDs() && this.drS != null && (list2 = this.drS.dss) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dsq, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.drY, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aDs() && this.drS != null && (list = this.drS.dss) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dsr, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dsi) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bt(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aHD();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aHD();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean si(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aHD() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class j {
        public ArrayList<k> dsA;
        public int dsy;
        public int dsz;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aHM();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aHM();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.sa(optJSONObject.optString("color", "#999999"));
            jVar.dsy = SwanAppConfigData.sa(optJSONObject.optString("selectedColor", "black"));
            jVar.dsz = SwanAppConfigData.sa(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.sa(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dsA = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dsA.add(k.bF(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aHL() {
            return this.dsA != null && this.dsA.size() >= 2;
        }

        public boolean sj(String str) {
            if (this.dsA == null) {
                return false;
            }
            for (int i = 0; i < this.dsA.size(); i++) {
                if (TextUtils.equals(this.dsA.get(i).dsB, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aHM() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dsA = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public boolean dsl;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aHH();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aHH();
            }
            com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
            String str = "";
            if (aGM != null) {
                str = aGM.id;
            }
            f fVar = new f();
            fVar.dsl = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aHG() {
            SwanAppConfigData ayL = com.baidu.swan.apps.v.f.azg().ayL();
            if (ayL == null) {
                return true;
            }
            f fVar = ayL.drW;
            com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
            b.a aVar = null;
            if (aGM != null) {
                aVar = aGM.afg();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean all = com.baidu.swan.apps.console.debugger.a.e.all();
            boolean agv = com.baidu.swan.apps.core.e.agv();
            boolean aEj = com.baidu.swan.apps.ad.a.a.aEj();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + all + " isMobileDebug: " + agv + " urlCheck: " + fVar.dsl);
            }
            return (b || all || agv || aEj) && !fVar.dsl;
        }

        private static f aHH() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dsl = true;
            return fVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class k {
        public String dsB;
        public String dsC;
        public String dsD;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aHN();
            }
            k kVar = new k();
            kVar.dsB = jSONObject.optString("pagePath");
            kVar.dsC = jSONObject.optString("iconPath");
            kVar.dsD = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aHN() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public List<g> dss;
        public HashMap<String, Boolean> dsu;
        public HashMap<String, String> dsv;
        public HashMap<String, String> dsw;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aHJ();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aHJ();
            }
            h hVar = new h();
            hVar.dss = new ArrayList();
            hVar.dsv = new HashMap<>();
            hVar.dsu = new HashMap<>();
            hVar.dsw = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dss.add(g.a(optJSONObject, hVar.dsv, hVar.dsw, file));
                }
            }
            return hVar;
        }

        private static h aHJ() {
            h hVar = new h();
            hVar.dss = new ArrayList();
            hVar.dsv = new HashMap<>();
            hVar.dsu = new HashMap<>();
            hVar.dsw = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class g {
        private static final String dsp = File.separator;
        public String dsm;
        public List<String> dsn;
        boolean dso = false;
        public c dsq;
        public c dsr;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aHI();
            }
            g gVar = new g();
            gVar.dsm = jSONObject.optString("root");
            gVar.dso = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dsn = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dsn.add(optString);
                    if (!TextUtils.isEmpty(gVar.dsm) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dsm.endsWith(dsp) || optString.startsWith(dsp)) {
                            str = gVar.dsm + optString;
                        } else {
                            str = gVar.dsm + dsp + optString;
                        }
                        hashMap.put(str, gVar.dsm);
                        if (gVar.dso) {
                            hashMap2.put(str, gVar.dsm);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aHI() {
            g gVar = new g();
            gVar.dsn = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String ayP() {
            if (TextUtils.isEmpty(this.dsm) || this.dsn == null || this.dsn.size() <= 0) {
                return null;
            }
            String str = this.dsn.get(0);
            if (this.dsm.endsWith(dsp)) {
                this.dsm = this.dsm.substring(0, this.dsm.length() - 1);
            }
            if (str.startsWith(dsp)) {
                str = str.substring(1);
            }
            return this.dsm + dsp + str;
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public HashMap<String, String> dsx;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dss == null || hVar.dss.size() <= 0) {
                return aHK();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aHK();
            }
            i iVar = new i();
            iVar.dsx = new HashMap<>();
            for (g gVar : hVar.dss) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dsm)) {
                    iVar.dsx.put(gVar.dsm, optJSONObject.optString(gVar.dsm));
                }
            }
            return iVar;
        }

        private static i aHK() {
            i iVar = new i();
            iVar.dsx = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dsi;

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
            cVar.dsi = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.djs = next;
                if (file != null && !TextUtils.isEmpty(aVar.djv)) {
                    aVar.djv = new File(file, aVar.djv).getAbsolutePath();
                }
                cVar.dsi.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public HashMap<String, String> dsk;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bz(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aHF = aHF();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aHF.dsk.containsKey(optString)) {
                            aHF.dsk.put(optString, optString2);
                        }
                    }
                }
            }
            return aHF;
        }

        private static e aHF() {
            e eVar = new e();
            eVar.dsk = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public ArrayList<String> dsj;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bx(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dsj = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dsj.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public Map<String, Map<String, String>> dsh;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bv(JSONObject jSONObject) {
            b aHE = aHE();
            if (jSONObject == null) {
                return aHE;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aHE.dsh = new HashMap();
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
                aHE.dsh.put(next, hashMap);
            }
            return aHE;
        }

        private static b aHE() {
            b bVar = new b();
            bVar.dsh = new HashMap();
            return bVar;
        }
    }
}
