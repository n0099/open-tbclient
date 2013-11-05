package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f800a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f800a = dVar;
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
        context = this.f800a.c;
        long i = com.baidu.android.systemmonitor.d.b.i(context);
        com.baidu.android.systemmonitor.devicestatistic.a.f fVar = new com.baidu.android.systemmonitor.devicestatistic.a.f(System.currentTimeMillis());
        context2 = this.f800a.c;
        if (com.baidu.android.systemmonitor.d.c.q(context2) == 1) {
            context16 = this.f800a.c;
            fVar.f796a = com.baidu.android.systemmonitor.d.c.k(context16);
        }
        context3 = this.f800a.c;
        fVar.b = com.baidu.android.systemmonitor.d.c.l(context3);
        context4 = this.f800a.c;
        if (com.baidu.android.systemmonitor.d.c.s(context4) == 1) {
            d dVar = this.f800a;
            context15 = this.f800a.c;
            dVar.a(context15, i, fVar);
        }
        context5 = this.f800a.c;
        if (com.baidu.android.systemmonitor.d.c.r(context5) == 1) {
            d dVar2 = this.f800a;
            context14 = this.f800a.c;
            dVar2.b(context14, i, fVar);
        }
        fVar.i = com.baidu.android.systemmonitor.d.c.c() + "@" + com.baidu.android.systemmonitor.d.c.b();
        fVar.j = com.baidu.android.systemmonitor.d.c.e() + "@" + com.baidu.android.systemmonitor.d.c.f();
        context6 = this.f800a.c;
        fVar.k = com.baidu.android.systemmonitor.d.c.f(context6);
        context7 = this.f800a.c;
        fVar.l = com.baidu.android.systemmonitor.d.c.g(context7);
        context8 = this.f800a.c;
        fVar.m = com.baidu.android.systemmonitor.d.c.i(context8);
        context9 = this.f800a.c;
        fVar.n = com.baidu.android.systemmonitor.d.c.h(context9);
        context10 = this.f800a.c;
        fVar.o = com.baidu.android.systemmonitor.d.c.j(context10);
        this.f800a.a(fVar);
        context11 = this.f800a.c;
        com.baidu.android.systemmonitor.d.b.b(context11, System.currentTimeMillis());
        d dVar3 = this.f800a;
        context12 = this.f800a.c;
        dVar3.b(context12);
        d dVar4 = this.f800a;
        context13 = this.f800a.c;
        dVar4.a(context13, SystemClock.elapsedRealtime());
    }
}
