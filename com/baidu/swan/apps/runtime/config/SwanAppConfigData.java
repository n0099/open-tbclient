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
/* loaded from: classes8.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> dDa = new HashMap<>();
    public boolean dBc;
    public a dCL;
    public h dCM;
    public i dCN;
    public com.baidu.swan.apps.runtime.config.c dCO;
    public j dCP;
    public f dCQ;
    public b.a dCR;
    public c dCS;
    public c dCT;
    @Nullable
    public d dCU;
    public List<com.baidu.swan.pms.model.h> dCV;
    public String dCW;
    public e dCX;
    public b dCY;
    @NonNull
    public Set<RequiredBackgroundModeItem> dCZ = new HashSet(1);

    static {
        dDa.put("light", -1);
        dDa.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData o(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.dCW = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.dCT = c.a(jSONObject, file);
            swanAppConfigData.dCS = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.dCV = com.baidu.swan.apps.ac.g.b.ab(optJSONArray.toString(), false);
            }
            swanAppConfigData.dBc = jSONObject.optBoolean("debug");
            swanAppConfigData.dCL = a.bD(jSONObject);
            swanAppConfigData.dCM = h.e(jSONObject, file);
            swanAppConfigData.dCN = i.a(jSONObject, swanAppConfigData.dCM);
            swanAppConfigData.dCO = com.baidu.swan.apps.runtime.config.c.bR(jSONObject);
            swanAppConfigData.dCP = j.bN(jSONObject);
            swanAppConfigData.dCQ = f.bL(jSONObject);
            swanAppConfigData.dCR = b.a.bC(jSONObject);
            swanAppConfigData.dCX = e.bJ(jSONObject);
            swanAppConfigData.dCU = d.bH(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.dCZ.add(find);
                    }
                }
            }
            swanAppConfigData.dCY = b.bF(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.axk().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.dCO = com.baidu.swan.apps.runtime.config.c.bR(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.dCP = j.bN(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.dCW = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int rt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = ru(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (dDa.containsKey(str)) {
                return dDa.get(str).intValue();
            }
            return -1;
        }
    }

    public static String ru(String str) {
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

    public String azw() {
        return aJe() ? this.dCL.mPages.get(0) : "";
    }

    public String rv(String str) {
        if (this.dCM == null || this.dCM.dDm == null) {
            return null;
        }
        for (g gVar : this.dCM.dDm) {
            if (TextUtils.equals(gVar.dDg, str)) {
                return gVar.azw();
            }
        }
        return null;
    }

    public boolean aJe() {
        return (this.dCL == null || this.dCL.mPages == null || this.dCL.mPages.isEmpty()) ? false : true;
    }

    public boolean aJf() {
        return (this.dCM == null || this.dCM.dDm == null || this.dCM.dDo == null) ? false : true;
    }

    private boolean aJg() {
        return (this.dCM == null || this.dCM.dDm == null || this.dCM.dDp == null) ? false : true;
    }

    public boolean rw(String str) {
        return aJf() && this.dCM.dDo.containsKey(str);
    }

    public boolean rx(String str) {
        return aJg() && this.dCM.dDp.containsKey(str);
    }

    public String rm(String str) {
        String rX = com.baidu.swan.apps.scheme.actions.k.j.rX(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(rX)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.qq(rX)) {
            return "dynamicLib";
        }
        if (!rw(rX)) {
            return "main";
        }
        if (!rx(rX)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aJh() {
        return this.dCP != null && this.dCP.aJq();
    }

    public boolean ry(String str) {
        return (aJe() && this.dCL.rB(str)) || (aJf() && this.dCM.dDo.containsKey(str));
    }

    public boolean rz(String str) {
        return this.dCP != null && this.dCP.rC(str);
    }

    public String rA(String str) {
        if (this.dCX != null && this.dCX.dDe != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.dCX.dDe.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jk(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.dCT, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.aEa() && this.dCM != null && (list2 = this.dCM.dDm) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.dDk, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.dCS, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.aEa() && this.dCM != null && (list = this.dCM.dDm) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.dDl, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.dDc) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bD(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJi();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aJi();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean rB(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aJi() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class j {
        public int dDr;
        public int dDs;
        public ArrayList<k> dDt;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bN(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aJr();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aJr();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.rt(optJSONObject.optString("color", "#999999"));
            jVar.dDr = SwanAppConfigData.rt(optJSONObject.optString("selectedColor", "black"));
            jVar.dDs = SwanAppConfigData.rt(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.rt(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.dDt = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.dDt.add(k.bP(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aJq() {
            return this.dDt != null && this.dDt.size() >= 2;
        }

        public boolean rC(String str) {
            if (this.dDt == null) {
                return false;
            }
            for (int i = 0; i < this.dDt.size(); i++) {
                if (TextUtils.equals(this.dDt.get(i).dDu, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aJr() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.dDt = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public boolean dDf;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bL(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJm();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aJm();
            }
            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
            String str = "";
            if (aIr != null) {
                str = aIr.id;
            }
            f fVar = new f();
            fVar.dDf = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aJl() {
            SwanAppConfigData azs = com.baidu.swan.apps.v.f.azN().azs();
            if (azs == null) {
                return true;
            }
            f fVar = azs.dCQ;
            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
            b.a aVar = null;
            if (aIr != null) {
                aVar = aIr.afB();
            }
            boolean b2 = com.baidu.swan.apps.f.a.b(aVar);
            boolean alM = com.baidu.swan.apps.console.debugger.a.e.alM();
            boolean agS = com.baidu.swan.apps.core.e.agS();
            boolean aER = com.baidu.swan.apps.ad.a.a.aER();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b2 + " isRemoteDebug: " + alM + " isMobileDebug: " + agS + " urlCheck: " + fVar.dDf);
            }
            return (b2 || alM || agS || aER) && !fVar.dDf;
        }

        private static f aJm() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.dDf = true;
            return fVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class k {
        public String dDu;
        public String dDv;
        public String dDw;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bP(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJs();
            }
            k kVar = new k();
            kVar.dDu = jSONObject.optString("pagePath");
            kVar.dDv = jSONObject.optString("iconPath");
            kVar.dDw = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aJs() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public List<g> dDm;
        public HashMap<String, Boolean> dDn;
        public HashMap<String, String> dDo;
        public HashMap<String, String> dDp;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aJo();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aJo();
            }
            h hVar = new h();
            hVar.dDm = new ArrayList();
            hVar.dDo = new HashMap<>();
            hVar.dDn = new HashMap<>();
            hVar.dDp = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.dDm.add(g.a(optJSONObject, hVar.dDo, hVar.dDp, file));
                }
            }
            return hVar;
        }

        private static h aJo() {
            h hVar = new h();
            hVar.dDm = new ArrayList();
            hVar.dDo = new HashMap<>();
            hVar.dDn = new HashMap<>();
            hVar.dDp = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        private static final String dDj = File.separator;
        public String dDg;
        public List<String> dDh;
        boolean dDi = false;
        public c dDk;
        public c dDl;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aJn();
            }
            g gVar = new g();
            gVar.dDg = jSONObject.optString("root");
            gVar.dDi = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.dDh = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.dDh.add(optString);
                    if (!TextUtils.isEmpty(gVar.dDg) && !TextUtils.isEmpty(optString)) {
                        if (gVar.dDg.endsWith(dDj) || optString.startsWith(dDj)) {
                            str = gVar.dDg + optString;
                        } else {
                            str = gVar.dDg + dDj + optString;
                        }
                        hashMap.put(str, gVar.dDg);
                        if (gVar.dDi) {
                            hashMap2.put(str, gVar.dDg);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aJn() {
            g gVar = new g();
            gVar.dDh = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String azw() {
            if (TextUtils.isEmpty(this.dDg) || this.dDh == null || this.dDh.size() <= 0) {
                return null;
            }
            String str = this.dDh.get(0);
            if (this.dDg.endsWith(dDj)) {
                this.dDg = this.dDg.substring(0, this.dDg.length() - 1);
            }
            if (str.startsWith(dDj)) {
                str = str.substring(1);
            }
            return this.dDg + dDj + str;
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public HashMap<String, String> dDq;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.dDm == null || hVar.dDm.size() <= 0) {
                return aJp();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aJp();
            }
            i iVar = new i();
            iVar.dDq = new HashMap<>();
            for (g gVar : hVar.dDm) {
                if (gVar != null && !TextUtils.isEmpty(gVar.dDg)) {
                    iVar.dDq.put(gVar.dDg, optJSONObject.optString(gVar.dDg));
                }
            }
            return iVar;
        }

        private static i aJp() {
            i iVar = new i();
            iVar.dDq = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> dDc;

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
            cVar.dDc = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.dqB = next;
                if (file != null && !TextUtils.isEmpty(aVar.dqE)) {
                    aVar.dqE = new File(file, aVar.dqE).getAbsolutePath();
                }
                cVar.dDc.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public HashMap<String, String> dDe;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bJ(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aJk = aJk();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aJk.dDe.containsKey(optString)) {
                            aJk.dDe.put(optString, optString2);
                        }
                    }
                }
            }
            return aJk;
        }

        private static e aJk() {
            e eVar = new e();
            eVar.dDe = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public ArrayList<String> dDd;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bH(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.dDd = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.dDd.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public Map<String, Map<String, String>> dDb;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bF(JSONObject jSONObject) {
            b aJj = aJj();
            if (jSONObject == null) {
                return aJj;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aJj.dDb = new HashMap();
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
                aJj.dDb.put(next, hashMap);
            }
            return aJj;
        }

        private static b aJj() {
            b bVar = new b();
            bVar.dDb = new HashMap();
            return bVar;
        }
    }
}
