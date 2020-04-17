package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger aiJ;
    private BigInteger aiK;

    public e(byte[] bArr, byte[] bArr2) {
        this.aiJ = new BigInteger(bArr);
        this.aiK = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sa() {
        return this.aiJ;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sb() {
        return this.aiK;
    }
}
