package com.baidu.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes19.dex */
class d extends f {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f1307a;
    private byte[] e;
    private byte[] f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        super(bVar);
        this.f = null;
        this.e = new byte[this.c];
        this.f1307a = new byte[this.c];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.c) {
            throw new InvalidKeyException("Internal error");
        }
        this.d = bArr2;
        b();
        this.amG.a(z, str, bArr);
    }

    @Override // com.baidu.cesium.c.a.f
    void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i + i2;
        while (i < i4) {
            for (int i5 = 0; i5 < this.c; i5++) {
                this.e[i5] = (byte) (bArr[i5 + i] ^ this.f1307a[i5]);
            }
            this.amG.a(this.e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.f1307a, 0, this.c);
            i += this.c;
            i3 += this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.cesium.c.a.f
    public void b() {
        System.arraycopy(this.d, 0, this.f1307a, 0, this.c);
    }

    @Override // com.baidu.cesium.c.a.f
    void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i + i2;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.c) ? null : (byte[]) bArr.clone();
        while (i < i4) {
            this.amG.b(bArr, i, this.e, 0);
            for (int i5 = 0; i5 < this.c; i5++) {
                bArr2[i5 + i3] = (byte) (this.e[i5] ^ this.f1307a[i5]);
            }
            if (bArr3 == null) {
                System.arraycopy(bArr, i, this.f1307a, 0, this.c);
            } else {
                System.arraycopy(bArr3, i, this.f1307a, 0, this.c);
            }
            i += this.c;
            i3 += this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.cesium.c.a.f
    public void c() {
        if (this.f == null) {
            this.f = new byte[this.c];
        }
        System.arraycopy(this.f1307a, 0, this.f, 0, this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.cesium.c.a.f
    public void d() {
        System.arraycopy(this.f, 0, this.f1307a, 0, this.c);
    }
}
