package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8134a;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8135e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f8136f;

    public d(b bVar) {
        super(bVar);
        this.f8136f = null;
        int i = this.f8146c;
        this.f8135e = new byte[i];
        this.f8134a = new byte[i];
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a() {
        System.arraycopy(this.f8147d, 0, this.f8134a, 0, this.f8146c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f8146c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f8147d = bArr2;
        a();
        this.f8145b.a(z, str, bArr);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            for (int i5 = 0; i5 < this.f8146c; i5++) {
                this.f8135e[i5] = (byte) (bArr[i5 + i] ^ this.f8134a[i5]);
            }
            this.f8145b.a(this.f8135e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.f8134a, 0, this.f8146c);
            int i6 = this.f8146c;
            i += i6;
            i3 += i6;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b() {
        if (this.f8136f == null) {
            this.f8136f = new byte[this.f8146c];
        }
        System.arraycopy(this.f8134a, 0, this.f8136f, 0, this.f8146c);
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5 = i2 + i;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.f8146c) ? null : (byte[]) bArr.clone();
        while (i < i5) {
            this.f8145b.b(bArr, i, this.f8135e, 0);
            int i6 = 0;
            while (true) {
                i4 = this.f8146c;
                if (i6 >= i4) {
                    break;
                }
                bArr2[i6 + i3] = (byte) (this.f8135e[i6] ^ this.f8134a[i6]);
                i6++;
            }
            byte[] bArr4 = this.f8134a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i, bArr4, 0, i4);
            } else {
                System.arraycopy(bArr3, i, bArr4, 0, i4);
            }
            int i7 = this.f8146c;
            i += i7;
            i3 += i7;
        }
    }

    @Override // com.baidu.mobads.cid.cesium.c.a.f
    public void c() {
        System.arraycopy(this.f8136f, 0, this.f8134a, 0, this.f8146c);
    }
}
