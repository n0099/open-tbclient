package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8241a;

    /* renamed from: b  reason: collision with root package name */
    public int f8242b;

    /* renamed from: c  reason: collision with root package name */
    public int f8243c;

    /* renamed from: f  reason: collision with root package name */
    public int f8246f;

    /* renamed from: g  reason: collision with root package name */
    public i f8247g;

    /* renamed from: h  reason: collision with root package name */
    public f f8248h;

    /* renamed from: d  reason: collision with root package name */
    public int f8244d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f8245e = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f8249i = 1;
    public boolean j = false;

    public e(b bVar, int i2) {
        this.f8241a = null;
        this.f8242b = 0;
        this.f8243c = 0;
        this.f8246f = 0;
        this.f8247g = null;
        this.f8248h = null;
        this.f8242b = i2;
        this.f8243c = i2;
        this.f8246f = i2;
        this.f8241a = new byte[i2 * 2];
        this.f8248h = new d(bVar);
        this.f8247g = new h(this.f8242b);
    }

    private int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || i4 == 0) {
            return 0;
        }
        int i5 = this.f8249i;
        if (i5 == 2 || i5 == 3 || i4 % this.f8243c == 0 || i5 == 6) {
            if (this.j) {
                this.f8248h.d(bArr, i2, i4, bArr2, i3);
            } else {
                this.f8248h.c(bArr, i2, i4, bArr2, i3);
            }
            return i4;
        } else if (this.f8247g != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f8243c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f8243c + " bytes");
        }
    }

    public int a(int i2) {
        int i3 = this.f8244d + i2;
        i iVar = this.f8247g;
        if (iVar == null || this.j) {
            return i3;
        }
        int i4 = this.f8243c;
        int i5 = this.f8242b;
        if (i4 != i5) {
            int i6 = this.f8246f;
            return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
        }
        return i3 + iVar.a(i3);
    }

    public int a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int a3;
        int i6 = this.f8244d + i3;
        int i7 = this.f8243c;
        int i8 = this.f8242b;
        if (i7 != i8) {
            int i9 = this.f8246f;
            a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
        } else {
            i iVar2 = this.f8247g;
            a2 = iVar2 != null ? iVar2.a(i6) : 0;
        }
        if (a2 > 0 && a2 != this.f8242b && this.f8247g != null && this.j) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f8242b + " when decrypting with padded cipher");
        }
        int i10 = (this.j || this.f8247g == null) ? i6 : i6 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i4;
            if (((!this.j || this.f8247g == null) && length < i10) || (this.j && length < i10 - this.f8242b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
            }
            if (this.f8244d == 0 && (this.j || this.f8247g == null)) {
                bArr3 = bArr;
                i5 = i2;
            } else {
                byte[] bArr4 = new byte[i10];
                int i11 = this.f8244d;
                if (i11 != 0) {
                    System.arraycopy(this.f8241a, 0, bArr4, 0, i11);
                }
                if (i3 != 0) {
                    System.arraycopy(bArr, i2, bArr4, this.f8244d, i3);
                }
                if (!this.j && (iVar = this.f8247g) != null) {
                    iVar.a(bArr4, i6, a2);
                }
                bArr3 = bArr4;
                i5 = 0;
            }
            if (this.j) {
                if (length < i10) {
                    this.f8248h.b();
                }
                byte[] bArr5 = new byte[i6];
                a3 = a(bArr3, i5, bArr5, 0, i6);
                i iVar3 = this.f8247g;
                if (iVar3 != null && (a3 = iVar3.b(bArr5, 0, a3)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i4 < a3) {
                    this.f8248h.c();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + a3 + " bytes needed");
                }
                for (int i12 = 0; i12 < a3; i12++) {
                    bArr2[i4 + i12] = bArr5[i12];
                }
            } else {
                a3 = a(bArr3, i5, bArr2, i4, i10);
            }
            this.f8244d = 0;
            this.f8246f = this.f8242b;
            if (this.f8249i != 0) {
                this.f8248h.a();
            }
            return a3;
        }
        throw new ShortBufferException("Output buffer is null");
    }

    public void a(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i2 == 2 || i2 == 4;
        this.j = z;
        if (this.f8249i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f8236a;
            }
            bArr2 = new byte[this.f8242b];
            secureRandom.nextBytes(bArr2);
        }
        this.f8244d = 0;
        this.f8246f = this.f8242b;
        this.f8248h.a(this.j, "", bArr, bArr2);
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        int a2;
        byte[] bArr2;
        int a3;
        byte[] bArr3 = null;
        try {
            a2 = a(i3);
            bArr2 = new byte[a2];
            a3 = a(bArr, i2, i3, bArr2, 0);
        } catch (ShortBufferException unused) {
        }
        if (a3 < a2) {
            bArr3 = new byte[a3];
            if (a3 != 0) {
                System.arraycopy(bArr2, 0, bArr3, 0, a3);
            }
            return bArr3;
        }
        return bArr2;
    }
}
