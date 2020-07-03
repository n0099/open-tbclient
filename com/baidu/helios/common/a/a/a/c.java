package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger akN;
    private BigInteger akO;

    public c(byte[] bArr, byte[] bArr2) {
        this.akN = new BigInteger(bArr);
        this.akO = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getModulus() {
        return this.akN;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger getPublicExponent() {
        return this.akO;
    }
}
