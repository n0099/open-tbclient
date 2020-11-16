package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
final class l implements Printer {
    private final Context anU;
    private i aog;
    private long aoe = 0;
    private long aof = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.aog = null;
        this.aog = iVar;
        this.anU = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.aoe = System.currentTimeMillis();
            this.aof = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ad(this.anU).anS != null) {
                c.ad(this.anU).anS.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.aoe >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dC("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.aoe + ETAG.EQUAL + (currentTimeMillis - this.aoe) + " >= " + a.W);
            j.vj().post(new m(this, this.aoe, currentTimeMillis, this.aof, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ad(this.anU).anS != null) {
            c.ad(this.anU).anS.stop();
        }
    }
}
