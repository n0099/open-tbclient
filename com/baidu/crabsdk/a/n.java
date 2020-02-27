package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long Rq;
    AtomicBoolean Rp = new AtomicBoolean(false);
    private Runnable Rr = new o(this);

    public n(long j) {
        this.Rq = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Rp.get()) {
            return;
        }
        this.Rp.set(true);
        j.od().removeCallbacks(this.Rr);
        j.od().postDelayed(this.Rr, a.h());
    }

    public final void stop() {
        if (this.Rp.get()) {
            this.Rp.set(false);
            j.od().removeCallbacks(this.Rr);
        }
    }
}
