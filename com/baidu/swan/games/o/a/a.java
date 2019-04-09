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
    public int beT;
    public boolean beU;
    public String beV;
    public b.a beW;
    public String beX;
    public b beY;
    public c beZ;
    public String bfa;
    public com.baidu.swan.games.inspector.a bfc;

    public static a iV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.beV = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.beW = b.a.N(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.beT = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.beT = 1;
            }
            aVar.beU = jSONObject.optBoolean("showStatusBar", false);
            aVar.beX = jSONObject.optString("workers");
            aVar.beY = b.as(jSONObject);
            aVar.beZ = c.a(jSONObject, aVar.beY);
            aVar.bfa = jSONObject.optString("openDataContext");
            aVar.bfc = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0204a> bff;
        public HashMap<String, Boolean> bfg;

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
            bVar.bff = new ArrayList();
            bVar.bfg = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bff.add(C0204a.aq(optJSONObject));
                }
            }
            return bVar;
        }

        private static b OR() {
            b bVar = new b();
            bVar.bff = new ArrayList();
            bVar.bfg = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0204a {
        public String bfd;
        public String bfe;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0204a aq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OQ();
            }
            C0204a c0204a = new C0204a();
            c0204a.bfd = jSONObject.optString("root");
            c0204a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0204a.bfd) || TextUtils.isEmpty(c0204a.name)) {
                return OQ();
            }
            if (c0204a.bfd.endsWith(".js")) {
                String[] split = c0204a.bfd.split(File.separator);
                if (split.length < 1) {
                    return OQ();
                }
                c0204a.bfe = split[split.length - 1];
                c0204a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0204a.path += split[i] + File.separator;
                }
            } else {
                c0204a.path = c0204a.bfd;
                if (!c0204a.path.endsWith(File.separator)) {
                    c0204a.path += File.separator;
                }
                c0204a.bfe = "index.js";
            }
            return c0204a;
        }

        private static C0204a OQ() {
            return new C0204a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bfh;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bff == null || bVar.bff.size() <= 0) {
                return OS();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return OS();
            }
            c cVar = new c();
            cVar.bfh = new HashMap<>();
            for (C0204a c0204a : bVar.bff) {
                if (c0204a != null && !TextUtils.isEmpty(c0204a.bfd)) {
                    cVar.bfh.put(c0204a.bfd, optJSONObject.optString(c0204a.bfd));
                }
            }
            return cVar;
        }

        private static c OS() {
            c cVar = new c();
            cVar.bfh = new HashMap<>();
            return cVar;
        }
    }
}
