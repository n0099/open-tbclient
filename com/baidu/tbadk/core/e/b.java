package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a dwS = null;

    public static void q(Context context, int i) {
        if (dwS != null) {
            dwS.q(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (dwS != null) {
            dwS.b(context, i, z);
        }
    }

    public static void dn(Context context) {
        if (dwS != null) {
            dwS.dn(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (dwS != null) {
            dwS.c(context, i, z);
        }
    }

    public static Class<?> aNK() {
        if (dwS == null) {
            return null;
        }
        return dwS.aNK();
    }

    public static String aNL() {
        if (dwS == null) {
            return null;
        }
        return dwS.aNL();
    }

    public static void a(a aVar) {
        dwS = aVar;
    }

    public static int getCurrentTabType() {
        if (dwS == null) {
            return -1;
        }
        return dwS.getCurrentTabType();
    }
}
