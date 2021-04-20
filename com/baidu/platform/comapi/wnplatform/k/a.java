package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f9859a;

    /* renamed from: b  reason: collision with root package name */
    public static a f9860b;

    public static a a() {
        if (f9860b == null) {
            f9860b = new a();
        }
        if (f9859a == null) {
            f9859a = new JSONObject();
        }
        return f9860b;
    }

    public boolean a(String str) {
        return false;
    }

    public void a(String str, String str2) {
        try {
            f9859a.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public void a(String str, int i) {
        try {
            f9859a.put(str, Integer.toString(i));
        } catch (JSONException unused) {
        }
    }
}
