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
    private static a dtu;
    private com.baidu.swan.apps.ak.b.b dtv = new com.baidu.swan.apps.ak.b.b();
    private c dtw = new c();
    private C0362a dtx = new C0362a();
    private com.baidu.swan.apps.ak.a.a dty = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aHs() {
        if (dtu == null) {
            synchronized (a.class) {
                if (dtu == null) {
                    dtu = new a();
                }
            }
        }
        return dtu;
    }

    public void bX(JSONObject jSONObject) {
        this.dtv.bZ(jSONObject);
    }

    public void sE(String str) {
        cw(str, null);
    }

    public void cw(String str, String str2) {
        this.dtv.add(str, str2);
    }

    public void bY(JSONObject jSONObject) {
        this.dtw.bZ(jSONObject);
    }

    public JSONObject aHt() {
        JSONObject aHz = this.dtv.aHz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aHz);
        }
        return aHz;
    }

    public JSONObject aHu() {
        JSONObject aHz = this.dtw.aHz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aHz);
        }
        return aHz;
    }

    public JSONObject aHv() {
        JSONObject aHz = this.dtx.aHz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aHz);
        }
        return aHz;
    }

    public void clear() {
        this.dtv.clear();
        this.dtw.clear();
        this.dtx.clear();
    }

    public File aHw() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aHt());
        jSONArray.put(aHu());
        jSONArray.put(aHv());
        return this.dty.G(jSONArray);
    }

    public void aHx() {
        if (this.dtx.dtz != null && this.dtx.dtz.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aHt());
            jSONArray.put(aHu());
            jSONArray.put(aHv());
            this.dty.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aHy() {
        return this.dty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0362a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray dtz;

        private C0362a() {
        }

        public JSONObject aHz() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dtz);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dtz = null;
        }
    }
}
