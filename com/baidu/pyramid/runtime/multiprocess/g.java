package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d aCK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar) {
        aCK = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (aCK != null) {
            aCK.dK(j(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dK(String str) {
        if (aCK != null) {
            aCK.dK(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject j(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.Aa());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
