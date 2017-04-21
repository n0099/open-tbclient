package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a acO = null;

    public static void i(Context context, int i) {
        if (acO != null) {
            acO.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (acO != null) {
            acO.b(context, i, z);
        }
    }

    public static void av(Context context) {
        if (acO != null) {
            acO.av(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (acO != null) {
            acO.c(context, i, z);
        }
    }

    public static Class<?> uE() {
        if (acO == null) {
            return null;
        }
        return acO.uE();
    }

    public static String uF() {
        if (acO == null) {
            return null;
        }
        return acO.uF();
    }

    public static void a(a aVar) {
        acO = aVar;
    }

    public static int getCurrentTabType() {
        if (acO == null) {
            return -1;
        }
        return acO.getCurrentTabType();
    }
}
