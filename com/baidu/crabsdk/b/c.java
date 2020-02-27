package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes8.dex */
public final class c {
    private static Thread RC = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.cj("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.ov()) {
            com.baidu.crabsdk.c.a.cj("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                RC = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread oh() {
        return RC;
    }
}
