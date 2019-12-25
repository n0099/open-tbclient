package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class c {
    private static c Pg;
    private static Context Ph;
    private static ExecutorService Pi;
    private static boolean al = false;
    public l Pe;
    public p Pf;

    private c(Context context) {
        Ph = context;
        this.Pf = new p(Looper.getMainLooper().getThread(), a.U);
        this.Pe = new l(new d(this), context);
        if (Pi == null) {
            Pi = Executors.newSingleThreadExecutor();
        }
    }

    public static c aq(Context context) {
        if (Pg == null) {
            synchronized (c.class) {
                if (Pg == null) {
                    Pg = new c(context);
                }
            }
        }
        return Pg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a nq = a.nq();
        nq.OZ = c;
        nq.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Pk.start();
            com.baidu.crabsdk.c.a.cb("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Pk.stop();
        }
    }
}
