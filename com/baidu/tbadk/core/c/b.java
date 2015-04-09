package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Sf = null;

    public static void e(Context context, int i) {
        if (Sf != null) {
            Sf.e(context, i);
        }
    }

    public static void Y(Context context) {
        if (Sf != null) {
            Sf.Y(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Sf != null) {
            Sf.a(context, i, z);
        }
    }

    public static Class<?> ru() {
        if (Sf == null) {
            return null;
        }
        return Sf.ru();
    }

    public static String rv() {
        if (Sf == null) {
            return null;
        }
        return Sf.rv();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            Sf = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (Sf == null) {
            return -1;
        }
        return Sf.getCurrentTabType();
    }
}
