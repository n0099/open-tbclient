package com.baidu.rtc.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes9.dex */
public class f {
    private int cBo;
    private Handler cBq;
    private long cBn = 0;
    private e cvq = null;
    private Runnable cBp = new Runnable() { // from class: com.baidu.rtc.b.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.afw();
            f.this.cBq.postDelayed(f.this.cBp, 5000L);
        }
    };

    public f(int i) {
        this.cBq = null;
        this.cBo = 600;
        this.cBq = new Handler(Looper.getMainLooper());
        this.cBo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cBn > this.cBo && this.cvq != null) {
            this.cvq.m(this.cBn, currentTimeMillis);
        }
        this.cBn = System.currentTimeMillis();
    }

    public void afx() {
        if (this.cBn <= 0) {
            this.cBq.postDelayed(this.cBp, 5000L);
            this.cBn = System.currentTimeMillis();
            return;
        }
        this.cBq.removeCallbacks(this.cBp);
        afw();
        this.cBq.postDelayed(this.cBp, 5000L);
    }

    public void reset() {
        this.cBn = 0L;
        this.cBq.removeCallbacks(this.cBp);
    }

    public void setStuckEventListener(e eVar) {
        this.cvq = eVar;
    }
}
