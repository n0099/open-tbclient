package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d ajo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar) {
        ajo = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (ajo != null) {
            ajo.da(j(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void da(String str) {
        if (ajo != null) {
            ajo.da(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject j(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.vg());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
