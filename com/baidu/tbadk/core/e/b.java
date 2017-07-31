package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aeK = null;

    public static void i(Context context, int i) {
        if (aeK != null) {
            aeK.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (aeK != null) {
            aeK.b(context, i, z);
        }
    }

    public static void az(Context context) {
        if (aeK != null) {
            aeK.az(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (aeK != null) {
            aeK.c(context, i, z);
        }
    }

    public static Class<?> uw() {
        if (aeK == null) {
            return null;
        }
        return aeK.uw();
    }

    public static String ux() {
        if (aeK == null) {
            return null;
        }
        return aeK.ux();
    }

    public static void a(a aVar) {
        aeK = aVar;
    }

    public static int getCurrentTabType() {
        if (aeK == null) {
            return -1;
        }
        return aeK.getCurrentTabType();
    }
}
