package com.baidu.pano.platform.a;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    private int f3873a;

    /* renamed from: b  reason: collision with root package name */
    private int f3874b;
    private final int c;
    private final float d;

    public e() {
        this(TbConfig.NOTIFY_YUN_PUSH, 0, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.f3873a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f3873a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f3874b;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f3874b++;
        this.f3873a = (int) (this.f3873a + (this.f3873a * this.d));
        if (!c()) {
            throw vVar;
        }
    }

    protected boolean c() {
        return this.f3874b <= this.c;
    }
}
