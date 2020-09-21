package com.baidu.ar.face.detector;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
/* loaded from: classes10.dex */
public class FaceDetector extends com.baidu.ar.b.a.a {
    private PixelReadParams mU;
    private j oF;
    private i ok;
    private int oE = 11;
    private boolean oj = false;
    private boolean oG = false;
    private boolean bl = false;
    private int oH = 3;
    private a oi = new a();
    private String bA = null;
    private int oI = 0;
    private long oJ = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class a {
        protected a() {
        }

        public void f(m mVar) {
            com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) new b(mVar));
        }
    }

    public FaceDetector() {
        com.baidu.ar.c.c.ce().a(this);
        this.mU = new PixelReadParams(PixelType.BGR);
        if (this.ok == null) {
            this.ok = new i();
        }
    }

    private boolean a(com.baidu.ar.c.a aVar, boolean z) {
        if (z) {
            if (em()) {
                return false;
            }
            if (aVar instanceof h) {
                ((h) aVar).X("additional_thread");
            } else if (aVar instanceof o) {
                ((o) aVar).X("additional_thread");
            } else if (!(aVar instanceof d)) {
                return false;
            } else {
                ((d) aVar).X("additional_thread");
            }
        }
        return true;
    }

    private void e(m mVar) {
        if (this.mg == null || mVar == null) {
            return;
        }
        l lVar = new l(getName(), mVar);
        lVar.p(mVar.dO());
        if (this.bA != null && mVar.cZ() > 0) {
            com.baidu.ar.arrender.m mVar2 = new com.baidu.ar.arrender.m();
            mVar2.p(this.bA);
            mVar2.i(mVar.cZ());
            mVar2.c(true);
            mVar2.d(mVar.isFrontCamera());
            mVar2.setTimestamp(mVar.getTimestamp());
            mVar2.q(this.mU.getOutputWidth());
            mVar2.r(this.mU.getOutputHeight());
            lVar.g(mVar2);
        }
        if (mVar.getTimestamp() < 0 || Math.abs(this.oJ - mVar.getTimestamp()) > 99999999) {
            com.baidu.ar.g.b.c("FaceDetector", "time interval between framepixels is larger than 33 * 3ms");
        } else if (this.oJ >= mVar.getTimestamp()) {
            return;
        }
        com.baidu.ar.g.b.c("FaceDetector", "time_interval: " + String.valueOf(mVar.getTimestamp() - this.oJ));
        this.oJ = mVar.getTimestamp();
        this.mg.a(lVar);
    }

    private boolean em() {
        boolean e = com.baidu.ar.b.a.ar().e(11);
        this.oI++;
        if (e && this.oI > 1) {
            this.oI = 0;
            return e;
        }
        return false;
    }

    public void F(boolean z) {
        this.oj = z;
    }

    public void G(boolean z) {
        this.oG = z;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        com.baidu.ar.g.b.l("FaceDetector", "detect_frame onCreateInitTask");
        com.baidu.ar.b.b.b bVar = new com.baidu.ar.b.b.b(this.oE) { // from class: com.baidu.ar.face.detector.FaceDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                FaceDetector.this.ok.a(FaceDetector.this.oF).dW();
                if (FaceDetector.this.mg != null && FaceDetector.this.ok.dX()) {
                    FaceDetector.this.mg.a(new com.baidu.ar.d.l(FaceDetector.this.getName(), true, 10));
                }
                return FaceDetector.this.ok.dX() ? 0 : -1;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return null;
            }
        };
        bVar.setPriority(10);
        return bVar;
    }

    @Override // com.baidu.ar.b.a.a
    public void a(AlgoHandleController algoHandleController) {
        this.ok.a(algoHandleController);
    }

    public void a(a.C0083a c0083a, int i, com.baidu.ar.face.b bVar, a.b bVar2, String str) {
        this.ok.E(i);
        if (c0083a != null) {
            this.ok.a(Float.parseFloat(c0083a.pB), Float.parseFloat(c0083a.pC));
            this.ok.e(Float.parseFloat(c0083a.pD));
        }
        this.ok.B(bVar.dz());
        this.ok.D(bVar.dA());
        this.ok.C(bVar.dy());
        this.ok.a(bVar.du(), bVar.dv(), bVar.dw());
        this.ok.E(bVar.dx());
        int dE = bVar.dE();
        if (!TextUtils.isEmpty(str)) {
            dE = bVar.dD() < bVar.dE() ? bVar.dD() : bVar.dE();
        }
        this.ok.F(dE);
        if (bVar2 == null || bVar2.od == null) {
            return;
        }
        this.ok.c(bVar2.od);
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void am() {
        if (this.oF == null) {
            com.baidu.ar.g.b.b("FaceDetector", "setupFrameDetector mFaceParams is NULLLL");
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean an() {
        return (!this.ok.ei() || com.baidu.ar.b.a.ar().e(13) || com.baidu.ar.b.a.ar().e(12)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        com.baidu.ar.c.c.ce().b(this);
        au();
        if (this.mg != null) {
            this.mg.b(new com.baidu.ar.d.l(getName(), true));
        }
        com.baidu.ar.g.b.l("FaceDetector", "releaseFrameDetector");
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a as() {
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.face.detector.FaceDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                FaceDetector.this.ok.release();
                return 0;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return null;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int at() {
        return this.oE;
    }

    @Override // com.baidu.ar.b.a.a
    public void b(long j) {
        this.ok.b(j);
    }

    public void b(j jVar) {
        this.oF = jVar;
        this.mU.setOutputWidth(this.oF.ey());
        this.mU.setOutputHeight(this.oF.ez());
        this.mU.setIsPortrait(true);
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        boolean b = com.baidu.ar.b.a.ar().b(at());
        if (!b || framePixels == null) {
            com.baidu.ar.g.b.b("FaceDetector", "detect_frame detect frame failed isInitTaskFinished: " + b);
            if (framePixels != null) {
                e(new m(framePixels.getTimestamp()));
                return true;
            }
            return false;
        }
        this.ok.eg();
        if (!this.bl || this.oH >= 3) {
            h hVar = new h(framePixels.getPixelsAddress(), framePixels.getWidth(), framePixels.getHeight(), framePixels.getTimestamp(), framePixels.isFrontCamera(), this.oG ? -1 : framePixels.getOrientation().getDegree(), this.oj);
            hVar.a(this.oi);
            hVar.a(this.ok);
            return com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) hVar);
        }
        return false;
    }

    @Override // com.baidu.ar.d.j
    public PixelReadParams dj() {
        return this.mU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(FramePixels framePixels) {
        return null;
    }

    public void ek() {
        this.bl = true;
        this.oH = 3;
    }

    public void el() {
        this.bl = false;
    }

    public i en() {
        return this.ok;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "FaceDetector";
    }

    public void o(Context context) {
        this.ok.setContext(context);
    }

    @CallBack
    public void onAnimateResult(c cVar) {
        com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) new b(cVar));
    }

    @CallBack
    public void onDetectResult(f fVar) {
        o oVar = new o(fVar);
        oVar.b(this.oi);
        com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) oVar);
    }

    @CallBack
    public void onFaceAlgoResult(m mVar) {
        e(mVar);
    }

    @CallBack
    public void onTrackResult(n nVar) {
        if (!this.bl) {
            boolean e = com.baidu.ar.b.a.ar().e(14);
            d dVar = new d(nVar);
            if (a(dVar, e)) {
                com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) dVar);
            }
        } else if (this.oH == 0) {
            this.oi.f(com.baidu.ar.face.c.a(nVar.nL, nVar.nQ, nVar.lQ, nVar.nR, nVar.nO, nVar.timestamp, nVar.nS));
        } else if (this.oH > 0) {
            this.oH--;
            o oVar = new o(nVar);
            oVar.b(this.oi);
            com.baidu.ar.c.c.ce().c((com.baidu.ar.c.a) oVar);
        }
    }

    public void p(String str) {
        this.bA = str;
    }

    public void s(long j) {
        this.ok.s(j);
    }
}
