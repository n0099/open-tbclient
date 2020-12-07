package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long apb;
    AtomicBoolean apa = new AtomicBoolean(false);
    private Runnable apc = new o(this);

    public n(long j) {
        this.apb = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.apa.get()) {
            return;
        }
        this.apa.set(true);
        j.uX().removeCallbacks(this.apc);
        j.uX().postDelayed(this.apc, a.i());
    }

    public final void stop() {
        if (this.apa.get()) {
            this.apa.set(false);
            j.uX().removeCallbacks(this.apc);
        }
    }
}
