package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
final class l implements Printer {
    private final Context RX;
    private i Sj;
    private long Sh = 0;
    private long Si = 0;
    private boolean Sk = false;

    public l(i iVar, Context context) {
        this.Sj = null;
        this.Sj = iVar;
        this.RX = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (!this.Sk) {
            this.Sh = System.currentTimeMillis();
            this.Si = SystemClock.currentThreadTimeMillis();
            this.Sk = true;
            if (c.at(this.RX).RV != null) {
                c.at(this.RX).RV.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Sk = false;
        if (currentTimeMillis - this.Sh >= ((long) a.T)) {
            com.baidu.crabsdk.c.a.cd("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Sh + "=" + (currentTimeMillis - this.Sh) + " >= " + a.T);
            j.oW().post(new m(this, this.Sh, currentTimeMillis, this.Si, SystemClock.currentThreadTimeMillis()));
        }
        if (c.at(this.RX).RV != null) {
            c.at(this.RX).RV.stop();
        }
    }
}
