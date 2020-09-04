package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class n {
    long amV;
    AtomicBoolean amU = new AtomicBoolean(false);
    private Runnable amW = new o(this);

    public n(long j) {
        this.amV = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.amU.get()) {
            return;
        }
        this.amU.set(true);
        j.uM().removeCallbacks(this.amW);
        j.uM().postDelayed(this.amW, a.i());
    }

    public final void stop() {
        if (this.amU.get()) {
            this.amU.set(false);
            j.uM().removeCallbacks(this.amW);
        }
    }
}
