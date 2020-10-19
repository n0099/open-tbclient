package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ewn = null;

    public static void r(Context context, int i) {
        if (ewn != null) {
            ewn.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ewn != null) {
            ewn.c(context, i, z);
        }
    }

    public static void dY(Context context) {
        if (ewn != null) {
            ewn.dY(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ewn != null) {
            ewn.d(context, i, z);
        }
    }

    public static Class<?> blE() {
        if (ewn == null) {
            return null;
        }
        return ewn.blE();
    }

    public static String blF() {
        if (ewn == null) {
            return null;
        }
        return ewn.blF();
    }

    public static void a(a aVar) {
        ewn = aVar;
    }

    public static int getCurrentTabType() {
        if (ewn == null) {
            return -1;
        }
        return ewn.getCurrentTabType();
    }
}
