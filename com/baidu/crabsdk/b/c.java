package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private static Thread aos = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.dA("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.vz()) {
            com.baidu.crabsdk.c.a.dA("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                aos = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread vm() {
        return aos;
    }
}
