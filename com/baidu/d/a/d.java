package com.baidu.d.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            jSONObject.put("message", str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put("message", str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
