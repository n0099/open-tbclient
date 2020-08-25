package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ n amV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.amV = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.amV.o();
        if (this.amV.amS.get()) {
            Handler uM = j.uM();
            runnable = this.amV.amU;
            uM.postDelayed(runnable, this.amV.amT);
        }
    }
}
