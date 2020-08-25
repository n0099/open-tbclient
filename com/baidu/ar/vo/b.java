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
    private d xH;
    private c xI;
    private com.baidu.ar.vo.b.d xJ;
    private volatile boolean xL;
    private volatile boolean xK = false;
    private volatile boolean xM = false;

    public b(d dVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.b.d dVar2) {
        this.xL = true;
        this.xH = dVar;
        this.xJ = dVar2;
        if (bVar != null) {
            this.xL = bVar.hh();
        }
        this.xI = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar) {
        if (bVar == null) {
            return new com.baidu.ar.vo.c.a(this.xH, this.xJ.yb, this.xJ.yc);
        }
        if (bVar.hd() == 1) {
            f fVar = new f(this.xH, bVar, this.xJ.yb, this.xJ.yc);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.hd() == 0) {
            return new e(this.xH, bVar, this.xJ.yb, this.xJ.yc);
        } else {
            return null;
        }
    }

    private float[] a(g gVar) {
        ArrayList<TrackModel> hk = gVar.hk();
        return (hk == null || hk.isEmpty()) ? new float[0] : hk.get(0).getPose();
    }

    public void W(boolean z) {
        this.xM = z;
    }

    public void a(com.baidu.ar.vo.b.f fVar, float[] fArr) {
        float[] a;
        if (!this.xL || this.xM) {
            return;
        }
        g hj = fVar.hj();
        if (this.xK) {
            if (hj == null || (a = a(hj)) == null || a.length <= 0) {
                return;
            }
            this.xH.s(a);
        } else if (this.xI != null) {
            this.xK = this.xI.r(fArr);
            if (this.xK) {
                this.xH.ho();
                StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
            }
        }
    }

    public void a(com.baidu.ar.vo.c.b bVar) {
        this.xH.a(bVar);
    }

    public void c(float f, float f2, float f3) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = f;
        bVar.y = f2;
        bVar.yk = f3;
        bVar.type = 2;
        a(bVar);
    }

    public void release() {
        if (this.xH != null) {
            this.xH.release();
            this.xH = null;
        }
        this.xI = null;
    }

    public void start() {
        this.xL = true;
    }
}
