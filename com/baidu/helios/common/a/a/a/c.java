package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes25.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger adp;
    private BigInteger adq;

    public c(byte[] bArr, byte[] bArr2) {
        this.adp = new BigInteger(bArr);
        this.adq = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.adp;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.adq;
    }
}
