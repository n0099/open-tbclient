package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n Rs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Rs = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Rs.n();
        if (this.Rs.Rp.get()) {
            Handler od = j.od();
            runnable = this.Rs.Rr;
            od.postDelayed(runnable, this.Rs.Rq);
        }
    }
}
