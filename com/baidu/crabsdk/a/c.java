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
    private static c aok;
    private static Context aol;
    private static ExecutorService aom;
    public l aoi;
    public p aoj;

    private c(Context context) {
        aol = context;
        this.aoj = new p(Looper.getMainLooper().getThread(), a.W);
        this.aoi = new l(new d(this), context);
        if (aom == null) {
            aom = Executors.newSingleThreadExecutor();
        }
    }

    public static c ad(Context context) {
        if (aok == null) {
            synchronized (c.class) {
                if (aok == null) {
                    aok = new c(context);
                }
            }
        }
        return aok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> f = p.f(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + f.size());
        if (f.isEmpty()) {
            return;
        }
        a uh = a.uh();
        uh.aoe = f;
        uh.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoo.start();
            com.baidu.crabsdk.c.a.ds("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoo.stop();
        }
    }
}
