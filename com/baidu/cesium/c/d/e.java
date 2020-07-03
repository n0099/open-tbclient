package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger akN;
    private BigInteger akO;

    public e(byte[] bArr, byte[] bArr2) {
        this.akN = new BigInteger(bArr);
        this.akO = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sE() {
        return this.akN;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sF() {
        return this.akO;
    }
}
