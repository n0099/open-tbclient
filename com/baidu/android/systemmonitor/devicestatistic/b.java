package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(i iVar) {
        this.f415a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.f415a.e();
        handler = this.f415a.e;
        runnable = this.f415a.i;
        handler.postDelayed(runnable, 60000L);
    }
}
