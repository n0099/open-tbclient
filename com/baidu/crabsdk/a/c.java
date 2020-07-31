package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class c {
    private static c alw;
    private static Context alx;
    private static ExecutorService aly;
    private static boolean an = false;
    public l alu;
    public p alv;

    private c(Context context) {
        alx = context;
        this.alv = new p(Looper.getMainLooper().getThread(), a.W);
        this.alu = new l(new d(this), context);
        if (aly == null) {
            aly = Executors.newSingleThreadExecutor();
        }
    }

    public static c Y(Context context) {
        if (alw == null) {
            synchronized (c.class) {
                if (alw == null) {
                    alw = new c(context);
                }
            }
        }
        return alw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a sZ = a.sZ();
        sZ.alq = c;
        sZ.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.alA.start();
            com.baidu.crabsdk.c.a.dh("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.alA.stop();
        }
    }
}
