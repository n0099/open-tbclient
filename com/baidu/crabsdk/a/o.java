package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class o implements Runnable {
    final /* synthetic */ n aqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aqe = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aqe.o();
        if (this.aqe.aqb.get()) {
            Handler ul = j.ul();
            runnable = this.aqe.aqd;
            ul.postDelayed(runnable, this.aqe.aqc);
        }
    }
}
