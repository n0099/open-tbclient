package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class c {
    private static c Ux;
    private static Context Uy;
    private static ExecutorService Uz;
    private static boolean ak = false;
    public l Uv;
    public p Uw;

    private c(Context context) {
        Uy = context;
        this.Uw = new p(Looper.getMainLooper().getThread(), a.T);
        this.Uv = new l(new d(this), context);
        if (Uz == null) {
            Uz = Executors.newSingleThreadExecutor();
        }
    }

    public static c aZ(Context context) {
        if (Ux == null) {
            synchronized (c.class) {
                if (Ux == null) {
                    Ux = new c(context);
                }
            }
        }
        return Ux;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> b = p.b(j, j2);
        com.baidu.crabsdk.c.a.cx("-BlockCanaryCore- threadStackEntries: size = " + b.size());
        if (b.isEmpty()) {
            return;
        }
        a pY = a.pY();
        pY.Ur = b;
        pY.a(j, j2, j3, j4);
    }

    public static void start() {
        ak = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.UC.start();
            com.baidu.crabsdk.c.a.cv("start FrameMonitor...");
        }
    }

    public static void stop() {
        ak = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.UC.stop();
        }
    }
}
