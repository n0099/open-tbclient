package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
final class l implements Printer {
    private final Context RU;
    private i Sg;
    private long Se = 0;
    private long Sf = 0;
    private boolean Sh = false;

    public l(i iVar, Context context) {
        this.Sg = null;
        this.Sg = iVar;
        this.RU = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (!this.Sh) {
            this.Se = System.currentTimeMillis();
            this.Sf = SystemClock.currentThreadTimeMillis();
            this.Sh = true;
            if (c.at(this.RU).RR != null) {
                c.at(this.RU).RR.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Sh = false;
        if (currentTimeMillis - this.Se >= ((long) a.T)) {
            com.baidu.crabsdk.c.a.ce("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Se + "=" + (currentTimeMillis - this.Se) + " >= " + a.T);
            j.oX().post(new m(this, this.Se, currentTimeMillis, this.Sf, SystemClock.currentThreadTimeMillis()));
        }
        if (c.at(this.RU).RR != null) {
            c.at(this.RU).RR.stop();
        }
    }
}
