package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static boolean an = false;
    private static c aph;
    private static Context api;
    private static ExecutorService apj;
    public l apf;
    public p apg;

    private c(Context context) {
        api = context;
        this.apg = new p(Looper.getMainLooper().getThread(), a.W);
        this.apf = new l(new d(this), context);
        if (apj == null) {
            apj = Executors.newSingleThreadExecutor();
        }
    }

    public static c ae(Context context) {
        if (aph == null) {
            synchronized (c.class) {
                if (aph == null) {
                    aph = new c(context);
                }
            }
        }
        return aph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> f = p.f(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + f.size());
        if (f.isEmpty()) {
            return;
        }
        a ur = a.ur();
        ur.apb = f;
        ur.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.apm.start();
            com.baidu.crabsdk.c.a.dx("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.apm.stop();
        }
    }
}
