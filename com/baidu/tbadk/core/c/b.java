package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a YB = null;

    public static void e(Context context, int i) {
        if (YB != null) {
            YB.e(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (YB != null) {
            YB.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (YB != null) {
            YB.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (YB != null) {
            YB.b(context, i, z);
        }
    }

    public static Class<?> tS() {
        if (YB == null) {
            return null;
        }
        return YB.tS();
    }

    public static String tT() {
        if (YB == null) {
            return null;
        }
        return YB.tT();
    }

    public static void a(a aVar) {
        YB = aVar;
    }

    public static int getCurrentTabType() {
        if (YB == null) {
            return -1;
        }
        return YB.getCurrentTabType();
    }
}
