package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.detector.FaceDetector;
/* loaded from: classes14.dex */
public class o extends com.baidu.ar.c.a<n> {
    private String nT = "face_track";
    private a nY;
    private FaceDetector.a oi;

    public o(f fVar) {
        this.nY = fVar;
        setPriority(10);
    }

    public o(n nVar) {
        this.nY = nVar;
        setPriority(10);
    }

    private void b(FaceAlgoData faceAlgoData) {
        if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || faceAlgoData.getFaceFrame().getProcessResult() != 200 || faceAlgoData.getFaceFrame().getTrackedPointsList().size() < this.nY.dJ().dY().dS()) {
            this.nY.dJ().dY().dR();
        } else {
            this.nY.dJ().dY().dQ();
        }
    }

    public void X(String str) {
        this.nT = str;
    }

    protected void a(a aVar) {
        this.oi.f(com.baidu.ar.face.c.a(aVar.nL, aVar.nQ, aVar.lQ, aVar.nR, aVar.nO, aVar.timestamp, aVar.nS));
    }

    public void b(FaceDetector.a aVar) {
        this.oi = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: eE */
    public n ax() {
        n nVar = new n(this.nY.nO);
        nVar.a(this.nY.nL);
        nVar.i(this.nY.lQ);
        nVar.r(this.nY.nR);
        nVar.setTimestamp(this.nY.timestamp);
        nVar.setFrontCamera(this.nY.nS);
        nVar.a(this.nY.nM);
        nVar.nT = this.nT;
        nVar.dK();
        nVar.dI();
        b(nVar.nL);
        if (nVar.nL != null) {
            return nVar;
        }
        a(this.nY);
        return null;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.nT;
    }
}
