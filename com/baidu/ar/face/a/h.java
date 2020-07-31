package com.baidu.ar.face.a;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class h {
    private long ix;
    private boolean mR;
    private long mTimestamp;
    private long nK = 0;
    private boolean nZ;
    private ByteBuffer nh;
    private boolean oG;
    private long oH;
    private FaceAlgoData oI;

    public h(long j) {
        this.mTimestamp = j;
    }

    public void G(boolean z) {
        this.oG = z;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.oI = faceAlgoData;
    }

    public void a(ByteBuffer byteBuffer) {
        this.nh = byteBuffer;
    }

    public long cz() {
        return this.ix;
    }

    public ByteBuffer db() {
        return this.nh;
    }

    public FaceAlgoData dc() {
        return this.oI;
    }

    public long de() {
        return this.nK;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void i(long j) {
        this.ix = j;
    }

    public boolean isFrontCamera() {
        return this.nZ;
    }

    public boolean isTracked() {
        return this.mR;
    }

    public void s(long j) {
        this.nK = j;
    }

    public void setFrontCamera(boolean z) {
        this.nZ = z;
    }

    public void setTracked(boolean z) {
        this.mR = z;
    }

    public void t(long j) {
        this.oH = j;
    }
}
