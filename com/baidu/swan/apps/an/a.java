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
    private static a bUB;
    private com.baidu.swan.apps.an.a.b bUC = new com.baidu.swan.apps.an.a.b();
    private c bUD = new c();

    private a() {
    }

    public static a aeH() {
        if (bUB == null) {
            synchronized (a.class) {
                if (bUB == null) {
                    bUB = new a();
                }
            }
        }
        return bUB;
    }

    public void aW(JSONObject jSONObject) {
        this.bUC.aY(jSONObject);
    }

    public void lC(String str) {
        bm(str, null);
    }

    public void bm(String str, String str2) {
        this.bUC.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bUD.aY(jSONObject);
    }

    public JSONObject aeI() {
        JSONObject aeM = this.bUC.aeM();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aeM);
        }
        return aeM;
    }

    public JSONObject aeJ() {
        JSONObject aeM = this.bUD.aeM();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aeM);
        }
        return aeM;
    }

    public void clear() {
        this.bUC.clear();
        this.bUD.clear();
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
