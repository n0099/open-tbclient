package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XW = null;

    public static void f(Context context, int i) {
        if (XW != null) {
            XW.f(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (XW != null) {
            XW.b(context, i, z);
        }
    }

    public static void T(Context context) {
        if (XW != null) {
            XW.T(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (XW != null) {
            XW.c(context, i, z);
        }
    }

    public static Class<?> tP() {
        if (XW == null) {
            return null;
        }
        return XW.tP();
    }

    public static String tQ() {
        if (XW == null) {
            return null;
        }
        return XW.tQ();
    }

    public static void a(a aVar) {
        XW = aVar;
    }

    public static int getCurrentTabType() {
        if (XW == null) {
            return -1;
        }
        return XW.getCurrentTabType();
    }
}
