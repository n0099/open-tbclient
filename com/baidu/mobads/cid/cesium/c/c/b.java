package com.baidu.mobads.cid.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8163a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8164b;

    public static byte[] a() {
        byte[] bArr = f8163a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8158a).modPow(new BigInteger(a.f8159b), new BigInteger(a.f8162e)).toByteArray();
        f8163a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f8164b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8160c).modPow(new BigInteger(a.f8161d), new BigInteger(a.f8162e)).toByteArray();
        f8164b = byteArray;
        return byteArray;
    }
}
