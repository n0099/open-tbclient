package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a BR = null;

    public static void d(Context context, int i) {
        if (BR != null) {
            BR.d(context, i);
        }
    }

    public static void t(Context context) {
        if (BR != null) {
            BR.t(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (BR != null) {
            BR.a(context, i, z);
        }
    }

    public static Class<?> ld() {
        if (BR == null) {
            return null;
        }
        return BR.ld();
    }

    public static String le() {
        if (BR == null) {
            return null;
        }
        return BR.le();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            BR = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (BR == null) {
            return -1;
        }
        return BR.getCurrentTabType();
    }
}
