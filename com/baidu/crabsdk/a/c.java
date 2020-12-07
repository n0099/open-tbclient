package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static boolean an = false;
    private static c aoH;
    private static Context aoI;
    private static ExecutorService aoJ;
    public l aoF;
    public p aoG;

    private c(Context context) {
        aoI = context;
        this.aoG = new p(Looper.getMainLooper().getThread(), a.W);
        this.aoF = new l(new d(this), context);
        if (aoJ == null) {
            aoJ = Executors.newSingleThreadExecutor();
        }
    }

    public static c ae(Context context) {
        if (aoH == null) {
            synchronized (c.class) {
                if (aoH == null) {
                    aoH = new c(context);
                }
            }
        }
        return aoH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a uS = a.uS();
        uS.aoB = c;
        uS.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoL.start();
            com.baidu.crabsdk.c.a.dE("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.aoL.stop();
        }
    }
}
