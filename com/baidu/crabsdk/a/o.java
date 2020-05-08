package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n ajW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.ajW = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.ajW.o();
        if (this.ajW.ajT.get()) {
            Handler sx = j.sx();
            runnable = this.ajW.ajV;
            sx.postDelayed(runnable, this.ajW.ajU);
        }
    }
}
