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
/* loaded from: classes8.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> cRg = new HashMap<>();
    public a cQR;
    public h cQS;
    public i cQT;
    public com.baidu.swan.apps.runtime.config.c cQU;
    public j cQV;
    public f cQW;
    public b.a cQX;
    public c cQY;
    public c cQZ;
    @Nullable
    public d cRa;
    public List<com.baidu.swan.pms.model.h> cRb;
    public String cRc;
    public e cRd;
    public b cRe;
    @NonNull
    public Set<RequiredBackgroundModeItem> cRf = new HashSet(1);
    public boolean mIsDebug;

    static {
        cRg.put("light", -1);
        cRg.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData m(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.cRc = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.cQZ = c.a(jSONObject, file);
            swanAppConfigData.cQY = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.cRb = com.baidu.swan.apps.ac.g.b.U(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.cQR = a.bg(jSONObject);
            swanAppConfigData.cQS = h.e(jSONObject, file);
            swanAppConfigData.cQT = i.a(jSONObject, swanAppConfigData.cQS);
            swanAppConfigData.cQU = com.baidu.swan.apps.runtime.config.c.bu(jSONObject);
            swanAppConfigData.cQV = j.bq(jSONObject);
            swanAppConfigData.cQW = f.bo(jSONObject);
            swanAppConfigData.cQX = b.a.bf(jSONObject);
            swanAppConfigData.cRd = e.bm(jSONObject);
            swanAppConfigData.cRa = d.bk(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.cRf.add(find);
                    }
                }
            }
            swanAppConfigData.cRe = b.bi(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.apw().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.cQU = com.baidu.swan.apps.runtime.config.c.bu(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.cQV = j.bq(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.cRc = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int fn(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = qt(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (cRg.containsKey(str)) {
                return cRg.get(str).intValue();
            }
            return -1;
        }
    }

    public static String qt(String str) {
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

    public String arH() {
        return aAv() ? this.cQR.mPages.get(0) : "";
    }

    public String qu(String str) {
        if (this.cQS == null || this.cQS.cRs == null) {
            return null;
        }
        for (g gVar : this.cQS.cRs) {
            if (TextUtils.equals(gVar.cRm, str)) {
                return gVar.arH();
            }
        }
        return null;
    }

    public boolean aAv() {
        return (this.cQR == null || this.cQR.mPages == null || this.cQR.mPages.isEmpty()) ? false : true;
    }

    public boolean aAw() {
        return (this.cQS == null || this.cQS.cRs == null || this.cQS.cRu == null) ? false : true;
    }

    private boolean aAx() {
        return (this.cQS == null || this.cQS.cRs == null || this.cQS.cRv == null) ? false : true;
    }

    public boolean qv(String str) {
        return aAw() && this.cQS.cRu.containsKey(str);
    }

    public boolean qw(String str) {
        return aAx() && this.cQS.cRv.containsKey(str);
    }

    public String qm(String str) {
        String qW = com.baidu.swan.apps.scheme.actions.k.j.qW(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(qW)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.pu(qW)) {
            return "dynamicLib";
        }
        if (!qv(qW)) {
            return "main";
        }
        if (!qw(qW)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aAy() {
        return this.cQV != null && this.cQV.aAH();
    }

    public boolean qx(String str) {
        return (aAv() && this.cQR.qA(str)) || (aAw() && this.cQS.cRu.containsKey(str));
    }

    public boolean qy(String str) {
        return this.cQV != null && this.cQV.qB(str);
    }

    public String qz(String str) {
        if (this.cRd != null && this.cRd.cRk != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.cRd.cRk.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jn(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.cQZ, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.awm() && this.cQS != null && (list2 = this.cQS.cRs) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.cRq, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.cQY, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.awm() && this.cQS != null && (list = this.cQS.cRs) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.cRr, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.cRi) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bg(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aAz();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aAz();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean qA(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aAz() {
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
        public int cRx;
        public int cRy;
        public ArrayList<k> cRz;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bq(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aAI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aAI();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.fn(optJSONObject.optString("color", "#999999"));
            jVar.cRx = SwanAppConfigData.fn(optJSONObject.optString("selectedColor", "black"));
            jVar.cRy = SwanAppConfigData.fn(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.fn(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.cRz = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.cRz.add(k.bs(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aAH() {
            return this.cRz != null && this.cRz.size() >= 2;
        }

        public boolean qB(String str) {
            if (this.cRz == null) {
                return false;
            }
            for (int i = 0; i < this.cRz.size(); i++) {
                if (TextUtils.equals(this.cRz.get(i).cRA, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aAI() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.cRz = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public boolean cRl;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bo(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aAD();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aAD();
            }
            com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
            String str = "";
            if (azI != null) {
                str = azI.id;
            }
            f fVar = new f();
            fVar.cRl = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aAC() {
            SwanAppConfigData arD = com.baidu.swan.apps.v.f.arY().arD();
            if (arD == null) {
                return true;
            }
            f fVar = arD.cQW;
            com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
            b.a aVar = null;
            if (azI != null) {
                aVar = azI.XZ();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean aee = com.baidu.swan.apps.console.debugger.a.e.aee();
            boolean Zo = com.baidu.swan.apps.core.e.Zo();
            boolean axd = com.baidu.swan.apps.ad.a.a.axd();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + aee + " isMobileDebug: " + Zo + " urlCheck: " + fVar.cRl);
            }
            return (b || aee || Zo || axd) && !fVar.cRl;
        }

        private static f aAD() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.cRl = true;
            return fVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class k {
        public String cRA;
        public String cRB;
        public String cRC;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bs(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aAJ();
            }
            k kVar = new k();
            kVar.cRA = jSONObject.optString("pagePath");
            kVar.cRB = jSONObject.optString("iconPath");
            kVar.cRC = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aAJ() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public List<g> cRs;
        public HashMap<String, Boolean> cRt;
        public HashMap<String, String> cRu;
        public HashMap<String, String> cRv;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aAF();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aAF();
            }
            h hVar = new h();
            hVar.cRs = new ArrayList();
            hVar.cRu = new HashMap<>();
            hVar.cRt = new HashMap<>();
            hVar.cRv = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.cRs.add(g.a(optJSONObject, hVar.cRu, hVar.cRv, file));
                }
            }
            return hVar;
        }

        private static h aAF() {
            h hVar = new h();
            hVar.cRs = new ArrayList();
            hVar.cRu = new HashMap<>();
            hVar.cRt = new HashMap<>();
            hVar.cRv = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        private static final String cRp = File.separator;
        public String cRm;
        public List<String> cRn;
        boolean cRo = false;
        public c cRq;
        public c cRr;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aAE();
            }
            g gVar = new g();
            gVar.cRm = jSONObject.optString("root");
            gVar.cRo = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.cRn = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.cRn.add(optString);
                    if (!TextUtils.isEmpty(gVar.cRm) && !TextUtils.isEmpty(optString)) {
                        if (gVar.cRm.endsWith(cRp) || optString.startsWith(cRp)) {
                            str = gVar.cRm + optString;
                        } else {
                            str = gVar.cRm + cRp + optString;
                        }
                        hashMap.put(str, gVar.cRm);
                        if (gVar.cRo) {
                            hashMap2.put(str, gVar.cRm);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aAE() {
            g gVar = new g();
            gVar.cRn = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String arH() {
            if (TextUtils.isEmpty(this.cRm) || this.cRn == null || this.cRn.size() <= 0) {
                return null;
            }
            String str = this.cRn.get(0);
            if (this.cRm.endsWith(cRp)) {
                this.cRm = this.cRm.substring(0, this.cRm.length() - 1);
            }
            if (str.startsWith(cRp)) {
                str = str.substring(1);
            }
            return this.cRm + cRp + str;
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public HashMap<String, String> cRw;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.cRs == null || hVar.cRs.size() <= 0) {
                return aAG();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aAG();
            }
            i iVar = new i();
            iVar.cRw = new HashMap<>();
            for (g gVar : hVar.cRs) {
                if (gVar != null && !TextUtils.isEmpty(gVar.cRm)) {
                    iVar.cRw.put(gVar.cRm, optJSONObject.optString(gVar.cRm));
                }
            }
            return iVar;
        }

        private static i aAG() {
            i iVar = new i();
            iVar.cRw = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> cRi;

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
            cVar.cRi = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cIw = next;
                if (file != null && !TextUtils.isEmpty(aVar.cIz)) {
                    aVar.cIz = new File(file, aVar.cIz).getAbsolutePath();
                }
                cVar.cRi.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public HashMap<String, String> cRk;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bm(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aAB = aAB();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aAB.cRk.containsKey(optString)) {
                            aAB.cRk.put(optString, optString2);
                        }
                    }
                }
            }
            return aAB;
        }

        private static e aAB() {
            e eVar = new e();
            eVar.cRk = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public ArrayList<String> cRj;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bk(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.cRj = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.cRj.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public Map<String, Map<String, String>> cRh;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bi(JSONObject jSONObject) {
            b aAA = aAA();
            if (jSONObject == null) {
                return aAA;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aAA.cRh = new HashMap();
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
                aAA.cRh.put(next, hashMap);
            }
            return aAA;
        }

        private static b aAA() {
            b bVar = new b();
            bVar.cRh = new HashMap();
            return bVar;
        }
    }
}
