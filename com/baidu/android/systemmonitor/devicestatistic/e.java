package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f418a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f418a.c();
        handler = this.f418a.c;
        runnable = this.f418a.e;
        handler.postDelayed(runnable, 60000L);
        this.f418a.g();
    }
}
