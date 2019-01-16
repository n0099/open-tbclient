package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    private static c Xv;
    private static Context Xw;
    private static ExecutorService Xx;
    private static boolean al = false;
    public l Xt;
    public p Xu;

    private c(Context context) {
        Xw = context;
        this.Xu = new p(Looper.getMainLooper().getThread(), a.U);
        this.Xt = new l(new d(this), context);
        if (Xx == null) {
            Xx = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cJ("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a rj = a.rj();
        rj.Xp = b;
        rj.a(j, j2, j3, j4);
    }

    public static c bg(Context context) {
        if (Xv == null) {
            synchronized (c.class) {
                if (Xv == null) {
                    Xv = new c(context);
                }
            }
        }
        return Xv;
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Xz.start();
            com.baidu.crabsdk.c.a.cH("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Xz.stop();
        }
    }
}
