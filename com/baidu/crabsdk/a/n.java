package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class n {
    long Sr;
    AtomicBoolean Sq = new AtomicBoolean(false);
    private Runnable Ss = new o(this);

    public n(long j) {
        this.Sr = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Sq.get()) {
            return;
        }
        this.Sq.set(true);
        j.oV().removeCallbacks(this.Ss);
        j.oV().postDelayed(this.Ss, a.h());
    }

    public final void stop() {
        if (this.Sq.get()) {
            this.Sq.set(false);
            j.oV().removeCallbacks(this.Ss);
        }
    }
}
