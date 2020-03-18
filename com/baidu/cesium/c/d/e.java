package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger Qk;
    private BigInteger Ql;

    public e(byte[] bArr, byte[] bArr2) {
        this.Qk = new BigInteger(bArr);
        this.Ql = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger nH() {
        return this.Qk;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger nI() {
        return this.Ql;
    }
}
