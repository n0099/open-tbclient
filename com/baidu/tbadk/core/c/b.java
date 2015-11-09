package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XO = null;

    public static void e(Context context, int i) {
        if (XO != null) {
            XO.e(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (XO != null) {
            XO.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (XO != null) {
            XO.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (XO != null) {
            XO.b(context, i, z);
        }
    }

    public static Class<?> tn() {
        if (XO == null) {
            return null;
        }
        return XO.tn();
    }

    public static String to() {
        if (XO == null) {
            return null;
        }
        return XO.to();
    }

    public static void a(a aVar) {
        XO = aVar;
    }

    public static int getCurrentTabType() {
        if (XO == null) {
            return -1;
        }
        return XO.getCurrentTabType();
    }
}
