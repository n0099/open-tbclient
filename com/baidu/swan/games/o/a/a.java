package com.baidu.swan.games.o.a;

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
    public int beS;
    public boolean beT;
    public String beU;
    public b.a beV;
    public String beW;
    public b beX;
    public c beY;
    public String beZ;
    public com.baidu.swan.games.inspector.a bfa;

    public static a iV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.beU = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.beV = b.a.N(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.beS = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.beS = 1;
            }
            aVar.beT = jSONObject.optBoolean("showStatusBar", false);
            aVar.beW = jSONObject.optString("workers");
            aVar.beX = b.as(jSONObject);
            aVar.beY = c.a(jSONObject, aVar.beX);
            aVar.beZ = jSONObject.optString("openDataContext");
            aVar.bfa = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0204a> bfe;
        public HashMap<String, Boolean> bff;

        /* JADX INFO: Access modifiers changed from: private */
        public static b as(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OR();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return OR();
            }
            b bVar = new b();
            bVar.bfe = new ArrayList();
            bVar.bff = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bfe.add(C0204a.aq(optJSONObject));
                }
            }
            return bVar;
        }

        private static b OR() {
            b bVar = new b();
            bVar.bfe = new ArrayList();
            bVar.bff = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0204a {
        public String bfc;
        public String bfd;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0204a aq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OQ();
            }
            C0204a c0204a = new C0204a();
            c0204a.bfc = jSONObject.optString("root");
            c0204a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0204a.bfc) || TextUtils.isEmpty(c0204a.name)) {
                return OQ();
            }
            if (c0204a.bfc.endsWith(".js")) {
                String[] split = c0204a.bfc.split(File.separator);
                if (split.length < 1) {
                    return OQ();
                }
                c0204a.bfd = split[split.length - 1];
                c0204a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0204a.path += split[i] + File.separator;
                }
            } else {
                c0204a.path = c0204a.bfc;
                if (!c0204a.path.endsWith(File.separator)) {
                    c0204a.path += File.separator;
                }
                c0204a.bfd = "index.js";
            }
            return c0204a;
        }

        private static C0204a OQ() {
            return new C0204a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bfg;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bfe == null || bVar.bfe.size() <= 0) {
                return OS();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return OS();
            }
            c cVar = new c();
            cVar.bfg = new HashMap<>();
            for (C0204a c0204a : bVar.bfe) {
                if (c0204a != null && !TextUtils.isEmpty(c0204a.bfc)) {
                    cVar.bfg.put(c0204a.bfc, optJSONObject.optString(c0204a.bfc));
                }
            }
            return cVar;
        }

        private static c OS() {
            c cVar = new c();
            cVar.bfg = new HashMap<>();
            return cVar;
        }
    }
}
