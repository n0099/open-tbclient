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
/* loaded from: classes3.dex */
public class b {
    private volatile boolean yA;
    private d yw;
    private c yx;
    private com.baidu.ar.vo.b.d yy;
    private volatile boolean yz = false;
    private volatile boolean yB = false;

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
            return new com.baidu.ar.vo.c.a(this.yw, this.yy.yQ, this.yy.yR);
        }
        if (bVar.hd() == 1) {
            f fVar = new f(this.yw, bVar, this.yy.yQ, this.yy.yR);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.hd() == 0) {
            return new e(this.yw, bVar, this.yy.yQ, this.yy.yR);
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
        float[] a2;
        if (!this.yA || this.yB) {
            return;
        }
        g hj = fVar.hj();
        if (this.yz) {
            if (hj == null || (a2 = a(hj)) == null || a2.length <= 0) {
                return;
            }
            this.yw.r(a2);
        } else if (this.yx != null) {
            this.yz = this.yx.q(fArr);
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
        if (this.yw != null) {
            this.yw.release();
            this.yw = null;
        }
        this.yx = null;
    }

    public void start() {
        this.yA = true;
    }
}
