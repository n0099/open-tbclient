package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long ZF;
    AtomicBoolean ZE = new AtomicBoolean(false);
    private Runnable ZG = new o(this);

    public n(long j) {
        this.ZF = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.ZE.get()) {
            return;
        }
        this.ZE.set(true);
        j.rg().removeCallbacks(this.ZG);
        j.rg().postDelayed(this.ZG, a.h());
    }

    public final void stop() {
        if (this.ZE.get()) {
            this.ZE.set(false);
            j.rg().removeCallbacks(this.ZG);
        }
    }
}
