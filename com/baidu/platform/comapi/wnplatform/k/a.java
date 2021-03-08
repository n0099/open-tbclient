package com.baidu.platform.comapi.wnplatform.k;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f3064a = null;
    private static a b = null;

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        if (f3064a == null) {
            f3064a = new JSONObject();
        }
        return b;
    }

    public void a(String str, String str2) {
        try {
            f3064a.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public void a(String str, int i) {
        try {
            f3064a.put(str, Integer.toString(i));
        } catch (JSONException e) {
        }
    }

    public boolean a(String str) {
        return false;
    }
}
