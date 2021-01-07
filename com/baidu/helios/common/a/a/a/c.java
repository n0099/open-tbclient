package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger afm;
    private BigInteger afn;

    public c(byte[] bArr, byte[] bArr2) {
        this.afm = new BigInteger(bArr);
        this.afn = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger za() {
        return this.afn;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger zb() {
        return this.afm;
    }
}
