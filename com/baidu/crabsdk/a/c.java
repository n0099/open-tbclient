package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c QW;
    private static Context QX;
    private static ExecutorService QY;
    private static boolean an = false;
    public l QU;
    public p QV;

    private c(Context context) {
        QX = context;
        this.QV = new p(Looper.getMainLooper().getThread(), a.W);
        this.QU = new l(new d(this), context);
        if (QY == null) {
            QY = Executors.newSingleThreadExecutor();
        }
    }

    public static c as(Context context) {
        if (QW == null) {
            synchronized (c.class) {
                if (QW == null) {
                    QW = new c(context);
                }
            }
        }
        return QW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a nY = a.nY();
        nY.QP = c;
        nY.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Ra.start();
            com.baidu.crabsdk.c.a.cj("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.Ra.stop();
        }
    }
}
