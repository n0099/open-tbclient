package com.baidu.swan.games.t.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.g;
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
    public int dga;
    public boolean dgb;
    public String dgc;
    public b.a dgd;
    public String dge;
    public b dgf;
    public c dgg;
    public String dgh;
    public com.baidu.swan.games.inspector.a dgi;
    public com.baidu.swan.games.network.b.c dgj;

    public static a st(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dgc = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dgd = b.a.aV(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dga = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dga = 1;
            }
            aVar2.dgb = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dge = jSONObject.optString("workers");
            aVar2.dgf = b.bX(jSONObject);
            aVar2.dgg = c.a(jSONObject, aVar2.dgf);
            aVar2.dgh = jSONObject.optString("openDataContext");
            aVar2.dgi = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            g.mx("startup").bF("preload_resources", z ? "1" : "0");
            aVar2.dgj = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0446a> dgm;
        public HashMap<String, Boolean> dgn;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bX(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aCu();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aCu();
            }
            b bVar = new b();
            bVar.dgm = new ArrayList();
            bVar.dgn = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dgm.add(C0446a.bV(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aCu() {
            b bVar = new b();
            bVar.dgm = new ArrayList();
            bVar.dgn = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0446a {
        public String dgk;
        public String dgl;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0446a bV(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aCt();
            }
            C0446a c0446a = new C0446a();
            c0446a.dgk = jSONObject.optString("root");
            c0446a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0446a.dgk) || TextUtils.isEmpty(c0446a.name)) {
                return aCt();
            }
            if (c0446a.dgk.endsWith(".js")) {
                String[] split = c0446a.dgk.split(File.separator);
                if (split.length < 1) {
                    return aCt();
                }
                c0446a.dgl = split[split.length - 1];
                c0446a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0446a.path += split[i] + File.separator;
                }
            } else {
                c0446a.path = c0446a.dgk;
                if (!c0446a.path.endsWith(File.separator)) {
                    c0446a.path += File.separator;
                }
                c0446a.dgl = "index.js";
            }
            return c0446a;
        }

        private static C0446a aCt() {
            return new C0446a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> dgo;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dgm == null || bVar.dgm.size() <= 0) {
                return aCv();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aCv();
            }
            c cVar = new c();
            cVar.dgo = new HashMap<>();
            for (C0446a c0446a : bVar.dgm) {
                if (c0446a != null && !TextUtils.isEmpty(c0446a.dgk)) {
                    cVar.dgo.put(c0446a.dgk, optJSONObject.optString(c0446a.dgk));
                }
            }
            return cVar;
        }

        private static c aCv() {
            c cVar = new c();
            cVar.dgo = new HashMap<>();
            return cVar;
        }
    }
}
