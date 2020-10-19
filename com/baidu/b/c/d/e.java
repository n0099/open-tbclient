package com.baidu.b.c.d;

import java.math.BigInteger;
/* loaded from: classes7.dex */
public class e implements d {
    private BigInteger adF;
    private BigInteger adG;

    public e(byte[] bArr, byte[] bArr2) {
        this.adF = new BigInteger(bArr);
        this.adG = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sM() {
        return this.adF;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sN() {
        return this.adG;
    }
}
