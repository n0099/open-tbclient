package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context api;
    private i apu;
    private long apt = 0;
    private long az = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.apu = null;
        this.apu = iVar;
        this.api = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.apt = System.currentTimeMillis();
            this.az = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ae(this.api).apg != null) {
                c.ae(this.api).apg.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.apt >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dx("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.apt + "=" + (currentTimeMillis - this.apt) + " >= " + a.W);
            j.uw().post(new m(this, this.apt, currentTimeMillis, this.az, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ae(this.api).apg != null) {
            c.ae(this.api).apg.stop();
        }
    }
}
