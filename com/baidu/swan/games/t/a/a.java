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
    public int dYj;
    public boolean dYk;
    public String dYl;
    public b.a dYm;
    public String dYn;
    public b dYo;
    public c dYp;
    public String dYq;
    public com.baidu.swan.games.inspector.a dYr;
    public com.baidu.swan.games.network.b.c dYs;

    public static a xu(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dYl = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dYm = b.a.by(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dYj = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dYj = 1;
            }
            aVar2.dYk = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dYn = jSONObject.optString("workers");
            aVar2.dYo = b.cC(jSONObject);
            aVar2.dYp = c.a(jSONObject, aVar2.dYo);
            aVar2.dYq = jSONObject.optString("openDataContext");
            aVar2.dYr = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qJ("startup").ci("preload_resources", z ? "1" : "0");
            aVar2.dYs = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0545a> dYv;
        public HashMap<String, Boolean> dYw;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aWG();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aWG();
            }
            b bVar = new b();
            bVar.dYv = new ArrayList();
            bVar.dYw = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dYv.add(C0545a.cA(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aWG() {
            b bVar = new b();
            bVar.dYv = new ArrayList();
            bVar.dYw = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0545a {
        public String dYt;
        public String dYu;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0545a cA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aWF();
            }
            C0545a c0545a = new C0545a();
            c0545a.dYt = jSONObject.optString("root");
            c0545a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0545a.dYt) || TextUtils.isEmpty(c0545a.name)) {
                return aWF();
            }
            if (c0545a.dYt.endsWith(".js")) {
                String[] split = c0545a.dYt.split(File.separator);
                if (split.length < 1) {
                    return aWF();
                }
                c0545a.dYu = split[split.length - 1];
                c0545a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0545a.path += split[i] + File.separator;
                }
            } else {
                c0545a.path = c0545a.dYt;
                if (!c0545a.path.endsWith(File.separator)) {
                    c0545a.path += File.separator;
                }
                c0545a.dYu = "index.js";
            }
            return c0545a;
        }

        private static C0545a aWF() {
            return new C0545a();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public HashMap<String, String> dYx;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dYv == null || bVar.dYv.size() <= 0) {
                return aWH();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aWH();
            }
            c cVar = new c();
            cVar.dYx = new HashMap<>();
            for (C0545a c0545a : bVar.dYv) {
                if (c0545a != null && !TextUtils.isEmpty(c0545a.dYt)) {
                    cVar.dYx.put(c0545a.dYt, optJSONObject.optString(c0545a.dYt));
                }
            }
            return cVar;
        }

        private static c aWH() {
            c cVar = new c();
            cVar.dYx = new HashMap<>();
            return cVar;
        }
    }
}
