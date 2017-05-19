package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ack = null;

    public static void i(Context context, int i) {
        if (ack != null) {
            ack.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (ack != null) {
            ack.b(context, i, z);
        }
    }

    public static void ay(Context context) {
        if (ack != null) {
            ack.ay(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ack != null) {
            ack.c(context, i, z);
        }
    }

    public static Class<?> tQ() {
        if (ack == null) {
            return null;
        }
        return ack.tQ();
    }

    public static String tR() {
        if (ack == null) {
            return null;
        }
        return ack.tR();
    }

    public static void a(a aVar) {
        ack = aVar;
    }

    public static int getCurrentTabType() {
        if (ack == null) {
            return -1;
        }
        return ack.getCurrentTabType();
    }
}
