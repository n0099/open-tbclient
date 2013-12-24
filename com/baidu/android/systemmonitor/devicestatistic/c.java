package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.a = dVar;
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
        long i = com.baidu.android.systemmonitor.c.b.i(context);
        com.baidu.android.systemmonitor.devicestatistic.a.a aVar = new com.baidu.android.systemmonitor.devicestatistic.a.a(System.currentTimeMillis());
        context2 = this.a.c;
        if (com.baidu.android.systemmonitor.c.d.q(context2) == 1) {
            context16 = this.a.c;
            aVar.a = com.baidu.android.systemmonitor.c.d.k(context16);
        }
        context3 = this.a.c;
        aVar.b = com.baidu.android.systemmonitor.c.d.l(context3);
        context4 = this.a.c;
        if (com.baidu.android.systemmonitor.c.d.s(context4) == 1) {
            d dVar = this.a;
            context15 = this.a.c;
            dVar.a(context15, i, aVar);
        }
        context5 = this.a.c;
        if (com.baidu.android.systemmonitor.c.d.r(context5) == 1) {
            d dVar2 = this.a;
            context14 = this.a.c;
            dVar2.b(context14, i, aVar);
        }
        aVar.g = com.baidu.android.systemmonitor.c.d.c() + "@" + com.baidu.android.systemmonitor.c.d.b();
        aVar.h = com.baidu.android.systemmonitor.c.d.e() + "@" + com.baidu.android.systemmonitor.c.d.f();
        context6 = this.a.c;
        aVar.i = com.baidu.android.systemmonitor.c.d.f(context6);
        context7 = this.a.c;
        aVar.j = com.baidu.android.systemmonitor.c.d.g(context7);
        context8 = this.a.c;
        aVar.k = com.baidu.android.systemmonitor.c.d.i(context8);
        context9 = this.a.c;
        aVar.l = com.baidu.android.systemmonitor.c.d.h(context9);
        context10 = this.a.c;
        aVar.m = com.baidu.android.systemmonitor.c.d.j(context10);
        this.a.a(aVar);
        context11 = this.a.c;
        com.baidu.android.systemmonitor.c.b.b(context11, System.currentTimeMillis());
        d dVar3 = this.a;
        context12 = this.a.c;
        dVar3.b(context12);
        d dVar4 = this.a;
        context13 = this.a.c;
        dVar4.a(context13, SystemClock.elapsedRealtime());
    }
}
