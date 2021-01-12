package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f3174a = 0;

    /* renamed from: b  reason: collision with root package name */
    private JNICommonMemCache f3175b;

    public a() {
        this.f3175b = null;
        this.f3175b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f3174a == 0) {
            this.f3174a = this.f3175b.Create();
        }
        return this.f3174a;
    }

    public void b() {
        if (this.f3174a != 0) {
            this.f3175b.Init(this.f3174a);
        }
    }
}
