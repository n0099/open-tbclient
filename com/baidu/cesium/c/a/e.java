package com.baidu.cesium.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes13.dex */
public final class e {
    private byte[] a;
    private i aiF;
    private f aiG;
    private int b;
    private int c;
    private int f;
    private int d = 0;
    private int e = 0;
    private int i = 1;
    private boolean j = false;

    public e(b bVar, int i) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.f = 0;
        this.aiF = null;
        this.aiG = null;
        this.b = i;
        this.c = i;
        this.f = i;
        this.a = new byte[this.b * 2];
        this.aiG = new d(bVar);
        this.aiF = new h(this.b);
    }

    private int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        if (this.i != 2 && this.i != 3 && i3 % this.c != 0 && this.i != 6) {
            if (this.aiF != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.c + " bytes");
            }
            throw new IllegalBlockSizeException("Input length not multiple of " + this.c + " bytes");
        } else if (this.j) {
            this.aiG.e(bArr, i, i3, bArr2, i2);
            return i3;
        } else {
            this.aiG.d(bArr, i, i3, bArr2, i2);
            return i3;
        }
    }

    int a(int i) {
        int i2 = this.d + i;
        return (this.aiF == null || this.j) ? i2 : this.c != this.b ? i2 < this.f ? this.f : (this.b + i2) - ((i2 - this.f) % this.b) : i2 + this.aiF.a(i2);
    }

    public void a(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.j = i == 2 || i == 4;
        if (this.i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (this.j) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.aiD;
            }
            bArr2 = new byte[this.b];
            secureRandom.nextBytes(bArr2);
        }
        this.d = 0;
        this.f = this.b;
        this.aiG.a(this.j, "", bArr, bArr2);
    }

    int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        byte[] bArr3;
        int a;
        int i5 = this.d + i2;
        int a2 = this.c != this.b ? i5 < this.f ? this.f - i5 : this.b - ((i5 - this.f) % this.b) : this.aiF != null ? this.aiF.a(i5) : 0;
        if (a2 <= 0 || a2 == this.b || this.aiF == null || !this.j) {
            int i6 = (this.j || this.aiF == null) ? i5 : i5 + a2;
            if (bArr2 == null) {
                throw new ShortBufferException("Output buffer is null");
            }
            int length = bArr2.length - i3;
            if (((!this.j || this.aiF == null) && length < i6) || (this.j && length < i6 - this.b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i6 + " bytes needed");
            }
            if (this.d == 0 && (this.j || this.aiF == null)) {
                i4 = i;
                bArr3 = bArr;
            } else {
                i4 = 0;
                bArr3 = new byte[i6];
                if (this.d != 0) {
                    System.arraycopy(this.a, 0, bArr3, 0, this.d);
                }
                if (i2 != 0) {
                    System.arraycopy(bArr, i, bArr3, this.d, i2);
                }
                if (!this.j && this.aiF != null) {
                    this.aiF.a(bArr3, i5, a2);
                }
            }
            if (this.j) {
                if (length < i6) {
                    this.aiG.c();
                }
                byte[] bArr4 = new byte[i5];
                a = a(bArr3, i4, bArr4, 0, i5);
                if (this.aiF != null && (a = this.aiF.b(bArr4, 0, a)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i3 < a) {
                    this.aiG.d();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + a + " bytes needed");
                }
                for (int i7 = 0; i7 < a; i7++) {
                    bArr2[i3 + i7] = bArr4[i7];
                }
            } else {
                a = a(bArr3, i4, bArr2, i3, i6);
            }
            this.d = 0;
            this.f = this.b;
            if (this.i != 0) {
                this.aiG.b();
            }
            return a;
        }
        throw new IllegalBlockSizeException("Input length must be multiple of " + this.b + " when decrypting with padded cipher");
    }

    public byte[] k(byte[] bArr, int i, int i2) {
        try {
            byte[] bArr2 = new byte[a(i2)];
            int c = c(bArr, i, i2, bArr2, 0);
            if (c < bArr2.length) {
                byte[] bArr3 = new byte[c];
                if (c != 0) {
                    try {
                        System.arraycopy(bArr2, 0, bArr3, 0, c);
                        return bArr3;
                    } catch (ShortBufferException e) {
                        return bArr3;
                    }
                }
                return bArr3;
            }
            return bArr2;
        } catch (ShortBufferException e2) {
            return null;
        }
    }
}
