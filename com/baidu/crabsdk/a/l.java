package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
final class l implements Printer {
    private i UL;
    private final Context Uy;
    private long UJ = 0;
    private long UK = 0;
    private boolean UM = false;

    public l(i iVar, Context context) {
        this.UL = null;
        this.UL = iVar;
        this.Uy = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (!this.UM) {
            this.UJ = System.currentTimeMillis();
            this.UK = SystemClock.currentThreadTimeMillis();
            this.UM = true;
            if (c.aZ(this.Uy).Uw != null) {
                c.aZ(this.Uy).Uw.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.UM = false;
        if (currentTimeMillis - this.UJ >= ((long) a.T)) {
            com.baidu.crabsdk.c.a.cv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.UJ + "=" + (currentTimeMillis - this.UJ) + " >= " + a.T);
            j.qd().post(new m(this, this.UJ, currentTimeMillis, this.UK, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aZ(this.Uy).Uw != null) {
            c.aZ(this.Uy).Uw.stop();
        }
    }
}
