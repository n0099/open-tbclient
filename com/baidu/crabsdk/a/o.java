package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ n PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.PH = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.PH.n();
        if (this.PH.PE.get()) {
            Handler nu = j.nu();
            runnable = this.PH.PG;
            nu.postDelayed(runnable, this.PH.PF);
        }
    }
}
