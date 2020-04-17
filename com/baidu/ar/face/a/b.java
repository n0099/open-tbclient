package com.baidu.ar.face.a;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class b {
    private long nA;
    private long nB;
    private boolean nC;
    private ByteBuffer nD;
    private long nE;
    private FaceAlgoData nz;
    private long timestamp;

    public b(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, boolean z, long j4) {
        this.nz = faceAlgoData;
        this.nA = j;
        this.timestamp = j2;
        this.nB = j3;
        this.nD = byteBuffer;
        this.nC = z;
        this.nE = j4;
    }

    public ByteBuffer cM() {
        return this.nD;
    }

    public FaceAlgoData cN() {
        return this.nz;
    }

    public long cO() {
        return this.nB;
    }

    public long cP() {
        return this.nE;
    }

    public long getHandle() {
        return this.nA;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isFrontCamera() {
        return this.nC;
    }
}
