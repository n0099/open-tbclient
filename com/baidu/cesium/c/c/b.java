package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1312a;
    private static byte[] b;

    public static byte[] a() {
        if (f1312a != null) {
            return f1312a;
        }
        f1312a = new BigInteger(a.f1311a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return f1312a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
