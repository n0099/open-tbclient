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
/* loaded from: classes3.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> cTk = new HashMap<>();
    public a cSV;
    public h cSW;
    public i cSX;
    public com.baidu.swan.apps.runtime.config.c cSY;
    public j cSZ;
    public f cTa;
    public b.a cTb;
    public c cTc;
    public c cTd;
    @Nullable
    public d cTe;
    public List<com.baidu.swan.pms.model.h> cTf;
    public String cTg;
    public e cTh;
    public b cTi;
    @NonNull
    public Set<RequiredBackgroundModeItem> cTj = new HashSet(1);
    public boolean mIsDebug;

    static {
        cTk.put("light", -1);
        cTk.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData m(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.cTg = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.cTd = c.a(jSONObject, file);
            swanAppConfigData.cTc = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.cTf = com.baidu.swan.apps.ac.g.b.U(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean(ETAG.KEY_DEBUG);
            swanAppConfigData.cSV = a.bj(jSONObject);
            swanAppConfigData.cSW = h.e(jSONObject, file);
            swanAppConfigData.cSX = i.a(jSONObject, swanAppConfigData.cSW);
            swanAppConfigData.cSY = com.baidu.swan.apps.runtime.config.c.bx(jSONObject);
            swanAppConfigData.cSZ = j.bt(jSONObject);
            swanAppConfigData.cTa = f.br(jSONObject);
            swanAppConfigData.cTb = b.a.bi(jSONObject);
            swanAppConfigData.cTh = e.bp(jSONObject);
            swanAppConfigData.cTe = d.bn(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.cTj.add(find);
                    }
                }
            }
            swanAppConfigData.cTi = b.bl(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.aqg().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.c.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.cSY = com.baidu.swan.apps.runtime.config.c.bx(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.cSZ = j.bt(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.cTg = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int fq(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = qN(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (cTk.containsKey(str)) {
                return cTk.get(str).intValue();
            }
            return -1;
        }
    }

    public static String qN(String str) {
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

    public String ass() {
        return aBe() ? this.cSV.mPages.get(0) : "";
    }

    public String qO(String str) {
        if (this.cSW == null || this.cSW.cTw == null) {
            return null;
        }
        for (g gVar : this.cSW.cTw) {
            if (TextUtils.equals(gVar.cTq, str)) {
                return gVar.ass();
            }
        }
        return null;
    }

    public boolean aBe() {
        return (this.cSV == null || this.cSV.mPages == null || this.cSV.mPages.isEmpty()) ? false : true;
    }

    public boolean aBf() {
        return (this.cSW == null || this.cSW.cTw == null || this.cSW.cTy == null) ? false : true;
    }

    private boolean aBg() {
        return (this.cSW == null || this.cSW.cTw == null || this.cSW.cTz == null) ? false : true;
    }

    public boolean qP(String str) {
        return aBf() && this.cSW.cTy.containsKey(str);
    }

    public boolean qQ(String str) {
        return aBg() && this.cSW.cTz.containsKey(str);
    }

    public String qG(String str) {
        String rq = com.baidu.swan.apps.scheme.actions.k.j.rq(ai.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(rq)) {
            return "main";
        }
        if (com.baidu.swan.apps.ac.b.a.pO(rq)) {
            return "dynamicLib";
        }
        if (!qP(rq)) {
            return "main";
        }
        if (!qQ(rq)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean aBh() {
        return this.cSZ != null && this.cSZ.aBq();
    }

    public boolean qR(String str) {
        return (aBe() && this.cSV.qU(str)) || (aBf() && this.cSW.cTy.containsKey(str));
    }

    public boolean qS(String str) {
        return this.cSZ != null && this.cSZ.qV(str);
    }

    public String qT(String str) {
        if (this.cTh != null && this.cTh.cTo != null) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            String str2 = this.cTh.cTo.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ac.f.a> jy(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.cTd, arrayList);
            if (!com.baidu.swan.apps.performance.b.c.awV() && this.cSW != null && (list2 = this.cSW.cTw) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.cTu, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.cTc, arrayList2);
            if (!com.baidu.swan.apps.performance.b.c.awV() && this.cSW != null && (list = this.cSW.cTw) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.cTv, arrayList2);
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
        if (cVar != null && list != null && (list2 = cVar.cTm) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a bj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBi();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return aBi();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean qU(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a aBi() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "PageConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>();
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class j {
        public int cTB;
        public int cTC;
        public ArrayList<k> cTD;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bt(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return aBr();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return aBr();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.fq(optJSONObject.optString("color", "#999999"));
            jVar.cTB = SwanAppConfigData.fq(optJSONObject.optString("selectedColor", "black"));
            jVar.cTC = SwanAppConfigData.fq(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.fq(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.cTD = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.cTD.add(k.bv(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean aBq() {
            return this.cTD != null && this.cTD.size() >= 2;
        }

        public boolean qV(String str) {
            if (this.cTD == null) {
                return false;
            }
            for (int i = 0; i < this.cTD.size(); i++) {
                if (TextUtils.equals(this.cTD.get(i).cTE, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j aBr() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.cTD = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public boolean cTp;

        /* JADX INFO: Access modifiers changed from: private */
        public static f br(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBm();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return aBm();
            }
            com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
            String str = "";
            if (aAr != null) {
                str = aAr.id;
            }
            f fVar = new f();
            fVar.cTp = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
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

        public static boolean aBl() {
            SwanAppConfigData aso = com.baidu.swan.apps.v.f.asJ().aso();
            if (aso == null) {
                return true;
            }
            f fVar = aso.cTa;
            com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
            b.a aVar = null;
            if (aAr != null) {
                aVar = aAr.YI();
            }
            boolean b = com.baidu.swan.apps.f.a.b(aVar);
            boolean aeO = com.baidu.swan.apps.console.debugger.a.e.aeO();
            boolean ZX = com.baidu.swan.apps.core.e.ZX();
            boolean axM = com.baidu.swan.apps.ad.a.a.axM();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + aeO + " isMobileDebug: " + ZX + " urlCheck: " + fVar.cTp);
            }
            return (b || aeO || ZX || axM) && !fVar.cTp;
        }

        private static f aBm() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.cTp = true;
            return fVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class k {
        public String cTE;
        public String cTF;
        public String cTG;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bv(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBs();
            }
            k kVar = new k();
            kVar.cTE = jSONObject.optString("pagePath");
            kVar.cTF = jSONObject.optString("iconPath");
            kVar.cTG = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k aBs() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public List<g> cTw;
        public HashMap<String, Boolean> cTx;
        public HashMap<String, String> cTy;
        public HashMap<String, String> cTz;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return aBo();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aBo();
            }
            h hVar = new h();
            hVar.cTw = new ArrayList();
            hVar.cTy = new HashMap<>();
            hVar.cTx = new HashMap<>();
            hVar.cTz = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.cTw.add(g.a(optJSONObject, hVar.cTy, hVar.cTz, file));
                }
            }
            return hVar;
        }

        private static h aBo() {
            h hVar = new h();
            hVar.cTw = new ArrayList();
            hVar.cTy = new HashMap<>();
            hVar.cTx = new HashMap<>();
            hVar.cTz = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        private static final String cTt = File.separator;
        public String cTq;
        public List<String> cTr;
        boolean cTs = false;
        public c cTu;
        public c cTv;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return aBn();
            }
            g gVar = new g();
            gVar.cTq = jSONObject.optString("root");
            gVar.cTs = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.cTr = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.cTr.add(optString);
                    if (!TextUtils.isEmpty(gVar.cTq) && !TextUtils.isEmpty(optString)) {
                        if (gVar.cTq.endsWith(cTt) || optString.startsWith(cTt)) {
                            str = gVar.cTq + optString;
                        } else {
                            str = gVar.cTq + cTt + optString;
                        }
                        hashMap.put(str, gVar.cTq);
                        if (gVar.cTs) {
                            hashMap2.put(str, gVar.cTq);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g aBn() {
            g gVar = new g();
            gVar.cTr = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String ass() {
            if (TextUtils.isEmpty(this.cTq) || this.cTr == null || this.cTr.size() <= 0) {
                return null;
            }
            String str = this.cTr.get(0);
            if (this.cTq.endsWith(cTt)) {
                this.cTq = this.cTq.substring(0, this.cTq.length() - 1);
            }
            if (str.startsWith(cTt)) {
                str = str.substring(1);
            }
            return this.cTq + cTt + str;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public HashMap<String, String> cTA;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.cTw == null || hVar.cTw.size() <= 0) {
                return aBp();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aBp();
            }
            i iVar = new i();
            iVar.cTA = new HashMap<>();
            for (g gVar : hVar.cTw) {
                if (gVar != null && !TextUtils.isEmpty(gVar.cTq)) {
                    iVar.cTA.put(gVar.cTq, optJSONObject.optString(gVar.cTq));
                }
            }
            return iVar;
        }

        private static i aBp() {
            i iVar = new i();
            iVar.cTA = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public List<com.baidu.swan.apps.ac.f.a> cTm;

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
            cVar.cTm = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ac.f.a aVar = new com.baidu.swan.apps.ac.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cKA = next;
                if (file != null && !TextUtils.isEmpty(aVar.cKD)) {
                    aVar.cKD = new File(file, aVar.cKD).getAbsolutePath();
                }
                cVar.cTm.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public HashMap<String, String> cTo;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bp(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e aBk = aBk();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!aBk.cTo.containsKey(optString)) {
                            aBk.cTo.put(optString, optString2);
                        }
                    }
                }
            }
            return aBk;
        }

        private static e aBk() {
            e eVar = new e();
            eVar.cTo = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public ArrayList<String> cTn;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bn(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.cTn = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.cTn.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public Map<String, Map<String, String>> cTl;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bl(JSONObject jSONObject) {
            b aBj = aBj();
            if (jSONObject == null) {
                return aBj;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aBj.cTl = new HashMap();
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
                aBj.cTl.put(next, hashMap);
            }
            return aBj;
        }

        private static b aBj() {
            b bVar = new b();
            bVar.cTl = new HashMap();
            return bVar;
        }
    }
}
