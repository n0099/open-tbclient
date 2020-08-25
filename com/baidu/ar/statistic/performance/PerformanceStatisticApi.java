package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.g.f;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.ar.statistic.performance.a;
import java.util.Random;
/* loaded from: classes11.dex */
public class PerformanceStatisticApi implements f {
    private a.C0085a wr;
    private int wo = 0;
    private boolean wp = false;
    private a wq = new a();
    private f.a ws = new f.a();

    private void gs() {
        if (this.wr == null) {
            this.wr = new a.C0085a();
            this.wo++;
            this.wr.wz = this.wo;
            this.wq.wy.add(this.wr);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        try {
            if (this.wp) {
                gs();
                this.wr.wA = SystemClock.elapsedRealtime();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        try {
            if (this.wp) {
                gs();
                this.wr.wB = SystemClock.elapsedRealtime();
                if (this.wo >= 3) {
                    this.wq.wv = this.ws.wv;
                    this.wq.wu = this.ws.wu;
                    this.wq.ww = this.ws.ww;
                    this.wq.wx = this.ws.wx;
                    this.wq.wt = ARConfig.getARKey();
                    StatisticApi.onPerformance("performance_summary", this.wq.gt());
                    this.wq.gu();
                    this.wo = 0;
                    this.wp = false;
                }
                this.wr = null;
            }
            if (!this.wp && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                this.wp = true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        try {
            if (this.wp) {
                gs();
                a.C0085a.C0086a c0086a = new a.C0085a.C0086a();
                c0086a.name = str;
                c0086a.wD = str2;
                c0086a.wE = j;
                c0086a.count = i;
                this.wr.wC.add(c0086a);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void switchCase(String str) {
        try {
            this.wq.wt = str;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
