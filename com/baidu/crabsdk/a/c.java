package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class c {
    private static c RU;
    private static Context RV;
    private static ExecutorService RW;
    private static boolean ak = false;
    public l RR;
    public p RT;

    private c(Context context) {
        RV = context;
        this.RT = new p(Looper.getMainLooper().getThread(), a.T);
        this.RR = new l(new d(this), context);
        if (RW == null) {
            RW = Executors.newSingleThreadExecutor();
        }
    }

    public static c at(Context context) {
        if (RU == null) {
            synchronized (c.class) {
                if (RU == null) {
                    RU = new c(context);
                }
            }
        }
        return RU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cd("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a oS = a.oS();
        oS.RL = b;
        oS.a(j, j2, j3, j4);
    }

    public static void start() {
        ak = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.RY.start();
            com.baidu.crabsdk.c.a.cb("start FrameMonitor...");
        }
    }

    public static void stop() {
        ak = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.RY.stop();
        }
    }
}
