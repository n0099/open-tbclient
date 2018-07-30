package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class c {
    private static c RT;
    private static Context RU;
    private static ExecutorService RV;
    private static boolean ak = false;
    public l RQ;
    public p RR;

    private c(Context context) {
        RU = context;
        this.RR = new p(Looper.getMainLooper().getThread(), a.T);
        this.RQ = new l(new d(this), context);
        if (RV == null) {
            RV = Executors.newSingleThreadExecutor();
        }
    }

    public static c at(Context context) {
        if (RT == null) {
            synchronized (c.class) {
                if (RT == null) {
                    RT = new c(context);
                }
            }
        }
        return RT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cg("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a oV = a.oV();
        oV.RK = b;
        oV.a(j, j2, j3, j4);
    }

    public static void start() {
        ak = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.RX.start();
            com.baidu.crabsdk.c.a.ce("start FrameMonitor...");
        }
    }

    public static void stop() {
        ak = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.RX.stop();
        }
    }
}
