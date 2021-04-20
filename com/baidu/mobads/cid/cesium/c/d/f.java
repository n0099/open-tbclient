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
    public static final Map<String, byte[]> f8172e = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    public final int f8173a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8174b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f8175c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8176d;

    public f(int i, int i2, SecureRandom secureRandom) {
        this.f8173a = i;
        this.f8174b = i2;
        this.f8175c = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i == 1 || i == 2) {
            i2 -= 11;
        } else if (i != 3) {
            throw new InvalidKeyException("Invalid padding: " + i);
        }
        this.f8176d = i2;
    }

    public static f a(int i, int i2, SecureRandom secureRandom) {
        return new f(i, i2, secureRandom);
    }

    private byte[] c(byte[] bArr) {
        int i;
        int i2;
        int i3 = this.f8174b;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, i3 - bArr.length, bArr.length);
        int length = (this.f8174b - 3) - bArr.length;
        bArr2[0] = 0;
        int i4 = this.f8173a;
        bArr2[1] = (byte) i4;
        int i5 = -1;
        int i6 = 2;
        if (i4 != 1) {
            if (this.f8175c == null) {
                this.f8175c = b.f8161a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i7 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i5 < 0) {
                        this.f8175c.nextBytes(bArr3);
                        i5 = 63;
                    }
                    i = i5 - 1;
                    i2 = bArr3[i5] & 255;
                    if (i2 != 0) {
                        break;
                    }
                    i5 = i;
                }
                bArr2[i6] = (byte) i2;
                i5 = i;
                length = i7;
                i6++;
            }
        } else {
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i6] = -1;
                i6++;
                length = i8;
            }
        }
        return bArr2;
    }

    private byte[] d(byte[] bArr) {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = 2;
        if (bArr[1] != this.f8173a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length <= this.f8176d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f8173a == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    public int a() {
        return this.f8176d;
    }

    public byte[] a(byte[] bArr) {
        if (bArr.length > this.f8176d) {
            throw new BadPaddingException("Data must be shorter than " + (this.f8176d + 1) + " bytes");
        }
        int i = this.f8173a;
        if (i == 1 || i == 2) {
            return c(bArr);
        }
        if (i == 3) {
            return bArr;
        }
        throw new AssertionError();
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        return a(b.a(bArr, i, i2));
    }

    public byte[] b(byte[] bArr) {
        if (bArr.length != this.f8174b) {
            throw new BadPaddingException("Padded length must be " + this.f8174b);
        }
        int i = this.f8173a;
        if (i == 1 || i == 2) {
            return d(bArr);
        }
        if (i == 3) {
            return bArr;
        }
        throw new AssertionError();
    }
}
