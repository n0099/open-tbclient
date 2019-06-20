package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n Zm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Zm = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Zm.n();
        if (this.Zm.Zj.get()) {
            Handler qI = j.qI();
            runnable = this.Zm.Zl;
            qI.postDelayed(runnable, this.Zm.Zk);
        }
    }
}
