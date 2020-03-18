package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.runtime.config.b;
import com.baidu.swan.apps.x.b.b;
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
    private static final HashMap<String, Integer> bQa = new HashMap<>();
    public a bPO;
    public e bPP;
    public f bPQ;
    public com.baidu.swan.apps.runtime.config.c bPR;
    public g bPS;
    public c bPT;
    public b.a bPU;
    public b bPV;
    public b bPW;
    public List<com.baidu.swan.pms.model.h> bPX;
    public String bPY;
    @NonNull
    public Set<RequiredBackgroundModeItem> bPZ = new HashSet(1);
    public boolean mIsDebug;

    static {
        bQa.put("light", -1);
        bQa.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData l(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.bPY = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.bPW = b.a(jSONObject, file);
            swanAppConfigData.bPV = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.bPX = com.baidu.swan.apps.ag.g.b.x(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.bPO = a.az(jSONObject);
            swanAppConfigData.bPP = e.e(jSONObject, file);
            swanAppConfigData.bPQ = f.a(jSONObject, swanAppConfigData.bPP);
            swanAppConfigData.bPR = com.baidu.swan.apps.runtime.config.c.aH(jSONObject);
            swanAppConfigData.bPS = g.aD(jSONObject);
            swanAppConfigData.bPT = c.aB(jSONObject);
            swanAppConfigData.bPU = b.a.ay(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.bPZ.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.UK().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.bPR = com.baidu.swan.apps.runtime.config.c.aH(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.bPS = g.aD(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.bPY = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int cF(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = kX(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (bQa.containsKey(str)) {
                return bQa.get(str).intValue();
            }
            return -1;
        }
    }

    public static String kX(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4 && str.charAt(0) == '#') {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i = 1; i < 4; i++) {
                char charAt = str.charAt(i);
                sb.append(charAt).append(charAt);
            }
            return sb.toString();
        }
        return str;
    }

    public String WF() {
        return adu() ? this.bPO.mPages.get(0) : "";
    }

    public String kY(String str) {
        if (this.bPP == null || this.bPP.bQj == null) {
            return null;
        }
        for (d dVar : this.bPP.bQj) {
            if (TextUtils.equals(dVar.bQd, str)) {
                return dVar.WF();
            }
        }
        return null;
    }

    public boolean adu() {
        return (this.bPO == null || this.bPO.mPages == null || this.bPO.mPages.isEmpty()) ? false : true;
    }

    public boolean adv() {
        return (this.bPP == null || this.bPP.bQj == null || this.bPP.bQl == null) ? false : true;
    }

    private boolean adw() {
        return (this.bPP == null || this.bPP.bQj == null || this.bPP.bQm == null) ? false : true;
    }

    public boolean kZ(String str) {
        return adv() && this.bPP.bQl.containsKey(str);
    }

    public boolean la(String str) {
        return adw() && this.bPP.bQm.containsKey(str);
    }

    public String kR(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !kZ(delAllParamsFromUrl)) {
            return "main";
        }
        if (!la(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean adx() {
        return this.bPS != null && this.bPS.adE();
    }

    public boolean lb(String str) {
        return (adu() && this.bPO.ld(str)) || (adv() && this.bPP.bQl.containsKey(str));
    }

    public boolean lc(String str) {
        return this.bPS != null && this.bPS.le(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> gl(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.bPW, arrayList);
            if (this.bPP != null && (list2 = this.bPP.bQj) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.bQh, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.bPV, arrayList2);
            if (this.bPP != null && (list = this.bPP.bQj) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.bQi, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(b bVar, List<com.baidu.swan.apps.ag.f.a> list) {
        List<com.baidu.swan.apps.ag.f.a> list2;
        if (bVar != null && list != null && (list2 = bVar.bQb) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a az(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ady();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return ady();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean ld(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a ady() {
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
    public static class g {
        public int bQo;
        public int bQp;
        public ArrayList<h> bQq;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aD(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return adF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return adF();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.cF(optJSONObject.optString("color", "#999999"));
            gVar.bQo = SwanAppConfigData.cF(optJSONObject.optString("selectedColor", "black"));
            gVar.bQp = SwanAppConfigData.cF(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.cF(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.bQq = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.bQq.add(h.aF(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean adE() {
            return this.bQq != null && this.bQq.size() >= 2;
        }

        public boolean le(String str) {
            if (this.bQq == null) {
                return false;
            }
            for (int i = 0; i < this.bQq.size(); i++) {
                if (TextUtils.equals(this.bQq.get(i).bQr, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g adF() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.bQq = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public boolean bQc;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return adA();
            }
            com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
            String str = "";
            if (acI != null) {
                str = acI.id;
            }
            c cVar = new c();
            cVar.bQc = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.aj.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.aj.a.c.f(str, optJSONObject3);
                }
            }
            return cVar;
        }

        public static boolean adz() {
            SwanAppConfigData WB = com.baidu.swan.apps.y.f.WV().WB();
            if (WB == null) {
                return true;
            }
            c cVar = WB.bPT;
            com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
            b.a aVar = null;
            if (acI != null) {
                aVar = acI.GJ();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean LS = com.baidu.swan.apps.console.debugger.a.e.LS();
            boolean HY = com.baidu.swan.apps.core.a.HY();
            boolean aaG = com.baidu.swan.apps.ah.a.a.aaG();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + LS + " isMobileDebug: " + HY + " urlCheck: " + cVar.bQc);
            }
            return (b || LS || HY || aaG) && !cVar.bQc;
        }

        private static c adA() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.bQc = true;
            return cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public String bQr;
        public String bQs;
        public String bQt;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return adG();
            }
            h hVar = new h();
            hVar.bQr = jSONObject.optString("pagePath");
            hVar.bQs = jSONObject.optString("iconPath");
            hVar.bQt = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h adG() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public List<d> bQj;
        public HashMap<String, Boolean> bQk;
        public HashMap<String, String> bQl;
        public HashMap<String, String> bQm;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return adC();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return adC();
            }
            e eVar = new e();
            eVar.bQj = new ArrayList();
            eVar.bQl = new HashMap<>();
            eVar.bQk = new HashMap<>();
            eVar.bQm = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.bQj.add(d.a(optJSONObject, eVar.bQl, eVar.bQm, file));
                }
            }
            return eVar;
        }

        private static e adC() {
            e eVar = new e();
            eVar.bQj = new ArrayList();
            eVar.bQl = new HashMap<>();
            eVar.bQk = new HashMap<>();
            eVar.bQm = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        private static final String bQg = File.separator;
        public String bQd;
        public List<String> bQe;
        boolean bQf = false;
        public b bQh;
        public b bQi;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return adB();
            }
            d dVar = new d();
            dVar.bQd = jSONObject.optString("root");
            dVar.bQf = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.bQe = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.bQe.add(optString);
                    if (!TextUtils.isEmpty(dVar.bQd) && !TextUtils.isEmpty(optString)) {
                        if (dVar.bQd.endsWith(bQg) || optString.startsWith(bQg)) {
                            str = dVar.bQd + optString;
                        } else {
                            str = dVar.bQd + bQg + optString;
                        }
                        hashMap.put(str, dVar.bQd);
                        if (dVar.bQf) {
                            hashMap2.put(str, dVar.bQd);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d adB() {
            d dVar = new d();
            dVar.bQe = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String WF() {
            if (TextUtils.isEmpty(this.bQd) || this.bQe == null || this.bQe.size() <= 0) {
                return null;
            }
            String str = this.bQe.get(0);
            if (this.bQd.endsWith(bQg)) {
                this.bQd = this.bQd.substring(0, this.bQd.length() - 1);
            }
            if (str.startsWith(bQg)) {
                str = str.substring(1);
            }
            return this.bQd + bQg + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public HashMap<String, String> bQn;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.bQj == null || eVar.bQj.size() <= 0) {
                return adD();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return adD();
            }
            f fVar = new f();
            fVar.bQn = new HashMap<>();
            for (d dVar : eVar.bQj) {
                if (dVar != null && !TextUtils.isEmpty(dVar.bQd)) {
                    fVar.bQn.put(dVar.bQd, optJSONObject.optString(dVar.bQd));
                }
            }
            return fVar;
        }

        private static f adD() {
            f fVar = new f();
            fVar.bQn = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> bQb;

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
            bVar.bQb = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.bIW = next;
                if (file != null && !TextUtils.isEmpty(aVar.bIZ)) {
                    aVar.bIZ = new File(file, aVar.bIZ).getAbsolutePath();
                }
                bVar.bQb.add(aVar);
            }
            return bVar;
        }
    }
}
