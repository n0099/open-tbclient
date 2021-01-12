package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.h.f;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.ar.statistic.performance.a;
import java.util.Random;
/* loaded from: classes6.dex */
public class PerformanceStatisticApi implements f {
    private a.C0081a xf;
    private int xc = 0;
    private boolean xd = false;
    private a xe = new a();
    private f.a xg = new f.a();

    private void gs() {
        if (this.xf == null) {
            this.xf = new a.C0081a();
            this.xc++;
            this.xf.xn = this.xc;
            this.xe.xm.add(this.xf);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        try {
            if (this.xd) {
                gs();
                this.xf.xo = SystemClock.elapsedRealtime();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        try {
            if (this.xd) {
                gs();
                this.xf.xp = SystemClock.elapsedRealtime();
                if (this.xc >= 3) {
                    this.xe.xj = this.xg.xj;
                    this.xe.xi = this.xg.xi;
                    this.xe.xk = this.xg.xk;
                    this.xe.xl = this.xg.xl;
                    this.xe.xh = ARConfig.getARKey();
                    StatisticApi.onPerformance("performance_summary", this.xe.gt());
                    this.xe.gu();
                    this.xc = 0;
                    this.xd = false;
                }
                this.xf = null;
            }
            if (!this.xd && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                this.xd = true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        try {
            if (this.xd) {
                gs();
                a.C0081a.C0082a c0082a = new a.C0081a.C0082a();
                c0082a.name = str;
                c0082a.xr = str2;
                c0082a.xs = j;
                c0082a.count = i;
                this.xf.xq.add(c0082a);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void switchCase(String str) {
        try {
            this.xe.xh = str;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
