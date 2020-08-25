package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    private static d bMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Exception exc) {
        if (bMP != null) {
            bMP.iq(l(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void iq(String str) {
        if (bMP != null) {
            bMP.iq(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject l(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.Wj());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
