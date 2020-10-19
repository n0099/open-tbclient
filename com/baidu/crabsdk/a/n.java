package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public abstract class n {
    long aog;
    AtomicBoolean aof = new AtomicBoolean(false);
    private Runnable aoh = new o(this);

    public n(long j) {
        this.aog = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aof.get()) {
            return;
        }
        this.aof.set(true);
        j.vj().removeCallbacks(this.aoh);
        j.vj().postDelayed(this.aoh, a.i());
    }

    public final void stop() {
        if (this.aof.get()) {
            this.aof.set(false);
            j.vj().removeCallbacks(this.aoh);
        }
    }
}
