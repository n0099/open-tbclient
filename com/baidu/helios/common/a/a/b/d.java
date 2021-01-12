package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f2437a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f2438b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a() {
        if (f2438b != null) {
            return f2438b;
        }
        f2438b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return f2438b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        if (f2437a != null) {
            return f2437a;
        }
        f2437a = new BigInteger(c.f2435a).modPow(new BigInteger(c.f2436b), new BigInteger(c.e)).toByteArray();
        return f2437a;
    }
}
