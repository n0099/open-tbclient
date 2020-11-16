package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dxF;
    private com.baidu.swan.apps.ak.b.b dxG = new com.baidu.swan.apps.ak.b.b();
    private c dxH = new c();
    private C0372a dxI = new C0372a();
    private com.baidu.swan.apps.ak.a.a dxJ = new com.baidu.swan.apps.ak.a.a();

    private a() {
    }

    public static a aJk() {
        if (dxF == null) {
            synchronized (a.class) {
                if (dxF == null) {
                    dxF = new a();
                }
            }
        }
        return dxF;
    }

    public void bX(JSONObject jSONObject) {
        this.dxG.bZ(jSONObject);
    }

    public void sN(String str) {
        cv(str, null);
    }

    public void cv(String str, String str2) {
        this.dxG.add(str, str2);
    }

    public void bY(JSONObject jSONObject) {
        this.dxH.bZ(jSONObject);
    }

    public JSONObject aJl() {
        JSONObject aJr = this.dxG.aJr();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aJr);
        }
        return aJr;
    }

    public JSONObject aJm() {
        JSONObject aJr = this.dxH.aJr();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aJr);
        }
        return aJr;
    }

    public JSONObject aJn() {
        JSONObject aJr = this.dxI.aJr();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aJr);
        }
        return aJr;
    }

    public void clear() {
        this.dxG.clear();
        this.dxH.clear();
        this.dxI.clear();
    }

    public File aJo() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aJl());
        jSONArray.put(aJm());
        jSONArray.put(aJn());
        return this.dxJ.G(jSONArray);
    }

    public void aJp() {
        if (this.dxI.dxK != null && this.dxI.dxK.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aJl());
            jSONArray.put(aJm());
            jSONArray.put(aJn());
            this.dxJ.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.ak.a.a aJq() {
        return this.dxJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.ak.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0372a implements com.baidu.swan.apps.ak.b.a<JSONObject> {
        private JSONArray dxK;

        private C0372a() {
        }

        public JSONObject aJr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dxK);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dxK = null;
        }
    }
}
