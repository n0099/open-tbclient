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
/* loaded from: classes3.dex */
public class b {
    public volatile boolean yA;
    public d yw;
    public c yx;
    public com.baidu.ar.vo.b.d yy;
    public volatile boolean yz = false;
    public volatile boolean yB = false;

    public b(d dVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.b.d dVar2) {
        this.yA = true;
        this.yw = dVar;
        this.yy = dVar2;
        if (bVar != null) {
            this.yA = bVar.hh();
        }
        this.yx = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar) {
        if (bVar == null) {
            d dVar = this.yw;
            com.baidu.ar.vo.b.d dVar2 = this.yy;
            return new com.baidu.ar.vo.c.a(dVar, dVar2.yQ, dVar2.yR);
        } else if (bVar.hd() == 1) {
            d dVar3 = this.yw;
            com.baidu.ar.vo.b.d dVar4 = this.yy;
            f fVar = new f(dVar3, bVar, dVar4.yQ, dVar4.yR);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.hd() == 0) {
            d dVar5 = this.yw;
            com.baidu.ar.vo.b.d dVar6 = this.yy;
            return new e(dVar5, bVar, dVar6.yQ, dVar6.yR);
        } else {
            return null;
        }
    }

    private float[] a(g gVar) {
        ArrayList<TrackModel> hk = gVar.hk();
        return (hk == null || hk.isEmpty()) ? new float[0] : hk.get(0).getPose();
    }

    public void U(boolean z) {
        this.yB = z;
    }

    public void a(com.baidu.ar.vo.b.f fVar, float[] fArr) {
        float[] a;
        if (!this.yA || this.yB) {
            return;
        }
        g hj = fVar.hj();
        if (this.yz) {
            if (hj == null || (a = a(hj)) == null || a.length <= 0) {
                return;
            }
            this.yw.r(a);
            return;
        }
        c cVar = this.yx;
        if (cVar != null) {
            this.yz = cVar.q(fArr);
            if (this.yz) {
                this.yw.ho();
                StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
            }
        }
    }

    public void a(com.baidu.ar.vo.c.b bVar) {
        this.yw.a(bVar);
    }

    public void c(float f, float f2, float f3) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = f;
        bVar.y = f2;
        bVar.yZ = f3;
        bVar.type = 2;
        a(bVar);
    }

    public void release() {
        d dVar = this.yw;
        if (dVar != null) {
            dVar.release();
            this.yw = null;
        }
        this.yx = null;
    }

    public void start() {
        this.yA = true;
    }
}
