package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
final class l implements Printer {
    private final Context anO;
    private i aoa;
    private long anY = 0;
    private long anZ = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.aoa = null;
        this.aoa = iVar;
        this.anO = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.anY = System.currentTimeMillis();
            this.anZ = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.ad(this.anO).anM != null) {
                c.ad(this.anO).anM.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.anY >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dA("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.anY + ETAG.EQUAL + (currentTimeMillis - this.anY) + " >= " + a.W);
            j.vk().post(new m(this, this.anY, currentTimeMillis, this.anZ, SystemClock.currentThreadTimeMillis()));
        }
        if (c.ad(this.anO).anM != null) {
            c.ad(this.anO).anM.stop();
        }
    }
}
