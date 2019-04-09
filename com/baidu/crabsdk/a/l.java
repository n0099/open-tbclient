package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context aaZ;
    private i abm;
    private long abk = 0;
    private long abl = 0;
    private boolean abn = false;

    public l(i iVar, Context context) {
        this.abm = null;
        this.abm = iVar;
        this.aaZ = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.abn) {
            this.abk = System.currentTimeMillis();
            this.abl = SystemClock.currentThreadTimeMillis();
            this.abn = true;
            if (c.ba(this.aaZ).aaX != null) {
                c.ba(this.aaZ).aaX.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.abn = false;
        if (currentTimeMillis - this.abk >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.abk + "=" + (currentTimeMillis - this.abk) + " >= " + a.U);
            j.rO().post(new m(this, this.abk, currentTimeMillis, this.abl, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ba(this.aaZ).aaX != null) {
            c.ba(this.aaZ).aaX.stop();
        }
    }
}
