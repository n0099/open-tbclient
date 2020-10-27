package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes11.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger adG;
    private BigInteger adH;

    public c(byte[] bArr, byte[] bArr2) {
        this.adG = new BigInteger(bArr);
        this.adH = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.adG;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.adH;
    }
}
