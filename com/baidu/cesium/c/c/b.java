package com.baidu.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1645a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1646b;

    public static byte[] a() {
        if (f1645a != null) {
            return f1645a;
        }
        f1645a = new BigInteger(a.f1643a).modPow(new BigInteger(a.f1644b), new BigInteger(a.e)).toByteArray();
        return f1645a;
    }

    public static byte[] b() {
        if (f1646b != null) {
            return f1646b;
        }
        f1646b = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        return f1646b;
    }
}
