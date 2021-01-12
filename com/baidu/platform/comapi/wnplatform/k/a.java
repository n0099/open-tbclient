package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f4423a = null;

    /* renamed from: b  reason: collision with root package name */
    private static a f4424b = null;

    private a() {
    }

    public static a a() {
        if (f4424b == null) {
            f4424b = new a();
        }
        if (f4423a == null) {
            f4423a = new JSONObject();
        }
        return f4424b;
    }

    public void a(String str, String str2) {
        try {
            f4423a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f4423a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
