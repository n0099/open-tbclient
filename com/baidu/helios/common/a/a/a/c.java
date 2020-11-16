package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes18.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger adL;
    private BigInteger adM;

    public c(byte[] bArr, byte[] bArr2) {
        this.adL = new BigInteger(bArr);
        this.adM = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.adL;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.adM;
    }
}
