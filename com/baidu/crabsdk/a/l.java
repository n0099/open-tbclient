package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
final class l implements Printer {
    private final Context aol;
    private i aov;
    private long aou = 0;
    private long az = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.aov = null;
        this.aov = iVar;
        this.aol = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.aou = System.currentTimeMillis();
            this.az = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ad(this.aol).aoj != null) {
                c.ad(this.aol).aoj.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.aou >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.ds("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aou + "=" + (currentTimeMillis - this.aou) + " >= " + a.W);
            j.um().post(new m(this, this.aou, currentTimeMillis, this.az, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ad(this.aol).aoj != null) {
            c.ad(this.aol).aoj.stop();
        }
    }
}
