package com.baidu.mobads.production;
/* loaded from: classes7.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f2397a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2397a.h.resize(this.f2397a.getProdBase().getWidth(), this.f2397a.getProdBase().getHeight());
    }
}
