package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
final class l implements Printer {
    private final Context Pl;
    private i Py;
    private long Pw = 0;
    private long Px = 0;
    private boolean Pz = false;

    public l(i iVar, Context context) {
        this.Py = null;
        this.Py = iVar;
        this.Pl = context;
    }

    @Override // android.util.Printer
    public final void println(String str) {
        if (Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.Pz) {
            this.Pw = System.currentTimeMillis();
            this.Px = SystemClock.currentThreadTimeMillis();
            this.Pz = true;
            if (c.aq(this.Pl).Pj != null) {
                c.aq(this.Pl).Pj.start();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.Pz = false;
        if (currentTimeMillis - this.Pw >= ((long) a.U)) {
            com.baidu.crabsdk.c.a.cb("BlockCanary ^^ notifyBlockEvent: " + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Pw + ETAG.EQUAL + (currentTimeMillis - this.Pw) + " >= " + a.U);
            j.nw().post(new m(this, this.Pw, currentTimeMillis, this.Px, SystemClock.currentThreadTimeMillis()));
        }
        if (c.aq(this.Pl).Pj != null) {
            c.aq(this.Pl).Pj.stop();
        }
    }
}
