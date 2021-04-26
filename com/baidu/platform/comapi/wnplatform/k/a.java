package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f10225a;

    /* renamed from: b  reason: collision with root package name */
    public static a f10226b;

    public static a a() {
        if (f10226b == null) {
            f10226b = new a();
        }
        if (f10225a == null) {
            f10225a = new JSONObject();
        }
        return f10226b;
    }

    public boolean a(String str) {
        return false;
    }

    public void a(String str, String str2) {
        try {
            f10225a.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public void a(String str, int i2) {
        try {
            f10225a.put(str, Integer.toString(i2));
        } catch (JSONException unused) {
        }
    }
}
