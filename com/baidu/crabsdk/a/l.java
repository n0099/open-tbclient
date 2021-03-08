package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
final class l implements Printer {
    private final Context apL;
    private i apV;
    private long apU = 0;
    private long az = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.apV = null;
        this.apV = iVar;
        this.apL = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.apU = System.currentTimeMillis();
            this.az = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ac(this.apL).apJ != null) {
                c.ac(this.apL).apJ.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.apU >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dw("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.apU + "=" + (currentTimeMillis - this.apU) + " >= " + a.W);
            j.um().post(new m(this, this.apU, currentTimeMillis, this.az, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ac(this.apL).apJ != null) {
            c.ac(this.apL).apJ.stop();
        }
    }
}
