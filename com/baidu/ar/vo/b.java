package com.baidu.ar.vo;

import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.vo.b.g;
import com.baidu.ar.vo.c.c;
import com.baidu.ar.vo.c.d;
import com.baidu.ar.vo.c.e;
import com.baidu.ar.vo.c.f;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b {
    private d xi;
    private c xj;
    private com.baidu.ar.vo.b.d xk;
    private volatile boolean xm;
    private volatile boolean xl = false;
    private volatile boolean xn = false;

    public b(d dVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.b.d dVar2) {
        this.xm = true;
        this.xi = dVar;
        this.xk = dVar2;
        if (bVar != null) {
            this.xm = bVar.fS();
        }
        this.xj = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar) {
        if (bVar == null) {
            return new com.baidu.ar.vo.c.a(this.xi, this.xk.xC, this.xk.xD);
        }
        if (bVar.fO() == 1) {
            f fVar = new f(this.xi, bVar, this.xk.xC, this.xk.xD);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.fO() == 0) {
            return new e(this.xi, bVar, this.xk.xC, this.xk.xD);
        } else {
            return null;
        }
    }

    private float[] a(g gVar) {
        ArrayList<TrackModel> fV = gVar.fV();
        return (fV == null || fV.isEmpty()) ? new float[0] : fV.get(0).getPose();
    }

    public void W(boolean z) {
        this.xn = z;
    }

    public void a(com.baidu.ar.vo.b.f fVar, float[] fArr) {
        float[] a;
        if (!this.xm || this.xn) {
            return;
        }
        g fU = fVar.fU();
        if (this.xl) {
            if (fU == null || (a = a(fU)) == null || a.length <= 0) {
                return;
            }
            this.xi.r(a);
        } else if (this.xj != null) {
            this.xl = this.xj.q(fArr);
            if (this.xl) {
                this.xi.fZ();
                StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
            }
        }
    }

    public void a(com.baidu.ar.vo.c.b bVar) {
        this.xi.a(bVar);
    }

    public void c(float f, float f2, float f3) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = f;
        bVar.y = f2;
        bVar.xL = f3;
        bVar.type = 2;
        a(bVar);
    }

    public void release() {
        if (this.xi != null) {
            this.xi.release();
            this.xi = null;
        }
        this.xj = null;
    }

    public void start() {
        this.xm = true;
    }
}
