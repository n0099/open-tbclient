package com.baidu.android.systemmonitor.freqstatistic;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
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
            handler = this.a.t;
            runnable = this.a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = c.i;
        if (!z) {
            c cVar = this.a;
            str = this.a.c;
            j = this.a.g;
            cVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.a.g = SystemClock.elapsedRealtime();
        this.a.c = null;
    }
}
