package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class n {
    long XH;
    AtomicBoolean XG = new AtomicBoolean(false);
    private Runnable XI = new o(this);

    public n(long j) {
        this.XH = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.XG.get()) {
            return;
        }
        this.XG.set(true);
        j.rk().removeCallbacks(this.XI);
        j.rk().postDelayed(this.XI, a.h());
    }

    public final void stop() {
        if (this.XG.get()) {
            this.XG.set(false);
            j.rk().removeCallbacks(this.XI);
        }
    }
}
