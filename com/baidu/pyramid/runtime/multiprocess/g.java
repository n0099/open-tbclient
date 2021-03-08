package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class g {
    private static d cup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Exception exc) {
        if (cup != null) {
            cup.report(m(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void report(String str) {
        if (cup != null) {
            cup.report(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject m(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.aef());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
