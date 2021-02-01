package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes5.dex */
public class e implements d {
    private BigInteger ano;
    private BigInteger anp;

    public e(byte[] bArr, byte[] bArr2) {
        this.ano = new BigInteger(bArr);
        this.anp = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tL() {
        return this.ano;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger tM() {
        return this.anp;
    }
}
