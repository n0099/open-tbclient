package com.baidu.android.systemmonitor.d;

import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends a.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f400a = cVar;
    }

    @Override // a.a.c
    public void a(int i) {
        boolean z;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z = c.h;
        if (!z) {
            boolean unused = c.h = true;
            this.f400a.g = SystemClock.elapsedRealtime();
        }
        handler = this.f400a.t;
        runnable = this.f400a.k;
        handler.removeCallbacks(runnable);
        handler2 = this.f400a.t;
        runnable2 = this.f400a.k;
        handler2.postDelayed(runnable2, 500L);
    }

    @Override // a.a.c
    public void a(String str) {
    }
}
