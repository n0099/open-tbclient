package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context YQ;
    private i Zc;
    private long Za = 0;
    private long Zb = 0;
    private boolean Zd = false;

    public l(i iVar, Context context) {
        this.Zc = null;
        this.Zc = iVar;
        this.YQ = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Zd) {
            this.Za = System.currentTimeMillis();
            this.Zb = SystemClock.currentThreadTimeMillis();
            this.Zd = true;
            if (c.as(this.YQ).YO != null) {
                c.as(this.YQ).YO.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Zd = false;
        if (currentTimeMillis - this.Za >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cf("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Za + "=" + (currentTimeMillis - this.Za) + " >= " + a.U);
            j.qJ().post(new m(this, this.Za, currentTimeMillis, this.Zb, SystemClock.currentThreadTimeMillis()));
        }
        if (c.as(this.YQ).YO != null) {
            c.as(this.YQ).YO.stop();
        }
    }
}
