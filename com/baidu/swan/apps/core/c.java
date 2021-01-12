package com.baidu.swan.apps.core;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes8.dex */
public class c {
    private static long cNf;
    private static volatile int cNg = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.cNn) {
                switch (cNg) {
                    case 0:
                        cNg = 1;
                        cNf = System.currentTimeMillis();
                        af(i, i2);
                        break;
                    case 1:
                        if ((cNf + 5000) - System.currentTimeMillis() < 0) {
                            cNg = 2;
                            af(i, i2);
                            f.log("toast提示个数已达2个");
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void af(@StringRes final int i, final int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ag(i, i2);
        } else {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.core.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ag(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ag(@StringRes int i, int i2) {
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx != null && !azx.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.u(azx, i).aIb();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.u(azx, i).aHZ();
                    return;
            }
        }
    }

    public static boolean amL() {
        return cNg < 2;
    }

    public static void reset() {
        cNg = 0;
        cNf = 0L;
    }
}
