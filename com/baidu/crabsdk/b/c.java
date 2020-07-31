package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes12.dex */
public final class c {
    private static Thread amc = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.dh("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.tw()) {
            com.baidu.crabsdk.c.a.dh("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                amc = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread th() {
        return amc;
    }
}
