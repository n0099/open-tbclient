package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        new StringBuilder().append(str);
        b.a();
        try {
            TextUtils.isEmpty(str2);
            String str3 = e.b() + "p/1/r";
            new StringBuilder().append(str3);
            b.a();
            String a = h.a(this.a, str3, str);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return new JSONObject(a).getInt("response") == 1;
        } catch (Throwable th) {
            e.a();
            return true;
        }
    }
}
