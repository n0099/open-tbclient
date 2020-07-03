package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.config.b;
import com.baidu.swan.apps.v.b.b;
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
    private static final HashMap<String, Integer> cFq = new HashMap<>();
    public a cFc;
    public g cFd;
    public h cFe;
    public com.baidu.swan.apps.runtime.config.c cFf;
    public i cFg;
    public e cFh;
    public b.a cFi;
    public b cFj;
    public b cFk;
    @Nullable
    public c cFl;
    public List<com.baidu.swan.pms.model.h> cFm;
    public String cFn;
    public d cFo;
    @NonNull
    public Set<RequiredBackgroundModeItem> cFp = new HashSet(1);
    public boolean mIsDebug;

    static {
        cFq.put("light", -1);
        cFq.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData k(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.cFn = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.cFk = b.a(jSONObject, file);
            swanAppConfigData.cFj = b.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.cFm = com.baidu.swan.apps.ae.g.b.Q(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.cFc = a.aW(jSONObject);
            swanAppConfigData.cFd = g.e(jSONObject, file);
            swanAppConfigData.cFe = h.a(jSONObject, swanAppConfigData.cFd);
            swanAppConfigData.cFf = com.baidu.swan.apps.runtime.config.c.bi(jSONObject);
            swanAppConfigData.cFg = i.be(jSONObject);
            swanAppConfigData.cFh = e.bc(jSONObject);
            swanAppConfigData.cFi = b.a.aV(jSONObject);
            swanAppConfigData.cFo = d.ba(jSONObject);
            swanAppConfigData.cFl = c.aY(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.cFp.add(find);
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
        File file2 = new File(file, com.baidu.swan.apps.u.a.agH().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.e.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.cFf = com.baidu.swan.apps.runtime.config.c.bi(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.cFg = i.be(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.cFn = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int dV(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = nO(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (cFq.containsKey(str)) {
                return cFq.get(str).intValue();
            }
            return -1;
        }
    }

    public static String nO(String str) {
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

    public String aiK() {
        return aqB() ? this.cFc.mPages.get(0) : "";
    }

    public String nP(String str) {
        if (this.cFd == null || this.cFd.cFB == null) {
            return null;
        }
        for (f fVar : this.cFd.cFB) {
            if (TextUtils.equals(fVar.cFv, str)) {
                return fVar.aiK();
            }
        }
        return null;
    }

    public boolean aqB() {
        return (this.cFc == null || this.cFc.mPages == null || this.cFc.mPages.isEmpty()) ? false : true;
    }

    public boolean aqC() {
        return (this.cFd == null || this.cFd.cFB == null || this.cFd.cFD == null) ? false : true;
    }

    private boolean aqD() {
        return (this.cFd == null || this.cFd.cFB == null || this.cFd.cFE == null) ? false : true;
    }

    public boolean nQ(String str) {
        return aqC() && this.cFd.cFD.containsKey(str);
    }

    public boolean nR(String str) {
        return aqD() && this.cFd.cFE.containsKey(str);
    }

    public String nH(String str) {
        String oq = com.baidu.swan.apps.scheme.actions.k.j.oq(ah.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(oq)) {
            return "main";
        }
        if (com.baidu.swan.apps.ae.b.a.mP(oq)) {
            return "dynamicLib";
        }
        if (!nQ(oq)) {
            return "main";
        }
        if (!nR(oq)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aqE() {
        return this.cFg != null && this.cFg.aqM();
    }

    public boolean nS(String str) {
        return (aqB() && this.cFc.nV(str)) || (aqC() && this.cFd.cFD.containsKey(str));
    }

    public boolean nT(String str) {
        return this.cFg != null && this.cFg.nW(str);
    }

    public String nU(String str) {
        if (this.cFo != null && this.cFo.cFt != null) {
            String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
            String str2 = this.cFo.cFt.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ae.f.a> gX(int i2) {
        List<f> list;
        List<f> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.cFk, arrayList);
            if (this.cFd != null && (list2 = this.cFd.cFB) != null) {
                for (f fVar : list2) {
                    if (fVar != null) {
                        a(fVar.cFz, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.cFj, arrayList2);
            if (this.cFd != null && (list = this.cFd.cFB) != null) {
                for (f fVar2 : list) {
                    if (fVar2 != null) {
                        a(fVar2.cFA, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(b bVar, List<com.baidu.swan.apps.ae.f.a> list) {
        List<com.baidu.swan.apps.ae.f.a> list2;
        if (bVar != null && list != null && (list2 = bVar.cFr) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a aW(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aqF();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aqF();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean nV(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aqF() {
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
    public static class i {
        public int cFG;
        public int cFH;
        public ArrayList<j> cFI;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static i be(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aqN();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aqN();
            }
            i iVar = new i();
            iVar.mColor = SwanAppConfigData.dV(optJSONObject.optString("color", "#999999"));
            iVar.cFG = SwanAppConfigData.dV(optJSONObject.optString("selectedColor", "black"));
            iVar.cFH = SwanAppConfigData.dV(optJSONObject.optString("borderStyle", "black"));
            iVar.mBackgroundColor = SwanAppConfigData.dV(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                iVar.cFI = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    iVar.cFI.add(j.bg(optJSONArray.optJSONObject(i2)));
                }
            }
            return iVar;
        }

        public boolean aqM() {
            return this.cFI != null && this.cFI.size() >= 2;
        }

        public boolean nW(String str) {
            if (this.cFI == null) {
                return false;
            }
            for (int i = 0; i < this.cFI.size(); i++) {
                if (TextUtils.equals(this.cFI.get(i).cFJ, str)) {
                    return true;
                }
            }
            return false;
        }

        private static i aqN() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            i iVar = new i();
            iVar.cFI = new ArrayList<>();
            return iVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public boolean cFu;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bc(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aqI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aqI();
            }
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            String str = "";
            if (apM != null) {
                str = apM.id;
            }
            e eVar = new e();
            eVar.cFu = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.ah.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.ah.a.c.g(str, optJSONObject3);
                }
            }
            return eVar;
        }

        public static boolean aqH() {
            SwanAppConfigData aiG = com.baidu.swan.apps.w.f.ajb().aiG();
            if (aiG == null) {
                return true;
            }
            e eVar = aiG.cFh;
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            b.a aVar = null;
            if (apM != null) {
                aVar = apM.RP();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean Xs = com.baidu.swan.apps.console.debugger.a.e.Xs();
            boolean ST = com.baidu.swan.apps.core.a.ST();
            boolean anx = com.baidu.swan.apps.af.a.a.anx();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + Xs + " isMobileDebug: " + ST + " urlCheck: " + eVar.cFu);
            }
            return (b || Xs || ST || anx) && !eVar.cFu;
        }

        private static e aqI() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            e eVar = new e();
            eVar.cFu = true;
            return eVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class j {
        public String cFJ;
        public String cFK;
        public String cFL;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bg(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aqO();
            }
            j jVar = new j();
            jVar.cFJ = jSONObject.optString("pagePath");
            jVar.cFK = jSONObject.optString("iconPath");
            jVar.cFL = jSONObject.optString("selectedIconPath");
            jVar.mText = jSONObject.optString("text");
            return jVar;
        }

        private static j aqO() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new j();
        }
    }

    /* loaded from: classes11.dex */
    public static class g {
        public List<f> cFB;
        public HashMap<String, Boolean> cFC;
        public HashMap<String, String> cFD;
        public HashMap<String, String> cFE;

        /* JADX INFO: Access modifiers changed from: private */
        public static g e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aqK();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aqK();
            }
            g gVar = new g();
            gVar.cFB = new ArrayList();
            gVar.cFD = new HashMap<>();
            gVar.cFC = new HashMap<>();
            gVar.cFE = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    gVar.cFB.add(f.a(optJSONObject, gVar.cFD, gVar.cFE, file));
                }
            }
            return gVar;
        }

        private static g aqK() {
            g gVar = new g();
            gVar.cFB = new ArrayList();
            gVar.cFD = new HashMap<>();
            gVar.cFC = new HashMap<>();
            gVar.cFE = new HashMap<>();
            return gVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        private static final String cFy = File.separator;
        public b cFA;
        public String cFv;
        public List<String> cFw;
        boolean cFx = false;
        public b cFz;

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aqJ();
            }
            f fVar = new f();
            fVar.cFv = jSONObject.optString("root");
            fVar.cFx = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                fVar.cFw = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    fVar.cFw.add(optString);
                    if (!TextUtils.isEmpty(fVar.cFv) && !TextUtils.isEmpty(optString)) {
                        if (fVar.cFv.endsWith(cFy) || optString.startsWith(cFy)) {
                            str = fVar.cFv + optString;
                        } else {
                            str = fVar.cFv + cFy + optString;
                        }
                        hashMap.put(str, fVar.cFv);
                        if (fVar.cFx) {
                            hashMap2.put(str, fVar.cFv);
                        }
                    }
                }
            }
            return fVar;
        }

        private static f aqJ() {
            f fVar = new f();
            fVar.cFw = new ArrayList();
            return fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aiK() {
            if (TextUtils.isEmpty(this.cFv) || this.cFw == null || this.cFw.size() <= 0) {
                return null;
            }
            String str = this.cFw.get(0);
            if (this.cFv.endsWith(cFy)) {
                this.cFv = this.cFv.substring(0, this.cFv.length() - 1);
            }
            if (str.startsWith(cFy)) {
                str = str.substring(1);
            }
            return this.cFv + cFy + str;
        }
    }

    /* loaded from: classes11.dex */
    public static class h {
        public HashMap<String, String> cFF;

        /* JADX INFO: Access modifiers changed from: private */
        public static h a(JSONObject jSONObject, g gVar) {
            if (jSONObject == null || gVar == null || gVar.cFB == null || gVar.cFB.size() <= 0) {
                return aqL();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aqL();
            }
            h hVar = new h();
            hVar.cFF = new HashMap<>();
            for (f fVar : gVar.cFB) {
                if (fVar != null && !TextUtils.isEmpty(fVar.cFv)) {
                    hVar.cFF.put(fVar.cFv, optJSONObject.optString(fVar.cFv));
                }
            }
            return hVar;
        }

        private static h aqL() {
            h hVar = new h();
            hVar.cFF = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<com.baidu.swan.apps.ae.f.a> cFr;

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
            bVar.cFr = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ae.f.a aVar = new com.baidu.swan.apps.ae.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cxO = next;
                if (file != null && !TextUtils.isEmpty(aVar.cxR)) {
                    aVar.cxR = new File(file, aVar.cxR).getAbsolutePath();
                }
                bVar.cFr.add(aVar);
            }
            return bVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class d {
        public HashMap<String, String> cFt;

        /* JADX INFO: Access modifiers changed from: private */
        public static d ba(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            d aqG = aqG();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aqG.cFt.containsKey(optString)) {
                            aqG.cFt.put(optString, optString2);
                        }
                    }
                }
            }
            return aqG;
        }

        private static d aqG() {
            d dVar = new d();
            dVar.cFt = new HashMap<>();
            return dVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public ArrayList<String> cFs;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static c aY(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            c cVar = new c();
            cVar.cFs = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                cVar.cFs.add(optJSONArray.optString(i));
            }
            return cVar;
        }
    }
}
