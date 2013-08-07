package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.f650a = fVar;
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
            handler = this.f650a.t;
            runnable = this.f650a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = f.i;
        if (!z) {
            f fVar = this.f650a;
            str = this.f650a.c;
            j = this.f650a.g;
            fVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.f650a.g = SystemClock.elapsedRealtime();
        this.f650a.c = null;
    }
}
