package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cXE = null;

    public static void v(Context context, int i) {
        if (cXE != null) {
            cXE.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cXE != null) {
            cXE.b(context, i, z);
        }
    }

    public static void dL(Context context) {
        if (cXE != null) {
            cXE.dL(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cXE != null) {
            cXE.c(context, i, z);
        }
    }

    public static Class<?> aFy() {
        if (cXE == null) {
            return null;
        }
        return cXE.aFy();
    }

    public static String aFz() {
        if (cXE == null) {
            return null;
        }
        return cXE.aFz();
    }

    public static void a(a aVar) {
        cXE = aVar;
    }

    public static int getCurrentTabType() {
        if (cXE == null) {
            return -1;
        }
        return cXE.getCurrentTabType();
    }
}
