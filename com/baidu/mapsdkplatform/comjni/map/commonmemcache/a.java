package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f8037a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f8038b;

    public a() {
        this.f8038b = null;
        this.f8038b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f8037a == 0) {
            this.f8037a = this.f8038b.Create();
        }
        return this.f8037a;
    }

    public void b() {
        long j = this.f8037a;
        if (j != 0) {
            this.f8038b.Init(j);
        }
    }
}
