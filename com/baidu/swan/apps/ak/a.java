package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cYI;
    private com.baidu.swan.apps.ak.b.b cYJ = new com.baidu.swan.apps.ak.b.b();
    private c cYK = new c();
    private C0331a cYL = new C0331a();
    private com.baidu.swan.apps.ak.a.a cYM = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aCP() {
        if (cYI == null) {
            synchronized (a.class) {
                if (cYI == null) {
                    cYI = new a();
                }
            }
        }
        return cYI;
    }

    public void bN(JSONObject jSONObject) {
        this.cYJ.bP(jSONObject);
    }

    public void ry(String str) {
        ck(str, null);
    }

    public void ck(String str, String str2) {
        this.cYJ.add(str, str2);
    }

    public void bO(JSONObject jSONObject) {
        this.cYK.bP(jSONObject);
    }

    public JSONObject aCQ() {
        JSONObject aCW = this.cYJ.aCW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aCW);
        }
        return aCW;
    }

    public JSONObject aCR() {
        JSONObject aCW = this.cYK.aCW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aCW);
        }
        return aCW;
    }

    public JSONObject aCS() {
        JSONObject aCW = this.cYL.aCW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aCW);
        }
        return aCW;
    }

    public void clear() {
        this.cYJ.clear();
        this.cYK.clear();
        this.cYL.clear();
    }

    public File aCT() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aCQ());
        jSONArray.put(aCR());
        jSONArray.put(aCS());
        return this.cYM.G(jSONArray);
    }

    public void aCU() {
        if (this.cYL.cYN != null && this.cYL.cYN.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aCQ());
            jSONArray.put(aCR());
            jSONArray.put(aCS());
            this.cYM.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aCV() {
        return this.cYM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0331a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray cYN;

        private C0331a() {
        }

        public JSONObject aCW() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cYN);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cYN = null;
        }
    }
}
