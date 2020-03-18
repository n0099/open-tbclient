package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context QX;
    private i Rl;
    private long Rj = 0;
    private long Rk = 0;
    private boolean Rm = false;

    public l(i iVar, Context context) {
        this.Rl = null;
        this.Rl = iVar;
        this.QX = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Rm) {
            this.Rj = System.currentTimeMillis();
            this.Rk = SystemClock.currentThreadTimeMillis();
            this.Rm = true;
            if (c.as(this.QX).QV != null) {
                c.as(this.QX).QV.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Rm = false;
        if (currentTimeMillis - this.Rj >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.cj("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Rj + ETAG.EQUAL + (currentTimeMillis - this.Rj) + " >= " + a.W);
            j.oe().post(new m(this, this.Rj, currentTimeMillis, this.Rk, SystemClock.currentThreadTimeMillis()));
        }
        if (c.as(this.QX).QV != null) {
            c.as(this.QX).QV.stop();
        }
    }
}
