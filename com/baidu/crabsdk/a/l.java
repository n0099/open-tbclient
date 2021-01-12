package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes14.dex */
final class l implements Printer {
    private i aoF;
    private final Context aov;
    private long aoE = 0;
    private long az = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.aoF = null;
        this.aoF = iVar;
        this.aov = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.aoE = System.currentTimeMillis();
            this.az = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ad(this.aov).aot != null) {
                c.ad(this.aov).aot.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.aoE >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.ds("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aoE + "=" + (currentTimeMillis - this.aoE) + " >= " + a.W);
            j.up().post(new m(this, this.aoE, currentTimeMillis, this.az, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ad(this.aov).aot != null) {
            c.ad(this.aov).aot.stop();
        }
    }
}
