package com.baidu.mobads.cid.cesium.c.a;
/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: b  reason: collision with root package name */
    public final b f8212b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8213c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f8214d;

    public f(b bVar) {
        this.f8212b = bVar;
        this.f8213c = bVar.a();
    }

    public abstract void a();

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void b();

    public abstract void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void c();

    public void c(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        a(bArr, i2, i3, bArr2, i4);
    }

    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        b(bArr, i2, i3, bArr2, i4);
    }
}
