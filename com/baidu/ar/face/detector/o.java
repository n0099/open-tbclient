package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;
import com.baidu.ar.face.detector.FaceDetector;
/* loaded from: classes10.dex */
public class o extends com.baidu.ar.c.a<n> {
    private String oj = "face_track";
    private a oo;
    private FaceDetector.a oy;

    public o(f fVar) {
        this.oo = fVar;
        setPriority(10);
    }

    public o(n nVar) {
        this.oo = nVar;
        setPriority(10);
    }

    private void b(FaceAlgoData faceAlgoData) {
        if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || faceAlgoData.getFaceFrame().getProcessResult() != 200 || faceAlgoData.getFaceFrame().getTrackedPointsList().size() < this.oo.dI().dX().dR()) {
            this.oo.dI().dX().dQ();
        } else {
            this.oo.dI().dX().dP();
        }
    }

    protected void a(a aVar) {
        this.oy.f(com.baidu.ar.face.c.a(aVar.ob, aVar.og, aVar.mf, aVar.oh, aVar.oe, aVar.timestamp, aVar.oi));
    }

    public void aa(String str) {
        this.oj = str;
    }

    public void b(FaceDetector.a aVar) {
        this.oy = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: eD */
    public n ay() {
        n nVar = new n(this.oo.oe);
        nVar.a(this.oo.ob);
        nVar.g(this.oo.mf);
        nVar.p(this.oo.oh);
        nVar.setTimestamp(this.oo.timestamp);
        nVar.setFrontCamera(this.oo.oi);
        nVar.a(this.oo.oc);
        nVar.oj = this.oj;
        nVar.dJ();
        nVar.dH();
        b(nVar.ob);
        if (nVar.ob != null) {
            return nVar;
        }
        a(this.oo);
        return null;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.oj;
    }
}
