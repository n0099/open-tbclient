package com.baidu.swan.apps.core;

import android.os.Looper;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.d;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public class b {
    private static long bZj;
    private static volatile int bZk = 0;

    public static synchronized void showToast(@StringRes int i) {
        synchronized (b.class) {
            if (d.a.bZq) {
                switch (bZk) {
                    case 0:
                        bZk = 1;
                        bZj = System.currentTimeMillis();
                        eS(i);
                        break;
                    case 1:
                        if ((bZj + 5000) - System.currentTimeMillis() < 0) {
                            bZk = 2;
                            eS(i);
                            break;
                        }
                        break;
                }
            }
        }
    }

    private static void eS(@StringRes final int i) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            eT(i);
        } else {
            al.p(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.eT(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eT(@StringRes int i) {
        SwanAppActivity akb = f.akr().akb();
        if (akb != null && !akb.isFinishing()) {
            com.baidu.swan.apps.res.widget.b.d.k(akb, i).showToast();
        }
    }

    public static void reset() {
        bZk = 0;
        bZj = 0L;
    }
}
