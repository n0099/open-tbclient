package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class c {
    private static c RW;
    private static Context RX;
    private static ExecutorService RY;
    private static boolean ak = false;
    public l RU;
    public p RV;

    private c(Context context) {
        RX = context;
        this.RV = new p(Looper.getMainLooper().getThread(), a.T);
        this.RU = new l(new d(this), context);
        if (RY == null) {
            RY = Executors.newSingleThreadExecutor();
        }
    }

    public static c at(Context context) {
        if (RW == null) {
            synchronized (c.class) {
                if (RW == null) {
                    RW = new c(context);
                }
            }
        }
        return RW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cf("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a oS = a.oS();
        oS.RP = b;
        oS.a(j, j2, j3, j4);
    }

    public static void start() {
        ak = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Sa.start();
            com.baidu.crabsdk.c.a.cd("start FrameMonitor...");
        }
    }

    public static void stop() {
        ak = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Sa.stop();
        }
    }
}
