package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c YP;
    private static Context YQ;
    private static ExecutorService YR;
    private static boolean al = false;
    public l YN;
    public p YO;

    private c(Context context) {
        YQ = context;
        this.YO = new p(Looper.getMainLooper().getThread(), a.U);
        this.YN = new l(new d(this), context);
        if (YR == null) {
            YR = Executors.newSingleThreadExecutor();
        }
    }

    public static c as(Context context) {
        if (YP == null) {
            synchronized (c.class) {
                if (YP == null) {
                    YP = new c(context);
                }
            }
        }
        return YP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a qE = a.qE();
        qE.YJ = c;
        qE.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.YT.start();
            com.baidu.crabsdk.c.a.cf("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.YT.stop();
        }
    }
}
