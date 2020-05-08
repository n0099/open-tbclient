package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long ajU;
    AtomicBoolean ajT = new AtomicBoolean(false);
    private Runnable ajV = new o(this);

    public n(long j) {
        this.ajU = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.ajT.get()) {
            return;
        }
        this.ajT.set(true);
        j.sx().removeCallbacks(this.ajV);
        j.sx().postDelayed(this.ajV, a.i());
    }

    public final void stop() {
        if (this.ajT.get()) {
            this.ajT.set(false);
            j.sx().removeCallbacks(this.ajV);
        }
    }
}
