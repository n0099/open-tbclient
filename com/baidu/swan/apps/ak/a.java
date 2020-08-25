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
    private static a cWE;
    private com.baidu.swan.apps.ak.b.b cWF = new com.baidu.swan.apps.ak.b.b();
    private c cWG = new c();
    private C0336a cWH = new C0336a();
    private com.baidu.swan.apps.ak.a.a cWI = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aCf() {
        if (cWE == null) {
            synchronized (a.class) {
                if (cWE == null) {
                    cWE = new a();
                }
            }
        }
        return cWE;
    }

    public void bK(JSONObject jSONObject) {
        this.cWF.bM(jSONObject);
    }

    public void re(String str) {
        ck(str, null);
    }

    public void ck(String str, String str2) {
        this.cWF.add(str, str2);
    }

    public void bL(JSONObject jSONObject) {
        this.cWG.bM(jSONObject);
    }

    public JSONObject aCg() {
        JSONObject aCm = this.cWF.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aCm);
        }
        return aCm;
    }

    public JSONObject aCh() {
        JSONObject aCm = this.cWG.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aCm);
        }
        return aCm;
    }

    public JSONObject aCi() {
        JSONObject aCm = this.cWH.aCm();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aCm);
        }
        return aCm;
    }

    public void clear() {
        this.cWF.clear();
        this.cWG.clear();
        this.cWH.clear();
    }

    public File aCj() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aCg());
        jSONArray.put(aCh());
        jSONArray.put(aCi());
        return this.cWI.G(jSONArray);
    }

    public void aCk() {
        if (this.cWH.cWJ != null && this.cWH.cWJ.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aCg());
            jSONArray.put(aCh());
            jSONArray.put(aCi());
            this.cWI.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aCl() {
        return this.cWI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0336a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray cWJ;

        private C0336a() {
        }

        public JSONObject aCm() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cWJ);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cWJ = null;
        }
    }
}
