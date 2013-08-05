package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f686a = dVar;
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
        context = this.f686a.c;
        long i = com.baidu.android.systemmonitor.a.b.i(context);
        com.baidu.android.systemmonitor.devicestatistic.a.a aVar = new com.baidu.android.systemmonitor.devicestatistic.a.a(System.currentTimeMillis());
        context2 = this.f686a.c;
        if (com.baidu.android.systemmonitor.a.d.q(context2) == 1) {
            context16 = this.f686a.c;
            aVar.f680a = com.baidu.android.systemmonitor.a.d.k(context16);
        }
        context3 = this.f686a.c;
        aVar.b = com.baidu.android.systemmonitor.a.d.l(context3);
        context4 = this.f686a.c;
        if (com.baidu.android.systemmonitor.a.d.s(context4) == 1) {
            d dVar = this.f686a;
            context15 = this.f686a.c;
            dVar.a(context15, i, aVar);
        }
        context5 = this.f686a.c;
        if (com.baidu.android.systemmonitor.a.d.r(context5) == 1) {
            d dVar2 = this.f686a;
            context14 = this.f686a.c;
            dVar2.b(context14, i, aVar);
        }
        aVar.g = com.baidu.android.systemmonitor.a.d.c() + "@" + com.baidu.android.systemmonitor.a.d.b();
        aVar.h = com.baidu.android.systemmonitor.a.d.e() + "@" + com.baidu.android.systemmonitor.a.d.f();
        context6 = this.f686a.c;
        aVar.i = com.baidu.android.systemmonitor.a.d.f(context6);
        context7 = this.f686a.c;
        aVar.j = com.baidu.android.systemmonitor.a.d.g(context7);
        context8 = this.f686a.c;
        aVar.k = com.baidu.android.systemmonitor.a.d.i(context8);
        context9 = this.f686a.c;
        aVar.l = com.baidu.android.systemmonitor.a.d.h(context9);
        context10 = this.f686a.c;
        aVar.m = com.baidu.android.systemmonitor.a.d.j(context10);
        this.f686a.a(aVar);
        context11 = this.f686a.c;
        com.baidu.android.systemmonitor.a.b.b(context11, System.currentTimeMillis());
        d dVar3 = this.f686a;
        context12 = this.f686a.c;
        dVar3.b(context12);
        d dVar4 = this.f686a;
        context13 = this.f686a.c;
        dVar4.a(context13, SystemClock.elapsedRealtime());
    }
}
