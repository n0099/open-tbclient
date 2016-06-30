package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ut = null;

    public static void d(Context context, int i) {
        if (Ut != null) {
            Ut.d(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Ut != null) {
            Ut.b(context, i, z);
        }
    }

    public static void L(Context context) {
        if (Ut != null) {
            Ut.L(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (Ut != null) {
            Ut.c(context, i, z);
        }
    }

    public static Class<?> sH() {
        if (Ut == null) {
            return null;
        }
        return Ut.sH();
    }

    public static String sI() {
        if (Ut == null) {
            return null;
        }
        return Ut.sI();
    }

    public static void a(a aVar) {
        Ut = aVar;
    }

    public static int getCurrentTabType() {
        if (Ut == null) {
            return -1;
        }
        return Ut.getCurrentTabType();
    }
}
