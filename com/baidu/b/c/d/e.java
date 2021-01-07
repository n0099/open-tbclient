package com.baidu.b.c.d;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class e implements d {
    private BigInteger afm;
    private BigInteger afn;

    public e(byte[] bArr, byte[] bArr2) {
        this.afm = new BigInteger(bArr);
        this.afn = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sp() {
        return this.afm;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sq() {
        return this.afn;
    }
}
