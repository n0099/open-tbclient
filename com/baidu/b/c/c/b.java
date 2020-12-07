package com.baidu.b.c.c;

import java.math.BigInteger;
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1263a;
    private static byte[] b;

    public static byte[] a() {
        if (f1263a != null) {
            return f1263a;
        }
        f1263a = new BigInteger(a.f1262a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return f1263a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
