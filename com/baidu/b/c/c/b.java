package com.baidu.b.c.c;

import java.math.BigInteger;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1603a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1604b;

    public static byte[] a() {
        if (f1603a != null) {
            return f1603a;
        }
        f1603a = new BigInteger(a.f1601a).modPow(new BigInteger(a.f1602b), new BigInteger(a.e)).toByteArray();
        return f1603a;
    }

    public static byte[] b() {
        if (f1604b != null) {
            return f1604b;
        }
        f1604b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1604b;
    }
}
