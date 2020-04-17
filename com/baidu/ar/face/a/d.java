package com.baidu.ar.face.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleController;
/* loaded from: classes3.dex */
public class d extends j {
    private e nF;
    private boolean mn = false;
    private String bx = null;
    private PixelReadParams lP = new PixelReadParams(PixelType.BGR);

    private c cQ() {
        return new c() { // from class: com.baidu.ar.face.a.d.1
            @Override // com.baidu.ar.face.a.c
            public void D(boolean z) {
                if (d.this.lb != null) {
                    d.this.lb.a(new l(d.this.getName(), z));
                }
            }

            @Override // com.baidu.ar.face.a.c
            public void E(boolean z) {
                if (d.this.lb != null) {
                    try {
                        d.this.lb.b(new l(d.this.getName(), z));
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.baidu.ar.face.a.c
            public void g(h hVar) {
                if (d.this.lb == null || hVar == null) {
                    return;
                }
                g gVar = new g(d.this.getName(), hVar);
                gVar.q(hVar.cP());
                if (d.this.bx != null && hVar.bv() > 0) {
                    com.baidu.ar.arrender.l lVar = new com.baidu.ar.arrender.l();
                    lVar.o(d.this.bx);
                    lVar.i(hVar.bv());
                    lVar.c(true);
                    lVar.d(hVar.isFrontCamera());
                    lVar.setTimestamp(hVar.getTimestamp());
                    lVar.r(d.this.lP.getOutputWidth());
                    lVar.s(d.this.lP.getOutputHeight());
                    gVar.a(lVar);
                }
                d.this.lb.a(gVar);
            }
        };
    }

    public void F(boolean z) {
        this.mn = z;
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
        if (this.nF == null) {
            com.baidu.ar.f.b.b("FaceDetector", "setupFrameDetector mFaceParams is NULLLL");
            return;
        }
        com.baidu.ar.f.b.c("FaceDetector", "setupFrameDetector");
        a.cE().a(cQ());
        a.cE().b(this.nF.cR(), this.nF.cS(), this.nF.cT(), new String[]{this.nF.cU(), this.nF.cV(), this.nF.cW()}, this.nF.cX(), this.nF.cY(), this.nF.cZ());
        a.cE().a(this.nF.da(), this.nF.db());
        a.cE().c(this.nF.dc());
    }

    @Override // com.baidu.ar.c.j
    public boolean Y() {
        return a.cE().cI();
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
        com.baidu.ar.f.b.c("FaceDetector", "releaseFrameDetector");
        a.cE().release();
        this.nF = null;
    }

    public void a(AlgoHandleController algoHandleController) {
        a.cE().a(algoHandleController);
    }

    public void a(e eVar) {
        this.nF = eVar;
        this.lP.setOutputWidth(this.nF.aj());
        this.lP.setOutputHeight(this.nF.ak());
        this.lP.setIsPortrait(true);
    }

    public void b(long j) {
        a.cE().b(j);
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (framePixels != null) {
            return a.cE().a(framePixels.getPixelsAddress(), framePixels.getTimestamp(), framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), framePixels.getSegOrientation().getValue(), this.mn);
        }
        return false;
    }

    @Override // com.baidu.ar.c.j
    public PixelReadParams ct() {
        return this.lP;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "FaceDetector";
    }

    public void o(String str) {
        this.bx = str;
    }

    public void r(long j) {
        a.cE().r(j);
    }
}
