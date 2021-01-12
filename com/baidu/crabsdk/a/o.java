package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class o implements Runnable {
    final /* synthetic */ n aoO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aoO = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aoO.o();
        if (this.aoO.aoL.get()) {
            Handler uo = j.uo();
            runnable = this.aoO.aoN;
            uo.postDelayed(runnable, this.aoO.aoM);
        }
    }
}
