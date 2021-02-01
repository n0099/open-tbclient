package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f2435a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f2436b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a() {
        if (f2436b != null) {
            return f2436b;
        }
        f2436b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return f2436b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        if (f2435a != null) {
            return f2435a;
        }
        f2435a = new BigInteger(c.f2433a).modPow(new BigInteger(c.f2434b), new BigInteger(c.e)).toByteArray();
        return f2435a;
    }
}
