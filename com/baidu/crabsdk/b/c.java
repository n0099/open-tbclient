package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c {
    private static Thread PT = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.cb("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.nL()) {
            com.baidu.crabsdk.c.a.cb("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                PT = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread nx() {
        return PT;
    }
}
