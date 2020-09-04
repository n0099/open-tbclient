package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
final class l implements Printer {
    private final Context amC;
    private i amO;
    private long amM = 0;
    private long amN = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.amO = null;
        this.amO = iVar;
        this.amC = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.amM = System.currentTimeMillis();
            this.amN = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.aa(this.amC).amA != null) {
                c.aa(this.amC).amA.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.amM >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dt("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.amM + ETAG.EQUAL + (currentTimeMillis - this.amM) + " >= " + a.W);
            j.uN().post(new m(this, this.amM, currentTimeMillis, this.amN, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aa(this.amC).amA != null) {
            c.aa(this.amC).amA.stop();
        }
    }
}
