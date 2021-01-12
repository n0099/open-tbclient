package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes10.dex */
public class e {
    private static e awE;
    private Handler awF;
    private HandlerThread awG = new HandlerThread("blm_work_threads");

    private e() {
        this.awG.start();
        this.awF = new Handler(this.awG.getLooper());
    }

    public static e xq() {
        if (awE == null) {
            synchronized (e.class) {
                if (awE == null) {
                    awE = new e();
                }
            }
        }
        return awE;
    }

    public void post(Runnable runnable) {
        if (this.awF != null) {
            this.awF.post(runnable);
        }
    }

    public void release() {
        if (this.awF != null) {
            this.awF.removeCallbacksAndMessages(null);
            this.awF = null;
        }
        if (this.awG != null) {
            this.awG.quit();
            this.awG = null;
        }
        awE = null;
    }
}
