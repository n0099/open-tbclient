package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    private static c amB;
    private static Context amC;
    private static ExecutorService amD;
    private static boolean an = false;
    public p amA;
    public l amz;

    private c(Context context) {
        amC = context;
        this.amA = new p(Looper.getMainLooper().getThread(), a.W);
        this.amz = new l(new d(this), context);
        if (amD == null) {
            amD = Executors.newSingleThreadExecutor();
        }
    }

    public static c aa(Context context) {
        if (amB == null) {
            synchronized (c.class) {
                if (amB == null) {
                    amB = new c(context);
                }
            }
        }
        return amB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a uH = a.uH();
        uH.amv = c;
        uH.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.amF.start();
            com.baidu.crabsdk.c.a.dt("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.amF.stop();
        }
    }
}
