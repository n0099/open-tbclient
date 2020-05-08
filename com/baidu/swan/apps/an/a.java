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
    private static a ctJ;
    private com.baidu.swan.apps.an.a.b ctK = new com.baidu.swan.apps.an.a.b();
    private c ctL = new c();

    private a() {
    }

    public static a amO() {
        if (ctJ == null) {
            synchronized (a.class) {
                if (ctJ == null) {
                    ctJ = new a();
                }
            }
        }
        return ctJ;
    }

    public void bh(JSONObject jSONObject) {
        this.ctK.bj(jSONObject);
    }

    public void mO(String str) {
        bv(str, null);
    }

    public void bv(String str, String str2) {
        this.ctK.add(str, str2);
    }

    public void bi(JSONObject jSONObject) {
        this.ctL.bj(jSONObject);
    }

    public JSONObject amP() {
        JSONObject amT = this.ctK.amT();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + amT);
        }
        return amT;
    }

    public JSONObject amQ() {
        JSONObject amT = this.ctL.amT();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + amT);
        }
        return amT;
    }

    public void clear() {
        this.ctK.clear();
        this.ctL.clear();
    }

    public File amR() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.akO() == null ? "" : e.akO()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(amP());
        jSONArray.put(amQ());
        com.baidu.swan.apps.v.a.j(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void amS() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.akO() == null ? "" : e.akO()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.st(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
