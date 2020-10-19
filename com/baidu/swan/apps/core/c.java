package com.baidu.swan.apps.core;

import android.os.Looper;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes10.dex */
public class c {
    private static long ctu;
    private static volatile int ctv = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.ctD) {
                switch (ctv) {
                    case 0:
                        ctv = 1;
                        ctu = System.currentTimeMillis();
                        ah(i, i2);
                        break;
                    case 1:
                        if ((ctu + 5000) - System.currentTimeMillis() < 0) {
                            ctv = 2;
                            ah(i, i2);
                            f.log("toast提示个数已达2个");
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void ah(@StringRes final int i, final int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ai(i, i2);
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ai(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ai(@StringRes int i, int i2) {
        SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
        if (ave != null && !ave.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.k(ave, i).showToastBottom();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.k(ave, i).showToast();
                    return;
            }
        }
    }

    public static boolean aiy() {
        return ctv < 2;
    }

    public static void reset() {
        ctv = 0;
        ctu = 0L;
    }
}
