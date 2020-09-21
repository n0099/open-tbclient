package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class m {
    private long hV;
    private long mTimestamp;
    private boolean nx;
    private boolean po;
    private long pp;
    private FaceAlgoData pq;
    private boolean pr;
    private ByteBuffer ps;
    private long pt = 0;

    public m(long j) {
        this.mTimestamp = j;
    }

    public void H(boolean z) {
        this.po = z;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.pq = faceAlgoData;
    }

    public void a(ByteBuffer byteBuffer) {
        this.ps = byteBuffer;
    }

    public long cZ() {
        return this.hV;
    }

    public long dO() {
        return this.pt;
    }

    public ByteBuffer eC() {
        return this.ps;
    }

    public FaceAlgoData eD() {
        return this.pq;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void i(long j) {
        this.hV = j;
    }

    public boolean isFrontCamera() {
        return this.pr;
    }

    public boolean isTracked() {
        return this.nx;
    }

    public void r(long j) {
        this.pt = j;
    }

    public void setFrontCamera(boolean z) {
        this.pr = z;
    }

    public void setTracked(boolean z) {
        this.nx = z;
    }

    public void t(long j) {
        this.pp = j;
    }
}
