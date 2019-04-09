package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c aaY;
    private static Context aaZ;
    private static ExecutorService aba;
    private static boolean al = false;
    public l aaW;
    public p aaX;

    private c(Context context) {
        aaZ = context;
        this.aaX = new p(Looper.getMainLooper().getThread(), a.U);
        this.aaW = new l(new d(this), context);
        if (aba == null) {
            aba = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a rJ = a.rJ();
        rJ.aaS = c;
        rJ.a(j, j2, j3, j4);
    }

    public static c ba(Context context) {
        if (aaY == null) {
            synchronized (c.class) {
                if (aaY == null) {
                    aaY = new c(context);
                }
            }
        }
        return aaY;
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.abd.start();
            com.baidu.crabsdk.c.a.cv("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.abd.stop();
        }
    }
}
