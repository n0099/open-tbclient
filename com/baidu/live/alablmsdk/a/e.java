package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes11.dex */
public class e {
    private static e awt;
    private Handler awu;
    private HandlerThread awv = new HandlerThread("blm_work_threads");

    private e() {
        this.awv.start();
        this.awu = new Handler(this.awv.getLooper());
    }

    public static e xq() {
        if (awt == null) {
            synchronized (e.class) {
                if (awt == null) {
                    awt = new e();
                }
            }
        }
        return awt;
    }

    public void post(Runnable runnable) {
        if (this.awu != null) {
            this.awu.post(runnable);
        }
    }

    public void release() {
        if (this.awu != null) {
            this.awu.removeCallbacksAndMessages(null);
            this.awu = null;
        }
        if (this.awv != null) {
            this.awv.quit();
            this.awv = null;
        }
        awt = null;
    }
}
