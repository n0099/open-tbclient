package com.baidu.mobads.production;
/* loaded from: classes3.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3473a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3473a.h.resize(this.f3473a.getProdBase().getWidth(), this.f3473a.getProdBase().getHeight());
    }
}
