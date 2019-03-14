package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context aaX;
    private i abk;
    private long abi = 0;
    private long abj = 0;
    private boolean abl = false;

    public l(i iVar, Context context) {
        this.abk = null;
        this.abk = iVar;
        this.aaX = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.abl) {
            this.abi = System.currentTimeMillis();
            this.abj = SystemClock.currentThreadTimeMillis();
            this.abl = true;
            if (c.ba(this.aaX).aaV != null) {
                c.ba(this.aaX).aaV.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.abl = false;
        if (currentTimeMillis - this.abi >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.abi + "=" + (currentTimeMillis - this.abi) + " >= " + a.U);
            j.rO().post(new m(this, this.abi, currentTimeMillis, this.abj, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ba(this.aaX).aaV != null) {
            c.ba(this.aaX).aaV.stop();
        }
    }
}
