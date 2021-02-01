package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1643a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1644b;

    public static byte[] a() {
        if (f1643a != null) {
            return f1643a;
        }
        f1643a = new BigInteger(a.f1641a).modPow(new BigInteger(a.f1642b), new BigInteger(a.e)).toByteArray();
        return f1643a;
    }

    public static byte[] b() {
        if (f1644b != null) {
            return f1644b;
        }
        f1644b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1644b;
    }
}
