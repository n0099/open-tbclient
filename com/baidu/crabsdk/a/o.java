package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ n amX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.amX = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.amX.o();
        if (this.amX.amU.get()) {
            Handler uM = j.uM();
            runnable = this.amX.amW;
            uM.postDelayed(runnable, this.amX.amV);
        }
    }
}
