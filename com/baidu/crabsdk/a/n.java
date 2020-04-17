package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long ajO;
    AtomicBoolean ajN = new AtomicBoolean(false);
    private Runnable ajP = new o(this);

    public n(long j) {
        this.ajO = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.ajN.get()) {
            return;
        }
        this.ajN.set(true);
        j.sy().removeCallbacks(this.ajP);
        j.sy().postDelayed(this.ajP, a.i());
    }

    public final void stop() {
        if (this.ajN.get()) {
            this.ajN.set(false);
            j.sy().removeCallbacks(this.ajP);
        }
    }
}
