package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class n {
    long aoC;
    AtomicBoolean aoB = new AtomicBoolean(false);
    private Runnable aoD = new o(this);

    public n(long j) {
        this.aoC = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aoB.get()) {
            return;
        }
        this.aoB.set(true);
        j.ul().removeCallbacks(this.aoD);
        j.ul().postDelayed(this.aoD, a.i());
    }

    public final void stop() {
        if (this.aoB.get()) {
            this.aoB.set(false);
            j.ul().removeCallbacks(this.aoD);
        }
    }
}
