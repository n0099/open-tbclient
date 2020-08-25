package com.baidu.b.c.c;

import java.math.BigInteger;
/* loaded from: classes20.dex */
public class b {
    private static byte[] a;
    private static byte[] b;

    public static byte[] a() {
        if (a != null) {
            return a;
        }
        a = new BigInteger(a.a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
