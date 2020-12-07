package com.baidu.helios.common.a.a.a;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class c implements com.baidu.helios.common.a.b.a {
    private BigInteger aeH;
    private BigInteger aeI;

    public c(byte[] bArr, byte[] bArr2) {
        this.aeH = new BigInteger(bArr);
        this.aeI = new BigInteger(bArr2);
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger zJ() {
        return this.aeI;
    }

    @Override // com.baidu.helios.common.a.b.a
    public BigInteger zK() {
        return this.aeH;
    }
}
