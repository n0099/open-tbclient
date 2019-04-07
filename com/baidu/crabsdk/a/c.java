package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c aaX;
    private static Context aaY;
    private static ExecutorService aaZ;
    private static boolean al = false;
    public l aaV;
    public p aaW;

    private c(Context context) {
        aaY = context;
        this.aaW = new p(Looper.getMainLooper().getThread(), a.U);
        this.aaV = new l(new d(this), context);
        if (aaZ == null) {
            aaZ = Executors.newSingleThreadExecutor();
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
        rJ.aaR = c;
        rJ.a(j, j2, j3, j4);
    }

    public static c ba(Context context) {
        if (aaX == null) {
            synchronized (c.class) {
                if (aaX == null) {
                    aaX = new c(context);
                }
            }
        }
        return aaX;
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.abb.start();
            com.baidu.crabsdk.c.a.cv("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.abb.stop();
        }
    }
}
