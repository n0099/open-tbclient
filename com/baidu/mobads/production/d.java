package com.baidu.mobads.production;
/* loaded from: classes3.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3474a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3474a.h.resize(this.f3474a.getProdBase().getWidth(), this.f3474a.getProdBase().getHeight());
    }
}
