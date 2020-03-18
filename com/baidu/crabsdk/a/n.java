package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long Rs;
    AtomicBoolean Rr = new AtomicBoolean(false);
    private Runnable Rt = new o(this);

    public n(long j) {
        this.Rs = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.Rr.get()) {
            return;
        }
        this.Rr.set(true);
        j.od().removeCallbacks(this.Rt);
        j.od().postDelayed(this.Rt, a.i());
    }

    public final void stop() {
        if (this.Rr.get()) {
            this.Rr.set(false);
            j.od().removeCallbacks(this.Rt);
        }
    }
}
