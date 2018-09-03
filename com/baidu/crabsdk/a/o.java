package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {
    final /* synthetic */ n Sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Sq = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Sq.n();
        if (this.Sq.Sn.get()) {
            Handler oW = j.oW();
            runnable = this.Sq.Sp;
            oW.postDelayed(runnable, this.Sq.So);
        }
    }
}
