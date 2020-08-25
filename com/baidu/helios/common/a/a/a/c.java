package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes8.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger acU;
    private BigInteger acV;

    public c(byte[] bArr, byte[] bArr2) {
        this.acU = new BigInteger(bArr);
        this.acV = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.acU;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.acV;
    }
}
