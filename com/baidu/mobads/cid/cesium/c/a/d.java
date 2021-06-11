package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8200a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8201e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8202f;

    public d(b bVar) {
        super(bVar);
        this.f8202f = null;
        int i2 = this.f8213c;
        this.f8201e = new byte[i2];
        this.f8200a = new byte[i2];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        System.arraycopy(this.f8214d, 0, this.f8200a, 0, this.f8213c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f8213c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f8214d = bArr2;
        a();
        this.f8212b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f8213c; i6++) {
                this.f8201e[i6] = (byte) (bArr[i6 + i2] ^ this.f8200a[i6]);
            }
            this.f8212b.a(this.f8201e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f8200a, 0, this.f8213c);
            int i7 = this.f8213c;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        if (this.f8202f == null) {
            this.f8202f = new byte[this.f8213c];
        }
        System.arraycopy(this.f8200a, 0, this.f8202f, 0, this.f8213c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f8213c) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f8212b.b(bArr, i2, this.f8201e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f8213c;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f8201e[i7] ^ this.f8200a[i7]);
                i7++;
            }
            byte[] bArr4 = this.f8200a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f8213c;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        System.arraycopy(this.f8202f, 0, this.f8200a, 0, this.f8213c);
    }
}
