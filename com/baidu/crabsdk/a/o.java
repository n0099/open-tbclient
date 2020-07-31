package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class o implements Runnable {
    final /* synthetic */ n alS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.alS = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.alS.o();
        if (this.alS.alP.get()) {
            Handler te = j.te();
            runnable = this.alS.alR;
            te.postDelayed(runnable, this.alS.alQ);
        }
    }
}
