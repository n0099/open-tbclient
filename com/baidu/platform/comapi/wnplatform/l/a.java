package com.baidu.platform.comapi.wnplatform.l;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f4653a = null;

    /* renamed from: b  reason: collision with root package name */
    private static a f4654b = null;

    private a() {
    }

    public static a a() {
        if (f4654b == null) {
            f4654b = new a();
        }
        if (f4653a == null) {
            f4653a = new JSONObject();
        }
        return f4654b;
    }

    public void a(String str, String str2) {
        try {
            f4653a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f4653a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
