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
/* loaded from: classes7.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dWB;
    public boolean dWC;
    public String dWD;
    public b.a dWE;
    public String dWF;
    public b dWG;
    public c dWH;
    public String dWI;
    public com.baidu.swan.games.inspector.a dWJ;
    public com.baidu.swan.games.network.b.c dWK;

    public static a xp(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dWD = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dWE = b.a.bs(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dWB = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dWB = 1;
            }
            aVar2.dWC = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dWF = jSONObject.optString("workers");
            aVar2.dWG = b.cw(jSONObject);
            aVar2.dWH = c.a(jSONObject, aVar2.dWG);
            aVar2.dWI = jSONObject.optString("openDataContext");
            aVar2.dWJ = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qD("startup").ch("preload_resources", z ? "1" : "0");
            aVar2.dWK = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes7.dex */
    public static class b {
        public List<C0543a> dWN;
        public HashMap<String, Boolean> dWO;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cw(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aVY();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aVY();
            }
            b bVar = new b();
            bVar.dWN = new ArrayList();
            bVar.dWO = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dWN.add(C0543a.cu(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aVY() {
            b bVar = new b();
            bVar.dWN = new ArrayList();
            bVar.dWO = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0543a {
        public String dWL;
        public String dWM;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0543a cu(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aVX();
            }
            C0543a c0543a = new C0543a();
            c0543a.dWL = jSONObject.optString("root");
            c0543a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0543a.dWL) || TextUtils.isEmpty(c0543a.name)) {
                return aVX();
            }
            if (c0543a.dWL.endsWith(".js")) {
                String[] split = c0543a.dWL.split(File.separator);
                if (split.length < 1) {
                    return aVX();
                }
                c0543a.dWM = split[split.length - 1];
                c0543a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0543a.path += split[i] + File.separator;
                }
            } else {
                c0543a.path = c0543a.dWL;
                if (!c0543a.path.endsWith(File.separator)) {
                    c0543a.path += File.separator;
                }
                c0543a.dWM = "index.js";
            }
            return c0543a;
        }

        private static C0543a aVX() {
            return new C0543a();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public HashMap<String, String> dWP;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dWN == null || bVar.dWN.size() <= 0) {
                return aVZ();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aVZ();
            }
            c cVar = new c();
            cVar.dWP = new HashMap<>();
            for (C0543a c0543a : bVar.dWN) {
                if (c0543a != null && !TextUtils.isEmpty(c0543a.dWL)) {
                    cVar.dWP.put(c0543a.dWL, optJSONObject.optString(c0543a.dWL));
                }
            }
            return cVar;
        }

        private static c aVZ() {
            c cVar = new c();
            cVar.dWP = new HashMap<>();
            return cVar;
        }
    }
}
