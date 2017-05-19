package com.baidu.android.pushservice.f;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends c {
    public static int a = 0;
    private int b;

    public i() {
        this.b = 0;
    }

    public i(String str) {
        super(str);
        this.b = 0;
    }

    public JSONObject a(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_type", this.b);
        if (!TextUtils.isEmpty(d())) {
            jSONObject.put("app_package_name", d());
        }
        if (!TextUtils.isEmpty(e())) {
            jSONObject.put("app_name", e());
        }
        if (!TextUtils.isEmpty(f())) {
            jSONObject.put("app_cfrom", f());
        }
        if (g() != -1) {
            jSONObject.put("app_vercode", g());
        }
        if (!TextUtils.isEmpty(h())) {
            jSONObject.put("app_vername", h());
        }
        if (i() != -1) {
            jSONObject.put("app_push_version", i());
        }
        jSONObject.put("app_appid", a());
        if (!TextUtils.isEmpty(b())) {
            jSONObject.put("user_id_rsa", b());
        }
        if (!TextUtils.isEmpty(c())) {
            jSONObject.put("user_id", c());
        }
        return jSONObject;
    }

    public void c(int i) {
        this.b = i;
    }

    public int j() {
        return this.b;
    }
}
