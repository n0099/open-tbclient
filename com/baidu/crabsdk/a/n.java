package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long alV;
    AtomicBoolean alU = new AtomicBoolean(false);
    private Runnable alW = new o(this);

    public n(long j) {
        this.alV = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.alU.get()) {
            return;
        }
        this.alU.set(true);
        j.tc().removeCallbacks(this.alW);
        j.tc().postDelayed(this.alW, a.i());
    }

    public final void stop() {
        if (this.alU.get()) {
            this.alU.set(false);
            j.tc().removeCallbacks(this.alW);
        }
    }
}
