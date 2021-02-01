package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f3172a = 0;

    /* renamed from: b  reason: collision with root package name */
    private JNICommonMemCache f3173b;

    public a() {
        this.f3173b = null;
        this.f3173b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f3172a == 0) {
            this.f3172a = this.f3173b.Create();
        }
        return this.f3172a;
    }

    public void b() {
        if (this.f3172a != 0) {
            this.f3173b.Init(this.f3172a);
        }
    }
}
