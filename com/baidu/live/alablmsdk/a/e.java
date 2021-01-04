package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes11.dex */
public class e {
    private static e aBr;
    private Handler aBs;
    private HandlerThread aBt = new HandlerThread("blm_work_threads");

    private e() {
        this.aBt.start();
        this.aBs = new Handler(this.aBt.getLooper());
    }

    public static e Bl() {
        if (aBr == null) {
            synchronized (e.class) {
                if (aBr == null) {
                    aBr = new e();
                }
            }
        }
        return aBr;
    }

    public void post(Runnable runnable) {
        if (this.aBs != null) {
            this.aBs.post(runnable);
        }
    }

    public void release() {
        if (this.aBs != null) {
            this.aBs.removeCallbacksAndMessages(null);
            this.aBs = null;
        }
        if (this.aBt != null) {
            this.aBt.quit();
            this.aBt = null;
        }
        aBr = null;
    }
}
