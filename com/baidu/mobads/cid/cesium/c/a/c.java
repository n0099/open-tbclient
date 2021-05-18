package com.baidu.mobads.cid.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f8236a = new SecureRandom();

    /* renamed from: b  reason: collision with root package name */
    public e f8237b;

    public c() {
        this.f8237b = null;
        this.f8237b = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i2, byte[] bArr, byte[] bArr2) {
        this.f8237b.a(i2, bArr, bArr2, f8236a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f8237b.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
