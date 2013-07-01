package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f401a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        boolean z;
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        i = c.n;
        if (i == 2) {
            handler = this.f401a.t;
            runnable = this.f401a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = c.i;
        if (!z) {
            c cVar = this.f401a;
            str = this.f401a.c;
            j = this.f401a.g;
            cVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.f401a.g = SystemClock.elapsedRealtime();
        this.f401a.c = null;
    }
}
