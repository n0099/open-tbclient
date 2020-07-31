package com.baidu.sapi2.utils;
/* loaded from: classes19.dex */
class k implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.setVisibility(4);
        this.a.a.reload();
    }
}
