package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger akI;
    private BigInteger akJ;

    public c(byte[] bArr, byte[] bArr2) {
        this.akI = new BigInteger(bArr);
        this.akJ = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.akI;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.akJ;
    }
}
