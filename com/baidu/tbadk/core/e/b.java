package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aeZ = null;

    public static void g(Context context, int i) {
        if (aeZ != null) {
            aeZ.g(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (aeZ != null) {
            aeZ.b(context, i, z);
        }
    }

    public static void ay(Context context) {
        if (aeZ != null) {
            aeZ.ay(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (aeZ != null) {
            aeZ.c(context, i, z);
        }
    }

    public static Class<?> uq() {
        if (aeZ == null) {
            return null;
        }
        return aeZ.uq();
    }

    public static String ur() {
        if (aeZ == null) {
            return null;
        }
        return aeZ.ur();
    }

    public static void a(a aVar) {
        aeZ = aVar;
    }

    public static int getCurrentTabType() {
        if (aeZ == null) {
            return -1;
        }
        return aeZ.getCurrentTabType();
    }
}
