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
/* loaded from: classes10.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cnb;
    public boolean cnc;
    public String cnd;
    public b.a cne;
    public String cnf;
    public b cng;
    public c cnh;
    public String cni;
    public com.baidu.swan.games.inspector.a cnj;
    public com.baidu.swan.games.network.b.c cnk;

    public static a pg(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.cnd = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.cne = b.a.ay(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.cnb = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.cnb = 1;
            }
            aVar2.cnc = jSONObject.optBoolean("showStatusBar", false);
            aVar2.cnf = jSONObject.optString("workers");
            aVar2.cng = b.bE(jSONObject);
            aVar2.cnh = c.a(jSONObject, aVar2.cng);
            aVar2.cni = jSONObject.optString("openDataContext");
            aVar2.cnj = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.jA("startup").aS("preload_resources", z ? "1" : "0");
            aVar2.cnk = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes10.dex */
    public static class b {
        public List<C0336a> cnn;
        public HashMap<String, Boolean> cno;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return amS();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return amS();
            }
            b bVar = new b();
            bVar.cnn = new ArrayList();
            bVar.cno = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.cnn.add(C0336a.bC(optJSONObject));
                }
            }
            return bVar;
        }

        private static b amS() {
            b bVar = new b();
            bVar.cnn = new ArrayList();
            bVar.cno = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0336a {
        public String cnl;
        public String cnm;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0336a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return amR();
            }
            C0336a c0336a = new C0336a();
            c0336a.cnl = jSONObject.optString("root");
            c0336a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0336a.cnl) || TextUtils.isEmpty(c0336a.name)) {
                return amR();
            }
            if (c0336a.cnl.endsWith(".js")) {
                String[] split = c0336a.cnl.split(File.separator);
                if (split.length < 1) {
                    return amR();
                }
                c0336a.cnm = split[split.length - 1];
                c0336a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0336a.path += split[i] + File.separator;
                }
            } else {
                c0336a.path = c0336a.cnl;
                if (!c0336a.path.endsWith(File.separator)) {
                    c0336a.path += File.separator;
                }
                c0336a.cnm = "index.js";
            }
            return c0336a;
        }

        private static C0336a amR() {
            return new C0336a();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public HashMap<String, String> cnp;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.cnn == null || bVar.cnn.size() <= 0) {
                return amT();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return amT();
            }
            c cVar = new c();
            cVar.cnp = new HashMap<>();
            for (C0336a c0336a : bVar.cnn) {
                if (c0336a != null && !TextUtils.isEmpty(c0336a.cnl)) {
                    cVar.cnp.put(c0336a.cnl, optJSONObject.optString(c0336a.cnl));
                }
            }
            return cVar;
        }

        private static c amT() {
            c cVar = new c();
            cVar.cnp = new HashMap<>();
            return cVar;
        }
    }
}
