package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class n {
    long apB;
    AtomicBoolean apA = new AtomicBoolean(false);
    private Runnable apC = new o(this);

    public n(long j) {
        this.apB = 0 == j ? 300L : j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o();

    public final void start() {
        if (this.apA.get()) {
            return;
        }
        this.apA.set(true);
        j.uv().removeCallbacks(this.apC);
        j.uv().postDelayed(this.apC, a.i());
    }

    public final void stop() {
        if (this.apA.get()) {
            this.apA.set(false);
            j.uv().removeCallbacks(this.apC);
        }
    }
}
