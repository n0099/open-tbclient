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
/* loaded from: classes10.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public com.baidu.swan.games.network.b.c dSA;
    public int dSr;
    public boolean dSs;
    public String dSt;
    public b.a dSu;
    public String dSv;
    public b dSw;
    public c dSx;
    public String dSy;
    public com.baidu.swan.games.inspector.a dSz;

    public static a xg(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dSt = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dSu = b.a.bs(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dSr = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dSr = 1;
            }
            aVar2.dSs = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dSv = jSONObject.optString("workers");
            aVar2.dSw = b.cw(jSONObject);
            aVar2.dSx = c.a(jSONObject, aVar2.dSw);
            aVar2.dSy = jSONObject.optString("openDataContext");
            aVar2.dSz = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qv("startup").ci("preload_resources", z ? "1" : "0");
            aVar2.dSA = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0533a> dSD;
        public HashMap<String, Boolean> dSE;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cw(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aUg();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aUg();
            }
            b bVar = new b();
            bVar.dSD = new ArrayList();
            bVar.dSE = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dSD.add(C0533a.cu(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aUg() {
            b bVar = new b();
            bVar.dSD = new ArrayList();
            bVar.dSE = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0533a {
        public String dSB;
        public String dSC;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0533a cu(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aUf();
            }
            C0533a c0533a = new C0533a();
            c0533a.dSB = jSONObject.optString("root");
            c0533a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0533a.dSB) || TextUtils.isEmpty(c0533a.name)) {
                return aUf();
            }
            if (c0533a.dSB.endsWith(".js")) {
                String[] split = c0533a.dSB.split(File.separator);
                if (split.length < 1) {
                    return aUf();
                }
                c0533a.dSC = split[split.length - 1];
                c0533a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0533a.path += split[i] + File.separator;
                }
            } else {
                c0533a.path = c0533a.dSB;
                if (!c0533a.path.endsWith(File.separator)) {
                    c0533a.path += File.separator;
                }
                c0533a.dSC = "index.js";
            }
            return c0533a;
        }

        private static C0533a aUf() {
            return new C0533a();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public HashMap<String, String> dSF;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dSD == null || bVar.dSD.size() <= 0) {
                return aUh();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aUh();
            }
            c cVar = new c();
            cVar.dSF = new HashMap<>();
            for (C0533a c0533a : bVar.dSD) {
                if (c0533a != null && !TextUtils.isEmpty(c0533a.dSB)) {
                    cVar.dSF.put(c0533a.dSB, optJSONObject.optString(c0533a.dSB));
                }
            }
            return cVar;
        }

        private static c aUh() {
            c cVar = new c();
            cVar.dSF = new HashMap<>();
            return cVar;
        }
    }
}
