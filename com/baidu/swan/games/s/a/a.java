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
    public int crg;
    public boolean crh;
    public String cri;
    public b.a crj;
    public String crk;
    public b crl;
    public c crm;
    public String crn;
    public com.baidu.swan.games.inspector.a cro;
    public com.baidu.swan.games.network.b.c crp;

    public static a pv(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.cri = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.crj = b.a.ay(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.crg = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.crg = 1;
            }
            aVar2.crh = jSONObject.optBoolean("showStatusBar", false);
            aVar2.crk = jSONObject.optString("workers");
            aVar2.crl = b.bE(jSONObject);
            aVar2.crm = c.a(jSONObject, aVar2.crl);
            aVar2.crn = jSONObject.optString("openDataContext");
            aVar2.cro = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.jP("startup").bb("preload_resources", z ? "1" : "0");
            aVar2.crp = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0346a> crs;
        public HashMap<String, Boolean> crt;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aph();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return aph();
            }
            b bVar = new b();
            bVar.crs = new ArrayList();
            bVar.crt = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.crs.add(C0346a.bC(optJSONObject));
                }
            }
            return bVar;
        }

        private static b aph() {
            b bVar = new b();
            bVar.crs = new ArrayList();
            bVar.crt = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0346a {
        public String crq;
        public String crr;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0346a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apg();
            }
            C0346a c0346a = new C0346a();
            c0346a.crq = jSONObject.optString("root");
            c0346a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0346a.crq) || TextUtils.isEmpty(c0346a.name)) {
                return apg();
            }
            if (c0346a.crq.endsWith(".js")) {
                String[] split = c0346a.crq.split(File.separator);
                if (split.length < 1) {
                    return apg();
                }
                c0346a.crr = split[split.length - 1];
                c0346a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0346a.path += split[i] + File.separator;
                }
            } else {
                c0346a.path = c0346a.crq;
                if (!c0346a.path.endsWith(File.separator)) {
                    c0346a.path += File.separator;
                }
                c0346a.crr = "index.js";
            }
            return c0346a;
        }

        private static C0346a apg() {
            return new C0346a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> cru;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.crs == null || bVar.crs.size() <= 0) {
                return apj();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return apj();
            }
            c cVar = new c();
            cVar.cru = new HashMap<>();
            for (C0346a c0346a : bVar.crs) {
                if (c0346a != null && !TextUtils.isEmpty(c0346a.crq)) {
                    cVar.cru.put(c0346a.crq, optJSONObject.optString(c0346a.crq));
                }
            }
            return cVar;
        }

        private static c apj() {
            c cVar = new c();
            cVar.cru = new HashMap<>();
            return cVar;
        }
    }
}
