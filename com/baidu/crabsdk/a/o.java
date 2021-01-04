package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ n apD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.apD = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.apD.o();
        if (this.apD.apA.get()) {
            Handler uv = j.uv();
            runnable = this.apD.apC;
            uv.postDelayed(runnable, this.apD.apB);
        }
    }
}
