package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long abt;
    AtomicBoolean abr = new AtomicBoolean(false);
    private Runnable abu = new o(this);

    public n(long j) {
        this.abt = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.abr.get()) {
            return;
        }
        this.abr.set(true);
        j.rN().removeCallbacks(this.abu);
        j.rN().postDelayed(this.abu, a.h());
    }

    public final void stop() {
        if (this.abr.get()) {
            this.abr.set(false);
            j.rN().removeCallbacks(this.abu);
        }
    }
}
