package com.baidu.helios.common.a.a.b;

import java.math.BigInteger;
/* loaded from: classes3.dex */
public class d {
    private static byte[] a;
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
        if (a != null) {
            return a;
        }
        a = new BigInteger(c.a).modPow(new BigInteger(c.b), new BigInteger(c.e)).toByteArray();
        return a;
    }
}
