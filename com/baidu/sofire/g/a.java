package com.baidu.sofire.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.sofire.b;
import com.baidu.sofire.i.e;
import com.baidu.sofire.i.i;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f5532a;

    public a(Context context) {
        this.f5532a = context;
    }

    public final boolean a(String str) {
        String a2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        new StringBuilder().append(str);
        b.a();
        try {
            String str2 = e.b() + "p/1/r";
            new StringBuilder().append(str2);
            b.a();
            a2 = i.a(this.f5532a, str2, str, false, false);
        } catch (Throwable th) {
            e.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (new JSONObject(a2).getInt(IIntercepter.TYPE_RESPONSE) == 1) {
            return true;
        }
        return false;
    }
}
