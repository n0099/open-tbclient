package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes5.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger ano;
    private BigInteger anp;

    public c(byte[] bArr, byte[] bArr2) {
        this.ano = new BigInteger(bArr);
        this.anp = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vc() {
        return this.anp;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger vd() {
        return this.ano;
    }
}
