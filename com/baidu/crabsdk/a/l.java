package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context ajB;
    private i ajN;
    private long ajL = 0;
    private long ajM = 0;
    private boolean ajO = false;

    public l(i iVar, Context context) {
        this.ajN = null;
        this.ajN = iVar;
        this.ajB = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.ajO) {
            this.ajL = System.currentTimeMillis();
            this.ajM = SystemClock.currentThreadTimeMillis();
            this.ajO = true;
            if (c.U(this.ajB).ajz != null) {
                c.U(this.ajB).ajz.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ajO = false;
        if (currentTimeMillis - this.ajL >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.de("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ajL + ETAG.EQUAL + (currentTimeMillis - this.ajL) + " >= " + a.W);
            j.sy().post(new m(this, this.ajL, currentTimeMillis, this.ajM, SystemClock.currentThreadTimeMillis()));
        }
        if (c.U(this.ajB).ajz != null) {
            c.U(this.ajB).ajz.stop();
        }
    }
}
