package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8137a;

    /* renamed from: b  reason: collision with root package name */
    public int f8138b;

    /* renamed from: c  reason: collision with root package name */
    public int f8139c;

    /* renamed from: f  reason: collision with root package name */
    public int f8142f;

    /* renamed from: g  reason: collision with root package name */
    public i f8143g;

    /* renamed from: h  reason: collision with root package name */
    public f f8144h;

    /* renamed from: d  reason: collision with root package name */
    public int f8140d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f8141e = 0;
    public int i = 1;
    public boolean j = false;

    public e(b bVar, int i) {
        this.f8137a = null;
        this.f8138b = 0;
        this.f8139c = 0;
        this.f8142f = 0;
        this.f8143g = null;
        this.f8144h = null;
        this.f8138b = i;
        this.f8139c = i;
        this.f8142f = i;
        this.f8137a = new byte[i * 2];
        this.f8144h = new d(bVar);
        this.f8143g = new h(this.f8138b);
    }

    private int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i4 = this.i;
        if (i4 == 2 || i4 == 3 || i3 % this.f8139c == 0 || i4 == 6) {
            if (this.j) {
                this.f8144h.d(bArr, i, i3, bArr2, i2);
            } else {
                this.f8144h.c(bArr, i, i3, bArr2, i2);
            }
            return i3;
        } else if (this.f8143g != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f8139c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f8139c + " bytes");
        }
    }

    public int a(int i) {
        int i2 = this.f8140d + i;
        i iVar = this.f8143g;
        if (iVar == null || this.j) {
            return i2;
        }
        int i3 = this.f8139c;
        int i4 = this.f8138b;
        if (i3 != i4) {
            int i5 = this.f8142f;
            return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
        }
        return i2 + iVar.a(i2);
    }

    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int a2;
        byte[] bArr3;
        int i4;
        i iVar;
        int a3;
        int i5 = this.f8140d + i2;
        int i6 = this.f8139c;
        int i7 = this.f8138b;
        if (i6 != i7) {
            int i8 = this.f8142f;
            a2 = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
        } else {
            i iVar2 = this.f8143g;
            a2 = iVar2 != null ? iVar2.a(i5) : 0;
        }
        if (a2 > 0 && a2 != this.f8138b && this.f8143g != null && this.j) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f8138b + " when decrypting with padded cipher");
        }
        int i9 = (this.j || this.f8143g == null) ? i5 : i5 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i3;
            if (((!this.j || this.f8143g == null) && length < i9) || (this.j && length < i9 - this.f8138b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
            }
            if (this.f8140d == 0 && (this.j || this.f8143g == null)) {
                bArr3 = bArr;
                i4 = i;
            } else {
                byte[] bArr4 = new byte[i9];
                int i10 = this.f8140d;
                if (i10 != 0) {
                    System.arraycopy(this.f8137a, 0, bArr4, 0, i10);
                }
                if (i2 != 0) {
                    System.arraycopy(bArr, i, bArr4, this.f8140d, i2);
                }
                if (!this.j && (iVar = this.f8143g) != null) {
                    iVar.a(bArr4, i5, a2);
                }
                bArr3 = bArr4;
                i4 = 0;
            }
            if (this.j) {
                if (length < i9) {
                    this.f8144h.b();
                }
                byte[] bArr5 = new byte[i5];
                a3 = a(bArr3, i4, bArr5, 0, i5);
                i iVar3 = this.f8143g;
                if (iVar3 != null && (a3 = iVar3.b(bArr5, 0, a3)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i3 < a3) {
                    this.f8144h.c();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + a3 + " bytes needed");
                }
                for (int i11 = 0; i11 < a3; i11++) {
                    bArr2[i3 + i11] = bArr5[i11];
                }
            } else {
                a3 = a(bArr3, i4, bArr2, i3, i9);
            }
            this.f8140d = 0;
            this.f8142f = this.f8138b;
            if (this.i != 0) {
                this.f8144h.a();
            }
            return a3;
        }
        throw new ShortBufferException("Output buffer is null");
    }

    public void a(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i == 2 || i == 4;
        this.j = z;
        if (this.i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f8132a;
            }
            bArr2 = new byte[this.f8138b];
            secureRandom.nextBytes(bArr2);
        }
        this.f8140d = 0;
        this.f8142f = this.f8138b;
        this.f8144h.a(this.j, "", bArr, bArr2);
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        int a2;
        byte[] bArr2;
        int a3;
        byte[] bArr3 = null;
        try {
            a2 = a(i2);
            bArr2 = new byte[a2];
            a3 = a(bArr, i, i2, bArr2, 0);
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
