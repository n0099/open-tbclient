package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7902a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f7903b;

    public a() {
        this.f7903b = null;
        this.f7903b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f7902a == 0) {
            this.f7902a = this.f7903b.Create();
        }
        return this.f7902a;
    }

    public void b() {
        long j = this.f7902a;
        if (j != 0) {
            this.f7903b.Init(j);
        }
    }
}
