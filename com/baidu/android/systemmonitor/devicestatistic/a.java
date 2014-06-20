package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        Context context15;
        Context context16;
        Process.setThreadPriority(10);
        context = this.a.c;
        long i = com.baidu.android.systemmonitor.util.e.i(context);
        com.baidu.android.systemmonitor.devicestatistic.a.d dVar = new com.baidu.android.systemmonitor.devicestatistic.a.d(System.currentTimeMillis());
        context2 = this.a.c;
        if (com.baidu.android.systemmonitor.util.b.q(context2) == 1) {
            context16 = this.a.c;
            dVar.a = com.baidu.android.systemmonitor.util.b.k(context16);
        }
        context3 = this.a.c;
        dVar.b = com.baidu.android.systemmonitor.util.b.l(context3);
        context4 = this.a.c;
        if (com.baidu.android.systemmonitor.util.b.s(context4) == 1) {
            g gVar = this.a;
            context15 = this.a.c;
            gVar.a(context15, i, dVar);
        }
        context5 = this.a.c;
        if (com.baidu.android.systemmonitor.util.b.r(context5) == 1) {
            g gVar2 = this.a;
            context14 = this.a.c;
            gVar2.b(context14, i, dVar);
        }
        dVar.g = com.baidu.android.systemmonitor.util.b.c() + "@" + com.baidu.android.systemmonitor.util.b.b();
        dVar.h = com.baidu.android.systemmonitor.util.b.e() + "@" + com.baidu.android.systemmonitor.util.b.f();
        context6 = this.a.c;
        dVar.i = com.baidu.android.systemmonitor.util.b.f(context6);
        context7 = this.a.c;
        dVar.j = com.baidu.android.systemmonitor.util.b.g(context7);
        context8 = this.a.c;
        dVar.k = com.baidu.android.systemmonitor.util.b.i(context8);
        context9 = this.a.c;
        dVar.l = com.baidu.android.systemmonitor.util.b.h(context9);
        context10 = this.a.c;
        dVar.m = com.baidu.android.systemmonitor.util.b.j(context10);
        this.a.a(dVar);
        context11 = this.a.c;
        com.baidu.android.systemmonitor.util.e.b(context11, System.currentTimeMillis());
        g gVar3 = this.a;
        context12 = this.a.c;
        gVar3.b(context12);
        g gVar4 = this.a;
        context13 = this.a.c;
        gVar4.a(context13, SystemClock.elapsedRealtime());
    }
}
