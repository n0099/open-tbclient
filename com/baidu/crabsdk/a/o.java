package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n anz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.anz = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.anz.o();
        if (this.anz.anw.get()) {
            Handler va = j.va();
            runnable = this.anz.any;
            va.postDelayed(runnable, this.anz.anx);
        }
    }
}
