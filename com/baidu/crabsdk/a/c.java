package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    private static c Xm;
    private static Context Xn;
    private static ExecutorService Xo;
    private static boolean al = false;
    public l Xk;
    public p Xl;

    private c(Context context) {
        Xn = context;
        this.Xl = new p(Looper.getMainLooper().getThread(), a.U);
        this.Xk = new l(new d(this), context);
        if (Xo == null) {
            Xo = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cI("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a ri = a.ri();
        ri.Xg = b;
        ri.a(j, j2, j3, j4);
    }

    public static c bg(Context context) {
        if (Xm == null) {
            synchronized (c.class) {
                if (Xm == null) {
                    Xm = new c(context);
                }
            }
        }
        return Xm;
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Xq.start();
            com.baidu.crabsdk.c.a.cG("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Xq.stop();
        }
    }
}
