package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.f;
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
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(str2)) {
                str3 = "&topic=" + str2;
            }
            String a = f.a(this.a, d.a() + "plugin/v1/report", str, false, false, str3);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return new JSONObject(a).getInt("response") == 1;
        } catch (Throwable th) {
            d.a(th);
            return true;
        }
    }
}
