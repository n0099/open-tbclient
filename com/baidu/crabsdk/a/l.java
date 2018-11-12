package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
final class l implements Printer {
    private final Context Xn;
    private i Xz;
    private long Xx = 0;
    private long Xy = 0;
    private boolean XA = false;

    public l(i iVar, Context context) {
        this.Xz = null;
        this.Xz = iVar;
        this.Xn = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.XA) {
            this.Xx = System.currentTimeMillis();
            this.Xy = SystemClock.currentThreadTimeMillis();
            this.XA = true;
            if (c.bg(this.Xn).Xl != null) {
                c.bg(this.Xn).Xl.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.XA = false;
        if (currentTimeMillis - this.Xx >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cG("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Xx + ETAG.EQUAL + (currentTimeMillis - this.Xx) + " >= " + a.U);
            j.rl().post(new m(this, this.Xx, currentTimeMillis, this.Xy, SystemClock.currentThreadTimeMillis()));
        }
        if (c.bg(this.Xn).Xl != null) {
            c.bg(this.Xn).Xl.stop();
        }
    }
}
