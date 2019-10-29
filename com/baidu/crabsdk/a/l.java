package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context Jl;
    private i Jy;
    private long Jw = 0;
    private long Jx = 0;
    private boolean Jz = false;

    public l(i iVar, Context context) {
        this.Jy = null;
        this.Jy = iVar;
        this.Jl = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Jz) {
            this.Jw = System.currentTimeMillis();
            this.Jx = SystemClock.currentThreadTimeMillis();
            this.Jz = true;
            if (c.aj(this.Jl).Jj != null) {
                c.aj(this.Jl).Jj.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Jz = false;
        if (currentTimeMillis - this.Jw >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.bu("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jw + "=" + (currentTimeMillis - this.Jw) + " >= " + a.U);
            j.mm().post(new m(this, this.Jw, currentTimeMillis, this.Jx, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aj(this.Jl).Jj != null) {
            c.aj(this.Jl).Jj.stop();
        }
    }
}
