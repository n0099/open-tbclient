package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n ZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.ZH = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.ZH.n();
        if (this.ZH.ZE.get()) {
            Handler rf = j.rf();
            runnable = this.ZH.ZG;
            rf.postDelayed(runnable, this.ZH.ZF);
        }
    }
}
