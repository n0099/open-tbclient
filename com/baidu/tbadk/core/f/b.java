package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cgG = null;

    public static void m(Context context, int i) {
        if (cgG != null) {
            cgG.m(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cgG != null) {
            cgG.b(context, i, z);
        }
    }

    public static void co(Context context) {
        if (cgG != null) {
            cgG.co(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cgG != null) {
            cgG.c(context, i, z);
        }
    }

    public static Class<?> alG() {
        if (cgG == null) {
            return null;
        }
        return cgG.alG();
    }

    public static String alH() {
        if (cgG == null) {
            return null;
        }
        return cgG.alH();
    }

    public static void a(a aVar) {
        cgG = aVar;
    }

    public static int getCurrentTabType() {
        if (cgG == null) {
            return -1;
        }
        return cgG.getCurrentTabType();
    }
}
