package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes14.dex */
public final class c {
    private static Thread aoX = null;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.ds("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.ad()) {
            com.baidu.crabsdk.c.a.ds("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                aoX = dVar;
                dVar.start();
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread ur() {
        return aoX;
    }
}
