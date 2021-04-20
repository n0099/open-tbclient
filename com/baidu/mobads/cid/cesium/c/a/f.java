package com.baidu.mobads.cid.cesium.c.a;
/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: b  reason: collision with root package name */
    public final b f8145b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8146c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f8147d;

    public f(b bVar) {
        this.f8145b = bVar;
        this.f8146c = bVar.a();
    }

    public abstract void a();

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void b();

    public abstract void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void c();

    public void c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        a(bArr, i, i2, bArr2, i3);
    }

    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        b(bArr, i, i2, bArr2, i3);
    }
}
