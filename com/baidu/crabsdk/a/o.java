package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n alX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.alX = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.alX.o();
        if (this.alX.alU.get()) {
            Handler tc = j.tc();
            runnable = this.alX.alW;
            tc.postDelayed(runnable, this.alX.alV);
        }
    }
}
