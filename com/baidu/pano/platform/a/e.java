package com.baidu.pano.platform.a;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    private int f3870a;

    /* renamed from: b  reason: collision with root package name */
    private int f3871b;
    private final int c;
    private final float d;

    public e() {
        this(TbConfig.NOTIFY_YUN_PUSH, 0, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.f3870a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f3870a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.f3871b;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.f3871b++;
        this.f3870a = (int) (this.f3870a + (this.f3870a * this.d));
        if (!c()) {
            throw vVar;
        }
    }

    protected boolean c() {
        return this.f3871b <= this.c;
    }
}
