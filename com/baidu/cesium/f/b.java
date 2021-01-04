package com.baidu.cesium.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f1699a;

    public b() {
        this(0L);
    }

    public b(long j) {
        this.f1699a = j;
    }

    public boolean a(long j, long j2) {
        long j3 = this.f1699a;
        this.f1699a = (this.f1699a & ((-1) ^ j2)) | (j & j2);
        return (j3 ^ this.f1699a) != 0;
    }
}
