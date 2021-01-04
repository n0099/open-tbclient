package com.baidu.swan.apps.aj;

import android.util.Log;
import com.baidu.swan.apps.aj.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dNi;
    private com.baidu.swan.apps.aj.b.b dNj = new com.baidu.swan.apps.aj.b.b();
    private c dNk = new c();
    private C0376a dNl = new C0376a();
    private com.baidu.swan.apps.aj.a.a dNm = new com.baidu.swan.apps.aj.a.a();

    private a() {
    }

    public static a aOI() {
        if (dNi == null) {
            synchronized (a.class) {
                if (dNi == null) {
                    dNi = new a();
                }
            }
        }
        return dNi;
    }

    public void ch(JSONObject jSONObject) {
        this.dNj.cj(jSONObject);
    }

    public void tr(String str) {
        cB(str, null);
    }

    public void cB(String str, String str2) {
        this.dNj.add(str, str2);
    }

    public void ci(JSONObject jSONObject) {
        this.dNk.cj(jSONObject);
    }

    public JSONObject aOJ() {
        JSONObject aOP = this.dNj.aOP();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aOP);
        }
        return aOP;
    }

    public JSONObject aOK() {
        JSONObject aOP = this.dNk.aOP();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aOP);
        }
        return aOP;
    }

    public JSONObject aOL() {
        JSONObject aOP = this.dNl.aOP();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aOP);
        }
        return aOP;
    }

    public void clear() {
        this.dNj.clear();
        this.dNk.clear();
        this.dNl.clear();
    }

    public File aOM() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aOJ());
        jSONArray.put(aOK());
        jSONArray.put(aOL());
        return this.dNm.H(jSONArray);
    }

    public void aON() {
        if (this.dNl.dNn != null && this.dNl.dNn.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aOJ());
            jSONArray.put(aOK());
            jSONArray.put(aOL());
            this.dNm.H(jSONArray);
        }
    }

    public com.baidu.swan.apps.aj.a.a aOO() {
        return this.dNm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.aj.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0376a implements com.baidu.swan.apps.aj.b.a<JSONObject> {
        private JSONArray dNn;

        private C0376a() {
        }

        public JSONObject aOP() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dNn);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dNn = null;
        }
    }
}
