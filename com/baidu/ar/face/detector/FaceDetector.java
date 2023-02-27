package com.baidu.ar.face.detector;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.face.a.a;
/* loaded from: classes.dex */
public class FaceDetector extends com.baidu.ar.b.a.a {
    public PixelReadParams ih;
    public i oA;
    public j oV;
    public int oU = 11;
    public boolean oz = false;
    public boolean oW = false;
    public boolean bn = false;
    public int oX = 3;
    public a oy = new a();
    public String bD = null;
    public int oY = 0;
    public long oZ = 0;

    /* loaded from: classes.dex */
    public class a {
        public a() {
        }

        public void f(m mVar) {
            com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) new b(mVar));
        }
    }

    public FaceDetector() {
        com.baidu.ar.c.c.cd().a(this);
        this.ih = new PixelReadParams(PixelType.BGR);
        if (this.oA == null) {
            this.oA = new i();
        }
    }

    private boolean a(com.baidu.ar.c.a aVar, boolean z) {
        if (z) {
            if (el()) {
                return false;
            }
            if (aVar instanceof h) {
                ((h) aVar).aa("additional_thread");
                return true;
            } else if (aVar instanceof o) {
                ((o) aVar).aa("additional_thread");
                return true;
            } else if (aVar instanceof d) {
                ((d) aVar).aa("additional_thread");
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private void e(m mVar) {
        if (this.mv == null || mVar == null) {
            return;
        }
        l lVar = new l(getName(), mVar);
        lVar.n(mVar.dN());
        if (this.bD != null && mVar.cY() > 0) {
            com.baidu.ar.arrender.n nVar = new com.baidu.ar.arrender.n();
            nVar.r(this.bD);
            nVar.g(mVar.cY());
            nVar.c(true);
            nVar.d(mVar.isFrontCamera());
            nVar.setTimestamp(mVar.getTimestamp());
            nVar.s(this.ih.getOutputWidth());
            nVar.t(this.ih.getOutputHeight());
            lVar.g(nVar);
        }
        if (mVar.getTimestamp() < 0 || Math.abs(this.oZ - mVar.getTimestamp()) > 99999999) {
            com.baidu.ar.h.b.c("FaceDetector", "time interval between framepixels is larger than 33 * 3ms");
        } else if (this.oZ >= mVar.getTimestamp()) {
            return;
        }
        com.baidu.ar.h.b.c("FaceDetector", "time_interval: " + String.valueOf(mVar.getTimestamp() - this.oZ));
        this.oZ = mVar.getTimestamp();
        this.mv.a(lVar);
    }

    private boolean el() {
        boolean f = com.baidu.ar.b.a.as().f(11);
        int i = this.oY + 1;
        this.oY = i;
        if (f && i > 1) {
            this.oY = 0;
            return f;
        }
        return false;
    }

    public void D(boolean z) {
        this.oz = z;
    }

    public void E(boolean z) {
        this.oW = z;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        com.baidu.ar.h.b.l("FaceDetector", "detect_frame onCreateInitTask");
        com.baidu.ar.b.b.b bVar = new com.baidu.ar.b.b.b(this.oU) { // from class: com.baidu.ar.face.detector.FaceDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                FaceDetector.this.oA.a(FaceDetector.this.oV).dV();
                if (FaceDetector.this.mv != null && FaceDetector.this.oA.dW()) {
                    FaceDetector.this.mv.a(new com.baidu.ar.d.l(FaceDetector.this.getName(), true, 10));
                }
                return FaceDetector.this.oA.dW() ? 0 : -1;
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
        this.oA.a(algoHandleController);
    }

    public void a(a.C0057a c0057a, int i, com.baidu.ar.face.b bVar, a.b bVar2, String str) {
        int[] iArr;
        this.oA.G(i);
        if (c0057a != null) {
            this.oA.a(Float.parseFloat(c0057a.pR), Float.parseFloat(c0057a.pS));
            this.oA.d(Float.parseFloat(c0057a.pT));
        }
        this.oA.z(bVar.dy());
        this.oA.B(bVar.dz());
        this.oA.A(bVar.dx());
        this.oA.a(bVar.dt(), bVar.du(), bVar.dv());
        this.oA.C(bVar.dw());
        int dD = bVar.dD();
        if (!TextUtils.isEmpty(str)) {
            dD = bVar.dC() < bVar.dD() ? bVar.dC() : bVar.dD();
        }
        this.oA.H(dD);
        if (bVar2 == null || (iArr = bVar2.ot) == null) {
            return;
        }
        this.oA.c(iArr);
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        if (this.oV == null) {
            com.baidu.ar.h.b.b("FaceDetector", "setupFrameDetector mFaceParams is NULLLL");
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean ap() {
        return (!this.oA.eh() || com.baidu.ar.b.a.as().f(13) || com.baidu.ar.b.a.as().f(12)) ? false : true;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        com.baidu.ar.c.c.cd().b(this);
        av();
        com.baidu.ar.d.e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new com.baidu.ar.d.l(getName(), true));
        }
        com.baidu.ar.h.b.l("FaceDetector", "releaseFrameDetector");
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.face.detector.FaceDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                FaceDetector.this.oA.release();
                return 0;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return null;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public void b(long j) {
        this.oA.b(j);
    }

    public void b(j jVar) {
        this.oV = jVar;
        this.ih.setOutputWidth(jVar.ex());
        this.ih.setOutputHeight(this.oV.ey());
        this.ih.setIsPortrait(true);
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        boolean c = com.baidu.ar.b.a.as().c(au());
        if (!c || framePixels == null) {
            com.baidu.ar.h.b.b("FaceDetector", "detect_frame detect frame failed isInitTaskFinished: " + c);
            if (framePixels != null) {
                e(new m(framePixels.getTimestamp()));
                return true;
            }
            return false;
        }
        this.oA.ef();
        if (!this.bn || this.oX >= 3) {
            h hVar = new h(framePixels.getPixelsAddress(), framePixels.getWidth(), framePixels.getHeight(), framePixels.getTimestamp(), framePixels.isFrontCamera(), this.oW ? -1 : framePixels.getOrientation().getDegree(), this.oz);
            hVar.a(this.oy);
            hVar.a(this.oA);
            return com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) hVar);
        }
        return false;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return null;
    }

    @Override // com.baidu.ar.d.j
    public PixelReadParams di() {
        return this.ih;
    }

    public void ej() {
        this.bn = true;
        this.oX = 3;
    }

    public void ek() {
        this.bn = false;
    }

    public i em() {
        return this.oA;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "FaceDetector";
    }

    @CallBack
    public void onAnimateResult(c cVar) {
        com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) new b(cVar));
    }

    @CallBack
    public void onDetectResult(f fVar) {
        o oVar = new o(fVar);
        oVar.b(this.oy);
        com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) oVar);
    }

    @CallBack
    public void onFaceAlgoResult(m mVar) {
        e(mVar);
    }

    @CallBack
    public void onTrackResult(n nVar) {
        if (!this.bn) {
            boolean f = com.baidu.ar.b.a.as().f(14);
            d dVar = new d(nVar);
            if (a(dVar, f)) {
                com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) dVar);
                return;
            }
            return;
        }
        int i = this.oX;
        if (i == 0) {
            this.oy.f(com.baidu.ar.face.c.a(nVar.ob, nVar.og, nVar.mf, nVar.oh, nVar.oe, nVar.timestamp, nVar.oi));
        } else if (i > 0) {
            this.oX = i - 1;
            o oVar = new o(nVar);
            oVar.b(this.oy);
            com.baidu.ar.c.c.cd().c((com.baidu.ar.c.a) oVar);
        }
    }

    public void p(Context context) {
        this.oA.setContext(context);
    }

    public void q(long j) {
        this.oA.q(j);
    }

    public void r(String str) {
        this.bD = str;
    }
}
