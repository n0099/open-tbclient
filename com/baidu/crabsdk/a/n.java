package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class n {
    long aqc;
    AtomicBoolean aqb = new AtomicBoolean(false);
    private Runnable aqd = new o(this);

    public n(long j) {
        this.aqc = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aqb.get()) {
            return;
        }
        this.aqb.set(true);
        j.ul().removeCallbacks(this.aqd);
        j.ul().postDelayed(this.aqd, a.i());
    }

    public final void stop() {
        if (this.aqb.get()) {
            this.aqb.set(false);
            j.ul().removeCallbacks(this.aqd);
        }
    }
}
