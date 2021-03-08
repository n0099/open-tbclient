package com.baidu.mobads;
/* loaded from: classes4.dex */
final class m extends com.baidu.mobads.f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f2420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Runnable runnable) {
        this.f2420a = runnable;
    }

    @Override // com.baidu.mobads.f.a
    protected Object a() {
        this.f2420a.run();
        return null;
    }
}
