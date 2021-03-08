package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class e implements d {
    private BigInteger aoN;
    private BigInteger aoO;

    public e(byte[] bArr, byte[] bArr2) {
        this.aoN = new BigInteger(bArr);
        this.aoO = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tL() {
        return this.aoN;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tM() {
        return this.aoO;
    }
}
