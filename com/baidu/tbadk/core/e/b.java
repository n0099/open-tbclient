package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adp = null;

    public static void i(Context context, int i) {
        if (adp != null) {
            adp.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (adp != null) {
            adp.b(context, i, z);
        }
    }

    public static void ay(Context context) {
        if (adp != null) {
            adp.ay(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adp != null) {
            adp.c(context, i, z);
        }
    }

    public static Class<?> um() {
        if (adp == null) {
            return null;
        }
        return adp.um();
    }

    public static String un() {
        if (adp == null) {
            return null;
        }
        return adp.un();
    }

    public static void a(a aVar) {
        adp = aVar;
    }

    public static int getCurrentTabType() {
        if (adp == null) {
            return -1;
        }
        return adp.getCurrentTabType();
    }
}
