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
    private static a dKA;
    private com.baidu.swan.apps.aj.b.b dKB = new com.baidu.swan.apps.aj.b.b();
    private c dKC = new c();
    private C0356a dKD = new C0356a();
    private com.baidu.swan.apps.aj.a.a dKE = new com.baidu.swan.apps.aj.a.a();

    private a() {
    }

    public static a aLi() {
        if (dKA == null) {
            synchronized (a.class) {
                if (dKA == null) {
                    dKA = new a();
                }
            }
        }
        return dKA;
    }

    public void ce(JSONObject jSONObject) {
        this.dKB.cg(jSONObject);
    }

    public void sz(String str) {
        cu(str, null);
    }

    public void cu(String str, String str2) {
        this.dKB.add(str, str2);
    }

    public void cf(JSONObject jSONObject) {
        this.dKC.cg(jSONObject);
    }

    public JSONObject aLj() {
        JSONObject aLp = this.dKB.aLp();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aLp);
        }
        return aLp;
    }

    public JSONObject aLk() {
        JSONObject aLp = this.dKC.aLp();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aLp);
        }
        return aLp;
    }

    public JSONObject aLl() {
        JSONObject aLp = this.dKD.aLp();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aLp);
        }
        return aLp;
    }

    public void clear() {
        this.dKB.clear();
        this.dKC.clear();
        this.dKD.clear();
    }

    public File aLm() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aLj());
        jSONArray.put(aLk());
        jSONArray.put(aLl());
        return this.dKE.G(jSONArray);
    }

    public void aLn() {
        if (this.dKD.dKF != null && this.dKD.dKF.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aLj());
            jSONArray.put(aLk());
            jSONArray.put(aLl());
            this.dKE.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.aj.a.a aLo() {
        return this.dKE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.aj.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0356a implements com.baidu.swan.apps.aj.b.a<JSONObject> {
        private JSONArray dKF;

        private C0356a() {
        }

        public JSONObject aLp() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dKF);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dKF = null;
        }
    }
}
