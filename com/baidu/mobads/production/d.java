package com.baidu.mobads.production;
/* loaded from: classes14.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3436a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3436a.h.resize(this.f3436a.getProdBase().getWidth(), this.f3436a.getProdBase().getHeight());
    }
}
