package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context aaW;
    private i abj;
    private long abh = 0;
    private long abi = 0;
    private boolean abk = false;

    public l(i iVar, Context context) {
        this.abj = null;
        this.abj = iVar;
        this.aaW = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.abk) {
            this.abh = System.currentTimeMillis();
            this.abi = SystemClock.currentThreadTimeMillis();
            this.abk = true;
            if (c.ba(this.aaW).aaU != null) {
                c.ba(this.aaW).aaU.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.abk = false;
        if (currentTimeMillis - this.abh >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.abh + "=" + (currentTimeMillis - this.abh) + " >= " + a.U);
            j.rO().post(new m(this, this.abh, currentTimeMillis, this.abi, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ba(this.aaW).aaU != null) {
            c.ba(this.aaW).aaU.stop();
        }
    }
}
