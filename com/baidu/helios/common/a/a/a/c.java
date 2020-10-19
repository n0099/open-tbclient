package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes11.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger adF;
    private BigInteger adG;

    public c(byte[] bArr, byte[] bArr2) {
        this.adF = new BigInteger(bArr);
        this.adG = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.adF;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.adG;
    }
}
