package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c QT;
    private static Context QU;
    private static ExecutorService QV;
    private static boolean al = false;
    public l QR;
    public p QS;

    private c(Context context) {
        QU = context;
        this.QS = new p(Looper.getMainLooper().getThread(), a.U);
        this.QR = new l(new d(this), context);
        if (QV == null) {
            QV = Executors.newSingleThreadExecutor();
        }
    }

    public static c as(Context context) {
        if (QT == null) {
            synchronized (c.class) {
                if (QT == null) {
                    QT = new c(context);
                }
            }
        }
        return QT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a nZ = a.nZ();
        nZ.QM = c;
        nZ.a(j, j2, j3, j4);
    }

    public static void start() {
        al = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.QX.start();
            com.baidu.crabsdk.c.a.cj("start FrameMonitor...");
        }
    }

    public static void stop() {
        al = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.QX.stop();
        }
    }
}
