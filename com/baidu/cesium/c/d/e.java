package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes19.dex */
public class e implements d {
    private BigInteger adL;
    private BigInteger adM;

    public e(byte[] bArr, byte[] bArr2) {
        this.adL = new BigInteger(bArr);
        this.adM = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sM() {
        return this.adL;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sN() {
        return this.adM;
    }
}
