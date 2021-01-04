package com.baidu.ar.face.detector;

import com.baidu.ar.face.detector.FaceDetector;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class h extends com.baidu.ar.c.a<f> {
    private int height;
    private i oA;
    private ByteBuffer oe;
    private boolean oi;
    private String oj = "face_detect";
    private int orientation;
    private FaceDetector.a oy;
    private boolean oz;
    private long timestamp;
    private int width;

    public h(ByteBuffer byteBuffer, int i, int i2, long j, boolean z, int i3, boolean z2) {
        this.oe = byteBuffer;
        this.width = i;
        this.height = i2;
        this.timestamp = j;
        this.oi = z;
        this.orientation = i3;
        this.oz = z2;
        setPriority(10);
    }

    private e dU() {
        e eVar = new e(this.oe);
        eVar.a(this.oA);
        eVar.a(this.width, this.height, this.oi, this.orientation, this.oz, this.timestamp);
        eVar.dH();
        if (eVar.mf <= 0) {
            com.baidu.ar.h.b.b(getTag(), "create handle illegal:" + eVar.mf);
            return null;
        }
        return eVar;
    }

    public void a(FaceDetector.a aVar) {
        this.oy = aVar;
    }

    public void a(i iVar) {
        this.oA = iVar;
    }

    public void aa(String str) {
        this.oj = str;
    }

    protected void b(f fVar) {
        if (fVar == null) {
            this.oy.f(null);
        }
        this.oy.f(com.baidu.ar.face.c.a(fVar.ob, fVar.og, fVar.mf, fVar.oh, fVar.oe, this.timestamp, this.oi));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.c.a
    /* renamed from: dT */
    public f ay() {
        if (this.oA.a(this.oi, this.orientation)) {
            return null;
        }
        com.baidu.ar.h.b.c(getTag(), "detect_frame track task executed");
        e dU = dU();
        if (dU == null) {
            com.baidu.ar.h.b.b(getTag(), "create faceHandle failed");
            b(null);
            return null;
        }
        f fVar = new f(this.oe);
        fVar.a(this.oA);
        fVar.a(dU.ob);
        fVar.g(dU.cY());
        fVar.p(dU.dN());
        fVar.setFrontCamera(this.oi);
        fVar.setTimestamp(this.timestamp);
        fVar.oj = this.oj;
        fVar.dJ();
        if (this.oA.dX().dO()) {
            com.baidu.ar.h.b.l("hjm", "check_skip detect");
            fVar.dH();
            if (this.oA.dX().a(fVar)) {
                b(fVar);
                return null;
            }
        } else {
            com.baidu.ar.h.b.l("hjm", "check_skip skip");
        }
        return fVar;
    }

    @Override // com.baidu.ar.c.a
    public String getTag() {
        return this.oj;
    }
}
