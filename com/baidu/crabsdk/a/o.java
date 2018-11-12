package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ n XJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.XJ = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.XJ.n();
        if (this.XJ.XG.get()) {
            Handler rk = j.rk();
            runnable = this.XJ.XI;
            rk.postDelayed(runnable, this.XJ.XH);
        }
    }
}
