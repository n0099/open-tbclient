package com.baidu.swan.games.s.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.runtime.config.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.network.b.c crA;
    public int crr;
    public boolean crs;
    public String crt;
    public b.a cru;
    public String crv;
    public b crw;
    public c crx;
    public String cry;
    public com.baidu.swan.games.inspector.a crz;

    public static a pu(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.crt = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.cru = b.a.ay(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.crr = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.crr = 1;
            }
            aVar2.crs = jSONObject.optBoolean("showStatusBar", false);
            aVar2.crv = jSONObject.optString("workers");
            aVar2.crw = b.bE(jSONObject);
            aVar2.crx = c.a(jSONObject, aVar2.crw);
            aVar2.cry = jSONObject.optString("openDataContext");
            aVar2.crz = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.jO("startup").ba("preload_resources", z ? "1" : "0");
            aVar2.crA = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes11.dex */
    public static class b {
        public List<C0346a> crD;
        public HashMap<String, Boolean> crE;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apl();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return apl();
            }
            b bVar = new b();
            bVar.crD = new ArrayList();
            bVar.crE = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.crD.add(C0346a.bC(optJSONObject));
                }
            }
            return bVar;
        }

        private static b apl() {
            b bVar = new b();
            bVar.crD = new ArrayList();
            bVar.crE = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0346a {
        public String crB;
        public String crC;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0346a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apk();
            }
            C0346a c0346a = new C0346a();
            c0346a.crB = jSONObject.optString("root");
            c0346a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0346a.crB) || TextUtils.isEmpty(c0346a.name)) {
                return apk();
            }
            if (c0346a.crB.endsWith(".js")) {
                String[] split = c0346a.crB.split(File.separator);
                if (split.length < 1) {
                    return apk();
                }
                c0346a.crC = split[split.length - 1];
                c0346a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0346a.path += split[i] + File.separator;
                }
            } else {
                c0346a.path = c0346a.crB;
                if (!c0346a.path.endsWith(File.separator)) {
                    c0346a.path += File.separator;
                }
                c0346a.crC = "index.js";
            }
            return c0346a;
        }

        private static C0346a apk() {
            return new C0346a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> crF;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.crD == null || bVar.crD.size() <= 0) {
                return apm();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return apm();
            }
            c cVar = new c();
            cVar.crF = new HashMap<>();
            for (C0346a c0346a : bVar.crD) {
                if (c0346a != null && !TextUtils.isEmpty(c0346a.crB)) {
                    cVar.crF.put(c0346a.crB, optJSONObject.optString(c0346a.crB));
                }
            }
            return cVar;
        }

        private static c apm() {
            c cVar = new c();
            cVar.crF = new HashMap<>();
            return cVar;
        }
    }
}
