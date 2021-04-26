package com.baidu.mobads.cid.cesium.c.d;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f8454a = new SecureRandom();

    public static int a(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) >> 3;
    }

    public static BigInteger a(byte[] bArr, BigInteger bigInteger) {
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bigInteger2.compareTo(bigInteger) < 0) {
            return bigInteger2;
        }
        throw new BadPaddingException("Message is larger than modulus");
    }

    public static byte[] a(BigInteger bigInteger, int i2) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (length == i2) {
            return byteArray;
        }
        if (length == i2 + 1 && byteArray[0] == 0) {
            byte[] bArr = new byte[i2];
            System.arraycopy(byteArray, 1, bArr, 0, i2);
            return bArr;
        } else if (length >= i2) {
            return null;
        } else {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(byteArray, 0, bArr2, i2 - length, length);
            return bArr2;
        }
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        if (i2 == 0 && i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, d dVar) {
        return a(bArr, dVar.a(), dVar.b());
    }

    public static byte[] a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        return a(a(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger));
    }
}
