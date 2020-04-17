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
    public int cQm;
    public boolean cQn;
    public String cQo;
    public b.a cQp;
    public String cQq;
    public b cQr;
    public c cQs;
    public String cQt;
    public com.baidu.swan.games.inspector.a cQu;
    public com.baidu.swan.games.network.b.c cQv;

    public static a qH(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.cQo = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.cQp = b.a.aJ(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.cQm = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.cQm = 1;
            }
            aVar2.cQn = jSONObject.optBoolean("showStatusBar", false);
            aVar2.cQq = jSONObject.optString("workers");
            aVar2.cQr = b.bP(jSONObject);
            aVar2.cQs = c.a(jSONObject, aVar2.cQr);
            aVar2.cQt = jSONObject.optString("openDataContext");
            aVar2.cQu = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.lb("startup").bk("preload_resources", z ? "1" : "0");
            aVar2.cQv = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0376a> cQy;
        public HashMap<String, Boolean> cQz;

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
            bVar.cQy = new ArrayList();
            bVar.cQz = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.cQy.add(C0376a.bN(optJSONObject));
                }
            }
            return bVar;
        }

        private static b axx() {
            b bVar = new b();
            bVar.cQy = new ArrayList();
            bVar.cQz = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0376a {
        public String cQw;
        public String cQx;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0376a bN(JSONObject jSONObject) {
            if (jSONObject == null) {
                return axw();
            }
            C0376a c0376a = new C0376a();
            c0376a.cQw = jSONObject.optString("root");
            c0376a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0376a.cQw) || TextUtils.isEmpty(c0376a.name)) {
                return axw();
            }
            if (c0376a.cQw.endsWith(".js")) {
                String[] split = c0376a.cQw.split(File.separator);
                if (split.length < 1) {
                    return axw();
                }
                c0376a.cQx = split[split.length - 1];
                c0376a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0376a.path += split[i] + File.separator;
                }
            } else {
                c0376a.path = c0376a.cQw;
                if (!c0376a.path.endsWith(File.separator)) {
                    c0376a.path += File.separator;
                }
                c0376a.cQx = "index.js";
            }
            return c0376a;
        }

        private static C0376a axw() {
            return new C0376a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> cQA;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.cQy == null || bVar.cQy.size() <= 0) {
                return axy();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return axy();
            }
            c cVar = new c();
            cVar.cQA = new HashMap<>();
            for (C0376a c0376a : bVar.cQy) {
                if (c0376a != null && !TextUtils.isEmpty(c0376a.cQw)) {
                    cVar.cQA.put(c0376a.cQw, optJSONObject.optString(c0376a.cQw));
                }
            }
            return cVar;
        }

        private static c axy() {
            c cVar = new c();
            cVar.cQA = new HashMap<>();
            return cVar;
        }
    }
}
