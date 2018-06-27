package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.h;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            TextUtils.isEmpty(str2);
            String a = h.a(this.a, e.a() + "p/1/r", str, false, false);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return new JSONObject(a).getInt("response") == 1;
        } catch (Throwable th) {
            e.a(th);
            return true;
        }
    }
}
