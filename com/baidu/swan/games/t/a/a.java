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
    public int dvS;
    public boolean dvT;
    public String dvU;
    public b.a dvV;
    public String dvW;
    public b dvX;
    public c dvY;
    public String dvZ;
    public com.baidu.swan.games.inspector.a dwa;
    public com.baidu.swan.games.network.b.c dwb;

    public static a vI(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dvU = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.dvV = b.a.bf(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.dvS = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.dvS = 1;
            }
            aVar2.dvT = jSONObject.optBoolean("showStatusBar", false);
            aVar2.dvW = jSONObject.optString("workers");
            aVar2.dvX = b.cj(jSONObject);
            aVar2.dvY = c.a(jSONObject, aVar2.dvX);
            aVar2.dvZ = jSONObject.optString("openDataContext");
            aVar2.dwa = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            i.oX("startup").bW("preload_resources", z ? "1" : "0");
            aVar2.dwb = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0507a> dwe;
        public HashMap<String, Boolean> dwf;

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
            bVar.dwe = new ArrayList();
            bVar.dwf = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.dwe.add(C0507a.ch(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aOS() {
            b bVar = new b();
            bVar.dwe = new ArrayList();
            bVar.dwf = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0507a {
        public String dwc;
        public String dwd;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0507a ch(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aOR();
            }
            C0507a c0507a = new C0507a();
            c0507a.dwc = jSONObject.optString("root");
            c0507a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0507a.dwc) || TextUtils.isEmpty(c0507a.name)) {
                return aOR();
            }
            if (c0507a.dwc.endsWith(".js")) {
                String[] split = c0507a.dwc.split(File.separator);
                if (split.length < 1) {
                    return aOR();
                }
                c0507a.dwd = split[split.length - 1];
                c0507a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0507a.path += split[i] + File.separator;
                }
            } else {
                c0507a.path = c0507a.dwc;
                if (!c0507a.path.endsWith(File.separator)) {
                    c0507a.path += File.separator;
                }
                c0507a.dwd = "index.js";
            }
            return c0507a;
        }

        private static C0507a aOR() {
            return new C0507a();
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public HashMap<String, String> dwg;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.dwe == null || bVar.dwe.size() <= 0) {
                return aOT();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return aOT();
            }
            c cVar = new c();
            cVar.dwg = new HashMap<>();
            for (C0507a c0507a : bVar.dwe) {
                if (c0507a != null && !TextUtils.isEmpty(c0507a.dwc)) {
                    cVar.dwg.put(c0507a.dwc, optJSONObject.optString(c0507a.dwc));
                }
            }
            return cVar;
        }

        private static c aOT() {
            c cVar = new c();
            cVar.dwg = new HashMap<>();
            return cVar;
        }
    }
}
