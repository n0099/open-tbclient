package com.baidu.pano.platform.a;
/* loaded from: classes2.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    public int f8920a;

    /* renamed from: b  reason: collision with root package name */
    public int f8921b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8922c;

    /* renamed from: d  reason: collision with root package name */
    public final float f8923d;

    public e() {
        this(2500, 0, 1.0f);
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f8920a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f8921b;
    }

    public boolean c() {
        return this.f8921b <= this.f8922c;
    }

    public e(int i, int i2, float f2) {
        this.f8920a = i;
        this.f8922c = i2;
        this.f8923d = f2;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f8921b++;
        int i = this.f8920a;
        this.f8920a = (int) (i + (i * this.f8923d));
        if (!c()) {
            throw vVar;
        }
    }
}
