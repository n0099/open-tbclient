package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8138a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8139e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8140f;

    public d(b bVar) {
        super(bVar);
        this.f8140f = null;
        int i2 = this.f8151c;
        this.f8139e = new byte[i2];
        this.f8138a = new byte[i2];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        System.arraycopy(this.f8152d, 0, this.f8138a, 0, this.f8151c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f8151c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f8152d = bArr2;
        a();
        this.f8150b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f8151c; i6++) {
                this.f8139e[i6] = (byte) (bArr[i6 + i2] ^ this.f8138a[i6]);
            }
            this.f8150b.a(this.f8139e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f8138a, 0, this.f8151c);
            int i7 = this.f8151c;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        if (this.f8140f == null) {
            this.f8140f = new byte[this.f8151c];
        }
        System.arraycopy(this.f8138a, 0, this.f8140f, 0, this.f8151c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f8151c) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f8150b.b(bArr, i2, this.f8139e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f8151c;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f8139e[i7] ^ this.f8138a[i7]);
                i7++;
            }
            byte[] bArr4 = this.f8138a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f8151c;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        System.arraycopy(this.f8140f, 0, this.f8138a, 0, this.f8151c);
    }
}
