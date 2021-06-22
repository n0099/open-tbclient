package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static int f10449a = -1;

    public static void a(Context context, boolean z) {
        if (context == null) {
            return;
        }
        f10449a = z ? 1 : 2;
        c.a(context, ".ffnpp", !z ? 1 : 0);
        if (context != null) {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            a2.f10324d.putBoolean("s_a_pl", z);
            if (Build.VERSION.SDK_INT >= 9) {
                a2.f10324d.apply();
            } else {
                a2.f10324d.commit();
            }
        }
    }

    public static boolean a(Context context) {
        int i2;
        if (context == null) {
            return false;
        }
        int a2 = c.a(context);
        if (a2 == 1 && (i2 = f10449a) != -1) {
            return i2 == 1;
        }
        boolean z = com.baidu.sofire.h.a.a(context).f10323c.getBoolean("s_a_pl", false);
        boolean z2 = !c.b(context, ".ffnpp");
        if (z && !z2 && a2 == 1) {
            c.a(context, ".ffnpp", 0);
            z2 = true;
        }
        if (a2 == 1) {
            if (z2) {
                f10449a = 1;
            } else {
                f10449a = 2;
            }
        }
        return z2;
    }
}
