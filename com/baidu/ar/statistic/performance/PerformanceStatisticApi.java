package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.f.d;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.ar.statistic.performance.a;
import java.util.Random;
/* loaded from: classes11.dex */
public class PerformanceStatisticApi implements f {
    private a.C0088a vO;
    private int vL = 0;
    private boolean vM = false;
    private a vN = new a();
    private d.a vP = new d.a();

    private void fe() {
        if (this.vO == null) {
            this.vO = new a.C0088a();
            this.vL++;
            this.vO.vW = this.vL;
            this.vN.vV.add(this.vO);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        try {
            if (this.vM) {
                fe();
                this.vO.vX = SystemClock.elapsedRealtime();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        try {
            if (this.vM) {
                fe();
                this.vO.vY = SystemClock.elapsedRealtime();
                if (this.vL >= 3) {
                    this.vN.vS = this.vP.vS;
                    this.vN.vR = this.vP.vR;
                    this.vN.vT = this.vP.vT;
                    this.vN.vU = this.vP.vU;
                    this.vN.vQ = ARConfig.getARKey();
                    StatisticApi.onPerformance("performance_summary", this.vN.ff());
                    this.vN.fg();
                    this.vL = 0;
                    this.vM = false;
                }
                this.vO = null;
            }
            if (!this.vM && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                this.vM = true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        try {
            if (this.vM) {
                fe();
                a.C0088a.C0089a c0089a = new a.C0088a.C0089a();
                c0089a.name = str;
                c0089a.wa = str2;
                c0089a.wb = j;
                c0089a.count = i;
                this.vO.vZ.add(c0089a);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void switchCase(String str) {
        try {
            this.vN.vQ = str;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
