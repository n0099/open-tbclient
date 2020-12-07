package com.baidu.platform.comapi.wnplatform.l;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f3128a = null;
    private static a b = null;

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        if (f3128a == null) {
            f3128a = new JSONObject();
        }
        return b;
    }

    public void a(String str, String str2) {
        try {
            f3128a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f3128a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
