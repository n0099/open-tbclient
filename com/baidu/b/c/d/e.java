package com.baidu.b.c.d;

import java.math.BigInteger;
/* loaded from: classes7.dex */
public class e implements d {
    private BigInteger adG;
    private BigInteger adH;

    public e(byte[] bArr, byte[] bArr2) {
        this.adG = new BigInteger(bArr);
        this.adH = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sM() {
        return this.adG;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sN() {
        return this.adH;
    }
}
