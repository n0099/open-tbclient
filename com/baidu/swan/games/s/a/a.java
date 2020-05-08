package com.baidu.swan.games.s.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.f;
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
    public com.baidu.swan.games.network.b.c cQA;
    public int cQr;
    public boolean cQs;
    public String cQt;
    public b.a cQu;
    public String cQv;
    public b cQw;
    public c cQx;
    public String cQy;
    public com.baidu.swan.games.inspector.a cQz;

    public static a qH(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.cQt = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.cQu = b.a.aJ(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.cQr = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.cQr = 1;
            }
            aVar2.cQs = jSONObject.optBoolean("showStatusBar", false);
            aVar2.cQv = jSONObject.optString("workers");
            aVar2.cQw = b.bP(jSONObject);
            aVar2.cQx = c.a(jSONObject, aVar2.cQw);
            aVar2.cQy = jSONObject.optString("openDataContext");
            aVar2.cQz = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.lb("startup").bk("preload_resources", z ? "1" : "0");
            aVar2.cQA = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0397a> cQD;
        public HashMap<String, Boolean> cQE;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bP(JSONObject jSONObject) {
            if (jSONObject == null) {
                return axx();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return axx();
            }
            b bVar = new b();
            bVar.cQD = new ArrayList();
            bVar.cQE = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.cQD.add(C0397a.bN(optJSONObject));
                }
            }
            return bVar;
        }

        private static b axx() {
            b bVar = new b();
            bVar.cQD = new ArrayList();
            bVar.cQE = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0397a {
        public String cQB;
        public String cQC;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0397a bN(JSONObject jSONObject) {
            if (jSONObject == null) {
                return axw();
            }
            C0397a c0397a = new C0397a();
            c0397a.cQB = jSONObject.optString("root");
            c0397a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0397a.cQB) || TextUtils.isEmpty(c0397a.name)) {
                return axw();
            }
            if (c0397a.cQB.endsWith(".js")) {
                String[] split = c0397a.cQB.split(File.separator);
                if (split.length < 1) {
                    return axw();
                }
                c0397a.cQC = split[split.length - 1];
                c0397a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0397a.path += split[i] + File.separator;
                }
            } else {
                c0397a.path = c0397a.cQB;
                if (!c0397a.path.endsWith(File.separator)) {
                    c0397a.path += File.separator;
                }
                c0397a.cQC = "index.js";
            }
            return c0397a;
        }

        private static C0397a axw() {
            return new C0397a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> cQF;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.cQD == null || bVar.cQD.size() <= 0) {
                return axy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return axy();
            }
            c cVar = new c();
            cVar.cQF = new HashMap<>();
            for (C0397a c0397a : bVar.cQD) {
                if (c0397a != null && !TextUtils.isEmpty(c0397a.cQB)) {
                    cVar.cQF.put(c0397a.cQB, optJSONObject.optString(c0397a.cQB));
                }
            }
            return cVar;
        }

        private static c axy() {
            c cVar = new c();
            cVar.cQF = new HashMap<>();
            return cVar;
        }
    }
}
