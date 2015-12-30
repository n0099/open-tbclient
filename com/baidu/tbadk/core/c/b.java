package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ze = null;

    public static void e(Context context, int i) {
        if (Ze != null) {
            Ze.e(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Ze != null) {
            Ze.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (Ze != null) {
            Ze.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Ze != null) {
            Ze.b(context, i, z);
        }
    }

    public static Class<?> tC() {
        if (Ze == null) {
            return null;
        }
        return Ze.tC();
    }

    public static String tD() {
        if (Ze == null) {
            return null;
        }
        return Ze.tD();
    }

    public static void a(a aVar) {
        Ze = aVar;
    }

    public static int getCurrentTabType() {
        if (Ze == null) {
            return -1;
        }
        return Ze.getCurrentTabType();
    }
}
