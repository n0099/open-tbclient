package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes8.dex */
public final class c {
    private static Thread aka = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.de("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.sV()) {
            com.baidu.crabsdk.c.a.de("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                aka = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread sB() {
        return aka;
    }
}
