package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f10301a;

    /* renamed from: b  reason: collision with root package name */
    public static a f10302b;

    public static a a() {
        if (f10302b == null) {
            f10302b = new a();
        }
        if (f10301a == null) {
            f10301a = new JSONObject();
        }
        return f10302b;
    }

    public boolean a(String str) {
        return false;
    }

    public void a(String str, String str2) {
        try {
            f10301a.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public void a(String str, int i) {
        try {
            f10301a.put(str, Integer.toString(i));
        } catch (JSONException unused) {
        }
    }
}
