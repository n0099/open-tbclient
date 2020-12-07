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
/* loaded from: classes25.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dzh = new HashMap<>();
    public a dyS;
    public h dyT;
    public i dyU;
    public com.baidu.swan.apps.runtime.config.c dyV;
    public j dyW;
    public f dyX;
    public b.a dyY;
    public c dyZ;
    public c dza;
    @Nullable
    public d dzb;
    public List<com.baidu.swan.pms.model.h> dzc;
    public String dzd;
    public e dze;
    public b dzf;
    @NonNull
    public Set<RequiredBackgroundModeItem> dzg = new HashSet(1);
    public boolean mIsDebug;

    static {
        dzh.put("light", -1);
        dzh.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dzd = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dza = c.a(jSONObject, file);
            swanAppConfigData.dyZ = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dzc = com.baidu.swan.apps.ac.g.b.ab(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.dyS = a.bv(jSONObject);
            swanAppConfigData.dyT = h.e(jSONObject, file);
            swanAppConfigData.dyU = i.a(jSONObject, swanAppConfigData.dyT);
            swanAppConfigData.dyV = com.baidu.swan.apps.runtime.config.c.bJ(jSONObject);
            swanAppConfigData.dyW = j.bF(jSONObject);
            swanAppConfigData.dyX = f.bD(jSONObject);
            swanAppConfigData.dyY = b.a.bu(jSONObject);
            swanAppConfigData.dze = e.bB(jSONObject);
            swanAppConfigData.dzb = d.bz(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dzg.add(find);
                    }
                }
            }
            swanAppConfigData.dzf = b.bx(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.azM().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dyV = com.baidu.swan.apps.runtime.config.c.bJ(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dyW = j.bF(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dzd = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int sI(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = sJ(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dzh.containsKey(str)) {
                return dzh.get(str).intValue();
            }
            return -1;
        }
    }

    public static String sJ(String str) {
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

    public String aBY() {
        return aKH() ? this.dyS.mPages.get(0) : "";
    }

    public String sK(String str) {
        if (this.dyT == null || this.dyT.dzt == null) {
            return null;
        }
        for (g gVar : this.dyT.dzt) {
            if (TextUtils.equals(gVar.dzn, str)) {
                return gVar.aBY();
            }
        }
        return null;
    }

    public boolean aKH() {
        return (this.dyS == null || this.dyS.mPages == null || this.dyS.mPages.isEmpty()) ? false : true;
    }

    public boolean aKI() {
        return (this.dyT == null || this.dyT.dzt == null || this.dyT.dzv == null) ? false : true;
    }

    private boolean aKJ() {
        return (this.dyT == null || this.dyT.dzt == null || this.dyT.dzw == null) ? false : true;
    }

    public boolean sL(String str) {
        return aKI() && this.dyT.dzv.containsKey(str);
    }

    public boolean sM(String str) {
        return aKJ() && this.dyT.dzw.containsKey(str);
    }

    public String sB(String str) {
        String tm = com.baidu.swan.apps.scheme.actions.k.j.tm(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(tm)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.rI(tm)) {
            return "dynamicLib";
        }
        if (!sL(tm)) {
            return "main";
        }
        if (!sM(tm)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aKK() {
        return this.dyW != null && this.dyW.aKT();
    }

    public boolean sN(String str) {
        return (aKH() && this.dyS.sQ(str)) || (aKI() && this.dyT.dzv.containsKey(str));
    }

    public boolean sO(String str) {
        return this.dyW != null && this.dyW.sR(str);
    }

    public String sP(String str) {
        if (this.dze != null && this.dze.dzl != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dze.dzl.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> kK(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dza, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aGA() && this.dyT != null && (list2 = this.dyT.dzt) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dzr, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dyZ, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aGA() && this.dyT != null && (list = this.dyT.dzt) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dzs, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dzj) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes25.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bv(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aKL();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aKL();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean sQ(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aKL() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public static class j {
        public ArrayList<k> dzA;
        public int dzy;
        public int dzz;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bF(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aKU();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aKU();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.sI(optJSONObject.optString("color", "#999999"));
            jVar.dzy = SwanAppConfigData.sI(optJSONObject.optString("selectedColor", "black"));
            jVar.dzz = SwanAppConfigData.sI(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.sI(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dzA = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dzA.add(k.bH(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aKT() {
            return this.dzA != null && this.dzA.size() >= 2;
        }

        public boolean sR(String str) {
            if (this.dzA == null) {
                return false;
            }
            for (int i = 0; i < this.dzA.size(); i++) {
                if (TextUtils.equals(this.dzA.get(i).dzB, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aKU() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dzA = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class f {
        public boolean dzm;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bD(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aKP();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aKP();
            }
            com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
            String str = "";
            if (aJU != null) {
                str = aJU.id;
            }
            f fVar = new f();
            fVar.dzm = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aKO() {
            SwanAppConfigData aBU = com.baidu.swan.apps.v.f.aCp().aBU();
            if (aBU == null) {
                return true;
            }
            f fVar = aBU.dyX;
            com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
            b.a aVar = null;
            if (aJU != null) {
                aVar = aJU.aio();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean aot = com.baidu.swan.apps.console.debugger.a.e.aot();
            boolean ajD = com.baidu.swan.apps.core.e.ajD();
            boolean aHr = com.baidu.swan.apps.ad.a.a.aHr();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + aot + " isMobileDebug: " + ajD + " urlCheck: " + fVar.dzm);
            }
            return (b || aot || ajD || aHr) && !fVar.dzm;
        }

        private static f aKP() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dzm = true;
            return fVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class k {
        public String dzB;
        public String dzC;
        public String dzD;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bH(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aKV();
            }
            k kVar = new k();
            kVar.dzB = jSONObject.optString("pagePath");
            kVar.dzC = jSONObject.optString("iconPath");
            kVar.dzD = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aKV() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes25.dex */
    public static class h {
        public List<g> dzt;
        public HashMap<String, Boolean> dzu;
        public HashMap<String, String> dzv;
        public HashMap<String, String> dzw;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aKR();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aKR();
            }
            h hVar = new h();
            hVar.dzt = new ArrayList();
            hVar.dzv = new HashMap<>();
            hVar.dzu = new HashMap<>();
            hVar.dzw = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dzt.add(g.a(optJSONObject, hVar.dzv, hVar.dzw, file));
                }
            }
            return hVar;
        }

        private static h aKR() {
            h hVar = new h();
            hVar.dzt = new ArrayList();
            hVar.dzv = new HashMap<>();
            hVar.dzu = new HashMap<>();
            hVar.dzw = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class g {
        private static final String dzq = File.separator;
        public String dzn;
        public List<String> dzo;
        boolean dzp = false;
        public c dzr;
        public c dzs;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aKQ();
            }
            g gVar = new g();
            gVar.dzn = jSONObject.optString("root");
            gVar.dzp = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dzo = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dzo.add(optString);
                    if (!TextUtils.isEmpty(gVar.dzn) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dzn.endsWith(dzq) || optString.startsWith(dzq)) {
                            str = gVar.dzn + optString;
                        } else {
                            str = gVar.dzn + dzq + optString;
                        }
                        hashMap.put(str, gVar.dzn);
                        if (gVar.dzp) {
                            hashMap2.put(str, gVar.dzn);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aKQ() {
            g gVar = new g();
            gVar.dzo = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aBY() {
            if (TextUtils.isEmpty(this.dzn) || this.dzo == null || this.dzo.size() <= 0) {
                return null;
            }
            String str = this.dzo.get(0);
            if (this.dzn.endsWith(dzq)) {
                this.dzn = this.dzn.substring(0, this.dzn.length() - 1);
            }
            if (str.startsWith(dzq)) {
                str = str.substring(1);
            }
            return this.dzn + dzq + str;
        }
    }

    /* loaded from: classes25.dex */
    public static class i {
        public HashMap<String, String> dzx;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dzt == null || hVar.dzt.size() <= 0) {
                return aKS();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aKS();
            }
            i iVar = new i();
            iVar.dzx = new HashMap<>();
            for (g gVar : hVar.dzt) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dzn)) {
                    iVar.dzx.put(gVar.dzn, optJSONObject.optString(gVar.dzn));
                }
            }
            return iVar;
        }

        private static i aKS() {
            i iVar = new i();
            iVar.dzx = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dzj;

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
            cVar.dzj = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dqr = next;
                if (file != null && !TextUtils.isEmpty(aVar.dqu)) {
                    aVar.dqu = new File(file, aVar.dqu).getAbsolutePath();
                }
                cVar.dzj.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class e {
        public HashMap<String, String> dzl;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bB(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aKN = aKN();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aKN.dzl.containsKey(optString)) {
                            aKN.dzl.put(optString, optString2);
                        }
                    }
                }
            }
            return aKN;
        }

        private static e aKN() {
            e eVar = new e();
            eVar.dzl = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class d {
        public ArrayList<String> dzk;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bz(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dzk = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dzk.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes25.dex */
    public static class b {
        public Map<String, Map<String, String>> dzi;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bx(JSONObject jSONObject) {
            b aKM = aKM();
            if (jSONObject == null) {
                return aKM;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aKM.dzi = new HashMap();
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
                aKM.dzi.put(next, hashMap);
            }
            return aKM;
        }

        private static b aKM() {
            b bVar = new b();
            bVar.dzi = new HashMap();
            return bVar;
        }
    }
}
