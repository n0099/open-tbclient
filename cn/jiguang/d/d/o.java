package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public final class o {
    private static final Object b = new Object();
    private static volatile o mi;
    private boolean c;
    private Handler d;
    private long e;

    public static void a(Context context, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", false);
        l.bY().d(context, "intent.PERIOD_RESUME", bundle);
    }

    public static o bZ() {
        if (mi == null) {
            synchronized (b) {
                if (mi == null) {
                    mi = new o();
                }
            }
        }
        return mi;
    }

    private void c(Context context) {
        this.e = SystemClock.uptimeMillis();
        this.d.removeMessages(8000);
        this.d.sendEmptyMessageDelayed(8000, cn.jiguang.d.a.a.g() * 1000);
        if (cn.jiguang.d.a.d.i(context)) {
            cn.jiguang.g.a.l(context);
        } else {
            cn.jiguang.g.a.k(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        this.d.removeMessages(8000);
        if (this.c) {
            c(context);
            if (i.bW().f() && !cn.jiguang.d.a.d.i(context)) {
                cn.jiguang.d.a.a(context, false, 0L);
            }
            cn.jiguang.a.c.c.a(context, 0);
            try {
                cn.jiguang.d.i.f.cj().a(context, false);
            } catch (OutOfMemoryError e) {
            }
        }
    }

    public final void a(Context context) {
        this.c = true;
        b(context, true);
    }

    public final void b(Context context) {
        try {
            if (this.d != null) {
                this.d.removeCallbacksAndMessages(null);
                this.d.getLooper().quit();
            }
            this.d = null;
        } catch (Throwable th) {
        }
        cn.jiguang.g.a.l(context);
    }

    public final void b(Context context, boolean z) {
        if (this.c) {
            if (this.d == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("PeriodWorker");
                    handlerThread.start();
                    this.d = new p(this, handlerThread.getLooper(), context);
                } catch (Throwable th) {
                }
            }
            if (this.e > 0 && SystemClock.uptimeMillis() > this.e + ((cn.jiguang.d.a.a.g() + 5) * 1000)) {
                d(context);
            } else if (z || !this.d.hasMessages(8000)) {
                c(context);
            }
        }
    }
}
