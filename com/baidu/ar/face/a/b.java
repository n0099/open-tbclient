package com.baidu.ar.face.a;

import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class b {
    private long ld;
    private FaceAlgoData nX;
    private long nY;
    private boolean nZ;
    private ByteBuffer oa;
    private long ob;
    private long timestamp;

    public b(FaceAlgoData faceAlgoData, long j, long j2, long j3, ByteBuffer byteBuffer, boolean z, long j4) {
        this.nX = faceAlgoData;
        this.ld = j;
        this.timestamp = j2;
        this.nY = j3;
        this.oa = byteBuffer;
        this.nZ = z;
        this.ob = j4;
    }

    public ByteBuffer db() {
        return this.oa;
    }

    public FaceAlgoData dc() {
        return this.nX;
    }

    public long dd() {
        return this.nY;
    }

    public long de() {
        return this.ob;
    }

    public long getHandle() {
        return this.ld;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isFrontCamera() {
        return this.nZ;
    }
}
