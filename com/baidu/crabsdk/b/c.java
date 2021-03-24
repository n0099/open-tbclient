package com.baidu.crabsdk.b;

import android.content.Context;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Thread f4674a;

    public static void a(Context context, int i) {
        com.baidu.crabsdk.c.a.b("===Anr init!===");
        if (com.baidu.crabsdk.sender.h.h()) {
            com.baidu.crabsdk.c.a.b("===Anr watchThread start!===");
            try {
                com.baidu.crabsdk.sender.d dVar = new com.baidu.crabsdk.sender.d(context, i, (byte) 0);
                f4674a = dVar;
                dVar.start();
            } catch (Exception unused) {
                com.baidu.crabsdk.c.a.d("Anr watchThread start failed !!");
            }
        }
    }

    public static Thread b() {
        return f4674a;
    }
}
