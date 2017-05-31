package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a acj = null;

    public static void i(Context context, int i) {
        if (acj != null) {
            acj.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (acj != null) {
            acj.b(context, i, z);
        }
    }

    public static void ay(Context context) {
        if (acj != null) {
            acj.ay(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (acj != null) {
            acj.c(context, i, z);
        }
    }

    public static Class<?> tP() {
        if (acj == null) {
            return null;
        }
        return acj.tP();
    }

    public static String tQ() {
        if (acj == null) {
            return null;
        }
        return acj.tQ();
    }

    public static void a(a aVar) {
        acj = aVar;
    }

    public static int getCurrentTabType() {
        if (acj == null) {
            return -1;
        }
        return acj.getCurrentTabType();
    }
}
