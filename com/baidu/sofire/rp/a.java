package com.baidu.sofire.rp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.g;
import com.baidu.sofire.utility.s;
/* loaded from: classes2.dex */
public final class a {
    public static String a(Context context) {
        com.baidu.sofire.h.a a2;
        String n;
        String str = "";
        try {
            a2 = com.baidu.sofire.h.a.a(context);
            if (!TextUtils.isEmpty(a2.f10323c.getString("rpiiem", ""))) {
                a2.f10324d.putString("rpiiem", "");
                a2.f10324d.commit();
            }
            n = a2.n();
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(n)) {
                n = s.h(context);
                if (!TextUtils.isEmpty(n)) {
                    if (TextUtils.isEmpty(n)) {
                        a2.f10324d.putString("rpiiemn", "");
                        a2.f10324d.commit();
                    } else {
                        a2.f10324d.putString("rpiiemn", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), n.getBytes("UTF-8"), true), 10), "UTF-8"));
                        a2.f10324d.commit();
                    }
                }
            }
            return n;
        } catch (Throwable unused2) {
            str = n;
            c.a();
            return str;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            str = a2.f10323c.getString("rpandid", "");
            if (TextUtils.isEmpty(str)) {
                str = s.i(context);
                if (!TextUtils.isEmpty(str)) {
                    a2.f10324d.putString("rpandid", str);
                    a2.f10324d.commit();
                }
            }
        } catch (Throwable unused) {
            c.a();
        }
        return str;
    }
}
