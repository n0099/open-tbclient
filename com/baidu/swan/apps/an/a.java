package com.baidu.swan.apps.an;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.a.c;
import com.baidu.swan.apps.runtime.e;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bQv;
    private com.baidu.swan.apps.an.a.b bQw = new com.baidu.swan.apps.an.a.b();
    private c bQx = new c();

    private a() {
    }

    public static a acr() {
        if (bQv == null) {
            synchronized (a.class) {
                if (bQv == null) {
                    bQv = new a();
                }
            }
        }
        return bQv;
    }

    public void aW(JSONObject jSONObject) {
        this.bQw.aY(jSONObject);
    }

    public void ln(String str) {
        bd(str, null);
    }

    public void bd(String str, String str2) {
        this.bQw.add(str, str2);
    }

    public void aX(JSONObject jSONObject) {
        this.bQx.aY(jSONObject);
    }

    public JSONObject acs() {
        JSONObject acw = this.bQw.acw();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + acw);
        }
        return acw;
    }

    public JSONObject act() {
        JSONObject acw = this.bQx.acw();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + acw);
        }
        return acw;
    }

    public void clear() {
        this.bQw.clear();
        this.bQx.clear();
    }

    public File acu() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.aar() == null ? "" : e.aar()) + "_swan_stability_traces.log";
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(acs());
        jSONArray.put(act());
        com.baidu.swan.apps.v.a.j(str, jSONArray.toString(), false);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Write traces to file：" + str + "\ndata: " + jSONArray);
        }
        return file;
    }

    public void acv() {
        String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/stability/" + (e.aar() == null ? "" : e.aar()) + "_swan_stability_traces.log";
        com.baidu.swan.d.c.qR(str);
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "Safe delete trace file：" + str);
        }
    }
}
