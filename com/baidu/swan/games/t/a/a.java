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
/* loaded from: classes25.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int edA;
    public boolean edB;
    public String edC;
    public b.a edD;
    public String edE;
    public b edF;
    public c edG;
    public String edH;
    public com.baidu.swan.games.inspector.a edI;
    public com.baidu.swan.games.network.b.c edJ;

    public static a xW(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.edC = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.edD = b.a.bu(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.edA = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.edA = 1;
            }
            aVar2.edB = jSONObject.optBoolean("showStatusBar", false);
            aVar2.edE = jSONObject.optString("workers");
            aVar2.edF = b.cy(jSONObject);
            aVar2.edG = c.a(jSONObject, aVar2.edF);
            aVar2.edH = jSONObject.optString("openDataContext");
            aVar2.edI = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.rk("startup").co("preload_resources", z ? "1" : "0");
            aVar2.edJ = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes25.dex */
    public static class b {
        public List<C0555a> edM;
        public HashMap<String, Boolean> edN;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cy(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aZd();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aZd();
            }
            b bVar = new b();
            bVar.edM = new ArrayList();
            bVar.edN = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.edM.add(C0555a.cw(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aZd() {
            b bVar = new b();
            bVar.edM = new ArrayList();
            bVar.edN = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0555a {
        public String edK;
        public String edL;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0555a cw(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aZc();
            }
            C0555a c0555a = new C0555a();
            c0555a.edK = jSONObject.optString("root");
            c0555a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0555a.edK) || TextUtils.isEmpty(c0555a.name)) {
                return aZc();
            }
            if (c0555a.edK.endsWith(".js")) {
                String[] split = c0555a.edK.split(File.separator);
                if (split.length < 1) {
                    return aZc();
                }
                c0555a.edL = split[split.length - 1];
                c0555a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0555a.path += split[i] + File.separator;
                }
            } else {
                c0555a.path = c0555a.edK;
                if (!c0555a.path.endsWith(File.separator)) {
                    c0555a.path += File.separator;
                }
                c0555a.edL = "index.js";
            }
            return c0555a;
        }

        private static C0555a aZc() {
            return new C0555a();
        }
    }

    /* loaded from: classes25.dex */
    public static class c {
        public HashMap<String, String> edO;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.edM == null || bVar.edM.size() <= 0) {
                return aZe();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aZe();
            }
            c cVar = new c();
            cVar.edO = new HashMap<>();
            for (C0555a c0555a : bVar.edM) {
                if (c0555a != null && !TextUtils.isEmpty(c0555a.edK)) {
                    cVar.edO.put(c0555a.edK, optJSONObject.optString(c0555a.edK));
                }
            }
            return cVar;
        }

        private static c aZe() {
            c cVar = new c();
            cVar.edO = new HashMap<>();
            return cVar;
        }
    }
}
