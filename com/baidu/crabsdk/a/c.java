package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static boolean an = false;
    private static c and;
    private static Context ane;
    private static ExecutorService anf;
    public l anb;
    public p anc;

    private c(Context context) {
        ane = context;
        this.anc = new p(Looper.getMainLooper().getThread(), a.W);
        this.anb = new l(new d(this), context);
        if (anf == null) {
            anf = Executors.newSingleThreadExecutor();
        }
    }

    public static c aa(Context context) {
        if (and == null) {
            synchronized (c.class) {
                if (and == null) {
                    and = new c(context);
                }
            }
        }
        return and;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a uV = a.uV();
        uV.amX = c;
        uV.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anh.start();
            com.baidu.crabsdk.c.a.dv("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anh.stop();
        }
    }
}
