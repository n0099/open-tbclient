package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class n {
    long PF;
    AtomicBoolean PE = new AtomicBoolean(false);
    private Runnable PG = new o(this);

    public n(long j) {
        this.PF = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.PE.get()) {
            return;
        }
        this.PE.set(true);
        j.nu().removeCallbacks(this.PG);
        j.nu().postDelayed(this.PG, a.h());
    }

    public final void stop() {
        if (this.PE.get()) {
            this.PE.set(false);
            j.nu().removeCallbacks(this.PG);
        }
    }
}
