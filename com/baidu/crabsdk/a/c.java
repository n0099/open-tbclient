package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c ajA;
    private static Context ajB;
    private static ExecutorService ajC;
    private static boolean an = false;
    public l ajy;
    public p ajz;

    private c(Context context) {
        ajB = context;
        this.ajz = new p(Looper.getMainLooper().getThread(), a.W);
        this.ajy = new l(new d(this), context);
        if (ajC == null) {
            ajC = Executors.newSingleThreadExecutor();
        }
    }

    public static c U(Context context) {
        if (ajA == null) {
            synchronized (c.class) {
                if (ajA == null) {
                    ajA = new c(context);
                }
            }
        }
        return ajA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a ss = a.ss();
        ss.aju = c;
        ss.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.ajE.start();
            com.baidu.crabsdk.c.a.de("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.ajE.stop();
        }
    }
}
