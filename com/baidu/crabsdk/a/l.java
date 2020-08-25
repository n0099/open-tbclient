package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
final class l implements Printer {
    private final Context amA;
    private i amM;
    private long amK = 0;
    private long amL = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.amM = null;
        this.amM = iVar;
        this.amA = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.amK = System.currentTimeMillis();
            this.amL = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.aa(this.amA).amy != null) {
                c.aa(this.amA).amy.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.amK >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.ds("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.amK + ETAG.EQUAL + (currentTimeMillis - this.amK) + " >= " + a.W);
            j.uN().post(new m(this, this.amK, currentTimeMillis, this.amL, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aa(this.amA).amy != null) {
            c.aa(this.amA).amy.stop();
        }
    }
}
