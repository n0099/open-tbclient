package com.baidu.mobads.cid.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f8275a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f8276b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f8275a = new BigInteger(bArr);
        this.f8276b = new BigInteger(bArr2);
    }

    @Override // com.baidu.mobads.cid.cesium.c.d.d
    public BigInteger a() {
        return this.f8275a;
    }

    @Override // com.baidu.mobads.cid.cesium.c.d.d
    public BigInteger b() {
        return this.f8276b;
    }
}
