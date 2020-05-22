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
    public int dbn;
    public boolean dbo;
    public String dbp;
    public b.a dbq;
    public String dbr;
    public b dbs;
    public c dbt;
    public String dbu;
    public com.baidu.swan.games.inspector.a dbv;
    public com.baidu.swan.games.network.b.c dbw;

    public static a sk(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dbp = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dbq = b.a.aO(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dbn = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dbn = 1;
            }
            aVar2.dbo = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dbr = jSONObject.optString("workers");
            aVar2.dbs = b.bQ(jSONObject);
            aVar2.dbt = c.a(jSONObject, aVar2.dbs);
            aVar2.dbu = jSONObject.optString("openDataContext");
            aVar2.dbv = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            g.mp("startup").bD("preload_resources", z ? "1" : "0");
            aVar2.dbw = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public HashMap<String, Boolean> dbA;
        public List<C0440a> dbz;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bQ(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBo();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aBo();
            }
            b bVar = new b();
            bVar.dbz = new ArrayList();
            bVar.dbA = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dbz.add(C0440a.bO(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aBo() {
            b bVar = new b();
            bVar.dbz = new ArrayList();
            bVar.dbA = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0440a {
        public String dbx;
        public String dby;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0440a bO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aBn();
            }
            C0440a c0440a = new C0440a();
            c0440a.dbx = jSONObject.optString("root");
            c0440a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0440a.dbx) || TextUtils.isEmpty(c0440a.name)) {
                return aBn();
            }
            if (c0440a.dbx.endsWith(".js")) {
                String[] split = c0440a.dbx.split(File.separator);
                if (split.length < 1) {
                    return aBn();
                }
                c0440a.dby = split[split.length - 1];
                c0440a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0440a.path += split[i] + File.separator;
                }
            } else {
                c0440a.path = c0440a.dbx;
                if (!c0440a.path.endsWith(File.separator)) {
                    c0440a.path += File.separator;
                }
                c0440a.dby = "index.js";
            }
            return c0440a;
        }

        private static C0440a aBn() {
            return new C0440a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> dbB;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dbz == null || bVar.dbz.size() <= 0) {
                return aBp();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aBp();
            }
            c cVar = new c();
            cVar.dbB = new HashMap<>();
            for (C0440a c0440a : bVar.dbz) {
                if (c0440a != null && !TextUtils.isEmpty(c0440a.dbx)) {
                    cVar.dbB.put(c0440a.dbx, optJSONObject.optString(c0440a.dbx));
                }
            }
            return cVar;
        }

        private static c aBp() {
            c cVar = new c();
            cVar.dbB = new HashMap<>();
            return cVar;
        }
    }
}
