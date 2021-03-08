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
/* loaded from: classes8.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String elA;
    public com.baidu.swan.games.inspector.a elB;
    public com.baidu.swan.games.network.b.c elC;
    public int elt;
    public boolean elu;
    public String elv;
    public b.a elw;
    public String elx;
    public b ely;
    public c elz;

    public static a xk(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.elv = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.elw = b.a.bB(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.elt = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.elt = 1;
            }
            aVar2.elu = jSONObject.optBoolean("showStatusBar", false);
            aVar2.elx = jSONObject.optString("workers");
            aVar2.ely = b.cF(jSONObject);
            aVar2.elz = c.a(jSONObject, aVar2.ely);
            aVar2.elA = jSONObject.optString("openDataContext");
            aVar2.elB = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qr("startup").cg("preload_resources", z ? "1" : "0");
            aVar2.elC = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes8.dex */
    public static class b {
        public List<C0534a> elF;
        public HashMap<String, Boolean> elG;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cF(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXT();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aXT();
            }
            b bVar = new b();
            bVar.elF = new ArrayList();
            bVar.elG = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.elF.add(C0534a.cD(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aXT() {
            b bVar = new b();
            bVar.elF = new ArrayList();
            bVar.elG = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0534a {
        public String elD;
        public String elE;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0534a cD(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXS();
            }
            C0534a c0534a = new C0534a();
            c0534a.elD = jSONObject.optString("root");
            c0534a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0534a.elD) || TextUtils.isEmpty(c0534a.name)) {
                return aXS();
            }
            if (c0534a.elD.endsWith(".js")) {
                String[] split = c0534a.elD.split(File.separator);
                if (split.length < 1) {
                    return aXS();
                }
                c0534a.elE = split[split.length - 1];
                c0534a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0534a.path += split[i] + File.separator;
                }
            } else {
                c0534a.path = c0534a.elD;
                if (!c0534a.path.endsWith(File.separator)) {
                    c0534a.path += File.separator;
                }
                c0534a.elE = "index.js";
            }
            return c0534a;
        }

        private static C0534a aXS() {
            return new C0534a();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public HashMap<String, String> elH;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.elF == null || bVar.elF.size() <= 0) {
                return aXU();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aXU();
            }
            c cVar = new c();
            cVar.elH = new HashMap<>();
            for (C0534a c0534a : bVar.elF) {
                if (c0534a != null && !TextUtils.isEmpty(c0534a.elD)) {
                    cVar.elH.put(c0534a.elD, optJSONObject.optString(c0534a.elD));
                }
            }
            return cVar;
        }

        private static c aXU() {
            c cVar = new c();
            cVar.elH = new HashMap<>();
            return cVar;
        }
    }
}
