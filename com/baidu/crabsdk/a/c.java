package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes14.dex */
public class c {
    private static boolean an = false;
    private static c aou;
    private static Context aov;
    private static ExecutorService aow;
    public l aos;
    public p aot;

    private c(Context context) {
        aov = context;
        this.aot = new p(Looper.getMainLooper().getThread(), a.W);
        this.aos = new l(new d(this), context);
        if (aow == null) {
            aow = Executors.newSingleThreadExecutor();
        }
    }

    public static c ad(Context context) {
        if (aou == null) {
            synchronized (c.class) {
                if (aou == null) {
                    aou = new c(context);
                }
            }
        }
        return aou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> f = p.f(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + f.size());
        if (f.isEmpty()) {
            return;
        }
        a uk = a.uk();
        uk.aoo = f;
        uk.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoy.start();
            com.baidu.crabsdk.c.a.ds("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoy.stop();
        }
    }
}
