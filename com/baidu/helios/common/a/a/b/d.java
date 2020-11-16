package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1806a;
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
        if (f1806a != null) {
            return f1806a;
        }
        f1806a = new BigInteger(c.f1805a).modPow(new BigInteger(c.b), new BigInteger(c.e)).toByteArray();
        return f1806a;
    }
}
