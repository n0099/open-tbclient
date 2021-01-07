package com.baidu.platform.comapi.wnplatform.l;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f4654a = null;

    /* renamed from: b  reason: collision with root package name */
    private static a f4655b = null;

    private a() {
    }

    public static a a() {
        if (f4655b == null) {
            f4655b = new a();
        }
        if (f4654a == null) {
            f4654a = new JSONObject();
        }
        return f4655b;
    }

    public void a(String str, String str2) {
        try {
            f4654a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f4654a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
