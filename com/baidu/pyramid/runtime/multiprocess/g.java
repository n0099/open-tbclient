package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (buz != null) {
            buz.ge(j(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ge(String str) {
        if (buz != null) {
            buz.ge(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject j(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.MG());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
