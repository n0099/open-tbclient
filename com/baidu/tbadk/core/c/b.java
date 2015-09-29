package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XJ = null;

    public static void e(Context context, int i) {
        if (XJ != null) {
            XJ.e(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (XJ != null) {
            XJ.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (XJ != null) {
            XJ.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (XJ != null) {
            XJ.b(context, i, z);
        }
    }

    public static Class<?> tn() {
        if (XJ == null) {
            return null;
        }
        return XJ.tn();
    }

    public static String to() {
        if (XJ == null) {
            return null;
        }
        return XJ.to();
    }

    public static void a(a aVar) {
        XJ = aVar;
    }

    public static int getCurrentTabType() {
        if (XJ == null) {
            return -1;
        }
        return XJ.getCurrentTabType();
    }
}
