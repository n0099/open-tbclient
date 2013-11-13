package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    private static g b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f629a;

    private g(Context context) {
        this.f629a = null;
        this.f629a = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (b == null) {
            b = new g(context);
        }
        return b;
    }

    public a a(String str) {
        String str2;
        try {
            str2 = new JSONObject(str).getString("cmd");
        } catch (JSONException e) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if ("appinstall".equals(str2)) {
            return new c(str, this.f629a);
        }
        if ("appuninstall".equals(str2)) {
            return new e(str, this.f629a);
        }
        if ("appfreeze".equals(str2)) {
            return new b(str, this.f629a);
        }
        if ("appunfreeze".equals(str2)) {
            return new d(str, this.f629a);
        }
        if ("filepush".equals(str2)) {
            return new h(str, this.f629a);
        }
        if ("settings".equals(str2)) {
            return new i(str, this.f629a);
        }
        return null;
    }
}
