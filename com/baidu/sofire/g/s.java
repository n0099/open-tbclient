package com.baidu.sofire.g;

import android.content.Context;
/* loaded from: classes3.dex */
public final class s {
    public static boolean a(Context context) {
        boolean z = new com.baidu.sofire.e(context).f11729b.getBoolean("s_a_pl", false);
        boolean z2 = !d.b(context, ".ffnpp");
        if (z && !z2 && d.b(context) == 1) {
            d.a(context, ".ffnpp", 0);
            return true;
        }
        return z2;
    }
}
