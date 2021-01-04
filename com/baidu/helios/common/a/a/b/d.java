package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f2486a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f2487b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a() {
        if (f2487b != null) {
            return f2487b;
        }
        f2487b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return f2487b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        if (f2486a != null) {
            return f2486a;
        }
        f2486a = new BigInteger(c.f2484a).modPow(new BigInteger(c.f2485b), new BigInteger(c.e)).toByteArray();
        return f2486a;
    }
}
