package com.baidu.swan.apps.runtime.config;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
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
/* loaded from: classes7.dex */
public class SwanAppConfigData {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final HashMap<String, Integer> cIh = new HashMap<>();
    public a cHS;
    public h cHT;
    public i cHU;
    public com.baidu.swan.apps.runtime.config.c cHV;
    public j cHW;
    public f cHX;
    public b.a cHY;
    public c cHZ;
    public c cIa;
    @Nullable
    public d cIb;
    public List<com.baidu.swan.pms.model.h> cIc;
    public String cId;
    public e cIe;
    public b cIf;
    @NonNull
    public Set<RequiredBackgroundModeItem> cIg = new HashSet(1);
    public boolean mIsDebug;

    static {
        cIh.put("light", -1);
        cIh.put("dark", Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
    }

    private SwanAppConfigData() {
    }

    @Nullable
    public static SwanAppConfigData m(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = new SwanAppConfigData();
        swanAppConfigData.cId = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            swanAppConfigData.cIa = c.a(jSONObject, file);
            swanAppConfigData.cHZ = c.b(jSONObject, file);
            JSONArray optJSONArray = jSONObject.optJSONArray("remote_debug_plugins");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                swanAppConfigData.cIc = com.baidu.swan.apps.ad.g.b.P(optJSONArray.toString(), false);
            }
            swanAppConfigData.mIsDebug = jSONObject.optBoolean("debug");
            swanAppConfigData.cHS = a.aZ(jSONObject);
            swanAppConfigData.cHT = h.e(jSONObject, file);
            swanAppConfigData.cHU = i.a(jSONObject, swanAppConfigData.cHT);
            swanAppConfigData.cHV = com.baidu.swan.apps.runtime.config.c.bn(jSONObject);
            swanAppConfigData.cHW = j.bj(jSONObject);
            swanAppConfigData.cHX = f.bh(jSONObject);
            swanAppConfigData.cHY = b.a.aY(jSONObject);
            swanAppConfigData.cIe = e.bf(jSONObject);
            swanAppConfigData.cIb = d.bd(jSONObject);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("requiredBackgroundModes");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    RequiredBackgroundModeItem find = RequiredBackgroundModeItem.find(optJSONArray2.optString(i2));
                    if (find != null) {
                        swanAppConfigData.cIg.add(find);
                    }
                }
            }
            swanAppConfigData.cIf = b.bb(jSONObject);
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
        File file2 = new File(file, com.baidu.swan.apps.t.a.ahU().getHostName() + "_app.json");
        if (file2.exists()) {
            String readFileData = com.baidu.swan.d.d.readFileData(file2);
            if (!TextUtils.isEmpty(readFileData)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(readFileData);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("window");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        swanAppConfigData.cHV = com.baidu.swan.apps.runtime.config.c.bn(jSONObject2);
                        jSONObject.put("window", optJSONObject);
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("tabBar");
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        swanAppConfigData.cHW = j.bj(jSONObject2);
                        jSONObject.put("tabBar", optJSONObject2);
                    }
                    swanAppConfigData.cId = jSONObject.toString();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static int dU(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            str = ow(str);
            return Color.parseColor(str);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("SwanAppConfigData", "parseColor failed:" + Log.getStackTraceString(e2));
            }
            if (cIh.containsKey(str)) {
                return cIh.get(str).intValue();
            }
            return -1;
        }
    }

    public static String ow(String str) {
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

    public String aka() {
        return asi() ? this.cHS.mPages.get(0) : "";
    }

    public String ox(String str) {
        if (this.cHT == null || this.cHT.cIt == null) {
            return null;
        }
        for (g gVar : this.cHT.cIt) {
            if (TextUtils.equals(gVar.cIn, str)) {
                return gVar.aka();
            }
        }
        return null;
    }

    public boolean asi() {
        return (this.cHS == null || this.cHS.mPages == null || this.cHS.mPages.isEmpty()) ? false : true;
    }

    public boolean asj() {
        return (this.cHT == null || this.cHT.cIt == null || this.cHT.cIv == null) ? false : true;
    }

    private boolean ask() {
        return (this.cHT == null || this.cHT.cIt == null || this.cHT.cIw == null) ? false : true;
    }

    public boolean oy(String str) {
        return asj() && this.cHT.cIv.containsKey(str);
    }

    public boolean oz(String str) {
        return ask() && this.cHT.cIw.containsKey(str);
    }

    public String op(String str) {
        String oZ = com.baidu.swan.apps.scheme.actions.k.j.oZ(aj.delAllParamsFromUrl(str));
        if (TextUtils.isEmpty(oZ)) {
            return "main";
        }
        if (com.baidu.swan.apps.ad.b.a.nw(oZ)) {
            return "dynamicLib";
        }
        if (!oy(oZ)) {
            return "main";
        }
        if (!oz(oZ)) {
            return "subNormal";
        }
        return "independent";
    }

    public boolean asl() {
        return this.cHW != null && this.cHW.asv();
    }

    public boolean oA(String str) {
        return (asi() && this.cHS.oD(str)) || (asj() && this.cHT.cIv.containsKey(str));
    }

    public boolean oB(String str) {
        return this.cHW != null && this.cHW.oE(str);
    }

    public String oC(String str) {
        if (this.cIe != null && this.cIe.cIl != null) {
            String delAllParamsFromUrl = aj.delAllParamsFromUrl(str);
            String str2 = this.cIe.cIl.get(delAllParamsFromUrl);
            return !TextUtils.isEmpty(str2) ? str.replaceFirst(delAllParamsFromUrl, str2) : str;
        }
        return str;
    }

    public List<com.baidu.swan.apps.ad.f.a> hg(int i2) {
        List<g> list;
        List<g> list2;
        if (i2 == 3) {
            ArrayList arrayList = new ArrayList();
            a(this.cIa, arrayList);
            if (this.cHT != null && (list2 = this.cHT.cIt) != null) {
                for (g gVar : list2) {
                    if (gVar != null) {
                        a(gVar.cIr, arrayList);
                    }
                }
            }
            return arrayList;
        } else if (i2 == 4) {
            ArrayList arrayList2 = new ArrayList();
            a(this.cHZ, arrayList2);
            if (this.cHT != null && (list = this.cHT.cIt) != null) {
                for (g gVar2 : list) {
                    if (gVar2 != null) {
                        a(gVar2.cIs, arrayList2);
                    }
                }
            }
            return arrayList2;
        } else {
            return null;
        }
    }

    private void a(c cVar, List<com.baidu.swan.apps.ad.f.a> list) {
        List<com.baidu.swan.apps.ad.f.a> list2;
        if (cVar != null && list != null && (list2 = cVar.cIj) != null && list2.size() > 0) {
            list.addAll(list2);
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public ArrayList<String> mPages;

        /* JADX INFO: Access modifiers changed from: private */
        public static a aZ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return asn();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray == null) {
                return asn();
            }
            a aVar = new a();
            aVar.mPages = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.mPages.add(optJSONArray.optString(i));
            }
            return aVar;
        }

        public boolean oD(String str) {
            return this.mPages != null && this.mPages.contains(str);
        }

        private static a asn() {
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

    /* loaded from: classes7.dex */
    public static class j {
        public ArrayList<k> cIA;
        public int cIy;
        public int cIz;
        public int mBackgroundColor;
        public int mColor;

        /* JADX INFO: Access modifiers changed from: private */
        public static j bj(JSONObject jSONObject) {
            int length;
            if (jSONObject == null) {
                return asw();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
            if (optJSONObject == null) {
                return asw();
            }
            j jVar = new j();
            jVar.mColor = SwanAppConfigData.dU(optJSONObject.optString("color", "#999999"));
            jVar.cIy = SwanAppConfigData.dU(optJSONObject.optString("selectedColor", "black"));
            jVar.cIz = SwanAppConfigData.dU(optJSONObject.optString("borderStyle", "black"));
            jVar.mBackgroundColor = SwanAppConfigData.dU(optJSONObject.optString("backgroundColor", "white"));
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i = length <= 5 ? length : 5;
                jVar.cIA = new ArrayList<>(i);
                for (int i2 = 0; i2 < i; i2++) {
                    jVar.cIA.add(k.bl(optJSONArray.optJSONObject(i2)));
                }
            }
            return jVar;
        }

        public boolean asv() {
            return this.cIA != null && this.cIA.size() >= 2;
        }

        public boolean oE(String str) {
            if (this.cIA == null) {
                return false;
            }
            for (int i = 0; i < this.cIA.size(); i++) {
                if (TextUtils.equals(this.cIA.get(i).cIB, str)) {
                    return true;
                }
            }
            return false;
        }

        private static j asw() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabBarConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            j jVar = new j();
            jVar.cIA = new ArrayList<>();
            return jVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public boolean cIm;

        /* JADX INFO: Access modifiers changed from: private */
        public static f bh(JSONObject jSONObject) {
            if (jSONObject == null) {
                return asr();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("setting");
            if (optJSONObject == null) {
                return asr();
            }
            com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
            String str = "";
            if (arv != null) {
                str = arv.id;
            }
            f fVar = new f();
            fVar.cIm = optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                com.baidu.swan.apps.ah.a.c.a(str, "", optJSONObject2.optJSONArray("web_view_domains"));
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject3 != null) {
                    com.baidu.swan.apps.ah.a.c.g(str, optJSONObject3);
                }
            }
            return fVar;
        }

        public static boolean asq() {
            SwanAppConfigData ajW = com.baidu.swan.apps.v.f.akr().ajW();
            if (ajW == null) {
                return true;
            }
            f fVar = ajW.cHX;
            com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
            b.a aVar = null;
            if (arv != null) {
                aVar = arv.Se();
            }
            boolean b = com.baidu.swan.apps.e.a.b(aVar);
            boolean XY = com.baidu.swan.apps.console.debugger.a.e.XY();
            boolean To = com.baidu.swan.apps.core.c.To();
            boolean apg = com.baidu.swan.apps.ae.a.a.apg();
            if (SwanAppConfigData.DEBUG) {
                Log.d("SwanAppConfigData", "isDevelop: " + b + " isRemoteDebug: " + XY + " isMobileDebug: " + To + " urlCheck: " + fVar.cIm);
            }
            return (b || XY || To || apg) && !fVar.cIm;
        }

        private static f asr() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "SettingConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            f fVar = new f();
            fVar.cIm = true;
            return fVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class k {
        public String cIB;
        public String cIC;
        public String cID;
        public String mText;

        /* JADX INFO: Access modifiers changed from: private */
        public static k bl(JSONObject jSONObject) {
            if (jSONObject == null) {
                return asx();
            }
            k kVar = new k();
            kVar.cIB = jSONObject.optString("pagePath");
            kVar.cIC = jSONObject.optString("iconPath");
            kVar.cID = jSONObject.optString("selectedIconPath");
            kVar.mText = jSONObject.optString("text");
            return kVar;
        }

        private static k asx() {
            if (SwanAppConfigData.DEBUG) {
                Log.e("SwanAppConfigData", "TabItem createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            return new k();
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public List<g> cIt;
        public HashMap<String, Boolean> cIu;
        public HashMap<String, String> cIv;
        public HashMap<String, String> cIw;

        /* JADX INFO: Access modifiers changed from: private */
        public static h e(JSONObject jSONObject, File file) {
            if (jSONObject == null) {
                return ast();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subPackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return ast();
            }
            h hVar = new h();
            hVar.cIt = new ArrayList();
            hVar.cIv = new HashMap<>();
            hVar.cIu = new HashMap<>();
            hVar.cIw = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    hVar.cIt.add(g.a(optJSONObject, hVar.cIv, hVar.cIw, file));
                }
            }
            return hVar;
        }

        private static h ast() {
            h hVar = new h();
            hVar.cIt = new ArrayList();
            hVar.cIv = new HashMap<>();
            hVar.cIu = new HashMap<>();
            hVar.cIw = new HashMap<>();
            return hVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class g {
        private static final String cIq = File.separator;
        public String cIn;
        public List<String> cIo;
        boolean cIp = false;
        public c cIr;
        public c cIs;

        /* JADX INFO: Access modifiers changed from: private */
        public static g a(JSONObject jSONObject, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, File file) {
            String str;
            if (jSONObject == null || hashMap == null) {
                return ass();
            }
            g gVar = new g();
            gVar.cIn = jSONObject.optString("root");
            gVar.cIp = jSONObject.optBoolean("independent");
            JSONArray optJSONArray = jSONObject.optJSONArray("pages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                gVar.cIo = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    gVar.cIo.add(optString);
                    if (!TextUtils.isEmpty(gVar.cIn) && !TextUtils.isEmpty(optString)) {
                        if (gVar.cIn.endsWith(cIq) || optString.startsWith(cIq)) {
                            str = gVar.cIn + optString;
                        } else {
                            str = gVar.cIn + cIq + optString;
                        }
                        hashMap.put(str, gVar.cIn);
                        if (gVar.cIp) {
                            hashMap2.put(str, gVar.cIn);
                        }
                    }
                }
            }
            return gVar;
        }

        private static g ass() {
            g gVar = new g();
            gVar.cIo = new ArrayList();
            return gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String aka() {
            if (TextUtils.isEmpty(this.cIn) || this.cIo == null || this.cIo.size() <= 0) {
                return null;
            }
            String str = this.cIo.get(0);
            if (this.cIn.endsWith(cIq)) {
                this.cIn = this.cIn.substring(0, this.cIn.length() - 1);
            }
            if (str.startsWith(cIq)) {
                str = str.substring(1);
            }
            return this.cIn + cIq + str;
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public HashMap<String, String> cIx;

        /* JADX INFO: Access modifiers changed from: private */
        public static i a(JSONObject jSONObject, h hVar) {
            if (jSONObject == null || hVar == null || hVar.cIt == null || hVar.cIt.size() <= 0) {
                return asu();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return asu();
            }
            i iVar = new i();
            iVar.cIx = new HashMap<>();
            for (g gVar : hVar.cIt) {
                if (gVar != null && !TextUtils.isEmpty(gVar.cIn)) {
                    iVar.cIx.put(gVar.cIn, optJSONObject.optString(gVar.cIn));
                }
            }
            return iVar;
        }

        private static i asu() {
            i iVar = new i();
            iVar.cIx = new HashMap<>();
            return iVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public List<com.baidu.swan.apps.ad.f.a> cIj;

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
            cVar.cIj = new ArrayList();
            while (keys.hasNext()) {
                String next = keys.next();
                com.baidu.swan.apps.ad.f.a aVar = new com.baidu.swan.apps.ad.f.a(optJSONObject.optJSONObject(next), i);
                aVar.cAn = next;
                if (file != null && !TextUtils.isEmpty(aVar.cAq)) {
                    aVar.cAq = new File(file, aVar.cAq).getAbsolutePath();
                }
                cVar.cIj.add(aVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public HashMap<String, String> cIl;

        /* JADX INFO: Access modifiers changed from: private */
        public static e bf(JSONObject jSONObject) {
            JSONArray optJSONArray;
            int length;
            e asp = asp();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("routes")) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        String optString2 = optJSONObject.optString("page");
                        if (!asp.cIl.containsKey(optString)) {
                            asp.cIl.put(optString, optString2);
                        }
                    }
                }
            }
            return asp;
        }

        private static e asp() {
            e eVar = new e();
            eVar.cIl = new HashMap<>();
            return eVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public ArrayList<String> cIk;

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static d bd(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prelinks")) == null) {
                return null;
            }
            d dVar = new d();
            dVar.cIk = new ArrayList<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.cIk.add(optJSONArray.optString(i));
            }
            return dVar;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public Map<String, Map<String, String>> cIi;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bb(JSONObject jSONObject) {
            b aso = aso();
            if (jSONObject == null) {
                return aso;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("permission");
            if (optJSONObject == null) {
                return null;
            }
            aso.cIi = new HashMap();
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
                aso.cIi.put(next, hashMap);
            }
            return aso;
        }

        private static b aso() {
            b bVar = new b();
            bVar.cIi = new HashMap();
            return bVar;
        }
    }
}
