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
    private static a dMb;
    private com.baidu.swan.apps.aj.b.b dMc = new com.baidu.swan.apps.aj.b.b();
    private c dMd = new c();
    private C0362a dMe = new C0362a();
    private com.baidu.swan.apps.aj.a.a dMf = new com.baidu.swan.apps.aj.a.a();

    private a() {
    }

    public static a aLl() {
        if (dMb == null) {
            synchronized (a.class) {
                if (dMb == null) {
                    dMb = new a();
                }
            }
        }
        return dMb;
    }

    public void cg(JSONObject jSONObject) {
        this.dMc.ci(jSONObject);
    }

    public void sG(String str) {
        cu(str, null);
    }

    public void cu(String str, String str2) {
        this.dMc.add(str, str2);
    }

    public void ch(JSONObject jSONObject) {
        this.dMd.ci(jSONObject);
    }

    public JSONObject aLm() {
        JSONObject aLs = this.dMc.aLs();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aLs);
        }
        return aLs;
    }

    public JSONObject aLn() {
        JSONObject aLs = this.dMd.aLs();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aLs);
        }
        return aLs;
    }

    public JSONObject aLo() {
        JSONObject aLs = this.dMe.aLs();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aLs);
        }
        return aLs;
    }

    public void clear() {
        this.dMc.clear();
        this.dMd.clear();
        this.dMe.clear();
    }

    public File aLp() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aLm());
        jSONArray.put(aLn());
        jSONArray.put(aLo());
        return this.dMf.G(jSONArray);
    }

    public void aLq() {
        if (this.dMe.dMg != null && this.dMe.dMg.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aLm());
            jSONArray.put(aLn());
            jSONArray.put(aLo());
            this.dMf.G(jSONArray);
        }
    }

    public com.baidu.swan.apps.aj.a.a aLr() {
        return this.dMf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.aj.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0362a implements com.baidu.swan.apps.aj.b.a<JSONObject> {
        private JSONArray dMg;

        private C0362a() {
        }

        public JSONObject aLs() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.dMg);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.dMg = null;
        }
    }
}
