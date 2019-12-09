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
    public com.baidu.swan.games.inspector.a bCA;
    public int bCs;
    public boolean bCt;
    public String bCu;
    public b.a bCv;
    public String bCw;
    public b bCx;
    public c bCy;
    public String bCz;

    public static a ku(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.bCu = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.bCv = b.a.al(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar.bCs = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.bCs = 1;
            }
            aVar.bCt = jSONObject.optBoolean("showStatusBar", false);
            aVar.bCw = jSONObject.optString("workers");
            aVar.bCx = b.aU(jSONObject);
            aVar.bCy = c.a(jSONObject, aVar.bCx);
            aVar.bCz = jSONObject.optString("openDataContext");
            aVar.bCA = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0252a> bCD;
        public HashMap<String, Boolean> bCE;

        /* JADX INFO: Access modifiers changed from: private */
        public static b aU(JSONObject jSONObject) {
            if (jSONObject == null) {
                return XH();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return XH();
            }
            b bVar = new b();
            bVar.bCD = new ArrayList();
            bVar.bCE = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bCD.add(C0252a.aS(optJSONObject));
                }
            }
            return bVar;
        }

        private static b XH() {
            b bVar = new b();
            bVar.bCD = new ArrayList();
            bVar.bCE = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0252a {
        public String bCB;
        public String bCC;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0252a aS(JSONObject jSONObject) {
            if (jSONObject == null) {
                return XG();
            }
            C0252a c0252a = new C0252a();
            c0252a.bCB = jSONObject.optString("root");
            c0252a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0252a.bCB) || TextUtils.isEmpty(c0252a.name)) {
                return XG();
            }
            if (c0252a.bCB.endsWith(".js")) {
                String[] split = c0252a.bCB.split(File.separator);
                if (split.length < 1) {
                    return XG();
                }
                c0252a.bCC = split[split.length - 1];
                c0252a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0252a.path += split[i] + File.separator;
                }
            } else {
                c0252a.path = c0252a.bCB;
                if (!c0252a.path.endsWith(File.separator)) {
                    c0252a.path += File.separator;
                }
                c0252a.bCC = "index.js";
            }
            return c0252a;
        }

        private static C0252a XG() {
            return new C0252a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bCF;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bCD == null || bVar.bCD.size() <= 0) {
                return XI();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return XI();
            }
            c cVar = new c();
            cVar.bCF = new HashMap<>();
            for (C0252a c0252a : bVar.bCD) {
                if (c0252a != null && !TextUtils.isEmpty(c0252a.bCB)) {
                    cVar.bCF.put(c0252a.bCB, optJSONObject.optString(c0252a.bCB));
                }
            }
            return cVar;
        }

        private static c XI() {
            c cVar = new c();
            cVar.bCF = new HashMap<>();
            return cVar;
        }
    }
}
