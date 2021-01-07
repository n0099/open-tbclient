package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1695a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1696b;

    public static byte[] a() {
        if (f1695a != null) {
            return f1695a;
        }
        f1695a = new BigInteger(a.f1693a).modPow(new BigInteger(a.f1694b), new BigInteger(a.e)).toByteArray();
        return f1695a;
    }

    public static byte[] b() {
        if (f1696b != null) {
            return f1696b;
        }
        f1696b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1696b;
    }
}
