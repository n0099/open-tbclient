package com.baidu.b.c.d;

import java.math.BigInteger;
/* loaded from: classes7.dex */
public class e implements d {
    private BigInteger adL;
    private BigInteger adM;

    public e(byte[] bArr, byte[] bArr2) {
        this.adL = new BigInteger(bArr);
        this.adM = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sM() {
        return this.adL;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sN() {
        return this.adM;
    }
}
