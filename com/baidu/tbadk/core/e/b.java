package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a dwO = null;

    public static void q(Context context, int i) {
        if (dwO != null) {
            dwO.q(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (dwO != null) {
            dwO.b(context, i, z);
        }
    }

    public static void dz(Context context) {
        if (dwO != null) {
            dwO.dz(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (dwO != null) {
            dwO.c(context, i, z);
        }
    }

    public static Class<?> aNM() {
        if (dwO == null) {
            return null;
        }
        return dwO.aNM();
    }

    public static String aNN() {
        if (dwO == null) {
            return null;
        }
        return dwO.aNN();
    }

    public static void a(a aVar) {
        dwO = aVar;
    }

    public static int getCurrentTabType() {
        if (dwO == null) {
            return -1;
        }
        return dwO.getCurrentTabType();
    }
}
