package com.baidu.pano.platform.a;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class e implements s {

    /* renamed from: a  reason: collision with root package name */
    private int f2702a;
    private int b;
    private final int c;
    private final float d;

    public e() {
        this(TbConfig.NOTIFY_YUN_PUSH, 0, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.f2702a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.baidu.pano.platform.a.s
    public int a() {
        return this.f2702a;
    }

    @Override // com.baidu.pano.platform.a.s
    public int b() {
        return this.b;
    }

    @Override // com.baidu.pano.platform.a.s
    public void a(v vVar) throws v {
        this.b++;
        this.f2702a = (int) (this.f2702a + (this.f2702a * this.d));
        if (!c()) {
            throw vVar;
        }
    }

    protected boolean c() {
        return this.b <= this.c;
    }
}
