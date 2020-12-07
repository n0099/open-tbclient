package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eQL = null;
    public static int eQM = 0;

    public static void A(Context context, int i) {
        if (eQL != null) {
            eQL.A(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eQL != null) {
            eQL.c(context, i, z);
        }
    }

    public static void eD(Context context) {
        if (eQL != null) {
            eQL.eD(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eQL != null) {
            eQL.d(context, i, z);
        }
    }

    public static Class<?> bsE() {
        if (eQL == null) {
            return null;
        }
        return eQL.bsE();
    }

    public static String bsF() {
        if (eQL == null) {
            return null;
        }
        return eQL.bsF();
    }

    public static void a(a aVar) {
        eQL = aVar;
    }

    public static int getCurrentTabType() {
        if (eQL == null) {
            return -1;
        }
        return eQL.getCurrentTabType();
    }
}
