package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n akB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.akB = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.akB.o();
        if (this.akB.aky.get()) {
            Handler sH = j.sH();
            runnable = this.akB.akA;
            sH.postDelayed(runnable, this.akB.akz);
        }
    }
}
