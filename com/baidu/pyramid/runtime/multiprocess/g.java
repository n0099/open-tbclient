package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d aiQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar) {
        aiQ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (aiQ != null) {
            aiQ.cY(j(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cY(String str) {
        if (aiQ != null) {
            aiQ.cY(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject j(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.vc());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
