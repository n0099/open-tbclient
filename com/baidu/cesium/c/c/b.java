package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1694a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1695b;

    public static byte[] a() {
        if (f1694a != null) {
            return f1694a;
        }
        f1694a = new BigInteger(a.f1692a).modPow(new BigInteger(a.f1693b), new BigInteger(a.e)).toByteArray();
        return f1694a;
    }

    public static byte[] b() {
        if (f1695b != null) {
            return f1695b;
        }
        f1695b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1695b;
    }
}
