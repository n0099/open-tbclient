package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a acN = null;

    public static void i(Context context, int i) {
        if (acN != null) {
            acN.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (acN != null) {
            acN.b(context, i, z);
        }
    }

    public static void av(Context context) {
        if (acN != null) {
            acN.av(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (acN != null) {
            acN.c(context, i, z);
        }
    }

    public static Class<?> uE() {
        if (acN == null) {
            return null;
        }
        return acN.uE();
    }

    public static String uF() {
        if (acN == null) {
            return null;
        }
        return acN.uF();
    }

    public static void a(a aVar) {
        acN = aVar;
    }

    public static int getCurrentTabType() {
        if (acN == null) {
            return -1;
        }
        return acN.getCurrentTabType();
    }
}
