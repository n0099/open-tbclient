package com.baidu.rtc.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes10.dex */
public class f {
    private int czO;
    private Handler czQ;
    private long czN = 0;
    private e ctO = null;
    private Runnable czP = new Runnable() { // from class: com.baidu.rtc.b.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.aft();
            f.this.czQ.postDelayed(f.this.czP, 5000L);
        }
    };

    public f(int i) {
        this.czQ = null;
        this.czO = 600;
        this.czQ = new Handler(Looper.getMainLooper());
        this.czO = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.czN > this.czO && this.ctO != null) {
            this.ctO.m(this.czN, currentTimeMillis);
        }
        this.czN = System.currentTimeMillis();
    }

    public void afu() {
        if (this.czN <= 0) {
            this.czQ.postDelayed(this.czP, 5000L);
            this.czN = System.currentTimeMillis();
            return;
        }
        this.czQ.removeCallbacks(this.czP);
        aft();
        this.czQ.postDelayed(this.czP, 5000L);
    }

    public void reset() {
        this.czN = 0L;
        this.czQ.removeCallbacks(this.czP);
    }

    public void setStuckEventListener(e eVar) {
        this.ctO = eVar;
    }
}
