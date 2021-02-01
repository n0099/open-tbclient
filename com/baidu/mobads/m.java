package com.baidu.mobads;
/* loaded from: classes5.dex */
final class m extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f3395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Runnable runnable) {
        this.f3395a = runnable;
    }

    @Override // com.baidu.mobads.f.a
    protected Object a() {
        this.f3395a.run();
        return null;
    }
}
