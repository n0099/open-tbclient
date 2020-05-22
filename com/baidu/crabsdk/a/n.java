package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class n {
    long akz;
    AtomicBoolean aky = new AtomicBoolean(false);
    private Runnable akA = new o(this);

    public n(long j) {
        this.akz = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.aky.get()) {
            return;
        }
        this.aky.set(true);
        j.sH().removeCallbacks(this.akA);
        j.sH().postDelayed(this.akA, a.i());
    }

    public final void stop() {
        if (this.aky.get()) {
            this.aky.set(false);
            j.sH().removeCallbacks(this.akA);
        }
    }
}
