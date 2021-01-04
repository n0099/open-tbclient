package com.baidu.swan.games.t.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.config.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public b.a emA;
    public String emB;
    public b emC;
    public c emD;
    public String emE;
    public com.baidu.swan.games.inspector.a emF;
    public com.baidu.swan.games.network.b.c emG;
    public int emx;
    public boolean emy;
    public String emz;

    public static a xV(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.emz = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.emA = b.a.bC(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.emx = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.emx = 1;
            }
            aVar2.emy = jSONObject.optBoolean("showStatusBar", false);
            aVar2.emB = jSONObject.optString("workers");
            aVar2.emC = b.cG(jSONObject);
            aVar2.emD = c.a(jSONObject, aVar2.emC);
            aVar2.emE = jSONObject.optString("openDataContext");
            aVar2.emF = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.rd("startup").cn("preload_resources", z ? "1" : "0");
            aVar2.emG = new com.baidu.swan.games.network.b.c(optJSONArray);
            aVar = aVar2;
            return aVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e));
                return aVar;
            }
            return aVar;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public List<C0548a> emJ;
        public HashMap<String, Boolean> emK;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cG(JSONObject jSONObject) {
            if (jSONObject == null) {
                return bbx();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return bbx();
            }
            b bVar = new b();
            bVar.emJ = new ArrayList();
            bVar.emK = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.emJ.add(C0548a.cE(optJSONObject));
                }
            }
            return bVar;
        }

        private static b bbx() {
            b bVar = new b();
            bVar.emJ = new ArrayList();
            bVar.emK = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0548a {
        public String emH;
        public String emI;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0548a cE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return bbw();
            }
            C0548a c0548a = new C0548a();
            c0548a.emH = jSONObject.optString("root");
            c0548a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0548a.emH) || TextUtils.isEmpty(c0548a.name)) {
                return bbw();
            }
            if (c0548a.emH.endsWith(".js")) {
                String[] split = c0548a.emH.split(File.separator);
                if (split.length < 1) {
                    return bbw();
                }
                c0548a.emI = split[split.length - 1];
                c0548a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0548a.path += split[i] + File.separator;
                }
            } else {
                c0548a.path = c0548a.emH;
                if (!c0548a.path.endsWith(File.separator)) {
                    c0548a.path += File.separator;
                }
                c0548a.emI = "index.js";
            }
            return c0548a;
        }

        private static C0548a bbw() {
            return new C0548a();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public HashMap<String, String> emL;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.emJ == null || bVar.emJ.size() <= 0) {
                return bby();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return bby();
            }
            c cVar = new c();
            cVar.emL = new HashMap<>();
            for (C0548a c0548a : bVar.emJ) {
                if (c0548a != null && !TextUtils.isEmpty(c0548a.emH)) {
                    cVar.emL.put(c0548a.emH, optJSONObject.optString(c0548a.emH));
                }
            }
            return cVar;
        }

        private static c bby() {
            c cVar = new c();
            cVar.emL = new HashMap<>();
            return cVar;
        }
    }
}
