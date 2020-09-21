package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class l implements Printer {
    private final Context ane;
    private i anq;
    private long ano = 0;
    private long anp = 0;
    private boolean aB = false;

    public l(i iVar, Context context) {
        this.anq = null;
        this.anq = iVar;
        this.ane = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.aB) {
            this.ano = System.currentTimeMillis();
            this.anp = SystemClock.currentThreadTimeMillis();
            this.aB = true;
            if (c.aa(this.ane).anc != null) {
                c.aa(this.ane).anc.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.aB = false;
        if (currentTimeMillis - this.ano >= ((long) a.W)) {
            com.baidu.crabsdk.c.a.dv("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ano + ETAG.EQUAL + (currentTimeMillis - this.ano) + " >= " + a.W);
            j.vb().post(new m(this, this.ano, currentTimeMillis, this.anp, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aa(this.ane).anc != null) {
            c.aa(this.ane).anc.stop();
        }
    }
}
