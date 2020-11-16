package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes7.dex */
public final class c {
    private static Thread aoy = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.dC("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.vy()) {
            com.baidu.crabsdk.c.a.dC("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                aoy = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread vl() {
        return aoy;
    }
}
