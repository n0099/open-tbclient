package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class n {
    long amT;
    AtomicBoolean amS = new AtomicBoolean(false);
    private Runnable amU = new o(this);

    public n(long j) {
        this.amT = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.amS.get()) {
            return;
        }
        this.amS.set(true);
        j.uM().removeCallbacks(this.amU);
        j.uM().postDelayed(this.amU, a.i());
    }

    public final void stop() {
        if (this.amS.get()) {
            this.amS.set(false);
            j.uM().removeCallbacks(this.amU);
        }
    }
}
