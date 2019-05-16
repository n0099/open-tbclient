package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c YQ;
    private static Context YR;
    private static ExecutorService YS;
    private static boolean al = false;
    public l YO;
    public p YP;

    private c(Context context) {
        YR = context;
        this.YP = new p(Looper.getMainLooper().getThread(), a.U);
        this.YO = new l(new d(this), context);
        if (YS == null) {
            YS = Executors.newSingleThreadExecutor();
        }
    }

    public static c as(Context context) {
        if (YQ == null) {
            synchronized (c.class) {
                if (YQ == null) {
                    YQ = new c(context);
                }
            }
        }
        return YQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a qE = a.qE();
        qE.YK = c;
        qE.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.YU.start();
            com.baidu.crabsdk.c.a.cf("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.YU.stop();
        }
    }
}
