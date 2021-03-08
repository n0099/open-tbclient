package com.baidu.mobads.production;
/* loaded from: classes4.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f2463a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2463a.h.resize(this.f2463a.getProdBase().getWidth(), this.f2463a.getProdBase().getHeight());
    }
}
