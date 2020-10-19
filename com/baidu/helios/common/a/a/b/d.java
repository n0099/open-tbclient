package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1804a;
    private static byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a() {
        if (b != null) {
            return b;
        }
        b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        if (f1804a != null) {
            return f1804a;
        }
        f1804a = new BigInteger(c.f1803a).modPow(new BigInteger(c.b), new BigInteger(c.e)).toByteArray();
        return f1804a;
    }
}
