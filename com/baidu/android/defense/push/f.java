package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private static f b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f509a;

    private f(Context context) {
        this.f509a = null;
        this.f509a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (b == null) {
            b = new f(context);
        }
        return b;
    }

    public i a(String str) {
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
            return new l(str, this.f509a);
        }
        if ("appuninstall".equals(str2)) {
            return new h(str, this.f509a);
        }
        if ("appfreeze".equals(str2)) {
            return new c(str, this.f509a);
        }
        if ("appunfreeze".equals(str2)) {
            return new j(str, this.f509a);
        }
        if ("filepush".equals(str2)) {
            return new g(str, this.f509a);
        }
        if ("settings".equals(str2)) {
            return new k(str, this.f509a);
        }
        return null;
    }
}
