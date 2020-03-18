package com.baidu.crabsdk.a;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class o implements Runnable {
    final /* synthetic */ n Ru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Ru = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.Ru.o();
        if (this.Ru.Rr.get()) {
            Handler od = j.od();
            runnable = this.Ru.Rt;
            od.postDelayed(runnable, this.Ru.Rs);
        }
    }
}
