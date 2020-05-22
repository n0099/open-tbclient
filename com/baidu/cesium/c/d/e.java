package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger ajr;
    private BigInteger ajs;

    public e(byte[] bArr, byte[] bArr2) {
        this.ajr = new BigInteger(bArr);
        this.ajs = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sj() {
        return this.ajr;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sk() {
        return this.ajs;
    }
}
