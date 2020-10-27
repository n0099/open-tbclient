package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class c {
    private static boolean an = false;
    private static c anN;
    private static Context anO;
    private static ExecutorService anP;
    public l anL;
    public p anM;

    private c(Context context) {
        anO = context;
        this.anM = new p(Looper.getMainLooper().getThread(), a.W);
        this.anL = new l(new d(this), context);
        if (anP == null) {
            anP = Executors.newSingleThreadExecutor();
        }
    }

    public static c ad(Context context) {
        if (anN == null) {
            synchronized (c.class) {
                if (anN == null) {
                    anN = new c(context);
                }
            }
        }
        return anN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a ve = a.ve();
        ve.anH = c;
        ve.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anR.start();
            com.baidu.crabsdk.c.a.dA("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anR.stop();
        }
    }
}
