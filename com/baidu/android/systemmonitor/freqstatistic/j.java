package com.baidu.android.systemmonitor.freqstatistic;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = b.h;
        if (!z) {
            boolean unused = b.h = true;
            this.a.g = SystemClock.elapsedRealtime();
        }
        this.a.m();
        handler = this.a.t;
        runnable = this.a.m;
        handler.postDelayed(runnable, 10000L);
    }
}
