package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class n {
    long PJ;
    AtomicBoolean PI = new AtomicBoolean(false);
    private Runnable PK = new o(this);

    public n(long j) {
        this.PJ = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.PI.get()) {
            return;
        }
        this.PI.set(true);
        j.nv().removeCallbacks(this.PK);
        j.nv().postDelayed(this.PK, a.h());
    }

    public final void stop() {
        if (this.PI.get()) {
            this.PI.set(false);
            j.nv().removeCallbacks(this.PK);
        }
    }
}
