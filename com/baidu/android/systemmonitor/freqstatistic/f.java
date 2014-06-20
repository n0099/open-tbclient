package com.baidu.android.systemmonitor.freqstatistic;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        boolean z;
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        i = b.n;
        if (i == 2) {
            handler = this.a.t;
            runnable = this.a.m;
            handler.removeCallbacks(runnable);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = b.i;
        if (!z) {
            b bVar = this.a;
            str = this.a.c;
            j = this.a.g;
            bVar.a(str, (j - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        this.a.g = SystemClock.elapsedRealtime();
        this.a.c = null;
    }
}
