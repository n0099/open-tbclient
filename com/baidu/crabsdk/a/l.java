package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context aaY;
    private i abl;
    private long abj = 0;
    private long abk = 0;
    private boolean abm = false;

    public l(i iVar, Context context) {
        this.abl = null;
        this.abl = iVar;
        this.aaY = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.abm) {
            this.abj = System.currentTimeMillis();
            this.abk = SystemClock.currentThreadTimeMillis();
            this.abm = true;
            if (c.ba(this.aaY).aaW != null) {
                c.ba(this.aaY).aaW.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.abm = false;
        if (currentTimeMillis - this.abj >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.abj + "=" + (currentTimeMillis - this.abj) + " >= " + a.U);
            j.rO().post(new m(this, this.abj, currentTimeMillis, this.abk, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ba(this.aaY).aaW != null) {
            c.ba(this.aaY).aaW.stop();
        }
    }
}
