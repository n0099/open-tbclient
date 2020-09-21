package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes18.dex */
public class e implements d {
    private BigInteger adp;
    private BigInteger adq;

    public e(byte[] bArr, byte[] bArr2) {
        this.adp = new BigInteger(bArr);
        this.adq = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sM() {
        return this.adp;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sN() {
        return this.adq;
    }
}
