package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger any;
    private BigInteger anz;

    public c(byte[] bArr, byte[] bArr2) {
        this.any = new BigInteger(bArr);
        this.anz = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vf() {
        return this.anz;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vg() {
        return this.any;
    }
}
