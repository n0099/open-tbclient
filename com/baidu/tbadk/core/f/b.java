package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a chx = null;

    public static void m(Context context, int i) {
        if (chx != null) {
            chx.m(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (chx != null) {
            chx.b(context, i, z);
        }
    }

    public static void co(Context context) {
        if (chx != null) {
            chx.co(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (chx != null) {
            chx.c(context, i, z);
        }
    }

    public static Class<?> alI() {
        if (chx == null) {
            return null;
        }
        return chx.alI();
    }

    public static String alJ() {
        if (chx == null) {
            return null;
        }
        return chx.alJ();
    }

    public static void a(a aVar) {
        chx = aVar;
    }

    public static int getCurrentTabType() {
        if (chx == null) {
            return -1;
        }
        return chx.getCurrentTabType();
    }
}
