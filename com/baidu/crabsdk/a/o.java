package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {
    final /* synthetic */ n St;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.St = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.St.n();
        if (this.St.Sq.get()) {
            Handler oV = j.oV();
            runnable = this.St.Ss;
            oV.postDelayed(runnable, this.St.Sr);
        }
    }
}
