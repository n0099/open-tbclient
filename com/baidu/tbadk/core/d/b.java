package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a YN = null;

    public static void d(Context context, int i) {
        if (YN != null) {
            YN.d(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (YN != null) {
            YN.a(context, i, z);
        }
    }

    public static void N(Context context) {
        if (YN != null) {
            YN.N(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (YN != null) {
            YN.b(context, i, z);
        }
    }

    public static Class<?> vd() {
        if (YN == null) {
            return null;
        }
        return YN.vd();
    }

    public static String ve() {
        if (YN == null) {
            return null;
        }
        return YN.ve();
    }

    public static void a(a aVar) {
        YN = aVar;
    }

    public static int getCurrentTabType() {
        if (YN == null) {
            return -1;
        }
        return YN.getCurrentTabType();
    }
}
