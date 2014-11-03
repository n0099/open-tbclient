package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a BS = null;

    public static void d(Context context, int i) {
        if (BS != null) {
            BS.d(context, i);
        }
    }

    public static void t(Context context) {
        if (BS != null) {
            BS.t(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (BS != null) {
            BS.a(context, i, z);
        }
    }

    public static Class<?> ld() {
        if (BS == null) {
            return null;
        }
        return BS.ld();
    }

    public static String le() {
        if (BS == null) {
            return null;
        }
        return BS.le();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            BS = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (BS == null) {
            return -1;
        }
        return BS.getCurrentTabType();
    }
}
