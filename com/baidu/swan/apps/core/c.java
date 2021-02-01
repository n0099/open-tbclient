package com.baidu.swan.apps.core;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.f;
/* loaded from: classes9.dex */
public class c {
    private static long cPt;
    private static volatile int cPu = 0;

    public static void showToast(@StringRes int i) {
        showToast(i, 0);
    }

    private static synchronized void showToast(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.a.cPB) {
                switch (cPu) {
                    case 0:
                        cPu = 1;
                        cPt = System.currentTimeMillis();
                        ac(i, i2);
                        break;
                    case 1:
                        if ((cPt + 5000) - System.currentTimeMillis() < 0) {
                            cPu = 2;
                            ac(i, i2);
                            f.log("toast提示个数已达2个");
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void ac(@StringRes final int i, final int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ad(i, i2);
        } else {
            ak.k(new Runnable() { // from class: com.baidu.swan.apps.core.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ad(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ad(@StringRes int i, int i2) {
        SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
        if (azV != null && !azV.isFinishing()) {
            switch (i2) {
                case 1:
                    com.baidu.swan.apps.res.widget.b.d.u(azV, i).aIu();
                    return;
                default:
                    com.baidu.swan.apps.res.widget.b.d.u(azV, i).aIs();
                    return;
            }
        }
    }

    public static boolean anj() {
        return cPu < 2;
    }

    public static void reset() {
        cPu = 0;
        cPt = 0L;
    }
}
