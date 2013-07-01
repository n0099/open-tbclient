package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private static f b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f245a;

    private f(Context context) {
        this.f245a = null;
        this.f245a = context.getApplicationContext();
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
            return new l(str, this.f245a);
        }
        if ("appuninstall".equals(str2)) {
            return new h(str, this.f245a);
        }
        if ("appfreeze".equals(str2)) {
            return new c(str, this.f245a);
        }
        if ("appunfreeze".equals(str2)) {
            return new j(str, this.f245a);
        }
        if ("filepush".equals(str2)) {
            return new g(str, this.f245a);
        }
        if ("settings".equals(str2)) {
            return new k(str, this.f245a);
        }
        return null;
    }
}
