package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ga = null;

    public static void e(Context context, int i) {
        if (Ga != null) {
            Ga.e(context, i);
        }
    }

    public static void R(Context context) {
        if (Ga != null) {
            Ga.R(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Ga != null) {
            Ga.a(context, i, z);
        }
    }

    public static Class<?> nZ() {
        if (Ga == null) {
            return null;
        }
        return Ga.nZ();
    }

    public static String oa() {
        if (Ga == null) {
            return null;
        }
        return Ga.oa();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            Ga = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (Ga == null) {
            return -1;
        }
        return Ga.getCurrentTabType();
    }
}
