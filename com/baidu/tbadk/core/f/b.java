package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bPT = null;

    public static void o(Context context, int i) {
        if (bPT != null) {
            bPT.o(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (bPT != null) {
            bPT.b(context, i, z);
        }
    }

    public static void cs(Context context) {
        if (bPT != null) {
            bPT.cs(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bPT != null) {
            bPT.c(context, i, z);
        }
    }

    public static Class<?> ahH() {
        if (bPT == null) {
            return null;
        }
        return bPT.ahH();
    }

    public static String ahI() {
        if (bPT == null) {
            return null;
        }
        return bPT.ahI();
    }

    public static void a(a aVar) {
        bPT = aVar;
    }

    public static int getCurrentTabType() {
        if (bPT == null) {
            return -1;
        }
        return bPT.getCurrentTabType();
    }
}
