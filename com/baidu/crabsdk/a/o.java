package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ n aoE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aoE = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aoE.o();
        if (this.aoE.aoB.get()) {
            Handler ul = j.ul();
            runnable = this.aoE.aoD;
            ul.postDelayed(runnable, this.aoE.aoC);
        }
    }
}
