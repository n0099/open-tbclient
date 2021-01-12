package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class e implements d {
    private BigInteger any;
    private BigInteger anz;

    public e(byte[] bArr, byte[] bArr2) {
        this.any = new BigInteger(bArr);
        this.anz = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tO() {
        return this.any;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tP() {
        return this.anz;
    }
}
