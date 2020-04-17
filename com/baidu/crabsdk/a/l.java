package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private i ajH;
    private final Context ajv;
    private long ajF = 0;
    private long ajG = 0;
    private boolean ajI = false;

    public l(i iVar, Context context) {
        this.ajH = null;
        this.ajH = iVar;
        this.ajv = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.ajI) {
            this.ajF = System.currentTimeMillis();
            this.ajG = SystemClock.currentThreadTimeMillis();
            this.ajI = true;
            if (c.ah(this.ajv).ajt != null) {
                c.ah(this.ajv).ajt.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ajI = false;
        if (currentTimeMillis - this.ajF >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.de("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ajF + ETAG.EQUAL + (currentTimeMillis - this.ajF) + " >= " + a.W);
            j.sz().post(new m(this, this.ajF, currentTimeMillis, this.ajG, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ah(this.ajv).ajt != null) {
            c.ah(this.ajv).ajt.stop();
        }
    }
}
