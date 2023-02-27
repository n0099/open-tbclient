package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class m {
    public long il;
    public long mTimestamp;
    public boolean nN;
    public boolean pE;
    public long pF;
    public FaceAlgoData pG;
    public boolean pH;
    public ByteBuffer pI;
    public long pJ = 0;

    public m(long j) {
        this.mTimestamp = j;
    }

    public void F(boolean z) {
        this.pE = z;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.pG = faceAlgoData;
    }

    public void a(ByteBuffer byteBuffer) {
        this.pI = byteBuffer;
    }

    public long cY() {
        return this.il;
    }

    public long dN() {
        return this.pJ;
    }

    public ByteBuffer eB() {
        return this.pI;
    }

    public FaceAlgoData eC() {
        return this.pG;
    }

    public void g(long j) {
        this.il = j;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isFrontCamera() {
        return this.pH;
    }

    public boolean isTracked() {
        return this.nN;
    }

    public void p(long j) {
        this.pJ = j;
    }

    public void r(long j) {
        this.pF = j;
    }

    public void setFrontCamera(boolean z) {
        this.pH = z;
    }

    public void setTracked(boolean z) {
        this.nN = z;
    }
}
