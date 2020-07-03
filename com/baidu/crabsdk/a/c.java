package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c alB;
    private static Context alC;
    private static ExecutorService alD;
    private static boolean an = false;
    public p alA;
    public l alz;

    private c(Context context) {
        alC = context;
        this.alA = new p(Looper.getMainLooper().getThread(), a.W);
        this.alz = new l(new d(this), context);
        if (alD == null) {
            alD = Executors.newSingleThreadExecutor();
        }
    }

    public static c Y(Context context) {
        if (alB == null) {
            synchronized (c.class) {
                if (alB == null) {
                    alB = new c(context);
                }
            }
        }
        return alB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a sX = a.sX();
        sX.alv = c;
        sX.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.alF.start();
            com.baidu.crabsdk.c.a.di("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.alF.stop();
        }
    }
}
