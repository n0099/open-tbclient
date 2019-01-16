package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
final class l implements Printer {
    private i XI;
    private final Context Xw;
    private long XG = 0;
    private long XH = 0;
    private boolean XJ = false;

    public l(i iVar, Context context) {
        this.XI = null;
        this.XI = iVar;
        this.Xw = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.XJ) {
            this.XG = System.currentTimeMillis();
            this.XH = SystemClock.currentThreadTimeMillis();
            this.XJ = true;
            if (c.bg(this.Xw).Xu != null) {
                c.bg(this.Xw).Xu.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.XJ = false;
        if (currentTimeMillis - this.XG >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cH("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.XG + ETAG.EQUAL + (currentTimeMillis - this.XG) + " >= " + a.U);
            j.ro().post(new m(this, this.XG, currentTimeMillis, this.XH, SystemClock.currentThreadTimeMillis()));
        }
        if (c.bg(this.Xw).Xu != null) {
            c.bg(this.Xw).Xu.stop();
        }
    }
}
