package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class o implements Runnable {
    final /* synthetic */ n aoj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aoj = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aoj.o();
        if (this.aoj.aog.get()) {
            Handler vj = j.vj();
            runnable = this.aoj.aoi;
            vj.postDelayed(runnable, this.aoj.aoh);
        }
    }
}
