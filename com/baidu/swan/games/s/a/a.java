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
    public int cre;
    public boolean crf;
    public String crg;
    public b.a crh;
    public String cri;
    public b crj;
    public c crk;
    public String crl;
    public com.baidu.swan.games.inspector.a crm;
    public com.baidu.swan.games.network.b.c crn;

    public static a pv(String str) {
        a aVar = null;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar2 = new a();
        aVar2.crg = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar2.crh = b.a.ay(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.cre = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar2.cre = 1;
            }
            aVar2.crf = jSONObject.optBoolean("showStatusBar", false);
            aVar2.cri = jSONObject.optString("workers");
            aVar2.crj = b.bE(jSONObject);
            aVar2.crk = c.a(jSONObject, aVar2.crj);
            aVar2.crl = jSONObject.optString("openDataContext");
            aVar2.crm = new com.baidu.swan.games.inspector.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                z = false;
            }
            f.jP("startup").bb("preload_resources", z ? "1" : "0");
            aVar2.crn = new com.baidu.swan.games.network.b.c(optJSONArray);
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
        public List<C0346a> crq;
        public HashMap<String, Boolean> crr;

        /* JADX INFO: Access modifiers changed from: private */
        public static b bE(JSONObject jSONObject) {
            if (jSONObject == null) {
                return apf();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return apf();
            }
            b bVar = new b();
            bVar.crq = new ArrayList();
            bVar.crr = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.crq.add(C0346a.bC(optJSONObject));
                }
            }
            return bVar;
        }

        private static b apf() {
            b bVar = new b();
            bVar.crq = new ArrayList();
            bVar.crr = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0346a {
        public String cro;
        public String crp;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0346a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ape();
            }
            C0346a c0346a = new C0346a();
            c0346a.cro = jSONObject.optString("root");
            c0346a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0346a.cro) || TextUtils.isEmpty(c0346a.name)) {
                return ape();
            }
            if (c0346a.cro.endsWith(".js")) {
                String[] split = c0346a.cro.split(File.separator);
                if (split.length < 1) {
                    return ape();
                }
                c0346a.crp = split[split.length - 1];
                c0346a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0346a.path += split[i] + File.separator;
                }
            } else {
                c0346a.path = c0346a.cro;
                if (!c0346a.path.endsWith(File.separator)) {
                    c0346a.path += File.separator;
                }
                c0346a.crp = "index.js";
            }
            return c0346a;
        }

        private static C0346a ape() {
            return new C0346a();
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public HashMap<String, String> crs;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.crq == null || bVar.crq.size() <= 0) {
                return apg();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return apg();
            }
            c cVar = new c();
            cVar.crs = new HashMap<>();
            for (C0346a c0346a : bVar.crq) {
                if (c0346a != null && !TextUtils.isEmpty(c0346a.cro)) {
                    cVar.crs.put(c0346a.cro, optJSONObject.optString(c0346a.cro));
                }
            }
            return cVar;
        }

        private static c apg() {
            c cVar = new c();
            cVar.crs = new HashMap<>();
            return cVar;
        }
    }
}
