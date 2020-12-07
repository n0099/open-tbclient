package com.baidu.swan.apps.core;

import android.os.Looper;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes25.dex */
public class c {
    private static long cMW;
    private static volatile int cMX = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.cNe) {
                switch (cMX) {
                    case 0:
                        cMX = 1;
                        cMW = System.currentTimeMillis();
                        ak(i, i2);
                        break;
                    case 1:
                        if ((cMW + 5000) - System.currentTimeMillis() < 0) {
                            cMX = 2;
                            ak(i, i2);
                            f.log("toast提示个数已达2个");
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void ak(@StringRes final int i, final int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            al(i, i2);
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.al(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void al(@StringRes int i, int i2) {
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (aBZ != null && !aBZ.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.t(aBZ, i).showToastBottom();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.t(aBZ, i).showToast();
                    return;
            }
        }
    }

    public static boolean apt() {
        return cMX < 2;
    }

    public static void reset() {
        cMX = 0;
        cMW = 0L;
    }
}
