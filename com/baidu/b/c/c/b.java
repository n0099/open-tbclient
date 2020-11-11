package com.baidu.b.c.c;

import java.math.BigInteger;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1261a;
    private static byte[] b;

    public static byte[] a() {
        if (f1261a != null) {
            return f1261a;
        }
        f1261a = new BigInteger(a.f1260a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return f1261a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
