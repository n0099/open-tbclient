package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XL = null;

    public static void e(Context context, int i) {
        if (XL != null) {
            XL.e(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (XL != null) {
            XL.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (XL != null) {
            XL.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (XL != null) {
            XL.b(context, i, z);
        }
    }

    public static Class<?> tn() {
        if (XL == null) {
            return null;
        }
        return XL.tn();
    }

    public static String to() {
        if (XL == null) {
            return null;
        }
        return XL.to();
    }

    public static void a(a aVar) {
        XL = aVar;
    }

    public static int getCurrentTabType() {
        if (XL == null) {
            return -1;
        }
        return XL.getCurrentTabType();
    }
}
