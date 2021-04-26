package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8429a;

    /* renamed from: b  reason: collision with root package name */
    public int f8430b;

    /* renamed from: c  reason: collision with root package name */
    public int f8431c;

    /* renamed from: f  reason: collision with root package name */
    public int f8434f;

    /* renamed from: g  reason: collision with root package name */
    public i f8435g;

    /* renamed from: h  reason: collision with root package name */
    public f f8436h;

    /* renamed from: d  reason: collision with root package name */
    public int f8432d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f8433e = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f8437i = 1;
    public boolean j = false;

    public e(b bVar, int i2) {
        this.f8429a = null;
        this.f8430b = 0;
        this.f8431c = 0;
        this.f8434f = 0;
        this.f8435g = null;
        this.f8436h = null;
        this.f8430b = i2;
        this.f8431c = i2;
        this.f8434f = i2;
        this.f8429a = new byte[i2 * 2];
        this.f8436h = new d(bVar);
        this.f8435g = new h(this.f8430b);
    }

    private int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || i4 == 0) {
            return 0;
        }
        int i5 = this.f8437i;
        if (i5 == 2 || i5 == 3 || i4 % this.f8431c == 0 || i5 == 6) {
            if (this.j) {
                this.f8436h.d(bArr, i2, i4, bArr2, i3);
            } else {
                this.f8436h.c(bArr, i2, i4, bArr2, i3);
            }
            return i4;
        } else if (this.f8435g != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f8431c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f8431c + " bytes");
        }
    }

    public int a(int i2) {
        int i3 = this.f8432d + i2;
        i iVar = this.f8435g;
        if (iVar == null || this.j) {
            return i3;
        }
        int i4 = this.f8431c;
        int i5 = this.f8430b;
        if (i4 != i5) {
            int i6 = this.f8434f;
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
        int i6 = this.f8432d + i3;
        int i7 = this.f8431c;
        int i8 = this.f8430b;
        if (i7 != i8) {
            int i9 = this.f8434f;
            a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
        } else {
            i iVar2 = this.f8435g;
            a2 = iVar2 != null ? iVar2.a(i6) : 0;
        }
        if (a2 > 0 && a2 != this.f8430b && this.f8435g != null && this.j) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f8430b + " when decrypting with padded cipher");
        }
        int i10 = (this.j || this.f8435g == null) ? i6 : i6 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i4;
            if (((!this.j || this.f8435g == null) && length < i10) || (this.j && length < i10 - this.f8430b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
            }
            if (this.f8432d == 0 && (this.j || this.f8435g == null)) {
                bArr3 = bArr;
                i5 = i2;
            } else {
                byte[] bArr4 = new byte[i10];
                int i11 = this.f8432d;
                if (i11 != 0) {
                    System.arraycopy(this.f8429a, 0, bArr4, 0, i11);
                }
                if (i3 != 0) {
                    System.arraycopy(bArr, i2, bArr4, this.f8432d, i3);
                }
                if (!this.j && (iVar = this.f8435g) != null) {
                    iVar.a(bArr4, i6, a2);
                }
                bArr3 = bArr4;
                i5 = 0;
            }
            if (this.j) {
                if (length < i10) {
                    this.f8436h.b();
                }
                byte[] bArr5 = new byte[i6];
                a3 = a(bArr3, i5, bArr5, 0, i6);
                i iVar3 = this.f8435g;
                if (iVar3 != null && (a3 = iVar3.b(bArr5, 0, a3)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i4 < a3) {
                    this.f8436h.c();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + a3 + " bytes needed");
                }
                for (int i12 = 0; i12 < a3; i12++) {
                    bArr2[i4 + i12] = bArr5[i12];
                }
            } else {
                a3 = a(bArr3, i5, bArr2, i4, i10);
            }
            this.f8432d = 0;
            this.f8434f = this.f8430b;
            if (this.f8437i != 0) {
                this.f8436h.a();
            }
            return a3;
        }
        throw new ShortBufferException("Output buffer is null");
    }

    public void a(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i2 == 2 || i2 == 4;
        this.j = z;
        if (this.f8437i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f8424a;
            }
            bArr2 = new byte[this.f8430b];
            secureRandom.nextBytes(bArr2);
        }
        this.f8432d = 0;
        this.f8434f = this.f8430b;
        this.f8436h.a(this.j, "", bArr, bArr2);
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
