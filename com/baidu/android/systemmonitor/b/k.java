package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends a.a.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.f674a = fVar;
    }

    @Override // a.a.a
    public void a(int i) {
        boolean z;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z = f.h;
        if (!z) {
            boolean unused = f.h = true;
            this.f674a.g = SystemClock.elapsedRealtime();
        }
        handler = this.f674a.t;
        runnable = this.f674a.k;
        handler.removeCallbacks(runnable);
        handler2 = this.f674a.t;
        runnable2 = this.f674a.k;
        handler2.postDelayed(runnable2, 500L);
    }

    @Override // a.a.a
    public void a(String str) {
    }
}
