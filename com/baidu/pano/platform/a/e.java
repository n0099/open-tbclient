package com.baidu.pano.platform.a;
/* loaded from: classes2.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    public int f9362a;

    /* renamed from: b  reason: collision with root package name */
    public int f9363b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9364c;

    /* renamed from: d  reason: collision with root package name */
    public final float f9365d;

    public e() {
        this(2500, 0, 1.0f);
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f9362a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f9363b;
    }

    public boolean c() {
        return this.f9363b <= this.f9364c;
    }

    public e(int i, int i2, float f2) {
        this.f9362a = i;
        this.f9364c = i2;
        this.f9365d = f2;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f9363b++;
        int i = this.f9362a;
        this.f9362a = (int) (i + (i * this.f9365d));
        if (!c()) {
            throw vVar;
        }
    }
}
