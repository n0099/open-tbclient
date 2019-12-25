package com.baidu.swan.apps.an;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.a.c;
import com.baidu.swan.apps.runtime.e;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bPL;
    private com.baidu.swan.apps.an.a.b bPM = new com.baidu.swan.apps.an.a.b();
    private c bPN = new c();

    private a() {
    }

    public static a abU() {
        if (bPL == null) {
            synchronized (a.class) {
                if (bPL == null) {
                    bPL = new a();
                }
            }
        }
        return bPL;
    }

    public void aW(JSONObject jSONObject) {
        this.bPM.aY(jSONObject);
    }

    public void lk(String str) {
        bc(str, null);
    }

    public void bc(String str, String str2) {
        this.bPM.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bPN.aY(jSONObject);
    }

    public JSONObject abV() {
        JSONObject abZ = this.bPM.abZ();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + abZ);
        }
        return abZ;
    }

    public JSONObject abW() {
        JSONObject abZ = this.bPN.abZ();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + abZ);
        }
        return abZ;
    }

    public void clear() {
        this.bPM.clear();
        this.bPN.clear();
    }

    public File abX() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.ZU() == null ? "" : e.ZU()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(abV());
        jSONArray.put(abW());
        com.baidu.swan.apps.v.a.j(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void abY() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.ZU() == null ? "" : e.ZU()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.qO(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
