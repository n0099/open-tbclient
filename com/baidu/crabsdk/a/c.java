package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class c {
    private static c aju;
    private static Context ajv;
    private static ExecutorService ajw;
    private static boolean an = false;
    public l ajs;
    public p ajt;

    private c(Context context) {
        ajv = context;
        this.ajt = new p(Looper.getMainLooper().getThread(), a.W);
        this.ajs = new l(new d(this), context);
        if (ajw == null) {
            ajw = Executors.newSingleThreadExecutor();
        }
    }

    public static c ah(Context context) {
        if (aju == null) {
            synchronized (c.class) {
                if (aju == null) {
                    aju = new c(context);
                }
            }
        }
        return aju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(long j, long j2, long j3, long j4) {
        ArrayList<String> c = p.c(j, j2);
        com.baidu.crabsdk.c.a.v("-BlockCanaryCore- threadStackEntries: size = " + c.size());
        if (c.isEmpty()) {
            return;
        }
        a st = a.st();
        st.ajo = c;
        st.a(j, j2, j3, j4);
    }

    public static void start() {
        an = true;
        if (Build.VERSION.SDK_INT >= 16) {
            e.ajy.start();
            com.baidu.crabsdk.c.a.de("start FrameMonitor...");
        }
    }

    public static void stop() {
        an = false;
        if (Build.VERSION.SDK_INT >= 16) {
            e.ajy.stop();
        }
    }
}
