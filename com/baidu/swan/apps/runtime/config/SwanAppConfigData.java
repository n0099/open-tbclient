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
    private static final HashMap<String, Integer> coS = new HashMap<>();
    public a coG;
    public e coH;
    public f coI;
    public com.baidu.swan.apps.runtime.config.c coJ;
    public g coK;
    public c coL;
    public b.a coM;
    public b coN;
    public b coO;
    public List<com.baidu.swan.pms.model.h> coP;
    public String coQ;
    @NonNull
    public Set<RequiredBackgroundModeItem> coR = new HashSet(1);
    public boolean mIsDebug;

    static {
        coS.put("light", -1);
        coS.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData k(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.coQ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.coO = b.a(jSONObject, file);
            swanAppConfigData.coN = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.coP = com.baidu.swan.apps.ag.g.b.C(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.coG = a.aK(jSONObject);
            swanAppConfigData.coH = e.e(jSONObject, file);
            swanAppConfigData.coI = f.a(jSONObject, swanAppConfigData.coH);
            swanAppConfigData.coJ = com.baidu.swan.apps.runtime.config.c.aS(jSONObject);
            swanAppConfigData.coK = g.aO(jSONObject);
            swanAppConfigData.coL = c.aM(jSONObject);
            swanAppConfigData.coM = b.a.aJ(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i));
                    if (find != null) {
                        swanAppConfigData.coR.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.w.a.acy().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.c.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.coJ = com.baidu.swan.apps.runtime.config.c.aS(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.coK = g.aO(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.coQ = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = mk(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (coS.containsKey(str)) {
                return coS.get(str).intValue();
            }
            return -1;
        }
    }

    public static String mk(String str) {
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

    public String aet() {
        return aly() ? this.coG.mPages.get(0) : "";
    }

    public String ml(String str) {
        if (this.coH == null || this.coH.cpb == null) {
            return null;
        }
        for (d dVar : this.coH.cpb) {
            if (TextUtils.equals(dVar.coV, str)) {
                return dVar.aet();
            }
        }
        return null;
    }

    public boolean aly() {
        return (this.coG == null || this.coG.mPages == null || this.coG.mPages.isEmpty()) ? false : true;
    }

    public boolean alz() {
        return (this.coH == null || this.coH.cpb == null || this.coH.cpd == null) ? false : true;
    }

    private boolean alA() {
        return (this.coH == null || this.coH.cpb == null || this.coH.cpe == null) ? false : true;
    }

    public boolean mm(String str) {
        return alz() && this.coH.cpd.containsKey(str);
    }

    public boolean mn(String str) {
        return alA() && this.coH.cpe.containsKey(str);
    }

    public String me(String str) {
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(str);
        if (TextUtils.isEmpty(delAllParamsFromUrl) || !mm(delAllParamsFromUrl)) {
            return "main";
        }
        if (!mn(delAllParamsFromUrl)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean alB() {
        return this.coK != null && this.coK.alI();
    }

    public boolean mo(String str) {
        return (aly() && this.coG.mq(str)) || (alz() && this.coH.cpd.containsKey(str));
    }

    public boolean mp(String str) {
        return this.coK != null && this.coK.mr(str);
    }

    public List<com.baidu.swan.apps.ag.f.a> gt(int i) {
        List<d> list;
        List<d> list2;
        if (i == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.coO, arrayList);
            if (this.coH != null && (list2 = this.coH.cpb) != null) {
                for (d dVar : list2) {
                    if (dVar != null) {
                        a(dVar.coZ, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.coN, arrayList2);
            if (this.coH != null && (list = this.coH.cpb) != null) {
                for (d dVar2 : list) {
                    if (dVar2 != null) {
                        a(dVar2.cpa, arrayList2);
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
        if (bVar != null && list != null && (list2 = bVar.coT) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a aK(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alC();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return alC();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean mq(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a alC() {
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
        public int cpg;
        public int cph;
        public ArrayList<h> cpi;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static g aO(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return alJ();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return alJ();
            }
            g gVar = new g();
            gVar.mColor = SwanAppConfigData.dA(optJSONObject.optString("color", "#999999"));
            gVar.cpg = SwanAppConfigData.dA(optJSONObject.optString("selectedColor", "black"));
            gVar.cph = SwanAppConfigData.dA(optJSONObject.optString("borderStyle", "black"));
            gVar.mBackgroundColor = SwanAppConfigData.dA(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                gVar.cpi = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    gVar.cpi.add(h.aQ(optJSONArray.optJSONObject(i2)));
                }
            }
            return gVar;
        }

        public boolean alI() {
            return this.cpi != null && this.cpi.size() >= 2;
        }

        public boolean mr(String str) {
            if (this.cpi == null) {
                return false;
            }
            for (int i = 0; i < this.cpi.size(); i++) {
                if (TextUtils.equals(this.cpi.get(i).cpj, str)) {
                    return true;
                }
            }
            return false;
        }

        private static g alJ() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            g gVar = new g();
            gVar.cpi = new ArrayList<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public boolean coU;

        /* JADX INFO: Access modifiers changed from: private */
        public static c aM(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alE();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return alE();
            }
            com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
            String str = "";
            if (akM != null) {
                str = akM.id;
            }
            c cVar = new c();
            cVar.coU = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.aj.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.aj.a.c.g(str, optJSONObject3);
                }
            }
            return cVar;
        }

        public static boolean alD() {
            SwanAppConfigData aep = com.baidu.swan.apps.y.f.aeJ().aep();
            if (aep == null) {
                return true;
            }
            c cVar = aep.coL;
            com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
            b.a aVar = null;
            if (akM != null) {
                aVar = akM.Ov();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean TF = com.baidu.swan.apps.console.debugger.a.e.TF();
            boolean PJ = com.baidu.swan.apps.core.a.PJ();
            boolean aiK = com.baidu.swan.apps.ah.a.a.aiK();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + TF + " isMobileDebug: " + PJ + " urlCheck: " + cVar.coU);
            }
            return (b || TF || PJ || aiK) && !cVar.coU;
        }

        private static c alE() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            c cVar = new c();
            cVar.coU = true;
            return cVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public String cpj;
        public String cpk;
        public String cpl;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static h aQ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return alK();
            }
            h hVar = new h();
            hVar.cpj = jSONObject.optString("pagePath");
            hVar.cpk = jSONObject.optString("iconPath");
            hVar.cpl = jSONObject.optString("selectedIconPath");
            hVar.mText = jSONObject.optString("text");
            return hVar;
        }

        private static h alK() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new h();
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public List<d> cpb;
        public HashMap<String, Boolean> cpc;
        public HashMap<String, String> cpd;
        public HashMap<String, String> cpe;

        /* JADX INFO: Access modifiers changed from: private */
        public static e e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return alG();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return alG();
            }
            e eVar = new e();
            eVar.cpb = new ArrayList();
            eVar.cpd = new HashMap<>();
            eVar.cpc = new HashMap<>();
            eVar.cpe = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eVar.cpb.add(d.a(optJSONObject, eVar.cpd, eVar.cpe, file));
                }
            }
            return eVar;
        }

        private static e alG() {
            e eVar = new e();
            eVar.cpb = new ArrayList();
            eVar.cpd = new HashMap<>();
            eVar.cpc = new HashMap<>();
            eVar.cpe = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        private static final String coY = File.separator;
        public String coV;
        public List<String> coW;
        boolean coX = false;
        public b coZ;
        public b cpa;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return alF();
            }
            d dVar = new d();
            dVar.coV = jSONObject.optString("root");
            dVar.coX = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                dVar.coW = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    dVar.coW.add(optString);
                    if (!TextUtils.isEmpty(dVar.coV) && !TextUtils.isEmpty(optString)) {
                        if (dVar.coV.endsWith(coY) || optString.startsWith(coY)) {
                            str = dVar.coV + optString;
                        } else {
                            str = dVar.coV + coY + optString;
                        }
                        hashMap.put(str, dVar.coV);
                        if (dVar.coX) {
                            hashMap2.put(str, dVar.coV);
                        }
                    }
                }
            }
            return dVar;
        }

        private static d alF() {
            d dVar = new d();
            dVar.coW = new ArrayList();
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aet() {
            if (TextUtils.isEmpty(this.coV) || this.coW == null || this.coW.size() <= 0) {
                return null;
            }
            String str = this.coW.get(0);
            if (this.coV.endsWith(coY)) {
                this.coV = this.coV.substring(0, this.coV.length() - 1);
            }
            if (str.startsWith(coY)) {
                str = str.substring(1);
            }
            return this.coV + coY + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public HashMap<String, String> cpf;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, e eVar) {
            if (jSONObject == null || eVar == null || eVar.cpb == null || eVar.cpb.size() <= 0) {
                return alH();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return alH();
            }
            f fVar = new f();
            fVar.cpf = new HashMap<>();
            for (d dVar : eVar.cpb) {
                if (dVar != null && !TextUtils.isEmpty(dVar.coV)) {
                    fVar.cpf.put(dVar.coV, optJSONObject.optString(dVar.coV));
                }
            }
            return fVar;
        }

        private static f alH() {
            f fVar = new f();
            fVar.cpf = new HashMap<>();
            return fVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ag.f.a> coT;

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
            bVar.coT = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ag.f.a aVar = new com.baidu.swan.apps.ag.f.a(optJSONObject.optJSONObject(next), i);
                aVar.chL = next;
                if (file != null && !TextUtils.isEmpty(aVar.chO)) {
                    aVar.chO = new File(file, aVar.chO).getAbsolutePath();
                }
                bVar.coT.add(aVar);
            }
            return bVar;
        }
    }
}
