package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes3.dex */
public final class c {
    private static Thread abE = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.cv("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.Y()) {
            com.baidu.crabsdk.c.a.cv("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                abE = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread rR() {
        return abE;
    }
}
