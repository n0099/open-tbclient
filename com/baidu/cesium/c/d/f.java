package com.baidu.cesium.c.d;

import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes13.dex */
public final class f {
    private static final Map<String, byte[]> akR = Collections.synchronizedMap(new HashMap());
    private MessageDigest akP;
    private MessageDigest akQ;
    private final int e;
    private final int f;
    private SecureRandom g;
    private final int h;
    private byte[] k;

    private f(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        this.e = i;
        this.f = i2;
        this.g = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        switch (i) {
            case 1:
            case 2:
                this.h = i2 - 11;
                return;
            case 3:
                this.h = i2;
                return;
            case 4:
                String str = "SHA-1";
                String str2 = "SHA-1";
                byte[] bArr = null;
                if (oAEPParameterSpec != null) {
                    try {
                        str = oAEPParameterSpec.getDigestAlgorithm();
                        String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                        if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                            throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                        }
                        str2 = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                        PSource pSource = oAEPParameterSpec.getPSource();
                        String algorithm = pSource.getAlgorithm();
                        if (!algorithm.equalsIgnoreCase("PSpecified")) {
                            throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                        }
                        bArr = ((PSource.PSpecified) pSource).getValue();
                    } catch (NoSuchAlgorithmException e) {
                        throw new InvalidKeyException("Digest SHA-1 not available", e);
                    }
                }
                this.akP = MessageDigest.getInstance(str);
                this.akQ = MessageDigest.getInstance(str2);
                this.k = c(this.akP, bArr);
                this.h = (i2 - 2) - (this.k.length * 2);
                if (this.h <= 0) {
                    throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str + " and MGF1" + str2);
                }
                return;
            default:
                throw new InvalidKeyException("Invalid padding: " + i);
        }
    }

    public static f a(int i, int i2, SecureRandom secureRandom) {
        return new f(i, i2, secureRandom, null);
    }

    public static f a(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        return new f(i, i2, secureRandom, oAEPParameterSpec);
    }

    private void c(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        int i5 = i4;
        int i6 = i3;
        while (i5 > 0) {
            this.akQ.update(bArr, i, i2);
            this.akQ.update(bArr3);
            try {
                this.akQ.digest(bArr4, 0, bArr4.length);
                int i7 = i5;
                int i8 = i6;
                for (int i9 = 0; i9 < bArr4.length && i7 > 0; i9++) {
                    bArr2[i8] = (byte) (bArr4[i9] ^ bArr2[i8]);
                    i7--;
                    i8++;
                }
                if (i7 > 0) {
                    int length = bArr3.length;
                    while (true) {
                        length--;
                        byte b = (byte) (bArr3[length] + 1);
                        bArr3[length] = b;
                        if (b != 0 || length <= 0) {
                            break;
                        }
                    }
                    i5 = i7;
                    i6 = i8;
                } else {
                    i5 = i7;
                    i6 = i8;
                }
            } catch (DigestException e) {
                throw new BadPaddingException(e.toString());
            }
        }
    }

    private static byte[] c(MessageDigest messageDigest, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            String algorithm = messageDigest.getAlgorithm();
            byte[] bArr2 = akR.get(algorithm);
            if (bArr2 == null) {
                byte[] digest = messageDigest.digest();
                akR.put(algorithm, digest);
                return digest;
            }
            return bArr2;
        }
        return messageDigest.digest(bArr);
    }

    private byte[] c(byte[] bArr) {
        int i;
        int i2;
        int i3 = -1;
        byte[] bArr2 = new byte[this.f];
        System.arraycopy(bArr, 0, bArr2, this.f - bArr.length, bArr.length);
        int length = (this.f - 3) - bArr.length;
        bArr2[0] = 0;
        int i4 = 2;
        bArr2[1] = (byte) this.e;
        if (this.e != 1) {
            if (this.g == null) {
                this.g = b.akD;
            }
            byte[] bArr3 = new byte[64];
            int i5 = length;
            int i6 = 2;
            while (true) {
                int i7 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                while (true) {
                    if (i3 < 0) {
                        this.g.nextBytes(bArr3);
                        i3 = bArr3.length - 1;
                    }
                    i = i3 - 1;
                    i2 = bArr3[i3] & 255;
                    if (i2 != 0) {
                        break;
                    }
                    i3 = i;
                }
                bArr2[i6] = (byte) i2;
                i6++;
                i3 = i;
                i5 = i7;
            }
        } else {
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i4] = -1;
                i4++;
                length = i8;
            }
        }
        return bArr2;
    }

    private byte[] t(byte[] bArr) {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = 2;
        if (bArr[1] != this.e) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length > this.h) {
                    throw new BadPaddingException("Padding string too short");
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                return bArr2;
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.e == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    private byte[] u(byte[] bArr) {
        if (this.g == null) {
            this.g = b.akD;
        }
        int length = this.k.length;
        byte[] bArr2 = new byte[length];
        this.g.nextBytes(bArr2);
        byte[] bArr3 = new byte[this.f];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i = length + 1;
        int length2 = bArr3.length - i;
        int length3 = this.f - bArr.length;
        System.arraycopy(this.k, 0, bArr3, i, length);
        bArr3[length3 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length3, bArr.length);
        c(bArr3, 1, length, bArr3, i, length2);
        c(bArr3, i, length2, bArr3, 1, length);
        return bArr3;
    }

    private byte[] v(byte[] bArr) {
        int length = this.k.length;
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = length + 1;
        int length2 = bArr.length - i;
        c(bArr, i, length2, bArr, 1, length);
        c(bArr, 1, length, bArr, i, length2);
        for (int i2 = 0; i2 < length; i2++) {
            if (this.k[i2] != bArr[i + i2]) {
                throw new BadPaddingException("lHash mismatch");
            }
        }
        int i3 = i + length;
        while (bArr[i3] == 0) {
            i3++;
            if (i3 >= bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            }
        }
        int i4 = i3 + 1;
        if (bArr[i3] != 1) {
            throw new BadPaddingException("Padding string not terminated by 0x01 byte");
        }
        int length3 = bArr.length - i4;
        byte[] bArr2 = new byte[length3];
        System.arraycopy(bArr, i4, bArr2, 0, length3);
        return bArr2;
    }

    public int a() {
        return this.h;
    }

    public byte[] a(byte[] bArr) {
        if (bArr.length > this.h) {
            throw new BadPaddingException("Data must be shorter than " + (this.h + 1) + " bytes");
        }
        switch (this.e) {
            case 1:
            case 2:
                return c(bArr);
            case 3:
                return bArr;
            case 4:
                return u(bArr);
            default:
                throw new AssertionError();
        }
    }

    public byte[] b(byte[] bArr) {
        if (bArr.length != this.f) {
            throw new BadPaddingException("Padded length must be " + this.f);
        }
        switch (this.e) {
            case 1:
            case 2:
                return t(bArr);
            case 3:
                return bArr;
            case 4:
                return v(bArr);
            default:
                throw new AssertionError();
        }
    }

    public byte[] l(byte[] bArr, int i, int i2) {
        return a(b.l(bArr, i, i2));
    }
}
