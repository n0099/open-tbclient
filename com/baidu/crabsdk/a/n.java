package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long anx;
    AtomicBoolean anw = new AtomicBoolean(false);
    private Runnable any = new o(this);

    public n(long j) {
        this.anx = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.anw.get()) {
            return;
        }
        this.anw.set(true);
        j.va().removeCallbacks(this.any);
        j.va().postDelayed(this.any, a.i());
    }

    public final void stop() {
        if (this.anw.get()) {
            this.anw.set(false);
            j.va().removeCallbacks(this.any);
        }
    }
}
