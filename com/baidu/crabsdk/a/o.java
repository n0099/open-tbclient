package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n Ji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Ji = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Ji.n();
        if (this.Ji.Jf.get()) {
            Handler ml = j.ml();
            runnable = this.Ji.Jh;
            ml.postDelayed(runnable, this.Ji.Jg);
        }
    }
}
