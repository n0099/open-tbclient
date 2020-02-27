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
    private static a bUA;
    private com.baidu.swan.apps.an.a.b bUB = new com.baidu.swan.apps.an.a.b();
    private c bUC = new c();

    private a() {
    }

    public static a aeF() {
        if (bUA == null) {
            synchronized (a.class) {
                if (bUA == null) {
                    bUA = new a();
                }
            }
        }
        return bUA;
    }

    public void aW(JSONObject jSONObject) {
        this.bUB.aY(jSONObject);
    }

    public void lC(String str) {
        bm(str, null);
    }

    public void bm(String str, String str2) {
        this.bUB.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bUC.aY(jSONObject);
    }

    public JSONObject aeG() {
        JSONObject aeK = this.bUB.aeK();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aeK);
        }
        return aeK;
    }

    public JSONObject aeH() {
        JSONObject aeK = this.bUC.aeK();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aeK);
        }
        return aeK;
    }

    public void clear() {
        this.bUB.clear();
        this.bUC.clear();
    }

    public File aeI() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acF() == null ? "" : e.acF()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aeG());
        jSONArray.put(aeH());
        com.baidu.swan.apps.v.a.k(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void aeJ() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acF() == null ? "" : e.acF()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.rg(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
