package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class o implements Runnable {
    final /* synthetic */ n aop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aop = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aop.o();
        if (this.aop.aom.get()) {
            Handler vi2 = j.vi();
            runnable = this.aop.aoo;
            vi2.postDelayed(runnable, this.aop.aon);
        }
    }
}
