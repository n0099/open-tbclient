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
    public int ehL;
    public boolean ehM;
    public String ehN;
    public b.a ehO;
    public String ehP;
    public b ehQ;
    public c ehR;
    public String ehS;
    public com.baidu.swan.games.inspector.a ehT;
    public com.baidu.swan.games.network.b.c ehU;

    public static a wK(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.ehN = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.ehO = b.a.bC(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.ehL = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.ehL = 1;
            }
            aVar2.ehM = jSONObject.optBoolean("showStatusBar", false);
            aVar2.ehP = jSONObject.optString("workers");
            aVar2.ehQ = b.cG(jSONObject);
            aVar2.ehR = c.a(jSONObject, aVar2.ehQ);
            aVar2.ehS = jSONObject.optString("openDataContext");
            aVar2.ehT = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.pS("startup").cm("preload_resources", z ? "1" : "0");
            aVar2.ehU = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0531a> ehX;
        public HashMap<String, Boolean> ehY;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cG(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXE();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aXE();
            }
            b bVar = new b();
            bVar.ehX = new ArrayList();
            bVar.ehY = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.ehX.add(C0531a.cE(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aXE() {
            b bVar = new b();
            bVar.ehX = new ArrayList();
            bVar.ehY = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0531a {
        public String ehV;
        public String ehW;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0531a cE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aXD();
            }
            C0531a c0531a = new C0531a();
            c0531a.ehV = jSONObject.optString("root");
            c0531a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0531a.ehV) || TextUtils.isEmpty(c0531a.name)) {
                return aXD();
            }
            if (c0531a.ehV.endsWith(".js")) {
                String[] split = c0531a.ehV.split(File.separator);
                if (split.length < 1) {
                    return aXD();
                }
                c0531a.ehW = split[split.length - 1];
                c0531a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0531a.path += split[i] + File.separator;
                }
            } else {
                c0531a.path = c0531a.ehV;
                if (!c0531a.path.endsWith(File.separator)) {
                    c0531a.path += File.separator;
                }
                c0531a.ehW = "index.js";
            }
            return c0531a;
        }

        private static C0531a aXD() {
            return new C0531a();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public HashMap<String, String> ehZ;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.ehX == null || bVar.ehX.size() <= 0) {
                return aXF();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aXF();
            }
            c cVar = new c();
            cVar.ehZ = new HashMap<>();
            for (C0531a c0531a : bVar.ehX) {
                if (c0531a != null && !TextUtils.isEmpty(c0531a.ehV)) {
                    cVar.ehZ.put(c0531a.ehV, optJSONObject.optString(c0531a.ehV));
                }
            }
            return cVar;
        }

        private static c aXF() {
            c cVar = new c();
            cVar.ehZ = new HashMap<>();
            return cVar;
        }
    }
}
