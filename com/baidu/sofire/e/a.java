package com.baidu.sofire.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f10295a;

    public a(Context context) {
        this.f10295a = context;
    }

    public final boolean a(String str) {
        String a2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        new StringBuilder().append(str);
        b.a();
        try {
            String str2 = d.b() + "p/1/r";
            new StringBuilder().append(str2);
            b.a();
            a2 = g.a(this.f10295a, str2, str, false, false);
        } catch (Throwable unused) {
            d.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return new JSONObject(a2).getInt("response") == 1;
    }
}
