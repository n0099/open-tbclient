package com.baidu.mobads.production;
/* loaded from: classes5.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f3458a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3458a.h.resize(this.f3458a.getProdBase().getWidth(), this.f3458a.getProdBase().getHeight());
    }
}
