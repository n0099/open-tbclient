package com.baidu.sofire.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.i.d;
import com.baidu.sofire.i.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        new StringBuilder().append(str);
        b.a();
        try {
            String str2 = d.b() + "p/1/r";
            new StringBuilder().append(str2);
            b.a();
            String a = h.a(this.a, str2, str, false);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return new JSONObject(a).getInt("response") == 1;
        } catch (Throwable th) {
            d.a();
            return true;
        }
    }
}
