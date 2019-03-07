package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n abu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.abu = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.abu.n();
        if (this.abu.abq.get()) {
            Handler rN = j.rN();
            runnable = this.abu.abt;
            rN.postDelayed(runnable, this.abu.abr);
        }
    }
}
