package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n apd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.apd = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.apd.o();
        if (this.apd.apa.get()) {
            Handler uX = j.uX();
            runnable = this.apd.apc;
            uX.postDelayed(runnable, this.apd.apb);
        }
    }
}
