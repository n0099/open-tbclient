package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    private static Context amA;
    private static ExecutorService amB;
    private static c amz;
    private static boolean an = false;
    public l amx;
    public p amy;

    private c(Context context) {
        amA = context;
        this.amy = new p(Looper.getMainLooper().getThread(), a.W);
        this.amx = new l(new d(this), context);
        if (amB == null) {
            amB = Executors.newSingleThreadExecutor();
        }
    }

    public static c aa(Context context) {
        if (amz == null) {
            synchronized (c.class) {
                if (amz == null) {
                    amz = new c(context);
                }
            }
        }
        return amz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a uH = a.uH();
        uH.amt = c;
        uH.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.amD.start();
            com.baidu.crabsdk.c.a.ds("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.amD.stop();
        }
    }
}
