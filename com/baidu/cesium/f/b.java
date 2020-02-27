package com.baidu.cesium.f;
/* loaded from: classes13.dex */
public class b {
    private long a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.a;
        this.a = (this.a & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.a) != 0;
    }
}
