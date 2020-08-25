package com.baidu.b.c.d;

import java.math.BigInteger;
/* loaded from: classes20.dex */
public class e implements d {
    private BigInteger acU;
    private BigInteger acV;

    public e(byte[] bArr, byte[] bArr2) {
        this.acU = new BigInteger(bArr);
        this.acV = new BigInteger(bArr2);
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sH() {
        return this.acU;
    }

    @Override // com.baidu.b.c.d.d
    public BigInteger sI() {
        return this.acV;
    }
}
