package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ c zv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.zv = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zv.release();
    }
}
