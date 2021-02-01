package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f4426a = null;

    /* renamed from: b  reason: collision with root package name */
    private static a f4427b = null;

    private a() {
    }

    public static a a() {
        if (f4427b == null) {
            f4427b = new a();
        }
        if (f4426a == null) {
            f4426a = new JSONObject();
        }
        return f4427b;
    }

    public void a(String str, String str2) {
        try {
            f4426a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f4426a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
