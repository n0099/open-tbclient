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
    public int ejS;
    public boolean ejT;
    public String ejU;
    public b.a ejV;
    public String ejW;
    public b ejX;
    public c ejY;
    public String ejZ;
    public com.baidu.swan.games.inspector.a eka;
    public com.baidu.swan.games.network.b.c ekb;

    public static a xd(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.ejU = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.ejV = b.a.bz(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.ejS = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.ejS = 1;
            }
            aVar2.ejT = jSONObject.optBoolean("showStatusBar", false);
            aVar2.ejW = jSONObject.optString("workers");
            aVar2.ejX = b.cD(jSONObject);
            aVar2.ejY = c.a(jSONObject, aVar2.ejX);
            aVar2.ejZ = jSONObject.optString("openDataContext");
            aVar2.eka = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qk("startup").cg("preload_resources", z ? "1" : "0");
            aVar2.ekb = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0528a> eke;
        public HashMap<String, Boolean> ekf;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cD(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXQ();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aXQ();
            }
            b bVar = new b();
            bVar.eke = new ArrayList();
            bVar.ekf = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.eke.add(C0528a.cB(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aXQ() {
            b bVar = new b();
            bVar.eke = new ArrayList();
            bVar.ekf = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0528a {
        public String ekc;
        public String ekd;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0528a cB(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXP();
            }
            C0528a c0528a = new C0528a();
            c0528a.ekc = jSONObject.optString("root");
            c0528a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0528a.ekc) || TextUtils.isEmpty(c0528a.name)) {
                return aXP();
            }
            if (c0528a.ekc.endsWith(".js")) {
                String[] split = c0528a.ekc.split(File.separator);
                if (split.length < 1) {
                    return aXP();
                }
                c0528a.ekd = split[split.length - 1];
                c0528a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0528a.path += split[i] + File.separator;
                }
            } else {
                c0528a.path = c0528a.ekc;
                if (!c0528a.path.endsWith(File.separator)) {
                    c0528a.path += File.separator;
                }
                c0528a.ekd = "index.js";
            }
            return c0528a;
        }

        private static C0528a aXP() {
            return new C0528a();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public HashMap<String, String> ekg;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.eke == null || bVar.eke.size() <= 0) {
                return aXR();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aXR();
            }
            c cVar = new c();
            cVar.ekg = new HashMap<>();
            for (C0528a c0528a : bVar.eke) {
                if (c0528a != null && !TextUtils.isEmpty(c0528a.ekc)) {
                    cVar.ekg.put(c0528a.ekc, optJSONObject.optString(c0528a.ekc));
                }
            }
            return cVar;
        }

        private static c aXR() {
            c cVar = new c();
            cVar.ekg = new HashMap<>();
            return cVar;
        }
    }
}
