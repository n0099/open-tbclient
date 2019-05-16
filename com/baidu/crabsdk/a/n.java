package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long Zl;
    AtomicBoolean Zk = new AtomicBoolean(false);
    private Runnable Zm = new o(this);

    public n(long j) {
        this.Zl = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Zk.get()) {
            return;
        }
        this.Zk.set(true);
        j.qI().removeCallbacks(this.Zm);
        j.qI().postDelayed(this.Zm, a.h());
    }

    public final void stop() {
        if (this.Zk.get()) {
            this.Zk.set(false);
            j.qI().removeCallbacks(this.Zm);
        }
    }
}
