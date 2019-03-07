package com.baidu.swan.apps.m.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public final String asI;
    public final String avj;

    public d(String str, String str2) {
        this.asI = str;
        this.avj = str2;
    }

    public static d eC(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new d(jSONObject.optString("webviewid"), jSONObject.optString("message"));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("SwanAppNativeMessage", "createEvent failed. " + Log.getStackTraceString(e));
            }
            return null;
        }
    }
}
