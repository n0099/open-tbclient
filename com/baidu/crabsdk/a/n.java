package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class n {
    long UU;
    AtomicBoolean UT = new AtomicBoolean(false);
    private Runnable UV = new o(this);

    public n(long j) {
        this.UU = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.UT.get()) {
            return;
        }
        this.UT.set(true);
        j.qc().removeCallbacks(this.UV);
        j.qc().postDelayed(this.UV, a.h());
    }

    public final void stop() {
        if (this.UT.get()) {
            this.UT.set(false);
            j.qc().removeCallbacks(this.UV);
        }
    }
}
