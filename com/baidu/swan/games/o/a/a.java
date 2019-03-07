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
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public int beO;
    public boolean beP;
    public String beQ;
    public b.a beR;
    public String beS;
    public b beT;
    public c beU;
    public String beV;
    public com.baidu.swan.games.inspector.a beW;

    public static a iU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.beQ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.beR = b.a.N(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.beO = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.beO = 1;
            }
            aVar.beP = jSONObject.optBoolean("showStatusBar", false);
            aVar.beS = jSONObject.optString("workers");
            aVar.beT = b.as(jSONObject);
            aVar.beU = c.a(jSONObject, aVar.beT);
            aVar.beV = jSONObject.optString("openDataContext");
            aVar.beW = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0175a> beZ;
        public HashMap<String, Boolean> bfa;

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
            bVar.beZ = new ArrayList();
            bVar.bfa = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.beZ.add(C0175a.aq(optJSONObject));
                }
            }
            return bVar;
        }

        private static b OT() {
            b bVar = new b();
            bVar.beZ = new ArrayList();
            bVar.bfa = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0175a {
        public String beX;
        public String beY;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0175a aq(JSONObject jSONObject) {
            if (jSONObject == null) {
                return OS();
            }
            C0175a c0175a = new C0175a();
            c0175a.beX = jSONObject.optString("root");
            c0175a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0175a.beX) || TextUtils.isEmpty(c0175a.name)) {
                return OS();
            }
            if (c0175a.beX.endsWith(".js")) {
                String[] split = c0175a.beX.split(File.separator);
                if (split.length < 1) {
                    return OS();
                }
                c0175a.beY = split[split.length - 1];
                c0175a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0175a.path += split[i] + File.separator;
                }
            } else {
                c0175a.path = c0175a.beX;
                if (!c0175a.path.endsWith(File.separator)) {
                    c0175a.path += File.separator;
                }
                c0175a.beY = "index.js";
            }
            return c0175a;
        }

        private static C0175a OS() {
            return new C0175a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bfc;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.beZ == null || bVar.beZ.size() <= 0) {
                return OU();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return OU();
            }
            c cVar = new c();
            cVar.bfc = new HashMap<>();
            for (C0175a c0175a : bVar.beZ) {
                if (c0175a != null && !TextUtils.isEmpty(c0175a.beX)) {
                    cVar.bfc.put(c0175a.beX, optJSONObject.optString(c0175a.beX));
                }
            }
            return cVar;
        }

        private static c OU() {
            c cVar = new c();
            cVar.bfc = new HashMap<>();
            return cVar;
        }
    }
}
