package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class o implements Runnable {
    final /* synthetic */ n aoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aoi = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.aoi.o();
        if (this.aoi.aof.get()) {
            Handler vj = j.vj();
            runnable = this.aoi.aoh;
            vj.postDelayed(runnable, this.aoi.aog);
        }
    }
}
