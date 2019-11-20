package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d aCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar) {
        aCs = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Exception exc) {
        if (aCs != null) {
            aCs.dK(i(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dK(String str) {
        if (aCs != null) {
            aCs.dK(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject i(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.Ab());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
