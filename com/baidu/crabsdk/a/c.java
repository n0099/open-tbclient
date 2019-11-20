package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c IH;
    private static Context II;
    private static ExecutorService IJ;
    private static boolean al = false;
    public l IF;
    public p IG;

    private c(Context context) {
        II = context;
        this.IG = new p(Looper.getMainLooper().getThread(), a.U);
        this.IF = new l(new d(this), context);
        if (IJ == null) {
            IJ = Executors.newSingleThreadExecutor();
        }
    }

    public static c aj(Context context) {
        if (IH == null) {
            synchronized (c.class) {
                if (IH == null) {
                    IH = new c(context);
                }
            }
        }
        return IH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a mh = a.mh();
        mh.IA = c;
        mh.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.IL.start();
            com.baidu.crabsdk.c.a.bu("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.IL.stop();
        }
    }
}
