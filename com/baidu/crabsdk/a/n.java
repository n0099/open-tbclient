package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public abstract class n {
    long alQ;
    AtomicBoolean alP = new AtomicBoolean(false);
    private Runnable alR = new o(this);

    public n(long j) {
        this.alQ = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.alP.get()) {
            return;
        }
        this.alP.set(true);
        j.te().removeCallbacks(this.alR);
        j.te().postDelayed(this.alR, a.i());
    }

    public final void stop() {
        if (this.alP.get()) {
            this.alP.set(false);
            j.te().removeCallbacks(this.alR);
        }
    }
}
