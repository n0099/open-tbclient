package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ n PM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.PM = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.PM.n();
        if (this.PM.PI.get()) {
            Handler nv = j.nv();
            runnable = this.PM.PK;
            nv.postDelayed(runnable, this.PM.PJ);
        }
    }
}
