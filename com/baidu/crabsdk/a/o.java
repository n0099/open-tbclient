package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n abv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.abv = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.abv.n();
        if (this.abv.abr.get()) {
            Handler rN = j.rN();
            runnable = this.abv.abu;
            rN.postDelayed(runnable, this.abv.abt);
        }
    }
}
