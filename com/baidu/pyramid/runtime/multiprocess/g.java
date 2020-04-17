package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d buu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Exception exc) {
        if (buu != null) {
            buu.ge(i(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ge(String str) {
        if (buu != null) {
            buu.ge(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject i(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.MH());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
