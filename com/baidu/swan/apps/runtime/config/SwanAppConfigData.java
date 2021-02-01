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
    private static final HashMap<String, Integer> dFe = new HashMap<>();
    public a dEP;
    public h dEQ;
    public i dER;
    public com.baidu.swan.apps.runtime.config.c dES;
    public j dET;
    public f dEU;
    public b.a dEV;
    public c dEW;
    public c dEX;
    @Nullable
    public d dEY;
    public List<com.baidu.swan.pms.model.h> dEZ;
    public String dFa;
    public e dFb;
    public b dFc;
    @NonNull
    public Set<RequiredBackgroundModeItem> dFd = new HashSet(1);
    public boolean mIsDebug;

    static {
        dFe.put("light", -1);
        dFe.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData o(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dFa = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dEX = c.a(jSONObject, file);
            swanAppConfigData.dEW = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dEZ = com.baidu.swan.apps.ac.g.b.aa(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.dEP = a.bA(jSONObject);
            swanAppConfigData.dEQ = h.e(jSONObject, file);
            swanAppConfigData.dER = i.a(jSONObject, swanAppConfigData.dEQ);
            swanAppConfigData.dES = com.baidu.swan.apps.runtime.config.c.bO(jSONObject);
            swanAppConfigData.dET = j.bK(jSONObject);
            swanAppConfigData.dEU = f.bI(jSONObject);
            swanAppConfigData.dEV = b.a.bz(jSONObject);
            swanAppConfigData.dFb = e.bG(jSONObject);
            swanAppConfigData.dEY = d.bE(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dFd.add(find);
                    }
                }
            }
            swanAppConfigData.dFc = b.bC(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.axI().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dES = com.baidu.swan.apps.runtime.config.c.bO(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dET = j.bK(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dFa = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int rM(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = rN(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dFe.containsKey(str)) {
                return dFe.get(str).intValue();
            }
            return -1;
        }
    }

    public static String rN(String str) {
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

    public String azU() {
        return aJx() ? this.dEP.mPages.get(0) : "";
    }

    public String rO(String str) {
        if (this.dEQ == null || this.dEQ.dFq == null) {
            return null;
        }
        for (g gVar : this.dEQ.dFq) {
            if (TextUtils.equals(gVar.dFk, str)) {
                return gVar.azU();
            }
        }
        return null;
    }

    public boolean aJx() {
        return (this.dEP == null || this.dEP.mPages == null || this.dEP.mPages.isEmpty()) ? false : true;
    }

    public boolean aJy() {
        return (this.dEQ == null || this.dEQ.dFq == null || this.dEQ.dFs == null) ? false : true;
    }

    private boolean aJz() {
        return (this.dEQ == null || this.dEQ.dFq == null || this.dEQ.dFt == null) ? false : true;
    }

    public boolean rP(String str) {
        return aJy() && this.dEQ.dFs.containsKey(str);
    }

    public boolean rQ(String str) {
        return aJz() && this.dEQ.dFt.containsKey(str);
    }

    public String rF(String str) {
        String sq = com.baidu.swan.apps.scheme.actions.k.j.sq(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(sq)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.qI(sq)) {
            return "dynamicLib";
        }
        if (!rP(sq)) {
            return "main";
        }
        if (!rQ(sq)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aJA() {
        return this.dET != null && this.dET.aJJ();
    }

    public boolean rR(String str) {
        return (aJx() && this.dEP.rU(str)) || (aJy() && this.dEQ.dFs.containsKey(str));
    }

    public boolean rS(String str) {
        return this.dET != null && this.dET.rV(str);
    }

    public String rT(String str) {
        if (this.dFb != null && this.dFb.dFi != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dFb.dFi.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jn(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dEX, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aEv() && this.dEQ != null && (list2 = this.dEQ.dFq) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dFo, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dEW, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aEv() && this.dEQ != null && (list = this.dEQ.dFq) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dFp, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dFg) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJB();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aJB();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean rU(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aJB() {
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
        public int dFv;
        public int dFw;
        public ArrayList<k> dFx;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bK(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aJK();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aJK();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.rM(optJSONObject.optString("color", "#999999"));
            jVar.dFv = SwanAppConfigData.rM(optJSONObject.optString("selectedColor", "black"));
            jVar.dFw = SwanAppConfigData.rM(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.rM(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dFx = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dFx.add(k.bM(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aJJ() {
            return this.dFx != null && this.dFx.size() >= 2;
        }

        public boolean rV(String str) {
            if (this.dFx == null) {
                return false;
            }
            for (int i = 0; i < this.dFx.size(); i++) {
                if (TextUtils.equals(this.dFx.get(i).dFy, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aJK() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dFx = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public boolean dFj;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bI(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aJF();
            }
            com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
            String str = "";
            if (aIK != null) {
                str = aIK.id;
            }
            f fVar = new f();
            fVar.dFj = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aJE() {
            SwanAppConfigData azQ = com.baidu.swan.apps.v.f.aAl().azQ();
            if (azQ == null) {
                return true;
            }
            f fVar = azQ.dEU;
            com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
            b.a aVar = null;
            if (aIK != null) {
                aVar = aIK.afZ();
            }
            boolean b2 = com.baidu.swan.apps.f.a.b(aVar);
            boolean amk = com.baidu.swan.apps.console.debugger.a.e.amk();
            boolean ahq = com.baidu.swan.apps.core.e.ahq();
            boolean aFm = com.baidu.swan.apps.ad.a.a.aFm();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b2 + " isRemoteDebug: " + amk + " isMobileDebug: " + ahq + " urlCheck: " + fVar.dFj);
            }
            return (b2 || amk || ahq || aFm) && !fVar.dFj;
        }

        private static f aJF() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dFj = true;
            return fVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class k {
        public String dFA;
        public String dFy;
        public String dFz;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bM(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJL();
            }
            k kVar = new k();
            kVar.dFy = jSONObject.optString("pagePath");
            kVar.dFz = jSONObject.optString("iconPath");
            kVar.dFA = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aJL() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public List<g> dFq;
        public HashMap<String, Boolean> dFr;
        public HashMap<String, String> dFs;
        public HashMap<String, String> dFt;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aJH();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aJH();
            }
            h hVar = new h();
            hVar.dFq = new ArrayList();
            hVar.dFs = new HashMap<>();
            hVar.dFr = new HashMap<>();
            hVar.dFt = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dFq.add(g.a(optJSONObject, hVar.dFs, hVar.dFt, file));
                }
            }
            return hVar;
        }

        private static h aJH() {
            h hVar = new h();
            hVar.dFq = new ArrayList();
            hVar.dFs = new HashMap<>();
            hVar.dFr = new HashMap<>();
            hVar.dFt = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        private static final String dFn = File.separator;
        public String dFk;
        public List<String> dFl;
        boolean dFm = false;
        public c dFo;
        public c dFp;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aJG();
            }
            g gVar = new g();
            gVar.dFk = jSONObject.optString("root");
            gVar.dFm = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dFl = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dFl.add(optString);
                    if (!TextUtils.isEmpty(gVar.dFk) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dFk.endsWith(dFn) || optString.startsWith(dFn)) {
                            str = gVar.dFk + optString;
                        } else {
                            str = gVar.dFk + dFn + optString;
                        }
                        hashMap.put(str, gVar.dFk);
                        if (gVar.dFm) {
                            hashMap2.put(str, gVar.dFk);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aJG() {
            g gVar = new g();
            gVar.dFl = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String azU() {
            if (TextUtils.isEmpty(this.dFk) || this.dFl == null || this.dFl.size() <= 0) {
                return null;
            }
            String str = this.dFl.get(0);
            if (this.dFk.endsWith(dFn)) {
                this.dFk = this.dFk.substring(0, this.dFk.length() - 1);
            }
            if (str.startsWith(dFn)) {
                str = str.substring(1);
            }
            return this.dFk + dFn + str;
        }
    }

    /* loaded from: classes9.dex */
    public static class i {
        public HashMap<String, String> dFu;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dFq == null || hVar.dFq.size() <= 0) {
                return aJI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aJI();
            }
            i iVar = new i();
            iVar.dFu = new HashMap<>();
            for (g gVar : hVar.dFq) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dFk)) {
                    iVar.dFu.put(gVar.dFk, optJSONObject.optString(gVar.dFk));
                }
            }
            return iVar;
        }

        private static i aJI() {
            i iVar = new i();
            iVar.dFu = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dFg;

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
            cVar.dFg = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dsN = next;
                if (file != null && !TextUtils.isEmpty(aVar.dsQ)) {
                    aVar.dsQ = new File(file, aVar.dsQ).getAbsolutePath();
                }
                cVar.dFg.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public HashMap<String, String> dFi;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bG(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aJD = aJD();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aJD.dFi.containsKey(optString)) {
                            aJD.dFi.put(optString, optString2);
                        }
                    }
                }
            }
            return aJD;
        }

        private static e aJD() {
            e eVar = new e();
            eVar.dFi = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public ArrayList<String> dFh;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bE(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dFh = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dFh.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public Map<String, Map<String, String>> dFf;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bC(JSONObject jSONObject) {
            b aJC = aJC();
            if (jSONObject == null) {
                return aJC;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aJC.dFf = new HashMap();
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
                aJC.dFf.put(next, hashMap);
            }
            return aJC;
        }

        private static b aJC() {
            b bVar = new b();
            bVar.dFf = new HashMap();
            return bVar;
        }
    }
}
