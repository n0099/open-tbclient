package com.baidu.android.systemmonitor.b;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends a.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.f675a = fVar;
    }

    @Override // a.a.c
    public void a(int i, int i2) {
    }

    @Override // a.a.c
    public void a(int i, int i2, int i3) {
    }

    @Override // a.a.c
    public void a(int i, int i2, boolean z) {
        boolean z2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z2 = f.h;
        if (!z2) {
            boolean unused = f.h = true;
            this.f675a.g = SystemClock.elapsedRealtime();
        }
        handler = this.f675a.t;
        runnable = this.f675a.k;
        handler.removeCallbacks(runnable);
        handler2 = this.f675a.t;
        runnable2 = this.f675a.k;
        handler2.postDelayed(runnable2, 500L);
    }
}
