package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private static Thread ane = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.ds("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.vc()) {
            com.baidu.crabsdk.c.a.ds("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                ane = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread uP() {
        return ane;
    }
}
