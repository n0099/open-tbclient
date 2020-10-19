package com.baidu.ar.face.detector;

import com.baidu.ar.face.detector.FaceDetector;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class h extends com.baidu.ar.c.a<f> {
    private int height;
    private ByteBuffer nO;
    private boolean nS;
    private String nT = "face_detect";
    private FaceDetector.a oi;
    private boolean oj;
    private i ok;
    private int orientation;
    private long timestamp;
    private int width;

    public h(ByteBuffer byteBuffer, int i, int i2, long j, boolean z, int i3, boolean z2) {
        this.nO = byteBuffer;
        this.width = i;
        this.height = i2;
        this.timestamp = j;
        this.nS = z;
        this.orientation = i3;
        this.oj = z2;
        setPriority(10);
    }

    private e dV() {
        e eVar = new e(this.nO);
        eVar.a(this.ok);
        eVar.a(this.width, this.height, this.nS, this.orientation, this.oj, this.timestamp);
        eVar.dI();
        if (eVar.lQ <= 0) {
            com.baidu.ar.g.b.b(getTag(), "create handle illegal:" + eVar.lQ);
            return null;
        }
        return eVar;
    }

    public void X(String str) {
        this.nT = str;
    }

    public void a(FaceDetector.a aVar) {
        this.oi = aVar;
    }

    public void a(i iVar) {
        this.ok = iVar;
    }

    protected void b(f fVar) {
        if (fVar == null) {
            this.oi.f(null);
        }
        this.oi.f(com.baidu.ar.face.c.a(fVar.nL, fVar.nQ, fVar.lQ, fVar.nR, fVar.nO, this.timestamp, this.nS));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dU */
    public f ax() {
        if (this.ok.a(this.nS, this.orientation)) {
            return null;
        }
        com.baidu.ar.g.b.c(getTag(), "detect_frame track task executed");
        e dV = dV();
        if (dV == null) {
            com.baidu.ar.g.b.b(getTag(), "create faceHandle failed");
            b(null);
            return null;
        }
        f fVar = new f(this.nO);
        fVar.a(this.ok);
        fVar.a(dV.nL);
        fVar.i(dV.cZ());
        fVar.r(dV.dO());
        fVar.setFrontCamera(this.nS);
        fVar.setTimestamp(this.timestamp);
        fVar.nT = this.nT;
        fVar.dK();
        if (this.ok.dY().dP()) {
            com.baidu.ar.g.b.l("hjm", "check_skip detect");
            fVar.dI();
            if (this.ok.dY().a(fVar)) {
                b(fVar);
                return null;
            }
        } else {
            com.baidu.ar.g.b.l("hjm", "check_skip skip");
        }
        return fVar;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.nT;
    }
}
