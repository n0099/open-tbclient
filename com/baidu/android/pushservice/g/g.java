package com.baidu.android.pushservice.g;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends b {
    public static int a = 0;
    public static int b = 10;
    public static int c = 11;
    public static int d = 12;
    public static int e = 13;
    public static int f = 14;
    private int g;

    public g() {
        this.g = 0;
    }

    public g(String str) {
        super(str);
        this.g = 0;
    }

    public JSONObject a(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_type", this.g);
        if (!TextUtils.isEmpty(b())) {
            jSONObject.put("app_package_name", b());
        }
        if (!TextUtils.isEmpty(c())) {
            jSONObject.put("app_name", c());
        }
        if (!TextUtils.isEmpty(d())) {
            jSONObject.put("app_cfrom", d());
        }
        if (e() != -1) {
            jSONObject.put("app_vercode", e());
        }
        if (!TextUtils.isEmpty(f())) {
            jSONObject.put("app_vername", f());
        }
        if (g() != -1) {
            jSONObject.put("app_push_version", g());
        }
        jSONObject.put("app_appid", a());
        return jSONObject;
    }

    public void c(int i) {
        this.g = i;
    }

    public int h() {
        return this.g;
    }
}
