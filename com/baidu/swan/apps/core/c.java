package com.baidu.swan.apps.core;

import android.os.Looper;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes10.dex */
public class c {
    private static long cHM;
    private static volatile int cHN = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.cHU) {
                switch (cHN) {
                    case 0:
                        cHN = 1;
                        cHM = System.currentTimeMillis();
                        ai(i, i2);
                        break;
                    case 1:
                        if ((cHM + 5000) - System.currentTimeMillis() < 0) {
                            cHN = 2;
                            ai(i, i2);
                            f.log("toast提示个数已达2个");
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void ai(@StringRes final int i, final int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            aj(i, i2);
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aj(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aj(@StringRes int i, int i2) {
        SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
        if (azy != null && !azy.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.k(azy, i).showToastBottom();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.k(azy, i).showToast();
                    return;
            }
        }
    }

    public static boolean amS() {
        return cHN < 2;
    }

    public static void reset() {
        cHN = 0;
        cHM = 0L;
    }
}
