package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class c {
    private static boolean an = false;
    private static c apK;
    private static Context apL;
    private static ExecutorService apM;
    public l apI;
    public p apJ;

    private c(Context context) {
        apL = context;
        this.apJ = new p(Looper.getMainLooper().getThread(), a.W);
        this.apI = new l(new d(this), context);
        if (apM == null) {
            apM = Executors.newSingleThreadExecutor();
        }
    }

    public static c ac(Context context) {
        if (apK == null) {
            synchronized (c.class) {
                if (apK == null) {
                    apK = new c(context);
                }
            }
        }
        return apK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> f = p.f(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + f.size());
        if (f.isEmpty()) {
            return;
        }
        a uh = a.uh();
        uh.apE = f;
        uh.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.apO.start();
            com.baidu.crabsdk.c.a.dw("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.apO.stop();
        }
    }
}
