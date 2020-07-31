package com.baidu.helios.common.cc;
/* loaded from: classes11.dex */
final class g extends e {
    public g(int i, int i2) {
        this.b = 4294967295L;
        this.c = 4;
        this.d = 32;
        this.e = i;
        this.f = i2;
    }

    @Override // com.baidu.helios.common.cc.e
    public a m(byte[] bArr, int i, int i2) {
        h hVar = new h();
        hVar.a(bArr, i, i2);
        return a.a(new long[]{hVar.b()});
    }
}
