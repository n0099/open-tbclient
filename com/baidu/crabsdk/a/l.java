package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context QU;
    private i Ri;
    private long Rg = 0;
    private long Rh = 0;
    private boolean Rj = false;

    public l(i iVar, Context context) {
        this.Ri = null;
        this.Ri = iVar;
        this.QU = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Rj) {
            this.Rg = System.currentTimeMillis();
            this.Rh = SystemClock.currentThreadTimeMillis();
            this.Rj = true;
            if (c.as(this.QU).QS != null) {
                c.as(this.QU).QS.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Rj = false;
        if (currentTimeMillis - this.Rg >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cj("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Rg + ETAG.EQUAL + (currentTimeMillis - this.Rg) + " >= " + a.U);
            j.oe().post(new m(this, this.Rg, currentTimeMillis, this.Rh, SystemClock.currentThreadTimeMillis()));
        }
        if (c.as(this.QU).QS != null) {
            c.as(this.QU).QS.stop();
        }
    }
}
