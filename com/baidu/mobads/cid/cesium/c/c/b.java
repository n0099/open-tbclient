package com.baidu.mobads.cid.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8225a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8226b;

    public static byte[] a() {
        byte[] bArr = f8225a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8220a).modPow(new BigInteger(a.f8221b), new BigInteger(a.f8224e)).toByteArray();
        f8225a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f8226b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8222c).modPow(new BigInteger(a.f8223d), new BigInteger(a.f8224e)).toByteArray();
        f8226b = byteArray;
        return byteArray;
    }
}
