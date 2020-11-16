package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class c {
    private static boolean an = false;
    private static c anT;
    private static Context anU;
    private static ExecutorService anV;
    public l anR;
    public p anS;

    private c(Context context) {
        anU = context;
        this.anS = new p(Looper.getMainLooper().getThread(), a.W);
        this.anR = new l(new d(this), context);
        if (anV == null) {
            anV = Executors.newSingleThreadExecutor();
        }
    }

    public static c ad(Context context) {
        if (anT == null) {
            synchronized (c.class) {
                if (anT == null) {
                    anT = new c(context);
                }
            }
        }
        return anT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a vd = a.vd();
        vd.anN = c;
        vd.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anX.start();
            com.baidu.crabsdk.c.a.dC("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.anX.stop();
        }
    }
}
