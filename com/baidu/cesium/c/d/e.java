package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes9.dex */
public class e implements d {
    private BigInteger acW;
    private BigInteger acX;

    public e(byte[] bArr, byte[] bArr2) {
        this.acW = new BigInteger(bArr);
        this.acX = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sH() {
        return this.acW;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sI() {
        return this.acX;
    }
}
