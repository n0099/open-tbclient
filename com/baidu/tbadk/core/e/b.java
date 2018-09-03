package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a and = null;

    public static void h(Context context, int i) {
        if (and != null) {
            and.h(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (and != null) {
            and.b(context, i, z);
        }
    }

    public static void aI(Context context) {
        if (and != null) {
            and.aI(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (and != null) {
            and.c(context, i, z);
        }
    }

    public static Class<?> xR() {
        if (and == null) {
            return null;
        }
        return and.xR();
    }

    public static String xS() {
        if (and == null) {
            return null;
        }
        return and.xS();
    }

    public static void a(a aVar) {
        and = aVar;
    }

    public static int getCurrentTabType() {
        if (and == null) {
            return -1;
        }
        return and.getCurrentTabType();
    }
}
