package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger ajr;
    private BigInteger ajs;

    public c(byte[] bArr, byte[] bArr2) {
        this.ajr = new BigInteger(bArr);
        this.ajs = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.ajr;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.ajs;
    }
}
