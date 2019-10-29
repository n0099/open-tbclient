package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n JI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.JI = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.JI.n();
        if (this.JI.JF.get()) {
            Handler ml = j.ml();
            runnable = this.JI.JH;
            ml.postDelayed(runnable, this.JI.JG);
        }
    }
}
