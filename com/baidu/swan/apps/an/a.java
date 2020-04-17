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
    private static a ctD;
    private com.baidu.swan.apps.an.a.b ctE = new com.baidu.swan.apps.an.a.b();
    private c ctF = new c();

    private a() {
    }

    public static a amP() {
        if (ctD == null) {
            synchronized (a.class) {
                if (ctD == null) {
                    ctD = new a();
                }
            }
        }
        return ctD;
    }

    public void bh(JSONObject jSONObject) {
        this.ctE.bj(jSONObject);
    }

    public void mO(String str) {
        bv(str, null);
    }

    public void bv(String str, String str2) {
        this.ctE.add(str, str2);
    }

    public void bi(JSONObject jSONObject) {
        this.ctF.bj(jSONObject);
    }

    public JSONObject amQ() {
        JSONObject amU = this.ctE.amU();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + amU);
        }
        return amU;
    }

    public JSONObject amR() {
        JSONObject amU = this.ctF.amU();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + amU);
        }
        return amU;
    }

    public void clear() {
        this.ctE.clear();
        this.ctF.clear();
    }

    public File amS() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.akP() == null ? "" : e.akP()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(amQ());
        jSONArray.put(amR());
        com.baidu.swan.apps.v.a.j(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void amT() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.akP() == null ? "" : e.akP()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.st(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
