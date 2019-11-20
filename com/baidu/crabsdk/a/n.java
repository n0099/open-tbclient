package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long Jg;
    AtomicBoolean Jf = new AtomicBoolean(false);
    private Runnable Jh = new o(this);

    public n(long j) {
        this.Jg = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Jf.get()) {
            return;
        }
        this.Jf.set(true);
        j.ml().removeCallbacks(this.Jh);
        j.ml().postDelayed(this.Jh, a.h());
    }

    public final void stop() {
        if (this.Jf.get()) {
            this.Jf.set(false);
            j.ml().removeCallbacks(this.Jh);
        }
    }
}
