package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.f688a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Handler handler;
        Runnable runnable;
        z = f.h;
        if (!z) {
            boolean unused = f.h = true;
            this.f688a.g = SystemClock.elapsedRealtime();
        }
        this.f688a.n();
        handler = this.f688a.t;
        runnable = this.f688a.m;
        handler.postDelayed(runnable, 30000L);
    }
}
