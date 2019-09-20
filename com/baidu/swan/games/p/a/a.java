package com.baidu.swan.games.p.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ae.a.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    public b bkA;
    public c bkB;
    public String bkC;
    public com.baidu.swan.games.inspector.a bkD;
    public int bkv;
    public boolean bkw;
    public String bkx;
    public b.a bky;
    public String bkz;

    public static a jS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.bkx = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.bky = b.a.M(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.bkv = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.bkv = 1;
            }
            aVar.bkw = jSONObject.optBoolean("showStatusBar", false);
            aVar.bkz = jSONObject.optString("workers");
            aVar.bkA = b.av(jSONObject);
            aVar.bkB = c.a(jSONObject, aVar.bkA);
            aVar.bkC = jSONObject.optString("openDataContext");
            aVar.bkD = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0225a> bkG;
        public HashMap<String, Boolean> bkH;

        /* JADX INFO: Access modifiers changed from: private */
        public static b av(JSONObject jSONObject) {
            if (jSONObject == null) {
                return SS();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return SS();
            }
            b bVar = new b();
            bVar.bkG = new ArrayList();
            bVar.bkH = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bkG.add(C0225a.at(optJSONObject));
                }
            }
            return bVar;
        }

        private static b SS() {
            b bVar = new b();
            bVar.bkG = new ArrayList();
            bVar.bkH = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0225a {
        public String bkE;
        public String bkF;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0225a at(JSONObject jSONObject) {
            if (jSONObject == null) {
                return SR();
            }
            C0225a c0225a = new C0225a();
            c0225a.bkE = jSONObject.optString("root");
            c0225a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0225a.bkE) || TextUtils.isEmpty(c0225a.name)) {
                return SR();
            }
            if (c0225a.bkE.endsWith(".js")) {
                String[] split = c0225a.bkE.split(File.separator);
                if (split.length < 1) {
                    return SR();
                }
                c0225a.bkF = split[split.length - 1];
                c0225a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0225a.path += split[i] + File.separator;
                }
            } else {
                c0225a.path = c0225a.bkE;
                if (!c0225a.path.endsWith(File.separator)) {
                    c0225a.path += File.separator;
                }
                c0225a.bkF = "index.js";
            }
            return c0225a;
        }

        private static C0225a SR() {
            return new C0225a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bkI;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bkG == null || bVar.bkG.size() <= 0) {
                return ST();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return ST();
            }
            c cVar = new c();
            cVar.bkI = new HashMap<>();
            for (C0225a c0225a : bVar.bkG) {
                if (c0225a != null && !TextUtils.isEmpty(c0225a.bkE)) {
                    cVar.bkI.put(c0225a.bkE, optJSONObject.optString(c0225a.bkE));
                }
            }
            return cVar;
        }

        private static c ST() {
            c cVar = new c();
            cVar.bkI = new HashMap<>();
            return cVar;
        }
    }
}
