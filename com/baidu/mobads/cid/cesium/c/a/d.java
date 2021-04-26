package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8426a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8427e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8428f;

    public d(b bVar) {
        super(bVar);
        this.f8428f = null;
        int i2 = this.f8439c;
        this.f8427e = new byte[i2];
        this.f8426a = new byte[i2];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        System.arraycopy(this.f8440d, 0, this.f8426a, 0, this.f8439c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f8439c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f8440d = bArr2;
        a();
        this.f8438b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f8439c; i6++) {
                this.f8427e[i6] = (byte) (bArr[i6 + i2] ^ this.f8426a[i6]);
            }
            this.f8438b.a(this.f8427e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f8426a, 0, this.f8439c);
            int i7 = this.f8439c;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        if (this.f8428f == null) {
            this.f8428f = new byte[this.f8439c];
        }
        System.arraycopy(this.f8426a, 0, this.f8428f, 0, this.f8439c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f8439c) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f8438b.b(bArr, i2, this.f8427e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f8439c;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f8427e[i7] ^ this.f8426a[i7]);
                i7++;
            }
            byte[] bArr4 = this.f8426a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f8439c;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        System.arraycopy(this.f8428f, 0, this.f8426a, 0, this.f8439c);
    }
}
