package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.b.g;
import com.baidu.sofire.e;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        String str;
        Throwable th;
        e eVar;
        try {
            eVar = new e(context);
            str = eVar.x();
        } catch (Throwable th2) {
            str = "";
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.d(str);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            com.baidu.sofire.b.e.a(th);
            return str;
        }
        return str;
    }

    public static String b(Context context) {
        String str;
        Throwable th;
        e eVar;
        try {
            eVar = new e(context);
            str = eVar.y();
        } catch (Throwable th2) {
            str = "";
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = g.f(context);
                if (!TextUtils.isEmpty(str)) {
                    eVar.e(str);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            com.baidu.sofire.b.e.a(th);
            return str;
        }
        return str;
    }

    public static String c(Context context) {
        String str;
        Throwable th;
        e eVar;
        try {
            eVar = new e(context);
            str = eVar.z();
        } catch (Throwable th2) {
            str = "";
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = g.f();
                if (!TextUtils.isEmpty(str)) {
                    eVar.f(str);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            com.baidu.sofire.b.e.a(th);
            return str;
        }
        return str;
    }
}
