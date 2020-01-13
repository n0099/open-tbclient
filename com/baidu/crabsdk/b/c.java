package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private static Thread PY = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.cb("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.nM()) {
            com.baidu.crabsdk.c.a.cb("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                PY = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread ny() {
        return PY;
    }
}
