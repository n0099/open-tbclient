package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7938a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f7939b;

    public a() {
        this.f7939b = null;
        this.f7939b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f7938a == 0) {
            this.f7938a = this.f7939b.Create();
        }
        return this.f7938a;
    }

    public void b() {
        long j = this.f7938a;
        if (j != 0) {
            this.f7939b.Init(j);
        }
    }
}
