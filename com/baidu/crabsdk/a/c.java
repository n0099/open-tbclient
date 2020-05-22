package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c ake;
    private static Context akf;
    private static ExecutorService akg;
    private static boolean an = false;
    public l akc;
    public p akd;

    private c(Context context) {
        akf = context;
        this.akd = new p(Looper.getMainLooper().getThread(), a.W);
        this.akc = new l(new d(this), context);
        if (akg == null) {
            akg = Executors.newSingleThreadExecutor();
        }
    }

    public static c X(Context context) {
        if (ake == null) {
            synchronized (c.class) {
                if (ake == null) {
                    ake = new c(context);
                }
            }
        }
        return ake;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a sC = a.sC();
        sC.ajY = c;
        sC.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aki.start();
            com.baidu.crabsdk.c.a.dg("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aki.stop();
        }
    }
}
