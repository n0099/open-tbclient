package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1311a;
    private static byte[] b;

    public static byte[] a() {
        if (f1311a != null) {
            return f1311a;
        }
        f1311a = new BigInteger(a.f1310a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return f1311a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
