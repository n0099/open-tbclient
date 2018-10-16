package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a auA = null;

    public static void k(Context context, int i) {
        if (auA != null) {
            auA.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (auA != null) {
            auA.c(context, i, z);
        }
    }

    public static void bx(Context context) {
        if (auA != null) {
            auA.bx(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (auA != null) {
            auA.d(context, i, z);
        }
    }

    public static Class<?> Bg() {
        if (auA == null) {
            return null;
        }
        return auA.Bg();
    }

    public static String Bh() {
        if (auA == null) {
            return null;
        }
        return auA.Bh();
    }

    public static void a(a aVar) {
        auA = aVar;
    }

    public static int getCurrentTabType() {
        if (auA == null) {
            return -1;
        }
        return auA.getCurrentTabType();
    }
}
