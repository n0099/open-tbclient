package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static d aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Exception exc) {
        if (aRm != null) {
            aRm.eE(i(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void eE(String str) {
        if (aRm != null) {
            aRm.eE(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject i(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.Cu());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
