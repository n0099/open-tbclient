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
    public int bjX;
    public boolean bjY;
    public String bjZ;
    public b.a bka;
    public String bkb;
    public b bkc;
    public c bkd;
    public String bke;
    public com.baidu.swan.games.inspector.a bkf;

    public static a jQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.bjZ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.bka = b.a.M(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", IntentConfig.PORTRAIT);
            aVar.bjX = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.bjX = 1;
            }
            aVar.bjY = jSONObject.optBoolean("showStatusBar", false);
            aVar.bkb = jSONObject.optString("workers");
            aVar.bkc = b.av(jSONObject);
            aVar.bkd = c.a(jSONObject, aVar.bkc);
            aVar.bke = jSONObject.optString("openDataContext");
            aVar.bkf = new com.baidu.swan.games.inspector.a(jSONObject);
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
        public List<C0211a> bki;
        public HashMap<String, Boolean> bkj;

        /* JADX INFO: Access modifiers changed from: private */
        public static b av(JSONObject jSONObject) {
            if (jSONObject == null) {
                return SO();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return SO();
            }
            b bVar = new b();
            bVar.bki = new ArrayList();
            bVar.bkj = new HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.bki.add(C0211a.at(optJSONObject));
                }
            }
            return bVar;
        }

        private static b SO() {
            b bVar = new b();
            bVar.bki = new ArrayList();
            bVar.bkj = new HashMap<>();
            return bVar;
        }
    }

    /* renamed from: com.baidu.swan.games.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0211a {
        public String bkg;
        public String bkh;
        public String name;
        public String path;

        /* JADX INFO: Access modifiers changed from: private */
        public static C0211a at(JSONObject jSONObject) {
            if (jSONObject == null) {
                return SN();
            }
            C0211a c0211a = new C0211a();
            c0211a.bkg = jSONObject.optString("root");
            c0211a.name = jSONObject.optString("name");
            if (TextUtils.isEmpty(c0211a.bkg) || TextUtils.isEmpty(c0211a.name)) {
                return SN();
            }
            if (c0211a.bkg.endsWith(".js")) {
                String[] split = c0211a.bkg.split(File.separator);
                if (split.length < 1) {
                    return SN();
                }
                c0211a.bkh = split[split.length - 1];
                c0211a.path = "";
                for (int i = 0; i < split.length - 1; i++) {
                    c0211a.path += split[i] + File.separator;
                }
            } else {
                c0211a.path = c0211a.bkg;
                if (!c0211a.path.endsWith(File.separator)) {
                    c0211a.path += File.separator;
                }
                c0211a.bkh = "index.js";
            }
            return c0211a;
        }

        private static C0211a SN() {
            return new C0211a();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public HashMap<String, String> bkk;

        /* JADX INFO: Access modifiers changed from: private */
        public static c a(JSONObject jSONObject, b bVar) {
            if (jSONObject == null || bVar == null || bVar.bki == null || bVar.bki.size() <= 0) {
                return SP();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
            if (optJSONObject == null) {
                return SP();
            }
            c cVar = new c();
            cVar.bkk = new HashMap<>();
            for (C0211a c0211a : bVar.bki) {
                if (c0211a != null && !TextUtils.isEmpty(c0211a.bkg)) {
                    cVar.bkk.put(c0211a.bkg, optJSONObject.optString(c0211a.bkg));
                }
            }
            return cVar;
        }

        private static c SP() {
            c cVar = new c();
            cVar.bkk = new HashMap<>();
            return cVar;
        }
    }
}
