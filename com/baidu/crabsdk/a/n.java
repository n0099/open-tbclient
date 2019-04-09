package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long abv;
    AtomicBoolean abu = new AtomicBoolean(false);
    private Runnable abw = new o(this);

    public n(long j) {
        this.abv = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.abu.get()) {
            return;
        }
        this.abu.set(true);
        j.rN().removeCallbacks(this.abw);
        j.rN().postDelayed(this.abw, a.h());
    }

    public final void stop() {
        if (this.abu.get()) {
            this.abu.set(false);
            j.rN().removeCallbacks(this.abw);
        }
    }
}
