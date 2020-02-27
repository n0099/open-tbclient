package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger Qj;
    private BigInteger Qk;

    public e(byte[] bArr, byte[] bArr2) {
        this.Qj = new BigInteger(bArr);
        this.Qk = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger nI() {
        return this.Qj;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger nJ() {
        return this.Qk;
    }
}
