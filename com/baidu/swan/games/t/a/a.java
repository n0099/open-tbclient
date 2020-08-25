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
/* loaded from: classes8.dex */
public final class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dvO;
    public boolean dvP;
    public String dvQ;
    public b.a dvR;
    public String dvS;
    public b dvT;
    public c dvU;
    public String dvV;
    public com.baidu.swan.games.inspector.a dvW;
    public com.baidu.swan.games.network.b.c dvX;

    public static a vH(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dvQ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dvR = b.a.bf(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dvO = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dvO = 1;
            }
            aVar2.dvP = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dvS = jSONObject.optString("workers");
            aVar2.dvT = b.cj(jSONObject);
            aVar2.dvU = c.a(jSONObject, aVar2.dvT);
            aVar2.dvV = jSONObject.optString("openDataContext");
            aVar2.dvW = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.oW("startup").bW("preload_resources", z ? "1" : "0");
            aVar2.dvX = new com.baidu.swan.games.network.b.c(optJSONArray);
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

    /* loaded from: classes8.dex */
    public static class b {
        public List<C0507a> dwa;
        public HashMap<String, Boolean> dwb;

        /* JADX INFO: Access modifiers changed from: private */
        public static b cj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aOS();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aOS();
            }
            b bVar = new b();
            bVar.dwa = new ArrayList();
            bVar.dwb = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dwa.add(C0507a.ch(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aOS() {
            b bVar = new b();
            bVar.dwa = new ArrayList();
            bVar.dwb = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0507a {
        public String dvY;
        public String dvZ;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0507a ch(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aOR();
            }
            C0507a c0507a = new C0507a();
            c0507a.dvY = jSONObject.optString("root");
            c0507a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0507a.dvY) || TextUtils.isEmpty(c0507a.name)) {
                return aOR();
            }
            if (c0507a.dvY.endsWith(".js")) {
                String[] split = c0507a.dvY.split(File.separator);
                if (split.length < 1) {
                    return aOR();
                }
                c0507a.dvZ = split[split.length - 1];
                c0507a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0507a.path += split[i] + File.separator;
                }
            } else {
                c0507a.path = c0507a.dvY;
                if (!c0507a.path.endsWith(File.separator)) {
                    c0507a.path += File.separator;
                }
                c0507a.dvZ = "index.js";
            }
            return c0507a;
        }

        private static C0507a aOR() {
            return new C0507a();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public HashMap<String, String> dwc;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dwa == null || bVar.dwa.size() <= 0) {
                return aOT();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aOT();
            }
            c cVar = new c();
            cVar.dwc = new HashMap<>();
            for (C0507a c0507a : bVar.dwa) {
                if (c0507a != null && !TextUtils.isEmpty(c0507a.dvY)) {
                    cVar.dwc.put(c0507a.dvY, optJSONObject.optString(c0507a.dvY));
                }
            }
            return cVar;
        }

        private static c aOT() {
            c cVar = new c();
            cVar.dwc = new HashMap<>();
            return cVar;
        }
    }
}
