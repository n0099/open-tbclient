package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes8.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger acW;
    private BigInteger acX;

    public c(byte[] bArr, byte[] bArr2) {
        this.acW = new BigInteger(bArr);
        this.acX = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.acW;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.acX;
    }
}
