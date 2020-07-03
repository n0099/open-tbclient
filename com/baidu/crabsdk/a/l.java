package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context alC;
    private i alO;
    private long alM = 0;
    private long alN = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.alO = null;
        this.alO = iVar;
        this.alC = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.alM = System.currentTimeMillis();
            this.alN = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.Y(this.alC).alA != null) {
                c.Y(this.alC).alA.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.alM >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.di("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.alM + ETAG.EQUAL + (currentTimeMillis - this.alM) + " >= " + a.W);
            j.td().post(new m(this, this.alM, currentTimeMillis, this.alN, SystemClock.currentThreadTimeMillis()));
        }
        if (c.Y(this.alC).alA != null) {
            c.Y(this.alC).alA.stop();
        }
    }
}
