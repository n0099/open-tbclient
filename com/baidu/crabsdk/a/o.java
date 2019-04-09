package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.abx = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.abx.n();
        if (this.abx.abu.get()) {
            Handler rN = j.rN();
            runnable = this.abx.abw;
            rN.postDelayed(runnable, this.abx.abv);
        }
    }
}
