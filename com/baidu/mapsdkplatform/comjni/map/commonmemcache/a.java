package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7937a = 0;

    /* renamed from: b  reason: collision with root package name */
    public JNICommonMemCache f7938b;

    public a() {
        this.f7938b = null;
        this.f7938b = new JNICommonMemCache();
    }

    public long a() {
        if (this.f7937a == 0) {
            this.f7937a = this.f7938b.Create();
        }
        return this.f7937a;
    }

    public void b() {
        long j = this.f7937a;
        if (j != 0) {
            this.f7938b.Init(j);
        }
    }
}
