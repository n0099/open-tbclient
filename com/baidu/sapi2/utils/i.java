package com.baidu.sapi2.utils;
/* loaded from: classes5.dex */
class i implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.setVisibility(4);
        this.a.a.reload();
    }
}
