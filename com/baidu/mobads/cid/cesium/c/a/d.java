package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8238a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8239e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8240f;

    public d(b bVar) {
        super(bVar);
        this.f8240f = null;
        int i2 = this.f8251c;
        this.f8239e = new byte[i2];
        this.f8238a = new byte[i2];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        System.arraycopy(this.f8252d, 0, this.f8238a, 0, this.f8251c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f8251c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f8252d = bArr2;
        a();
        this.f8250b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f8251c; i6++) {
                this.f8239e[i6] = (byte) (bArr[i6 + i2] ^ this.f8238a[i6]);
            }
            this.f8250b.a(this.f8239e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f8238a, 0, this.f8251c);
            int i7 = this.f8251c;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        if (this.f8240f == null) {
            this.f8240f = new byte[this.f8251c];
        }
        System.arraycopy(this.f8238a, 0, this.f8240f, 0, this.f8251c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f8251c) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f8250b.b(bArr, i2, this.f8239e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f8251c;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f8239e[i7] ^ this.f8238a[i7]);
                i7++;
            }
            byte[] bArr4 = this.f8238a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f8251c;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        System.arraycopy(this.f8240f, 0, this.f8238a, 0, this.f8251c);
    }
}
