package com.baidu.cesium.c.a;

import javax.crypto.ShortBufferException;
/* loaded from: classes4.dex */
final class h implements i {

    /* renamed from: a  reason: collision with root package name */
    private int f1691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        this.f1691a = i;
    }

    @Override // com.baidu.cesium.c.a.i
    public int a(int i) {
        return this.f1691a - (i % this.f1691a);
    }

    @Override // com.baidu.cesium.c.a.i
    public void a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        if (i + i2 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b2 = (byte) (i2 & 255);
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3 + i] = b2;
        }
    }

    @Override // com.baidu.cesium.c.a.i
    public int b(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null || i2 == 0) {
            return 0;
        }
        int i4 = bArr[(i + i2) - 1];
        int i5 = i4 & 255;
        if (i5 < 1 || i5 > this.f1691a || (i3 = (i + i2) - (i4 & 255)) < i) {
            return -1;
        }
        for (int i6 = 0; i6 < (i4 & 255); i6++) {
            if (bArr[i3 + i6] != i4) {
                return -1;
            }
        }
        return i3;
    }
}
