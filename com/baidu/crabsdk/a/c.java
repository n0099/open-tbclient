package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class c {
    private static c Pk;
    private static Context Pl;
    private static ExecutorService Pm;
    private static boolean al = false;
    public l Pi;
    public p Pj;

    private c(Context context) {
        Pl = context;
        this.Pj = new p(Looper.getMainLooper().getThread(), a.U);
        this.Pi = new l(new d(this), context);
        if (Pm == null) {
            Pm = Executors.newSingleThreadExecutor();
        }
    }

    public static c aq(Context context) {
        if (Pk == null) {
            synchronized (c.class) {
                if (Pk == null) {
                    Pk = new c(context);
                }
            }
        }
        return Pk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a nr = a.nr();
        nr.Pe = c;
        nr.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Po.start();
            com.baidu.crabsdk.c.a.cb("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Po.stop();
        }
    }
}
