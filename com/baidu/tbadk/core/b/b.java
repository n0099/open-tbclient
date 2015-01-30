package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Gg = null;

    public static void e(Context context, int i) {
        if (Gg != null) {
            Gg.e(context, i);
        }
    }

    public static void R(Context context) {
        if (Gg != null) {
            Gg.R(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Gg != null) {
            Gg.a(context, i, z);
        }
    }

    public static Class<?> oc() {
        if (Gg == null) {
            return null;
        }
        return Gg.oc();
    }

    public static String od() {
        if (Gg == null) {
            return null;
        }
        return Gg.od();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            Gg = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (Gg == null) {
            return -1;
        }
        return Gg.getCurrentTabType();
    }
}
