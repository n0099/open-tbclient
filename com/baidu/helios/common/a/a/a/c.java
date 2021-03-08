package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes14.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger aoN;
    private BigInteger aoO;

    public c(byte[] bArr, byte[] bArr2) {
        this.aoN = new BigInteger(bArr);
        this.aoO = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vf() {
        return this.aoO;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vg() {
        return this.aoN;
    }
}
