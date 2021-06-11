package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7980a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f7981b;

    public a() {
        this.f7981b = null;
        this.f7981b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f7980a == 0) {
            this.f7980a = this.f7981b.Create();
        }
        return this.f7980a;
    }

    public void b() {
        long j = this.f7980a;
        if (j != 0) {
            this.f7981b.Init(j);
        }
    }
}
