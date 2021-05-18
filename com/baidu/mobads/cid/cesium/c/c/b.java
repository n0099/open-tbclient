package com.baidu.mobads.cid.cesium.c.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f8263a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8264b;

    public static byte[] a() {
        byte[] bArr = f8263a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8258a).modPow(new BigInteger(a.f8259b), new BigInteger(a.f8262e)).toByteArray();
        f8263a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f8264b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f8260c).modPow(new BigInteger(a.f8261d), new BigInteger(a.f8262e)).toByteArray();
        f8264b = byteArray;
        return byteArray;
    }
}
