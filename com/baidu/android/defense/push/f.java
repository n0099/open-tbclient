package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private static f b = null;
    private Context a;

    private f(Context context) {
        this.a = null;
        this.a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (b == null) {
            b = new f(context);
        }
        return b;
    }

    public final i a(String str) {
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
            return new l(str, this.a);
        }
        if ("appuninstall".equals(str2)) {
            return new h(str, this.a);
        }
        if ("appfreeze".equals(str2)) {
            return new c(str, this.a);
        }
        if ("appunfreeze".equals(str2)) {
            return new j(str, this.a);
        }
        if ("filepush".equals(str2)) {
            return new g(str, this.a);
        }
        if ("settings".equals(str2)) {
            return new k(str, this.a);
        }
        return null;
    }
}
