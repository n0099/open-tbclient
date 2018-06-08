package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {
    final /* synthetic */ n Sr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Sr = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Sr.n();
        if (this.Sr.So.get()) {
            Handler oV = j.oV();
            runnable = this.Sr.Sq;
            oV.postDelayed(runnable, this.Sr.Sp);
        }
    }
}
