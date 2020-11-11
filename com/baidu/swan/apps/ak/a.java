package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dzm;
    private com.baidu.swan.apps.ak.b.b dzn = new com.baidu.swan.apps.ak.b.b();
    private c dzo = new c();
    private C0374a dzp = new C0374a();
    private com.baidu.swan.apps.ak.a.a dzq = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aJS() {
        if (dzm == null) {
            synchronized (a.class) {
                if (dzm == null) {
                    dzm = new a();
                }
            }
        }
        return dzm;
    }

    public void cd(JSONObject jSONObject) {
        this.dzn.cf(jSONObject);
    }

    public void sS(String str) {
        cw(str, null);
    }

    public void cw(String str, String str2) {
        this.dzn.add(str, str2);
    }

    public void ce(JSONObject jSONObject) {
        this.dzo.cf(jSONObject);
    }

    public JSONObject aJT() {
        JSONObject aJZ = this.dzn.aJZ();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aJZ);
        }
        return aJZ;
    }

    public JSONObject aJU() {
        JSONObject aJZ = this.dzo.aJZ();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aJZ);
        }
        return aJZ;
    }

    public JSONObject aJV() {
        JSONObject aJZ = this.dzp.aJZ();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aJZ);
        }
        return aJZ;
    }

    public void clear() {
        this.dzn.clear();
        this.dzo.clear();
        this.dzp.clear();
    }

    public File aJW() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aJT());
        jSONArray.put(aJU());
        jSONArray.put(aJV());
        return this.dzq.G(jSONArray);
    }

    public void aJX() {
        if (this.dzp.dzr != null && this.dzp.dzr.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aJT());
            jSONArray.put(aJU());
            jSONArray.put(aJV());
            this.dzq.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aJY() {
        return this.dzq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0374a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray dzr;

        private C0374a() {
        }

        public JSONObject aJZ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dzr);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dzr = null;
        }
    }
}
