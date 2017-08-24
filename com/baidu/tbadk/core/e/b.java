package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aeM = null;

    public static void i(Context context, int i) {
        if (aeM != null) {
            aeM.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (aeM != null) {
            aeM.b(context, i, z);
        }
    }

    public static void az(Context context) {
        if (aeM != null) {
            aeM.az(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (aeM != null) {
            aeM.c(context, i, z);
        }
    }

    public static Class<?> ux() {
        if (aeM == null) {
            return null;
        }
        return aeM.ux();
    }

    public static String uy() {
        if (aeM == null) {
            return null;
        }
        return aeM.uy();
    }

    public static void a(a aVar) {
        aeM = aVar;
    }

    public static int getCurrentTabType() {
        if (aeM == null) {
            return -1;
        }
        return aeM.getCurrentTabType();
    }
}
