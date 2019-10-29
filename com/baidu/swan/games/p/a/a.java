package com.baidu.swan.games.p.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bDj;
    public boolean bDk;
    public String bDl;
    public b.a bDm;
    public String bDn;
    public b bDo;
    public c bDp;
    public String bDq;
    public com.baidu.swan.games.inspector.a bDr;

    public static a ku(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.bDl = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.bDm = b.a.ak(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar.bDj = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.bDj = 1;
            }
            aVar.bDk = jSONObject.optBoolean("showStatusBar", false);
            aVar.bDn = jSONObject.optString("workers");
            aVar.bDo = b.aT(jSONObject);
            aVar.bDp = c.a(jSONObject, aVar.bDo);
            aVar.bDq = jSONObject.optString("openDataContext");
            aVar.bDr = new com.baidu.swan.games.inspector.a(jSONObject);
            return aVar;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public List<C0257a> bDu;
        public HashMap<String, Boolean> bDv;

        /* JADX INFO: Access modifiers changed from: private */
        public static b aT(JSONObject jSONObject) {
            if (jSONObject == null) {
                return XJ();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return XJ();
            }
            b bVar = new b();
            bVar.bDu = new ArrayList();
            bVar.bDv = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bDu.add(C0257a.aR(optJSONObject));
                }
            }
            return bVar;
        }

        private static b XJ() {
            b bVar = new b();
            bVar.bDu = new ArrayList();
            bVar.bDv = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0257a {
        public String bDs;
        public String bDt;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0257a aR(JSONObject jSONObject) {
            if (jSONObject == null) {
                return XI();
            }
            C0257a c0257a = new C0257a();
            c0257a.bDs = jSONObject.optString("root");
            c0257a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0257a.bDs) || TextUtils.isEmpty(c0257a.name)) {
                return XI();
            }
            if (c0257a.bDs.endsWith(".js")) {
                String[] split = c0257a.bDs.split(File.separator);
                if (split.length < 1) {
                    return XI();
                }
                c0257a.bDt = split[split.length - 1];
                c0257a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0257a.path += split[i] + File.separator;
                }
            } else {
                c0257a.path = c0257a.bDs;
                if (!c0257a.path.endsWith(File.separator)) {
                    c0257a.path += File.separator;
                }
                c0257a.bDt = "index.js";
            }
            return c0257a;
        }

        private static C0257a XI() {
            return new C0257a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bDw;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bDu == null || bVar.bDu.size() <= 0) {
                return XK();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return XK();
            }
            c cVar = new c();
            cVar.bDw = new HashMap<>();
            for (C0257a c0257a : bVar.bDu) {
                if (c0257a != null && !TextUtils.isEmpty(c0257a.bDs)) {
                    cVar.bDw.put(c0257a.bDs, optJSONObject.optString(c0257a.bDs));
                }
            }
            return cVar;
        }

        private static c XK() {
            c cVar = new c();
            cVar.bDw = new HashMap<>();
            return cVar;
        }
    }
}
