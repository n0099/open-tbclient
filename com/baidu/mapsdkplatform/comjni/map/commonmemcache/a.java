package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7903a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f7904b;

    public a() {
        this.f7904b = null;
        this.f7904b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f7903a == 0) {
            this.f7903a = this.f7904b.Create();
        }
        return this.f7903a;
    }

    public void b() {
        long j = this.f7903a;
        if (j != 0) {
            this.f7904b.Init(j);
        }
    }
}
