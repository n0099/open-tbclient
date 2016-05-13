package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ud = null;

    public static void d(Context context, int i) {
        if (Ud != null) {
            Ud.d(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Ud != null) {
            Ud.a(context, i, z);
        }
    }

    public static void M(Context context) {
        if (Ud != null) {
            Ud.M(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Ud != null) {
            Ud.b(context, i, z);
        }
    }

    public static Class<?> sK() {
        if (Ud == null) {
            return null;
        }
        return Ud.sK();
    }

    public static String sL() {
        if (Ud == null) {
            return null;
        }
        return Ud.sL();
    }

    public static void a(a aVar) {
        Ud = aVar;
    }

    public static int getCurrentTabType() {
        if (Ud == null) {
            return -1;
        }
        return Ud.getCurrentTabType();
    }
}
