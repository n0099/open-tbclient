package com.baidu.ar.face.a;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleController;
/* loaded from: classes11.dex */
public class d extends j {
    private e oc;
    private boolean mK = false;
    private boolean od = false;
    private String bJ = null;
    private PixelReadParams mm = new PixelReadParams(PixelType.BGR);

    private c df() {
        return new c() { // from class: com.baidu.ar.face.a.d.1
            @Override // com.baidu.ar.face.a.c
            public void C(boolean z) {
                if (d.this.ly != null) {
                    d.this.ly.a(new l(d.this.getName(), z, 10));
                }
            }

            @Override // com.baidu.ar.face.a.c
            public void D(boolean z) {
                if (d.this.ly != null) {
                    try {
                        d.this.ly.b(new l(d.this.getName(), z));
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.baidu.ar.face.a.c
            public void e(h hVar) {
                if (d.this.ly == null || hVar == null) {
                    return;
                }
                g gVar = new g(d.this.getName(), hVar);
                gVar.p(hVar.de());
                if (d.this.bJ != null && hVar.cz() > 0) {
                    com.baidu.ar.arrender.l lVar = new com.baidu.ar.arrender.l();
                    lVar.o(d.this.bJ);
                    lVar.i(hVar.cz());
                    lVar.c(true);
                    lVar.d(hVar.isFrontCamera());
                    lVar.setTimestamp(hVar.getTimestamp());
                    lVar.t(d.this.mm.getOutputWidth());
                    lVar.u(d.this.mm.getOutputHeight());
                    gVar.a(lVar);
                }
                d.this.ly.a(gVar);
            }
        };
    }

    public void E(boolean z) {
        this.mK = z;
    }

    public void F(boolean z) {
        this.od = z;
    }

    public void a(AlgoHandleController algoHandleController) {
        a.cT().a(algoHandleController);
    }

    public void a(e eVar) {
        this.oc = eVar;
        this.mm.setOutputWidth(this.oc.ax());
        this.mm.setOutputHeight(this.oc.ay());
        this.mm.setIsPortrait(true);
    }

    @Override // com.baidu.ar.c.j
    protected void al() {
        if (this.oc == null) {
            com.baidu.ar.f.b.b("FaceDetector", "setupFrameDetector mFaceParams is NULLLL");
            return;
        }
        com.baidu.ar.f.b.c("FaceDetector", "setupFrameDetector");
        a.cT().a(df());
        a.cT().b(this.oc.dg(), this.oc.dh(), this.oc.di(), new String[]{this.oc.dj(), this.oc.dk(), this.oc.dl()}, this.oc.dm(), this.oc.dn(), this.oc.m18do(), this.oc.dp());
        a.cT().a(this.oc.dq(), this.oc.dr());
        a.cT().e(this.oc.ds());
    }

    @Override // com.baidu.ar.c.j
    public boolean am() {
        return a.cT().cX();
    }

    @Override // com.baidu.ar.c.j
    protected void an() {
        com.baidu.ar.f.b.c("FaceDetector", "releaseFrameDetector");
        a.cT().release();
        this.oc = null;
    }

    public void b(long j) {
        a.cT().b(j);
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(FramePixels framePixels) {
        if (framePixels != null) {
            return a.cT().a(framePixels.getPixelsAddress(), framePixels.getTimestamp(), framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), this.od ? -1 : framePixels.getOrientation().getDegree(), this.mK);
        }
        return false;
    }

    @Override // com.baidu.ar.c.j
    public PixelReadParams cJ() {
        return this.mm;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "FaceDetector";
    }

    public void o(String str) {
        this.bJ = str;
    }

    public void r(long j) {
        a.cT().r(j);
    }
}
