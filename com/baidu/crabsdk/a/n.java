package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long abr;
    AtomicBoolean abq = new AtomicBoolean(false);
    private Runnable abt = new o(this);

    public n(long j) {
        this.abr = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.abq.get()) {
            return;
        }
        this.abq.set(true);
        j.rN().removeCallbacks(this.abt);
        j.rN().postDelayed(this.abt, a.h());
    }

    public final void stop() {
        if (this.abq.get()) {
            this.abq.set(false);
            j.rN().removeCallbacks(this.abt);
        }
    }
}
