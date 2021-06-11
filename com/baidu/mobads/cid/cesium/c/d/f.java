package com.baidu.mobads.cid.cesium.c.d;

import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, byte[]> f8239e = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    public final int f8240a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8241b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f8242c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8243d;

    public f(int i2, int i3, SecureRandom secureRandom) {
        this.f8240a = i2;
        this.f8241b = i3;
        this.f8242c = secureRandom;
        if (i3 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i2 == 1 || i2 == 2) {
            i3 -= 11;
        } else if (i2 != 3) {
            throw new InvalidKeyException("Invalid padding: " + i2);
        }
        this.f8243d = i3;
    }

    public static f a(int i2, int i3, SecureRandom secureRandom) {
        return new f(i2, i3, secureRandom);
    }

    private byte[] c(byte[] bArr) {
        int i2;
        int i3;
        int i4 = this.f8241b;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
        int length = (this.f8241b - 3) - bArr.length;
        bArr2[0] = 0;
        int i5 = this.f8240a;
        bArr2[1] = (byte) i5;
        int i6 = -1;
        int i7 = 2;
        if (i5 != 1) {
            if (this.f8242c == null) {
                this.f8242c = b.f8228a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i6 < 0) {
                        this.f8242c.nextBytes(bArr3);
                        i6 = 63;
                    }
                    i2 = i6 - 1;
                    i3 = bArr3[i6] & 255;
                    if (i3 != 0) {
                        break;
                    }
                    i6 = i2;
                }
                bArr2[i7] = (byte) i3;
                i6 = i2;
                length = i8;
                i7++;
            }
        } else {
            while (true) {
                int i9 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i7] = -1;
                i7++;
                length = i9;
            }
        }
        return bArr2;
    }

    private byte[] d(byte[] bArr) {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i2 = 2;
        if (bArr[1] != this.f8240a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0) {
                int length = bArr.length - i3;
                if (length <= this.f8243d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i3 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f8240a == 1 && i4 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i4);
                }
                i2 = i3;
            }
        }
    }

    public int a() {
        return this.f8243d;
    }

    public byte[] a(byte[] bArr) {
        if (bArr.length > this.f8243d) {
            throw new BadPaddingException("Data must be shorter than " + (this.f8243d + 1) + " bytes");
        }
        int i2 = this.f8240a;
        if (i2 == 1 || i2 == 2) {
            return c(bArr);
        }
        if (i2 == 3) {
            return bArr;
        }
        throw new AssertionError();
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        return a(b.a(bArr, i2, i3));
    }

    public byte[] b(byte[] bArr) {
        if (bArr.length != this.f8241b) {
            throw new BadPaddingException("Padded length must be " + this.f8241b);
        }
        int i2 = this.f8240a;
        if (i2 == 1 || i2 == 2) {
            return d(bArr);
        }
        if (i2 == 3) {
            return bArr;
        }
        throw new AssertionError();
    }
}
