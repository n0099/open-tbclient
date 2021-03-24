package com.baidu.rtc.logreport;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class StuckDataCalculator {
    public int stuckInterval;
    public Handler stuckTimer;
    public long frameStartTime = 0;
    public SLIReportInterface mStuckEvent = null;
    public Runnable stuckRunnable = new Runnable() { // from class: com.baidu.rtc.logreport.StuckDataCalculator.1
        @Override // java.lang.Runnable
        public void run() {
            StuckDataCalculator.this.reportStuckData();
            StuckDataCalculator.this.stuckTimer.postDelayed(StuckDataCalculator.this.stuckRunnable, 5000L);
        }
    };

    public StuckDataCalculator(int i) {
        this.stuckTimer = null;
        this.stuckInterval = 600;
        this.stuckTimer = new Handler(Looper.getMainLooper());
        this.stuckInterval = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportStuckData() {
        SLIReportInterface sLIReportInterface;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.frameStartTime;
        if (currentTimeMillis - j > this.stuckInterval && (sLIReportInterface = this.mStuckEvent) != null) {
            sLIReportInterface.onStuckData(j, currentTimeMillis);
        }
        this.frameStartTime = System.currentTimeMillis();
    }

    public void calculateStuck() {
        int i = (this.frameStartTime > 0L ? 1 : (this.frameStartTime == 0L ? 0 : -1));
        Handler handler = this.stuckTimer;
        Runnable runnable = this.stuckRunnable;
        if (i <= 0) {
            handler.postDelayed(runnable, 5000L);
            this.frameStartTime = System.currentTimeMillis();
            return;
        }
        handler.removeCallbacks(runnable);
        reportStuckData();
        this.stuckTimer.postDelayed(this.stuckRunnable, 5000L);
    }

    public void reset() {
        this.frameStartTime = 0L;
        this.stuckTimer.removeCallbacks(this.stuckRunnable);
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        this.mStuckEvent = sLIReportInterface;
    }
}
