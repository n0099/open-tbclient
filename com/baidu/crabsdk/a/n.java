package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long Zk;
    AtomicBoolean Zj = new AtomicBoolean(false);
    private Runnable Zl = new o(this);

    public n(long j) {
        this.Zk = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Zj.get()) {
            return;
        }
        this.Zj.set(true);
        j.qI().removeCallbacks(this.Zl);
        j.qI().postDelayed(this.Zl, a.h());
    }

    public final void stop() {
        if (this.Zj.get()) {
            this.Zj.set(false);
            j.qI().removeCallbacks(this.Zl);
        }
    }
}
