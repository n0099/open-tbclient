package com.baidu.mapsdkplatform.comjni.map.commonmemcache;
/* loaded from: classes8.dex */
public class a {
    private long a = 0;
    private JNICommonMemCache b;

    public a() {
        this.b = null;
        this.b = new JNICommonMemCache();
    }

    public long a() {
        if (this.a == 0) {
            this.a = this.b.Create();
        }
        return this.a;
    }

    public void b() {
        if (this.a != 0) {
            this.b.Init(this.a);
        }
    }
}
