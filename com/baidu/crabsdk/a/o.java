package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n abw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.abw = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.abw.n();
        if (this.abw.abt.get()) {
            Handler rN = j.rN();
            runnable = this.abw.abv;
            rN.postDelayed(runnable, this.abw.abu);
        }
    }
}
