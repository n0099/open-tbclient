package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1307a;
    private static byte[] b;

    public static byte[] a() {
        if (f1307a != null) {
            return f1307a;
        }
        f1307a = new BigInteger(a.f1306a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        return f1307a;
    }

    public static byte[] b() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return b;
    }
}
