package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class c {
    private static c Zk;
    private static Context Zl;
    private static ExecutorService Zm;
    private static boolean al = false;
    public l Zi;
    public p Zj;

    private c(Context context) {
        Zl = context;
        this.Zj = new p(Looper.getMainLooper().getThread(), a.U);
        this.Zi = new l(new d(this), context);
        if (Zm == null) {
            Zm = Executors.newSingleThreadExecutor();
        }
    }

    public static c as(Context context) {
        if (Zk == null) {
            synchronized (c.class) {
                if (Zk == null) {
                    Zk = new c(context);
                }
            }
        }
        return Zk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a rb = a.rb();
        rb.Ze = c;
        rb.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Zo.start();
            com.baidu.crabsdk.c.a.ch("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Zo.stop();
        }
    }
}
