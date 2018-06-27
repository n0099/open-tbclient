package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a anB = null;

    public static void g(Context context, int i) {
        if (anB != null) {
            anB.g(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (anB != null) {
            anB.b(context, i, z);
        }
    }

    public static void aI(Context context) {
        if (anB != null) {
            anB.aI(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (anB != null) {
            anB.c(context, i, z);
        }
    }

    public static Class<?> ya() {
        if (anB == null) {
            return null;
        }
        return anB.ya();
    }

    public static String yb() {
        if (anB == null) {
            return null;
        }
        return anB.yb();
    }

    public static void a(a aVar) {
        anB = aVar;
    }

    public static int getCurrentTabType() {
        if (anB == null) {
            return -1;
        }
        return anB.getCurrentTabType();
    }
}
