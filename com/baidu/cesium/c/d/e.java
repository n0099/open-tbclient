package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes14.dex */
public class e implements d {
    private BigInteger aeH;
    private BigInteger aeI;

    public e(byte[] bArr, byte[] bArr2) {
        this.aeH = new BigInteger(bArr);
        this.aeI = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sP() {
        return this.aeH;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sQ() {
        return this.aeI;
    }
}
