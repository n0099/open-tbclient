package com.baidu.mobads.production;
/* loaded from: classes7.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f2399a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2399a.h.resize(this.f2399a.getProdBase().getWidth(), this.f2399a.getProdBase().getHeight());
    }
}
