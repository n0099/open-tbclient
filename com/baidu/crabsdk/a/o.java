package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n Zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Zn = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Zn.n();
        if (this.Zn.Zk.get()) {
            Handler qI = j.qI();
            runnable = this.Zn.Zm;
            qI.postDelayed(runnable, this.Zn.Zl);
        }
    }
}
