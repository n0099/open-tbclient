package com.baidu.pano.platform.a;
/* loaded from: classes2.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    public int f9248a;

    /* renamed from: b  reason: collision with root package name */
    public int f9249b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9250c;

    /* renamed from: d  reason: collision with root package name */
    public final float f9251d;

    public e() {
        this(2500, 0, 1.0f);
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f9248a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f9249b;
    }

    public boolean c() {
        return this.f9249b <= this.f9250c;
    }

    public e(int i2, int i3, float f2) {
        this.f9248a = i2;
        this.f9250c = i3;
        this.f9251d = f2;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f9249b++;
        int i2 = this.f9248a;
        this.f9248a = (int) (i2 + (i2 * this.f9251d));
        if (!c()) {
            throw vVar;
        }
    }
}
