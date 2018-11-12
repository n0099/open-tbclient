package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    private static f ahy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar) {
        ahy = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (ahy != null) {
            ahy.dj(l(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dj(String str) {
        if (ahy != null) {
            ahy.dj(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject l(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(th));
            jSONObject.put("process_info", a.us());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
