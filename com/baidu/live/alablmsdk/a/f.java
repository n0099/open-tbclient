package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class f {
    private static f ayK;
    private Handler ayL;
    private HandlerThread ayM = new HandlerThread("blm_work_threads");

    private f() {
        this.ayM.start();
        this.ayL = new Handler(this.ayM.getLooper());
    }

    public static f AA() {
        if (ayK == null) {
            synchronized (f.class) {
                if (ayK == null) {
                    ayK = new f();
                }
            }
        }
        return ayK;
    }

    public void post(Runnable runnable) {
        if (this.ayL != null) {
            this.ayL.post(runnable);
        }
    }

    public void release() {
        if (this.ayL != null) {
            this.ayL.removeCallbacksAndMessages(null);
            this.ayL = null;
        }
        if (this.ayM != null) {
            this.ayM.quit();
            this.ayM = null;
        }
        ayK = null;
    }
}
