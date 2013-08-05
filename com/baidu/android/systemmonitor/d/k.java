package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.f675a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = c.h;
        if (!z) {
            boolean unused = c.h = true;
            this.f675a.g = SystemClock.elapsedRealtime();
        }
        this.f675a.n();
        handler = this.f675a.t;
        runnable = this.f675a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
