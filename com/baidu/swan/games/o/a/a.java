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
    public int beP;
    public boolean beQ;
    public String beR;
    public b.a beS;
    public String beT;
    public b beU;
    public c beV;
    public String beW;
    public com.baidu.swan.games.inspector.a beX;

    public static a iU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.beR = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.beS = b.a.N(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.beP = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.beP = 1;
            }
            aVar.beQ = jSONObject.optBoolean("showStatusBar", false);
            aVar.beT = jSONObject.optString("workers");
            aVar.beU = b.as(jSONObject);
            aVar.beV = c.a(jSONObject, aVar.beU);
            aVar.beW = jSONObject.optString("openDataContext");
            aVar.beX = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0204a> bfa;
        public HashMap<String, Boolean> bfc;

        /* JADX INFO: Access modifiers changed from: private */
        public static b as(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OT();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return OT();
            }
            b bVar = new b();
            bVar.bfa = new ArrayList();
            bVar.bfc = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bfa.add(C0204a.aq(optJSONObject));
                }
            }
            return bVar;
        }

        private static b OT() {
            b bVar = new b();
            bVar.bfa = new ArrayList();
            bVar.bfc = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0204a {
        public String beY;
        public String beZ;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0204a aq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OS();
            }
            C0204a c0204a = new C0204a();
            c0204a.beY = jSONObject.optString("root");
            c0204a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0204a.beY) || TextUtils.isEmpty(c0204a.name)) {
                return OS();
            }
            if (c0204a.beY.endsWith(".js")) {
                String[] split = c0204a.beY.split(File.separator);
                if (split.length < 1) {
                    return OS();
                }
                c0204a.beZ = split[split.length - 1];
                c0204a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0204a.path += split[i] + File.separator;
                }
            } else {
                c0204a.path = c0204a.beY;
                if (!c0204a.path.endsWith(File.separator)) {
                    c0204a.path += File.separator;
                }
                c0204a.beZ = "index.js";
            }
            return c0204a;
        }

        private static C0204a OS() {
            return new C0204a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bfd;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bfa == null || bVar.bfa.size() <= 0) {
                return OU();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return OU();
            }
            c cVar = new c();
            cVar.bfd = new HashMap<>();
            for (C0204a c0204a : bVar.bfa) {
                if (c0204a != null && !TextUtils.isEmpty(c0204a.beY)) {
                    cVar.bfd.put(c0204a.beY, optJSONObject.optString(c0204a.beY));
                }
            }
            return cVar;
        }

        private static c OU() {
            c cVar = new c();
            cVar.bfd = new HashMap<>();
            return cVar;
        }
    }
}
