package com.baidu.pyramid.runtime.multiprocess;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private static e ahY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar) {
        ahY = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Exception exc) {
        if (ahY != null) {
            ahY.dh(j(exc).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dh(String str) {
        if (ahY != null) {
            ahY.dh(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject j(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("process_name", a.getProcessName());
            jSONObject.put("stack_trace", Log.getStackTraceString(exc));
            jSONObject.put("process_info", a.tR());
            jSONObject.put("report_time", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
