package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
final class l implements Printer {
    private final Context anN;
    private i anZ;
    private long anX = 0;
    private long anY = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.anZ = null;
        this.anZ = iVar;
        this.anN = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.anX = System.currentTimeMillis();
            this.anY = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ad(this.anN).anL != null) {
                c.ad(this.anN).anL.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.anX >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dA("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.anX + ETAG.EQUAL + (currentTimeMillis - this.anX) + " >= " + a.W);
            j.vk().post(new m(this, this.anX, currentTimeMillis, this.anY, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ad(this.anN).anL != null) {
            c.ad(this.anN).anL.stop();
        }
    }
}
