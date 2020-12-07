package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class e {
    private static e aBa;
    private Handler aBb;
    private HandlerThread aBc = new HandlerThread("blm_work_threads");

    private e() {
        this.aBc.start();
        this.aBb = new Handler(this.aBc.getLooper());
    }

    public static e BU() {
        if (aBa == null) {
            synchronized (e.class) {
                if (aBa == null) {
                    aBa = new e();
                }
            }
        }
        return aBa;
    }

    public void post(Runnable runnable) {
        if (this.aBb != null) {
            this.aBb.post(runnable);
        }
    }

    public void release() {
        if (this.aBb != null) {
            this.aBb.removeCallbacksAndMessages(null);
            this.aBb = null;
        }
        if (this.aBc != null) {
            this.aBc.quit();
            this.aBc = null;
        }
        aBa = null;
    }
}
