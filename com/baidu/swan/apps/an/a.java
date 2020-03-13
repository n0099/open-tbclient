package com.baidu.swan.apps.an;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.a.c;
import com.baidu.swan.apps.runtime.e;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bUC;
    private com.baidu.swan.apps.an.a.b bUD = new com.baidu.swan.apps.an.a.b();
    private c bUE = new c();

    private a() {
    }

    public static a aeH() {
        if (bUC == null) {
            synchronized (a.class) {
                if (bUC == null) {
                    bUC = new a();
                }
            }
        }
        return bUC;
    }

    public void aW(JSONObject jSONObject) {
        this.bUD.aY(jSONObject);
    }

    public void lC(String str) {
        bm(str, null);
    }

    public void bm(String str, String str2) {
        this.bUD.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bUE.aY(jSONObject);
    }

    public JSONObject aeI() {
        JSONObject aeM = this.bUD.aeM();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aeM);
        }
        return aeM;
    }

    public JSONObject aeJ() {
        JSONObject aeM = this.bUE.aeM();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aeM);
        }
        return aeM;
    }

    public void clear() {
        this.bUD.clear();
        this.bUE.clear();
    }

    public File aeK() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acH() == null ? "" : e.acH()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aeI());
        jSONArray.put(aeJ());
        com.baidu.swan.apps.v.a.k(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void aeL() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acH() == null ? "" : e.acH()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.rg(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
