package com.baidu.swan.apps.core;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes9.dex */
public class c {
    private static long cRR;
    private static volatile int cRS = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.cRZ) {
                switch (cRS) {
                    case 0:
                        cRS = 1;
                        cRR = System.currentTimeMillis();
                        af(i, i2);
                        break;
                    case 1:
                        if ((cRR + 5000) - System.currentTimeMillis() < 0) {
                            cRS = 2;
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
        SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
        if (aDr != null && !aDr.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.u(aDr, i).aLV();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.u(aDr, i).aLT();
                    return;
            }
        }
    }

    public static boolean aqG() {
        return cRS < 2;
    }

    public static void reset() {
        cRS = 0;
        cRR = 0L;
    }
}
