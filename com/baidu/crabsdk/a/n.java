package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public abstract class n {
    long aoh;
    AtomicBoolean aog = new AtomicBoolean(false);
    private Runnable aoi = new o(this);

    public n(long j) {
        this.aoh = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aog.get()) {
            return;
        }
        this.aog.set(true);
        j.vj().removeCallbacks(this.aoi);
        j.vj().postDelayed(this.aoi, a.i());
    }

    public final void stop() {
        if (this.aog.get()) {
            this.aog.set(false);
            j.vj().removeCallbacks(this.aoi);
        }
    }
}
