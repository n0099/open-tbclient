package com.baidu.mobads.cid.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f8237a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f8238b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f8237a = new BigInteger(bArr);
        this.f8238b = new BigInteger(bArr2);
    }

    @Override // com.baidu.mobads.cid.cesium.c.d.d
    public BigInteger a() {
        return this.f8237a;
    }

    @Override // com.baidu.mobads.cid.cesium.c.d.d
    public BigInteger b() {
        return this.f8238b;
    }
}
