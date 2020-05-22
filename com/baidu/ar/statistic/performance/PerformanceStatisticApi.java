package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.f.d;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.ar.statistic.performance.a;
import java.util.Random;
/* loaded from: classes3.dex */
public class PerformanceStatisticApi implements f {
    private a.C0086a vo;
    private int vl = 0;
    private boolean vm = false;
    private a vn = new a();
    private d.a vp = new d.a();

    private void eO() {
        if (this.vo == null) {
            this.vo = new a.C0086a();
            this.vl++;
            this.vo.vw = this.vl;
            this.vn.vv.add(this.vo);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        try {
            if (this.vm) {
                eO();
                this.vo.vx = SystemClock.elapsedRealtime();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        try {
            if (this.vm) {
                eO();
                this.vo.vy = SystemClock.elapsedRealtime();
                if (this.vl >= 3) {
                    this.vn.vs = this.vp.vs;
                    this.vn.vr = this.vp.vr;
                    this.vn.vt = this.vp.vt;
                    this.vn.vu = this.vp.vu;
                    this.vn.vq = ARConfig.getARKey();
                    StatisticApi.onPerformance("performance_summary", this.vn.eP());
                    this.vn.eQ();
                    this.vl = 0;
                    this.vm = false;
                }
                this.vo = null;
            }
            if (!this.vm && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                this.vm = true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        try {
            if (this.vm) {
                eO();
                a.C0086a.C0087a c0087a = new a.C0086a.C0087a();
                c0087a.name = str;
                c0087a.vA = str2;
                c0087a.vB = j;
                c0087a.count = i;
                this.vo.vz.add(c0087a);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void switchCase(String str) {
        try {
            this.vn.vq = str;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
