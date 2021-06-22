package com.baidu.sofire.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f10311a;

    public a(Context context) {
        this.f10311a = context;
    }

    public final boolean a(String str) {
        String a2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            a2 = f.a(this.f10311a, c.b() + "p/1/r", str, false, false);
        } catch (Throwable unused) {
            c.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return new JSONObject(a2).getInt("response") == 1;
    }
}
