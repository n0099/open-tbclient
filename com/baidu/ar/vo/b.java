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
    private d wI;
    private c wJ;
    private com.baidu.ar.vo.b.d wK;
    private volatile boolean wM;
    private volatile boolean wL = false;
    private volatile boolean wN = false;

    public b(d dVar, com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar, com.baidu.ar.vo.b.d dVar2) {
        this.wM = true;
        this.wI = dVar;
        this.wK = dVar2;
        if (bVar != null) {
            this.wM = bVar.fC();
        }
        this.wJ = a(bVar, aVar);
    }

    private c a(com.baidu.ar.vo.a.b bVar, com.baidu.ar.vo.b.a aVar) {
        if (bVar == null) {
            return new com.baidu.ar.vo.c.a(this.wI, this.wK.xc, this.wK.xd);
        }
        if (bVar.fy() == 1) {
            f fVar = new f(this.wI, bVar, this.wK.xc, this.wK.xd);
            fVar.a(aVar);
            return fVar;
        } else if (bVar.fy() == 0) {
            return new e(this.wI, bVar, this.wK.xc, this.wK.xd);
        } else {
            return null;
        }
    }

    private float[] a(g gVar) {
        ArrayList<TrackModel> fF = gVar.fF();
        return (fF == null || fF.isEmpty()) ? new float[0] : fF.get(0).getPose();
    }

    public void V(boolean z) {
        this.wN = z;
    }

    public void a(com.baidu.ar.vo.b.f fVar, float[] fArr) {
        float[] a;
        if (!this.wM || this.wN) {
            return;
        }
        g fE = fVar.fE();
        if (this.wL) {
            if (fE == null || (a = a(fE)) == null || a.length <= 0) {
                return;
            }
            this.wI.q(a);
        } else if (this.wJ != null) {
            this.wL = this.wJ.p(fArr);
            if (this.wL) {
                this.wI.fJ();
                StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
            }
        }
    }

    public void a(com.baidu.ar.vo.c.b bVar) {
        this.wI.a(bVar);
    }

    public void c(float f, float f2, float f3) {
        com.baidu.ar.vo.c.b bVar = new com.baidu.ar.vo.c.b();
        bVar.x = f;
        bVar.y = f2;
        bVar.xl = f3;
        bVar.type = 2;
        a(bVar);
    }

    public void release() {
        if (this.wI != null) {
            this.wI.release();
            this.wI = null;
        }
        this.wJ = null;
    }

    public void start() {
        this.wM = true;
    }
}
