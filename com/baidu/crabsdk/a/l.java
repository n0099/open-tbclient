package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
final class l implements Printer {
    private i alJ;
    private final Context alx;
    private long alH = 0;
    private long alI = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.alJ = null;
        this.alJ = iVar;
        this.alx = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.alH = System.currentTimeMillis();
            this.alI = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.Y(this.alx).alv != null) {
                c.Y(this.alx).alv.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.alH >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dh("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.alH + ETAG.EQUAL + (currentTimeMillis - this.alH) + " >= " + a.W);
            j.tf().post(new m(this, this.alH, currentTimeMillis, this.alI, SystemClock.currentThreadTimeMillis()));
        }
        if (c.Y(this.alx).alv != null) {
            c.Y(this.alx).alv.stop();
        }
    }
}
