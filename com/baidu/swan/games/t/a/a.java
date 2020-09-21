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
/* loaded from: classes3.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dxT;
    public boolean dxU;
    public String dxV;
    public b.a dxW;
    public String dxX;
    public b dxY;
    public c dxZ;
    public String dya;
    public com.baidu.swan.games.inspector.a dyb;
    public com.baidu.swan.games.network.b.c dyc;

    public static a wb(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dxV = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dxW = b.a.bi(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dxT = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dxT = 1;
            }
            aVar2.dxU = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dxX = jSONObject.optString("workers");
            aVar2.dxY = b.cm(jSONObject);
            aVar2.dxZ = c.a(jSONObject, aVar2.dxY);
            aVar2.dya = jSONObject.optString("openDataContext");
            aVar2.dyb = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.pq("startup").bW("preload_resources", z ? "1" : "0");
            aVar2.dyc = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes3.dex */
    public static class b {
        public List<C0502a> dyf;
        public HashMap<String, Boolean> dyg;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cm(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aPD();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aPD();
            }
            b bVar = new b();
            bVar.dyf = new ArrayList();
            bVar.dyg = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dyf.add(C0502a.ck(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aPD() {
            b bVar = new b();
            bVar.dyf = new ArrayList();
            bVar.dyg = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0502a {
        public String dyd;
        public String dye;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0502a ck(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aPC();
            }
            C0502a c0502a = new C0502a();
            c0502a.dyd = jSONObject.optString("root");
            c0502a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0502a.dyd) || TextUtils.isEmpty(c0502a.name)) {
                return aPC();
            }
            if (c0502a.dyd.endsWith(".js")) {
                String[] split = c0502a.dyd.split(File.separator);
                if (split.length < 1) {
                    return aPC();
                }
                c0502a.dye = split[split.length - 1];
                c0502a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0502a.path += split[i] + File.separator;
                }
            } else {
                c0502a.path = c0502a.dyd;
                if (!c0502a.path.endsWith(File.separator)) {
                    c0502a.path += File.separator;
                }
                c0502a.dye = "index.js";
            }
            return c0502a;
        }

        private static C0502a aPC() {
            return new C0502a();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public HashMap<String, String> dyh;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dyf == null || bVar.dyf.size() <= 0) {
                return aPE();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aPE();
            }
            c cVar = new c();
            cVar.dyh = new HashMap<>();
            for (C0502a c0502a : bVar.dyf) {
                if (c0502a != null && !TextUtils.isEmpty(c0502a.dyd)) {
                    cVar.dyh.put(c0502a.dyd, optJSONObject.optString(c0502a.dyd));
                }
            }
            return cVar;
        }

        private static c aPE() {
            c cVar = new c();
            cVar.dyh = new HashMap<>();
            return cVar;
        }
    }
}
