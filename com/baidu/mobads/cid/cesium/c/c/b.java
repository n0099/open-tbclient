package com.baidu.mobads.cid.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8158a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8159b;

    public static byte[] a() {
        byte[] bArr = f8158a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8153a).modPow(new BigInteger(a.f8154b), new BigInteger(a.f8157e)).toByteArray();
        f8158a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f8159b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8155c).modPow(new BigInteger(a.f8156d), new BigInteger(a.f8157e)).toByteArray();
        f8159b = byteArray;
        return byteArray;
    }
}
