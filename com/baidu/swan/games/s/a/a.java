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
/* loaded from: classes9.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cmO;
    public boolean cmP;
    public String cmQ;
    public b.a cmR;
    public String cmS;
    public b cmT;
    public c cmU;
    public String cmV;
    public com.baidu.swan.games.inspector.a cmW;
    public com.baidu.swan.games.network.b.c cmX;

    public static a pd(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.cmQ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.cmR = b.a.ay(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.cmO = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.cmO = 1;
            }
            aVar2.cmP = jSONObject.optBoolean("showStatusBar", false);
            aVar2.cmS = jSONObject.optString("workers");
            aVar2.cmT = b.bE(jSONObject);
            aVar2.cmU = c.a(jSONObject, aVar2.cmT);
            aVar2.cmV = jSONObject.optString("openDataContext");
            aVar2.cmW = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.jx("startup").aR("preload_resources", z ? "1" : "0");
            aVar2.cmX = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0334a> cna;
        public HashMap<String, Boolean> cnb;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return amz();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return amz();
            }
            b bVar = new b();
            bVar.cna = new ArrayList();
            bVar.cnb = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.cna.add(C0334a.bC(optJSONObject));
                }
            }
            return bVar;
        }

        private static b amz() {
            b bVar = new b();
            bVar.cna = new ArrayList();
            bVar.cnb = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0334a {
        public String cmY;
        public String cmZ;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0334a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return amy();
            }
            C0334a c0334a = new C0334a();
            c0334a.cmY = jSONObject.optString("root");
            c0334a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0334a.cmY) || TextUtils.isEmpty(c0334a.name)) {
                return amy();
            }
            if (c0334a.cmY.endsWith(".js")) {
                String[] split = c0334a.cmY.split(File.separator);
                if (split.length < 1) {
                    return amy();
                }
                c0334a.cmZ = split[split.length - 1];
                c0334a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0334a.path += split[i] + File.separator;
                }
            } else {
                c0334a.path = c0334a.cmY;
                if (!c0334a.path.endsWith(File.separator)) {
                    c0334a.path += File.separator;
                }
                c0334a.cmZ = "index.js";
            }
            return c0334a;
        }

        private static C0334a amy() {
            return new C0334a();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public HashMap<String, String> cnc;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.cna == null || bVar.cna.size() <= 0) {
                return amA();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return amA();
            }
            c cVar = new c();
            cVar.cnc = new HashMap<>();
            for (C0334a c0334a : bVar.cna) {
                if (c0334a != null && !TextUtils.isEmpty(c0334a.cmY)) {
                    cVar.cnc.put(c0334a.cmY, optJSONObject.optString(c0334a.cmY));
                }
            }
            return cVar;
        }

        private static c amA() {
            c cVar = new c();
            cVar.cnc = new HashMap<>();
            return cVar;
        }
    }
}
