package com.baidu.cesium.c.d;

import java.math.BigInteger;
/* loaded from: classes13.dex */
public class e implements d {
    private BigInteger aiN;
    private BigInteger aiO;

    public e(byte[] bArr, byte[] bArr2) {
        this.aiN = new BigInteger(bArr);
        this.aiO = new BigInteger(bArr2);
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger rZ() {
        return this.aiN;
    }

    @Override // com.baidu.cesium.c.d.d
    public BigInteger sa() {
        return this.aiO;
    }
}
