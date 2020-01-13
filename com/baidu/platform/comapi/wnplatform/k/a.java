package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static JSONObject a = null;
    private static a b = null;

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        if (a == null) {
            a = new JSONObject();
        }
        return b;
    }

    public void a(String str, String str2) {
        try {
            a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
