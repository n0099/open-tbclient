package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.f676a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = f.h;
        if (!z) {
            boolean unused = f.h = true;
            this.f676a.g = SystemClock.elapsedRealtime();
        }
        this.f676a.n();
        handler = this.f676a.t;
        runnable = this.f676a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
