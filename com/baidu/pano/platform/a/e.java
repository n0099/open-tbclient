package com.baidu.pano.platform.a;
/* loaded from: classes2.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    public int f9361a;

    /* renamed from: b  reason: collision with root package name */
    public int f9362b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9363c;

    /* renamed from: d  reason: collision with root package name */
    public final float f9364d;

    public e() {
        this(2500, 0, 1.0f);
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f9361a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f9362b;
    }

    public boolean c() {
        return this.f9362b <= this.f9363c;
    }

    public e(int i, int i2, float f2) {
        this.f9361a = i;
        this.f9363c = i2;
        this.f9364d = f2;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f9362b++;
        int i = this.f9361a;
        this.f9361a = (int) (i + (i * this.f9364d));
        if (!c()) {
            throw vVar;
        }
    }
}
