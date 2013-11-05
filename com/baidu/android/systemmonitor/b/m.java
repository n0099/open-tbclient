package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.f767a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = f.h;
        if (!z) {
            boolean unused = f.h = true;
            this.f767a.g = SystemClock.elapsedRealtime();
        }
        this.f767a.n();
        handler = this.f767a.t;
        runnable = this.f767a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
