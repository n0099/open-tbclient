package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public abstract class n {
    long aoM;
    AtomicBoolean aoL = new AtomicBoolean(false);
    private Runnable aoN = new o(this);

    public n(long j) {
        this.aoM = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aoL.get()) {
            return;
        }
        this.aoL.set(true);
        j.uo().removeCallbacks(this.aoN);
        j.uo().postDelayed(this.aoN, a.i());
    }

    public final void stop() {
        if (this.aoL.get()) {
            this.aoL.set(false);
            j.uo().removeCallbacks(this.aoN);
        }
    }
}
