package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a anc = null;

    public static void h(Context context, int i) {
        if (anc != null) {
            anc.h(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (anc != null) {
            anc.b(context, i, z);
        }
    }

    public static void aJ(Context context) {
        if (anc != null) {
            anc.aJ(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (anc != null) {
            anc.c(context, i, z);
        }
    }

    public static Class<?> xS() {
        if (anc == null) {
            return null;
        }
        return anc.xS();
    }

    public static String xT() {
        if (anc == null) {
            return null;
        }
        return anc.xT();
    }

    public static void a(a aVar) {
        anc = aVar;
    }

    public static int getCurrentTabType() {
        if (anc == null) {
            return -1;
        }
        return anc.getCurrentTabType();
    }
}
