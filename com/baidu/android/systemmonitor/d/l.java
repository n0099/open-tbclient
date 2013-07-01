package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends a.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.f406a = cVar;
    }

    @Override // a.a.b
    public void a(int i, int i2) {
    }

    @Override // a.a.b
    public void a(int i, int i2, int i3) {
    }

    @Override // a.a.b
    public void a(int i, int i2, boolean z) {
        boolean z2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z2 = c.h;
        if (!z2) {
            boolean unused = c.h = true;
            this.f406a.g = SystemClock.elapsedRealtime();
        }
        handler = this.f406a.t;
        runnable = this.f406a.k;
        handler.removeCallbacks(runnable);
        handler2 = this.f406a.t;
        runnable2 = this.f406a.k;
        handler2.postDelayed(runnable2, 500L);
    }
}
