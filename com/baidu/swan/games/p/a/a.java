package com.baidu.swan.games.p.a;

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
    public int bjk;
    public boolean bjl;
    public String bjm;
    public b.a bjn;
    public String bjo;
    public b bjp;
    public c bjq;
    public String bjr;
    public com.baidu.swan.games.inspector.a bjs;

    public static a jJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.bjm = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.bjn = b.a.M(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.bjk = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.bjk = 1;
            }
            aVar.bjl = jSONObject.optBoolean("showStatusBar", false);
            aVar.bjo = jSONObject.optString("workers");
            aVar.bjp = b.av(jSONObject);
            aVar.bjq = c.a(jSONObject, aVar.bjp);
            aVar.bjr = jSONObject.optString("openDataContext");
            aVar.bjs = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0214a> bjv;
        public HashMap<String, Boolean> bjw;

        /* JADX INFO: Access modifiers changed from: private */
        public static b av(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RV();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return RV();
            }
            b bVar = new b();
            bVar.bjv = new ArrayList();
            bVar.bjw = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bjv.add(C0214a.at(optJSONObject));
                }
            }
            return bVar;
        }

        private static b RV() {
            b bVar = new b();
            bVar.bjv = new ArrayList();
            bVar.bjw = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0214a {
        public String bjt;
        public String bju;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0214a at(JSONObject jSONObject) {
            if (jSONObject == null) {
                return RU();
            }
            C0214a c0214a = new C0214a();
            c0214a.bjt = jSONObject.optString("root");
            c0214a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0214a.bjt) || TextUtils.isEmpty(c0214a.name)) {
                return RU();
            }
            if (c0214a.bjt.endsWith(".js")) {
                String[] split = c0214a.bjt.split(File.separator);
                if (split.length < 1) {
                    return RU();
                }
                c0214a.bju = split[split.length - 1];
                c0214a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0214a.path += split[i] + File.separator;
                }
            } else {
                c0214a.path = c0214a.bjt;
                if (!c0214a.path.endsWith(File.separator)) {
                    c0214a.path += File.separator;
                }
                c0214a.bju = "index.js";
            }
            return c0214a;
        }

        private static C0214a RU() {
            return new C0214a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bjx;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bjv == null || bVar.bjv.size() <= 0) {
                return RW();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return RW();
            }
            c cVar = new c();
            cVar.bjx = new HashMap<>();
            for (C0214a c0214a : bVar.bjv) {
                if (c0214a != null && !TextUtils.isEmpty(c0214a.bjt)) {
                    cVar.bjx.put(c0214a.bjt, optJSONObject.optString(c0214a.bjt));
                }
            }
            return cVar;
        }

        private static c RW() {
            c cVar = new c();
            cVar.bjx = new HashMap<>();
            return cVar;
        }
    }
}
