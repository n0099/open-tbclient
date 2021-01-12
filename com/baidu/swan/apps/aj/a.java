package com.baidu.swan.apps.aj;

import android.util.Log;
import com.baidu.swan.apps.aj.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dIw;
    private com.baidu.swan.apps.aj.b.b dIx = new com.baidu.swan.apps.aj.b.b();
    private c dIy = new c();
    private C0359a dIz = new C0359a();
    private com.baidu.swan.apps.aj.a.a dIA = new com.baidu.swan.apps.aj.a.a();

    private a() {
    }

    public static a aKP() {
        if (dIw == null) {
            synchronized (a.class) {
                if (dIw == null) {
                    dIw = new a();
                }
            }
        }
        return dIw;
    }

    public void ch(JSONObject jSONObject) {
        this.dIx.cj(jSONObject);
    }

    public void sf(String str) {
        cA(str, null);
    }

    public void cA(String str, String str2) {
        this.dIx.add(str, str2);
    }

    public void ci(JSONObject jSONObject) {
        this.dIy.cj(jSONObject);
    }

    public JSONObject aKQ() {
        JSONObject aKW = this.dIx.aKW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aKW);
        }
        return aKW;
    }

    public JSONObject aKR() {
        JSONObject aKW = this.dIy.aKW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aKW);
        }
        return aKW;
    }

    public JSONObject aKS() {
        JSONObject aKW = this.dIz.aKW();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aKW);
        }
        return aKW;
    }

    public void clear() {
        this.dIx.clear();
        this.dIy.clear();
        this.dIz.clear();
    }

    public File aKT() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aKQ());
        jSONArray.put(aKR());
        jSONArray.put(aKS());
        return this.dIA.H(jSONArray);
    }

    public void aKU() {
        if (this.dIz.dIB != null && this.dIz.dIB.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aKQ());
            jSONArray.put(aKR());
            jSONArray.put(aKS());
            this.dIA.H(jSONArray);
        }
    }

    public com.baidu.swan.apps.aj.a.a aKV() {
        return this.dIA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.aj.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0359a implements com.baidu.swan.apps.aj.b.a<JSONObject> {
        private JSONArray dIB;

        private C0359a() {
        }

        public JSONObject aKW() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dIB);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dIB = null;
        }
    }
}
