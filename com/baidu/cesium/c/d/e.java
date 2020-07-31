package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class e implements d {
    private BigInteger akI;
    private BigInteger akJ;

    public e(byte[] bArr, byte[] bArr2) {
        this.akI = new BigInteger(bArr);
        this.akJ = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sG() {
        return this.akI;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sH() {
        return this.akJ;
    }
}
