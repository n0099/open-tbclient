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
    private static a dkS;
    private com.baidu.swan.apps.ak.b.b dkT = new com.baidu.swan.apps.ak.b.b();
    private c dkU = new c();
    private C0348a dkV = new C0348a();
    private com.baidu.swan.apps.ak.a.a dkW = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aFy() {
        if (dkS == null) {
            synchronized (a.class) {
                if (dkS == null) {
                    dkS = new a();
                }
            }
        }
        return dkS;
    }

    public void bU(JSONObject jSONObject) {
        this.dkT.bW(jSONObject);
    }

    public void sk(String str) {
        cp(str, null);
    }

    public void cp(String str, String str2) {
        this.dkT.add(str, str2);
    }

    public void bV(JSONObject jSONObject) {
        this.dkU.bW(jSONObject);
    }

    public JSONObject aFz() {
        JSONObject aFF = this.dkT.aFF();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aFF);
        }
        return aFF;
    }

    public JSONObject aFA() {
        JSONObject aFF = this.dkU.aFF();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aFF);
        }
        return aFF;
    }

    public JSONObject aFB() {
        JSONObject aFF = this.dkV.aFF();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aFF);
        }
        return aFF;
    }

    public void clear() {
        this.dkT.clear();
        this.dkU.clear();
        this.dkV.clear();
    }

    public File aFC() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aFz());
        jSONArray.put(aFA());
        jSONArray.put(aFB());
        return this.dkW.G(jSONArray);
    }

    public void aFD() {
        if (this.dkV.dkX != null && this.dkV.dkX.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aFz());
            jSONArray.put(aFA());
            jSONArray.put(aFB());
            this.dkW.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aFE() {
        return this.dkW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0348a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray dkX;

        private C0348a() {
        }

        public JSONObject aFF() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dkX);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dkX = null;
        }
    }
}
