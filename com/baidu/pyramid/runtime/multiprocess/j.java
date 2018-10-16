package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    private static f agL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar) {
        agL = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (agL != null) {
            agL.dj(l(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dj(String str) {
        if (agL != null) {
            agL.dj(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject l(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(th));
            jSONObject.put("process_info", a.ui());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
