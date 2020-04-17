package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n ajQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.ajQ = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.ajQ.o();
        if (this.ajQ.ajN.get()) {
            Handler sy = j.sy();
            runnable = this.ajQ.ajP;
            sy.postDelayed(runnable, this.ajQ.ajO);
        }
    }
}
