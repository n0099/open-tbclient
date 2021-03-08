package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f2292a = 0;
    private JNICommonMemCache b;

    public a() {
        this.b = null;
        this.b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f2292a == 0) {
            this.f2292a = this.b.Create();
        }
        return this.f2292a;
    }

    public void b() {
        if (this.f2292a != 0) {
            this.b.Init(this.f2292a);
        }
    }
}
