package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class n {
    long Sp;
    AtomicBoolean So = new AtomicBoolean(false);
    private Runnable Sq = new o(this);

    public n(long j) {
        this.Sp = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.So.get()) {
            return;
        }
        this.So.set(true);
        j.oV().removeCallbacks(this.Sq);
        j.oV().postDelayed(this.Sq, a.h());
    }

    public final void stop() {
        if (this.So.get()) {
            this.So.set(false);
            j.oV().removeCallbacks(this.Sq);
        }
    }
}
