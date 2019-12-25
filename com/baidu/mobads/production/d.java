package com.baidu.mobads.production;
/* loaded from: classes7.dex */
class d implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.h.resize(this.a.getProdBase().getWidth(), this.a.getProdBase().getHeight());
    }
}
