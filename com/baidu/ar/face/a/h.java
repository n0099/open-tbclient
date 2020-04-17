package com.baidu.ar.face.a;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class h {
    private long ii;
    private ByteBuffer mK;
    private long mTimestamp;
    private boolean mu;
    private boolean nC;
    private long nn = 0;
    private boolean oh;
    private long oi;
    private FaceAlgoData oj;

    public h(long j) {
        this.mTimestamp = j;
    }

    public void G(boolean z) {
        this.oh = z;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.oj = faceAlgoData;
    }

    public void a(ByteBuffer byteBuffer) {
        this.mK = byteBuffer;
    }

    public long bv() {
        return this.ii;
    }

    public ByteBuffer cM() {
        return this.mK;
    }

    public FaceAlgoData cN() {
        return this.oj;
    }

    public long cP() {
        return this.nn;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void i(long j) {
        this.ii = j;
    }

    public boolean isFrontCamera() {
        return this.nC;
    }

    public boolean isTracked() {
        return this.mu;
    }

    public void s(long j) {
        this.nn = j;
    }

    public void setFrontCamera(boolean z) {
        this.nC = z;
    }

    public void setTracked(boolean z) {
        this.mu = z;
    }

    public void t(long j) {
        this.oi = j;
    }
}
