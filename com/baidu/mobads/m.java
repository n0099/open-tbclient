package com.baidu.mobads;
/* loaded from: classes2.dex */
public final class m extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f8364a;

    public m(Runnable runnable) {
        this.f8364a = runnable;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        this.f8364a.run();
        return null;
    }
}
