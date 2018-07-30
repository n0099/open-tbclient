package com.baidu.c.a;

import android.support.v4.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i);
            jSONObject.put("message", str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, -1);
            jSONObject.put("message", str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
