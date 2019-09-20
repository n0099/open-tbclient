package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bQu = null;

    public static void o(Context context, int i) {
        if (bQu != null) {
            bQu.o(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (bQu != null) {
            bQu.b(context, i, z);
        }
    }

    public static void cs(Context context) {
        if (bQu != null) {
            bQu.cs(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bQu != null) {
            bQu.c(context, i, z);
        }
    }

    public static Class<?> ahL() {
        if (bQu == null) {
            return null;
        }
        return bQu.ahL();
    }

    public static String ahM() {
        if (bQu == null) {
            return null;
        }
        return bQu.ahM();
    }

    public static void a(a aVar) {
        bQu = aVar;
    }

    public static int getCurrentTabType() {
        if (bQu == null) {
            return -1;
        }
        return bQu.getCurrentTabType();
    }
}
