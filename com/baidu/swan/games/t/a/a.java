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
    public int dJU;
    public boolean dJV;
    public String dJW;
    public b.a dJX;
    public String dJY;
    public b dJZ;
    public c dKa;
    public String dKb;
    public com.baidu.swan.games.inspector.a dKc;
    public com.baidu.swan.games.network.b.c dKd;

    public static a wN(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dJW = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dJX = b.a.bp(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dJU = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dJU = 1;
            }
            aVar2.dJV = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dJY = jSONObject.optString("workers");
            aVar2.dJZ = b.ct(jSONObject);
            aVar2.dKa = c.a(jSONObject, aVar2.dJZ);
            aVar2.dKb = jSONObject.optString("openDataContext");
            aVar2.dKc = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.qc("startup").cb("preload_resources", z ? "1" : "0");
            aVar2.dKd = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0519a> dKg;
        public HashMap<String, Boolean> dKh;

        /* JADX INFO: Access modifiers changed from: private */
        public static b ct(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aSm();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aSm();
            }
            b bVar = new b();
            bVar.dKg = new ArrayList();
            bVar.dKh = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dKg.add(C0519a.cr(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aSm() {
            b bVar = new b();
            bVar.dKg = new ArrayList();
            bVar.dKh = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0519a {
        public String dKe;
        public String dKf;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0519a cr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aSl();
            }
            C0519a c0519a = new C0519a();
            c0519a.dKe = jSONObject.optString("root");
            c0519a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0519a.dKe) || TextUtils.isEmpty(c0519a.name)) {
                return aSl();
            }
            if (c0519a.dKe.endsWith(".js")) {
                String[] split = c0519a.dKe.split(File.separator);
                if (split.length < 1) {
                    return aSl();
                }
                c0519a.dKf = split[split.length - 1];
                c0519a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0519a.path += split[i] + File.separator;
                }
            } else {
                c0519a.path = c0519a.dKe;
                if (!c0519a.path.endsWith(File.separator)) {
                    c0519a.path += File.separator;
                }
                c0519a.dKf = "index.js";
            }
            return c0519a;
        }

        private static C0519a aSl() {
            return new C0519a();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public HashMap<String, String> dKi;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dKg == null || bVar.dKg.size() <= 0) {
                return aSn();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aSn();
            }
            c cVar = new c();
            cVar.dKi = new HashMap<>();
            for (C0519a c0519a : bVar.dKg) {
                if (c0519a != null && !TextUtils.isEmpty(c0519a.dKe)) {
                    cVar.dKi.put(c0519a.dKe, optJSONObject.optString(c0519a.dKe));
                }
            }
            return cVar;
        }

        private static c aSn() {
            c cVar = new c();
            cVar.dKi = new HashMap<>();
            return cVar;
        }
    }
}
