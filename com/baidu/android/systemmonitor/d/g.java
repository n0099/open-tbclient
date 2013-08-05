package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f671a = cVar;
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
            handler = this.f671a.t;
            runnable = this.f671a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = c.i;
        if (!z) {
            c cVar = this.f671a;
            str = this.f671a.c;
            j = this.f671a.g;
            cVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.f671a.g = SystemClock.elapsedRealtime();
        this.f671a.c = null;
    }
}
