package com.baidu.mobads.cid.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f8424a = new SecureRandom();

    /* renamed from: b  reason: collision with root package name */
    public e f8425b;

    public c() {
        this.f8425b = null;
        this.f8425b = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i2, byte[] bArr, byte[] bArr2) {
        this.f8425b.a(i2, bArr, bArr2, f8424a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f8425b.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
