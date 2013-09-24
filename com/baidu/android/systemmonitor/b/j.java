package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.f685a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        boolean z;
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        i = f.n;
        if (i == 2) {
            handler = this.f685a.t;
            runnable = this.f685a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = f.i;
        if (!z) {
            f fVar = this.f685a;
            str = this.f685a.c;
            j = this.f685a.g;
            fVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.f685a.g = SystemClock.elapsedRealtime();
        this.f685a.c = null;
    }
}
