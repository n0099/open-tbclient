package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
final class l implements Printer {
    private final Context Ph;
    private i Pu;
    private long Ps = 0;
    private long Pt = 0;
    private boolean Pv = false;

    public l(i iVar, Context context) {
        this.Pu = null;
        this.Pu = iVar;
        this.Ph = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Pv) {
            this.Ps = System.currentTimeMillis();
            this.Pt = SystemClock.currentThreadTimeMillis();
            this.Pv = true;
            if (c.aq(this.Ph).Pf != null) {
                c.aq(this.Ph).Pf.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Pv = false;
        if (currentTimeMillis - this.Ps >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cb("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Ps + ETAG.EQUAL + (currentTimeMillis - this.Ps) + " >= " + a.U);
            j.nv().post(new m(this, this.Ps, currentTimeMillis, this.Pt, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aq(this.Ph).Pf != null) {
            c.aq(this.Ph).Pf.stop();
        }
    }
}
