package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dEE;
    private com.baidu.swan.apps.ak.b.b dEF = new com.baidu.swan.apps.ak.b.b();
    private c dEG = new c();
    private C0384a dEH = new C0384a();
    private com.baidu.swan.apps.ak.a.a dEI = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aMs() {
        if (dEE == null) {
            synchronized (a.class) {
                if (dEE == null) {
                    dEE = new a();
                }
            }
        }
        return dEE;
    }

    public void bZ(JSONObject jSONObject) {
        this.dEF.cb(jSONObject);
    }

    public void tu(String str) {
        cC(str, null);
    }

    public void cC(String str, String str2) {
        this.dEF.add(str, str2);
    }

    public void ca(JSONObject jSONObject) {
        this.dEG.cb(jSONObject);
    }

    public JSONObject aMt() {
        JSONObject aMz = this.dEF.aMz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aMz);
        }
        return aMz;
    }

    public JSONObject aMu() {
        JSONObject aMz = this.dEG.aMz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aMz);
        }
        return aMz;
    }

    public JSONObject aMv() {
        JSONObject aMz = this.dEH.aMz();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aMz);
        }
        return aMz;
    }

    public void clear() {
        this.dEF.clear();
        this.dEG.clear();
        this.dEH.clear();
    }

    public File aMw() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aMt());
        jSONArray.put(aMu());
        jSONArray.put(aMv());
        return this.dEI.H(jSONArray);
    }

    public void aMx() {
        if (this.dEH.dEJ != null && this.dEH.dEJ.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aMt());
            jSONArray.put(aMu());
            jSONArray.put(aMv());
            this.dEI.H(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aMy() {
        return this.dEI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0384a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray dEJ;

        private C0384a() {
        }

        public JSONObject aMz() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dEJ);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dEJ = null;
        }
    }
}
