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
    public int dlJ;
    public boolean dlK;
    public String dlL;
    public b.a dlM;
    public String dlN;
    public b dlO;
    public c dlP;
    public String dlQ;
    public com.baidu.swan.games.inspector.a dlR;
    public com.baidu.swan.games.network.b.c dlS;

    public static a tr(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dlL = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dlM = b.a.aY(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dlJ = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dlJ = 1;
            }
            aVar2.dlK = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dlN = jSONObject.optString("workers");
            aVar2.dlO = b.cd(jSONObject);
            aVar2.dlP = c.a(jSONObject, aVar2.dlO);
            aVar2.dlQ = jSONObject.optString("openDataContext");
            aVar2.dlR = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.mX("startup").bH("preload_resources", z ? "1" : "0");
            aVar2.dlS = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0459a> dlV;
        public HashMap<String, Boolean> dlW;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cd(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aGb();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aGb();
            }
            b bVar = new b();
            bVar.dlV = new ArrayList();
            bVar.dlW = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dlV.add(C0459a.cb(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aGb() {
            b bVar = new b();
            bVar.dlV = new ArrayList();
            bVar.dlW = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0459a {
        public String dlT;
        public String dlU;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0459a cb(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aGa();
            }
            C0459a c0459a = new C0459a();
            c0459a.dlT = jSONObject.optString("root");
            c0459a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0459a.dlT) || TextUtils.isEmpty(c0459a.name)) {
                return aGa();
            }
            if (c0459a.dlT.endsWith(".js")) {
                String[] split = c0459a.dlT.split(File.separator);
                if (split.length < 1) {
                    return aGa();
                }
                c0459a.dlU = split[split.length - 1];
                c0459a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0459a.path += split[i] + File.separator;
                }
            } else {
                c0459a.path = c0459a.dlT;
                if (!c0459a.path.endsWith(File.separator)) {
                    c0459a.path += File.separator;
                }
                c0459a.dlU = "index.js";
            }
            return c0459a;
        }

        private static C0459a aGa() {
            return new C0459a();
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public HashMap<String, String> dlX;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dlV == null || bVar.dlV.size() <= 0) {
                return aGc();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aGc();
            }
            c cVar = new c();
            cVar.dlX = new HashMap<>();
            for (C0459a c0459a : bVar.dlV) {
                if (c0459a != null && !TextUtils.isEmpty(c0459a.dlT)) {
                    cVar.dlX.put(c0459a.dlT, optJSONObject.optString(c0459a.dlT));
                }
            }
            return cVar;
        }

        private static c aGc() {
            c cVar = new c();
            cVar.dlX = new HashMap<>();
            return cVar;
        }
    }
}
