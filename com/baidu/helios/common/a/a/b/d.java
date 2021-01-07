package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f2487a;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f2488b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a() {
        if (f2488b != null) {
            return f2488b;
        }
        f2488b = new BigInteger(c.c).modPow(new BigInteger(c.d), new BigInteger(c.e)).toByteArray();
        return f2488b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        if (f2487a != null) {
            return f2487a;
        }
        f2487a = new BigInteger(c.f2485a).modPow(new BigInteger(c.f2486b), new BigInteger(c.e)).toByteArray();
        return f2487a;
    }
}
