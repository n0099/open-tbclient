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
    private static a bUN;
    private com.baidu.swan.apps.an.a.b bUO = new com.baidu.swan.apps.an.a.b();
    private c bUP = new c();

    private a() {
    }

    public static a aeK() {
        if (bUN == null) {
            synchronized (a.class) {
                if (bUN == null) {
                    bUN = new a();
                }
            }
        }
        return bUN;
    }

    public void aW(JSONObject jSONObject) {
        this.bUO.aY(jSONObject);
    }

    public void lB(String str) {
        bl(str, null);
    }

    public void bl(String str, String str2) {
        this.bUO.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bUP.aY(jSONObject);
    }

    public JSONObject aeL() {
        JSONObject aeP = this.bUO.aeP();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aeP);
        }
        return aeP;
    }

    public JSONObject aeM() {
        JSONObject aeP = this.bUP.aeP();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aeP);
        }
        return aeP;
    }

    public void clear() {
        this.bUO.clear();
        this.bUP.clear();
    }

    public File aeN() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acK() == null ? "" : e.acK()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aeL());
        jSONArray.put(aeM());
        com.baidu.swan.apps.v.a.k(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void aeO() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.acK() == null ? "" : e.acK()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.rf(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
