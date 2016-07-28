package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ve = null;

    public static void d(Context context, int i) {
        if (Ve != null) {
            Ve.d(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Ve != null) {
            Ve.b(context, i, z);
        }
    }

    public static void L(Context context) {
        if (Ve != null) {
            Ve.L(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (Ve != null) {
            Ve.c(context, i, z);
        }
    }

    public static Class<?> sG() {
        if (Ve == null) {
            return null;
        }
        return Ve.sG();
    }

    public static String sH() {
        if (Ve == null) {
            return null;
        }
        return Ve.sH();
    }

    public static void a(a aVar) {
        Ve = aVar;
    }

    public static int getCurrentTabType() {
        if (Ve == null) {
            return -1;
        }
        return Ve.getCurrentTabType();
    }
}
