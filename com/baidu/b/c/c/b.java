package com.baidu.b.c.c;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1604a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1605b;

    public static byte[] a() {
        if (f1604a != null) {
            return f1604a;
        }
        f1604a = new BigInteger(a.f1602a).modPow(new BigInteger(a.f1603b), new BigInteger(a.e)).toByteArray();
        return f1604a;
    }

    public static byte[] b() {
        if (f1605b != null) {
            return f1605b;
        }
        f1605b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1605b;
    }
}
