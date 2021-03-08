package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes10.dex */
public class e {
    private static e axT;
    private Handler axU;
    private HandlerThread axV = new HandlerThread("blm_work_threads");

    private e() {
        this.axV.start();
        this.axU = new Handler(this.axV.getLooper());
    }

    public static e xt() {
        if (axT == null) {
            synchronized (e.class) {
                if (axT == null) {
                    axT = new e();
                }
            }
        }
        return axT;
    }

    public void post(Runnable runnable) {
        if (this.axU != null) {
            this.axU.post(runnable);
        }
    }

    public void release() {
        if (this.axU != null) {
            this.axU.removeCallbacksAndMessages(null);
            this.axU = null;
        }
        if (this.axV != null) {
            this.axV.quit();
            this.axV = null;
        }
        axT = null;
    }
}
