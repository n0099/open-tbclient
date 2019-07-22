package com.baidu.swan.apps.m.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String atF;
    public final String awm;

    public d(String str, String str2) {
        this.atF = str;
        this.awm = str2;
    }

    public static d ew(String str) {
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
