package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context YR;
    private i Zd;
    private long Zb = 0;
    private long Zc = 0;
    private boolean Ze = false;

    public l(i iVar, Context context) {
        this.Zd = null;
        this.Zd = iVar;
        this.YR = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Ze) {
            this.Zb = System.currentTimeMillis();
            this.Zc = SystemClock.currentThreadTimeMillis();
            this.Ze = true;
            if (c.as(this.YR).YP != null) {
                c.as(this.YR).YP.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Ze = false;
        if (currentTimeMillis - this.Zb >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cf("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Zb + "=" + (currentTimeMillis - this.Zb) + " >= " + a.U);
            j.qJ().post(new m(this, this.Zb, currentTimeMillis, this.Zc, SystemClock.currentThreadTimeMillis()));
        }
        if (c.as(this.YR).YP != null) {
            c.as(this.YR).YP.stop();
        }
    }
}
