package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context akf;
    private i akr;
    private long akp = 0;
    private long akq = 0;
    private boolean aks = false;

    public l(i iVar, Context context) {
        this.akr = null;
        this.akr = iVar;
        this.akf = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aks) {
            this.akp = System.currentTimeMillis();
            this.akq = SystemClock.currentThreadTimeMillis();
            this.aks = true;
            if (c.X(this.akf).akd != null) {
                c.X(this.akf).akd.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aks = false;
        if (currentTimeMillis - this.akp >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dg("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.akp + ETAG.EQUAL + (currentTimeMillis - this.akp) + " >= " + a.W);
            j.sI().post(new m(this, this.akp, currentTimeMillis, this.akq, SystemClock.currentThreadTimeMillis()));
        }
        if (c.X(this.akf).akd != null) {
            c.X(this.akf).akd.stop();
        }
    }
}
