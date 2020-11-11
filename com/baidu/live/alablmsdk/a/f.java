package com.baidu.live.alablmsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class f {
    private static f aAv;
    private Handler aAw;
    private HandlerThread aAx = new HandlerThread("blm_work_threads");

    private f() {
        this.aAx.start();
        this.aAw = new Handler(this.aAx.getLooper());
    }

    public static f Bj() {
        if (aAv == null) {
            synchronized (f.class) {
                if (aAv == null) {
                    aAv = new f();
                }
            }
        }
        return aAv;
    }

    public void post(Runnable runnable) {
        if (this.aAw != null) {
            this.aAw.post(runnable);
        }
    }

    public void release() {
        if (this.aAw != null) {
            this.aAw.removeCallbacksAndMessages(null);
            this.aAw = null;
        }
        if (this.aAx != null) {
            this.aAx.quit();
            this.aAx = null;
        }
        aAv = null;
    }
}
