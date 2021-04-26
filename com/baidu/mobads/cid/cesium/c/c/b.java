package com.baidu.mobads.cid.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8451a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8452b;

    public static byte[] a() {
        byte[] bArr = f8451a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8446a).modPow(new BigInteger(a.f8447b), new BigInteger(a.f8450e)).toByteArray();
        f8451a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f8452b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8448c).modPow(new BigInteger(a.f8449d), new BigInteger(a.f8450e)).toByteArray();
        f8452b = byteArray;
        return byteArray;
    }
}
