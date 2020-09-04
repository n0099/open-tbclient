package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cWI;
    private com.baidu.swan.apps.ak.b.b cWJ = new com.baidu.swan.apps.ak.b.b();
    private c cWK = new c();
    private C0336a cWL = new C0336a();
    private com.baidu.swan.apps.ak.a.a cWM = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aCf() {
        if (cWI == null) {
            synchronized (a.class) {
                if (cWI == null) {
                    cWI = new a();
                }
            }
        }
        return cWI;
    }

    public void bK(JSONObject jSONObject) {
        this.cWJ.bM(jSONObject);
    }

    public void rf(String str) {
        ck(str, null);
    }

    public void ck(String str, String str2) {
        this.cWJ.add(str, str2);
    }

    public void bL(JSONObject jSONObject) {
        this.cWK.bM(jSONObject);
    }

    public JSONObject aCg() {
        JSONObject aCm = this.cWJ.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aCm);
        }
        return aCm;
    }

    public JSONObject aCh() {
        JSONObject aCm = this.cWK.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aCm);
        }
        return aCm;
    }

    public JSONObject aCi() {
        JSONObject aCm = this.cWL.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aCm);
        }
        return aCm;
    }

    public void clear() {
        this.cWJ.clear();
        this.cWK.clear();
        this.cWL.clear();
    }

    public File aCj() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aCg());
        jSONArray.put(aCh());
        jSONArray.put(aCi());
        return this.cWM.G(jSONArray);
    }

    public void aCk() {
        if (this.cWL.cWN != null && this.cWL.cWN.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aCg());
            jSONArray.put(aCh());
            jSONArray.put(aCi());
            this.cWM.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aCl() {
        return this.cWM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0336a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray cWN;

        private C0336a() {
        }

        public JSONObject aCm() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cWN);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cWN = null;
        }
    }
}
