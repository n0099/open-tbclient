package com.baidu.android.systemmonitor.devicestatistic;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        this.a.c();
        handler = this.a.c;
        runnable = this.a.e;
        handler.postDelayed(runnable, 60000L);
        this.a.g();
    }
}
