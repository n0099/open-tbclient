package com.baidu.b.c.d;

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
/* loaded from: classes7.dex */
public final class f {
    private static final Map<String, byte[]> h = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    private final int f1263a;
    private SecureRandom adI;
    private MessageDigest adJ;
    private MessageDigest adK;
    private final int b;
    private final int d;
    private byte[] g;

    private f(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        this.f1263a = i;
        this.b = i2;
        this.adI = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        switch (i) {
            case 1:
            case 2:
                this.d = i2 - 11;
                return;
            case 3:
                this.d = i2;
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
                this.adJ = MessageDigest.getInstance(str);
                this.adK = MessageDigest.getInstance(str2);
                this.g = c(this.adJ, bArr);
                this.d = (i2 - 2) - (this.g.length * 2);
                if (this.d <= 0) {
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
            this.adK.update(bArr, i, i2);
            this.adK.update(bArr3);
            try {
                this.adK.digest(bArr4, 0, bArr4.length);
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
            byte[] bArr2 = h.get(algorithm);
            if (bArr2 == null) {
                byte[] digest = messageDigest.digest();
                h.put(algorithm, digest);
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
        byte[] bArr2 = new byte[this.b];
        System.arraycopy(bArr, 0, bArr2, this.b - bArr.length, bArr.length);
        int length = (this.b - 3) - bArr.length;
        bArr2[0] = 0;
        int i4 = 2;
        bArr2[1] = (byte) this.f1263a;
        if (this.f1263a != 1) {
            if (this.adI == null) {
                this.adI = b.adw;
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
                        this.adI.nextBytes(bArr3);
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
        if (bArr[1] != this.f1263a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length > this.d) {
                    throw new BadPaddingException("Padding string too short");
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                return bArr2;
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f1263a == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    private byte[] u(byte[] bArr) {
        if (this.adI == null) {
            this.adI = b.adw;
        }
        int length = this.g.length;
        byte[] bArr2 = new byte[length];
        this.adI.nextBytes(bArr2);
        byte[] bArr3 = new byte[this.b];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i = length + 1;
        int length2 = bArr3.length - i;
        int length3 = this.b - bArr.length;
        System.arraycopy(this.g, 0, bArr3, i, length);
        bArr3[length3 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length3, bArr.length);
        c(bArr3, 1, length, bArr3, i, length2);
        c(bArr3, i, length2, bArr3, 1, length);
        return bArr3;
    }

    private byte[] v(byte[] bArr) {
        int length = this.g.length;
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = length + 1;
        int length2 = bArr.length - i;
        c(bArr, i, length2, bArr, 1, length);
        c(bArr, 1, length, bArr, i, length2);
        for (int i2 = 0; i2 < length; i2++) {
            if (this.g[i2] != bArr[i + i2]) {
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
        return this.d;
    }

    public byte[] a(byte[] bArr) {
        if (bArr.length > this.d) {
            throw new BadPaddingException("Data must be shorter than " + (this.d + 1) + " bytes");
        }
        switch (this.f1263a) {
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
        if (bArr.length != this.b) {
            throw new BadPaddingException("Padded length must be " + this.b);
        }
        switch (this.f1263a) {
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

    public byte[] k(byte[] bArr, int i, int i2) {
        return a(b.k(bArr, i, i2));
    }
}
