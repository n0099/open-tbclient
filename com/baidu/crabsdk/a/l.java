package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context aoI;
    private i aoU;
    private long aoS = 0;
    private long aoT = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.aoU = null;
        this.aoU = iVar;
        this.aoI = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.aoS = System.currentTimeMillis();
            this.aoT = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ae(this.aoI).aoG != null) {
                c.ae(this.aoI).aoG.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.aoS >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dE("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aoS + "=" + (currentTimeMillis - this.aoS) + " >= " + a.W);
            j.uY().post(new m(this, this.aoS, currentTimeMillis, this.aoT, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ae(this.aoI).aoG != null) {
            c.ae(this.aoI).aoG.stop();
        }
    }
}
