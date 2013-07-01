package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.f405a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = c.h;
        if (!z) {
            boolean unused = c.h = true;
            this.f405a.g = SystemClock.elapsedRealtime();
        }
        this.f405a.n();
        handler = this.f405a.t;
        runnable = this.f405a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
