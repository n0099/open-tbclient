package com.baidu.android.systemmonitor.freqstatistic;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = c.h;
        if (!z) {
            boolean unused = c.h = true;
            this.a.g = SystemClock.elapsedRealtime();
        }
        this.a.n();
        handler = this.a.t;
        runnable = this.a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
