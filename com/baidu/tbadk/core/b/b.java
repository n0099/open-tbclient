package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Gd = null;

    public static void e(Context context, int i) {
        if (Gd != null) {
            Gd.e(context, i);
        }
    }

    public static void R(Context context) {
        if (Gd != null) {
            Gd.R(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Gd != null) {
            Gd.a(context, i, z);
        }
    }

    public static Class<?> nV() {
        if (Gd == null) {
            return null;
        }
        return Gd.nV();
    }

    public static String nW() {
        if (Gd == null) {
            return null;
        }
        return Gd.nW();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            Gd = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (Gd == null) {
            return -1;
        }
        return Gd.getCurrentTabType();
    }
}
