package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {
    final /* synthetic */ n UW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.UW = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.UW.n();
        if (this.UW.UT.get()) {
            Handler qc = j.qc();
            runnable = this.UW.UV;
            qc.postDelayed(runnable, this.UW.UU);
        }
    }
}
