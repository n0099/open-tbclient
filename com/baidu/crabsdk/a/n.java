package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class n {
    long So;
    AtomicBoolean Sn = new AtomicBoolean(false);
    private Runnable Sp = new o(this);

    public n(long j) {
        this.So = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n();

    public final void start() {
        if (this.Sn.get()) {
            return;
        }
        this.Sn.set(true);
        j.oZ().removeCallbacks(this.Sp);
        j.oZ().postDelayed(this.Sp, a.h());
    }

    public final void stop() {
        if (this.Sn.get()) {
            this.Sn.set(false);
            j.oZ().removeCallbacks(this.Sp);
        }
    }
}
