package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class n {
    long XQ;
    AtomicBoolean XP = new AtomicBoolean(false);
    private Runnable XR = new o(this);

    public n(long j) {
        this.XQ = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.XP.get()) {
            return;
        }
        this.XP.set(true);
        j.rn().removeCallbacks(this.XR);
        j.rn().postDelayed(this.XR, a.h());
    }

    public final void stop() {
        if (this.XP.get()) {
            this.XP.set(false);
            j.rn().removeCallbacks(this.XR);
        }
    }
}
