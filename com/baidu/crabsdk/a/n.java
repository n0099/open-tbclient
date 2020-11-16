package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class n {
    long aon;
    AtomicBoolean aom = new AtomicBoolean(false);
    private Runnable aoo = new o(this);

    public n(long j) {
        this.aon = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aom.get()) {
            return;
        }
        this.aom.set(true);
        j.vi().removeCallbacks(this.aoo);
        j.vi().postDelayed(this.aoo, a.i());
    }

    public final void stop() {
        if (this.aom.get()) {
            this.aom.set(false);
            j.vi().removeCallbacks(this.aoo);
        }
    }
}
