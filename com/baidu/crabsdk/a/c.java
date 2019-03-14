package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c aaW;
    private static Context aaX;
    private static ExecutorService aaY;
    private static boolean al = false;
    public l aaU;
    public p aaV;

    private c(Context context) {
        aaX = context;
        this.aaV = new p(Looper.getMainLooper().getThread(), a.U);
        this.aaU = new l(new d(this), context);
        if (aaY == null) {
            aaY = Executors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.cx("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a rJ = a.rJ();
        rJ.aaQ = c;
        rJ.a(j, j2, j3, j4);
    }

    public static c ba(Context context) {
        if (aaW == null) {
            synchronized (c.class) {
                if (aaW == null) {
                    aaW = new c(context);
                }
            }
        }
        return aaW;
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aba.start();
            com.baidu.crabsdk.c.a.cv("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aba.stop();
        }
    }
}
