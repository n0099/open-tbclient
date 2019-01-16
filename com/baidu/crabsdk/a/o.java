package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o implements Runnable {
    final /* synthetic */ n XS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.XS = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.XS.n();
        if (this.XS.XP.get()) {
            Handler rn = j.rn();
            runnable = this.XS.XR;
            rn.postDelayed(runnable, this.XS.XQ);
        }
    }
}
