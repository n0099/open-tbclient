package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
final class l implements Printer {
    private final Context II;
    private i IY;
    private long IW = 0;
    private long IX = 0;
    private boolean IZ = false;

    public l(i iVar, Context context) {
        this.IY = null;
        this.IY = iVar;
        this.II = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.IZ) {
            this.IW = System.currentTimeMillis();
            this.IX = SystemClock.currentThreadTimeMillis();
            this.IZ = true;
            if (c.aj(this.II).IG != null) {
                c.aj(this.II).IG.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.IZ = false;
        if (currentTimeMillis - this.IW >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.bu("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.IW + "=" + (currentTimeMillis - this.IW) + " >= " + a.U);
            j.mm().post(new m(this, this.IW, currentTimeMillis, this.IX, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aj(this.II).IG != null) {
            c.aj(this.II).IG.stop();
        }
    }
}
