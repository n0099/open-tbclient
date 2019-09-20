package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context Zl;
    private i Zx;
    private long Zv = 0;
    private long Zw = 0;
    private boolean Zy = false;

    public l(i iVar, Context context) {
        this.Zx = null;
        this.Zx = iVar;
        this.Zl = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Zy) {
            this.Zv = System.currentTimeMillis();
            this.Zw = SystemClock.currentThreadTimeMillis();
            this.Zy = true;
            if (c.as(this.Zl).Zj != null) {
                c.as(this.Zl).Zj.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Zy = false;
        if (currentTimeMillis - this.Zv >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.ch("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Zv + "=" + (currentTimeMillis - this.Zv) + " >= " + a.U);
            j.rh().post(new m(this, this.Zv, currentTimeMillis, this.Zw, SystemClock.currentThreadTimeMillis()));
        }
        if (c.as(this.Zl).Zj != null) {
            c.as(this.Zl).Zj.stop();
        }
    }
}
