package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
final class l implements Printer {
    private final Context RV;
    private i Sh;
    private long Sf = 0;
    private long Sg = 0;
    private boolean Si = false;

    public l(i iVar, Context context) {
        this.Sh = null;
        this.Sh = iVar;
        this.RV = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (!this.Si) {
            this.Sf = System.currentTimeMillis();
            this.Sg = SystemClock.currentThreadTimeMillis();
            this.Si = true;
            if (c.at(this.RV).RT != null) {
                c.at(this.RV).RT.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Si = false;
        if (currentTimeMillis - this.Sf >= ((long) a.T)) {
            com.baidu.crabsdk.c.a.cb("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Sf + "=" + (currentTimeMillis - this.Sf) + " >= " + a.T);
            j.oW().post(new m(this, this.Sf, currentTimeMillis, this.Sg, SystemClock.currentThreadTimeMillis()));
        }
        if (c.at(this.RV).RT != null) {
            c.at(this.RV).RT.stop();
        }
    }
}
