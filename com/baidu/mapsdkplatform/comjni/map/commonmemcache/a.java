package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f8225a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f8226b;

    public a() {
        this.f8226b = null;
        this.f8226b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f8225a == 0) {
            this.f8225a = this.f8226b.Create();
        }
        return this.f8225a;
    }

    public void b() {
        long j = this.f8225a;
        if (j != 0) {
            this.f8226b.Init(j);
        }
    }
}
