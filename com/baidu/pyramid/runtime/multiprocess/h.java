package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private static e ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar) {
        ajj = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (ajj != null) {
            ajj.ds(l(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ds(String str) {
        if (ajj != null) {
            ajj.ds(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject l(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(th));
            jSONObject.put("process_info", a.uM());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
