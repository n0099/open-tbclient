package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long abu;
    AtomicBoolean abt = new AtomicBoolean(false);
    private Runnable abv = new o(this);

    public n(long j) {
        this.abu = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.abt.get()) {
            return;
        }
        this.abt.set(true);
        j.rN().removeCallbacks(this.abv);
        j.rN().postDelayed(this.abv, a.h());
    }

    public final void stop() {
        if (this.abt.get()) {
            this.abt.set(false);
            j.rN().removeCallbacks(this.abv);
        }
    }
}
