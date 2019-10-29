package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long JG;
    AtomicBoolean JF = new AtomicBoolean(false);
    private Runnable JH = new o(this);

    public n(long j) {
        this.JG = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.JF.get()) {
            return;
        }
        this.JF.set(true);
        j.ml().removeCallbacks(this.JH);
        j.ml().postDelayed(this.JH, a.h());
    }

    public final void stop() {
        if (this.JF.get()) {
            this.JF.set(false);
            j.ml().removeCallbacks(this.JH);
        }
    }
}
